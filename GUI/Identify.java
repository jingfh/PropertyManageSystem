package GUI;

//import GUI.BossLogin;
//import GUI.WorkerLogin;
//import GUI.ManagerLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

//import DB.DBManager;

/*
 * 1.0
 * ȷ�������Ϣ����
 * copyright@2018.07.19 by JingFanghao
 */
@SuppressWarnings("serial")
public class Identify extends JFrame{
	
	private JLabel hint;//top hint
	
	private JPanel in;
	private JRadioButton boss,worker,manager;
	private ButtonGroup id;
	
	private JButton exit,register;

//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					new Identify();
					//identify.setVisible(true);			
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{
					
				}
			}
		});
	}
	
//���캯��
	public Identify(){
		
		super("Identify");
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		setSize(300,300);
		//setBounds(100, 100, 300, 300);
		setLocation(WindowXY.getXY(this.getSize()));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	//1.��ʾ��ǩ	
		//top = new JPanel();
		String s = "��ѡ���������";
		hint = new JLabel(s);
		hint.setFont(new Font("",Font.PLAIN,35));
		hint.setBounds(23,5,250,50);
		//top.add(hint);
		//getContentPane().add(top);
		getContentPane().add(hint);
		
	//2.��ݵ�ѡ��
		in = new JPanel();
		in.setBounds(110,84,50, 100);
		boss = new JRadioButton("�ϰ�",false);
		boss.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(boss.isSelected() == true){
					new BossLogin();
					dispose();
				}
			}	
		});
		worker = new JRadioButton("ְ��",false);
		worker.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(worker.isSelected() == true){
					new WorkerLogin();
					dispose();
				}
			}	
		});
		manager = new JRadioButton("����",false);
		//manager.setFont(new Font("",Font.BOLD,4));
		manager.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(manager.isSelected() == true){
					new ManagerLogin();
					dispose();
				}
			}	
		});
		id = new ButtonGroup();
		id.add(boss);
		id.add(worker);
		id.add(manager);
		in.add(boss,BorderLayout.NORTH);
		in.add(worker,BorderLayout.CENTER);
		in.add(manager,BorderLayout.SOUTH);
		getContentPane().add(in);
		
	//3.ע�ᣬ�˳���ť
		//down = new JPanel();
		exit = new JButton("�˳�");
		exit.setFont(new Font("",Font.BOLD,30));
		exit.setBounds(160, 200, 100, 50);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}		
		});
		//down.add(exit);
		register = new JButton("ע��");
		register.setFont(new Font("",Font.BOLD,30));
		register.setBounds(40, 200, 100, 50);
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Register();
				dispose();
			}	
		});
		//down.add(register);
		//getContentPane().add(down, BorderLayout.SOUTH);
		getContentPane().add(exit);
		getContentPane().add(register);
	}
}
