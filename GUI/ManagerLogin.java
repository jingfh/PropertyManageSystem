package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import DB.DBLink;

/*
 * 2.1
 * �����ߵ�½����
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class ManagerLogin extends JFrame{

	private JPasswordField passwordField;
	private JTextField textField;
	
	//private ResultSet rs;
	//private Statement st;
	
	private JButton log,exit;
	
	//private volatile boolean flag= true;//�̹߳ر�״̬λ
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		
//		test.Main.main(args);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
//		test.Main.main(args);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ManagerLogin frame = 
							new ManagerLogin();	
					//DBManager.DBLink();//�������ݿ�
					//DBManager.rmrank();//ɾ���ϴν����ı��
					//DBManager.mkrank();//���½������
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{
					
				}
			}
		});
	}

	public ManagerLogin() {
		
		super("ManagerLog");
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		setBounds(100, 100, 300, 300);
		setVisible(true);
		setLocation(WindowXY.getXY(this.getSize()));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Lable
		final JLabel welcome=new JLabel("Manager");
		welcome.setFont(new Font("",Font.PLAIN,60));
		welcome.setBounds(32,10,250,80);
		getContentPane().add(welcome);
		
		//ID
		final JLabel idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("",Font.PLAIN,30));
		idLabel.setBounds(20, 110, 80, 25);
		getContentPane().add(idLabel);		
		//ID�����
		textField = new JTextField("");
		textField.setFont(new Font("",Font.ITALIC,30));
		textField.setBounds(60, 100, 230, 40);
		getContentPane().add(textField);
		
		//����
		final JLabel label_1 = new JLabel("PassWord:");
		label_1.setFont(new Font("",Font.PLAIN,30));
		label_1.setBounds(3, 160, 160, 25);
		getContentPane().add(label_1);	
		//���������
		passwordField = new JPasswordField("");
		passwordField.setFont(new Font("",Font.ITALIC,30));
		passwordField.setBounds(150, 150, 140, 40);
		getContentPane().add(passwordField);
		
		//��½��ť
		log = new JButton("��¼");
		log.setBounds(176, 200, 100, 50);
		log.setFont(new Font("",Font.BOLD,30));
		log.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=textField.getText();
				String password=new String(passwordField.getPassword());	
			System.out.println("Login! id: "+id+",password: "+password);
				//String PASSWORD=DBManager.getPassword(id);
				String PASSWORD = getPW(id);
				
				DBLink.dbLink();
				try {
					String sql = "select eno from manager where eno = \'"+id+"\'";
					ResultSet rs;
					rs = DBLink.st.executeQuery(sql);
					if(password.equals(PASSWORD) && rs.next()){
						//����������
						//BossWindow window=
								try {
									
									new ManagerWindow(id);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally{
									DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
								}
						//�رյ�ǰ��ť
						//getContntPane().exit(0);
						dispose();
					}
					else if(rs.next() == false){
						dispose();
						String s= "**�����ڸ�manager**\n"
								+ "*******����������*******";
						try{
						new Thread(new Runnable(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								JOptionPane.showConfirmDialog(new ManagerLogin(),s, "����",
										JOptionPane.DEFAULT_OPTION);
							}					
						}).start();
						Thread.sleep(100);
						}catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							//new Login();
						}
					}
					else{
						dispose();
						String s= "**�û��������벻ƥ��**\n"
								+ "*******����������*******";
						try{
						new Thread(new Runnable(){
							@Override
							public void run() {
								// TODO Auto-generated method stub
								JOptionPane.showConfirmDialog(new ManagerLogin(),s, "����",
										JOptionPane.DEFAULT_OPTION);
							}					
						}).start();
						Thread.sleep(100);
						}catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							//new Login();
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}		
		});
		getContentPane().add(log);
		
		//�һ����밴ť
		exit = new JButton("�һ�����");
		exit.setBounds(18, 200, 156, 50);
		exit.setFont(new Font("",Font.BOLD,30));
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GetBackPW();
				dispose();
			}		
		});
		getContentPane().add(exit);				
	}
	
	//��DataBase��ȡmanager����
		private static String getPW(String id){
			String password = "";
			DBLink.dbLink();
			String sql = "select * from employee where eno = \'"+id+"\'";
			try {
				DBLink.dbLink();
				ResultSet rs = DBLink.st.executeQuery(sql);
				if(rs.next()){
					password = rs.getString("secret");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
			}
		System.out.println("PASSWORD: "+password);
			return password;
		}
}
	