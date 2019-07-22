package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import DB.DBLink;

/*
* 1.1
*注册界面
*只注册基本雇员信息
*然后要由管理者将其设置为公司职员
* copyright@2018.07.19 by JingFanghao
*/
@SuppressWarnings("serial")
public class Register extends JFrame{

	JLabel no,name,sex,age,phone;
	JTextField noIn,nameIn,phoneIn;
	JPanel noPane,namePane,sexPane,agePane,phonePane;
	JRadioButton man,women;
	ButtonGroup sexBox;
	JButton confirm;
	String NO,NAME,SEX,AGE,PHONE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test.Main.main(args);
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//JDialog.setDefaultLookAndFeelDecorated(true);
//		test.Main.main(args);
		new Register();
	}

	public Register(){
		super("Register");
		DBLink.dbLink();
		
		setVisible(true);
		setSize(608, 300);
		setLocation(WindowXY.getXY(this.getSize()));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pane = new JPanel();
		setContentPane(pane);
		pane.setLayout(null);
		
	//1.工号(时间+录取编号,2818年8月1日第0001号录取,201808010001)
		no = new JLabel("工号:(年月日+编号,如2018年8月1日0001号,201808010001)");
		no.setFont(new Font("",Font.BOLD,20));
		no.setBounds(10, 0, 608, 30);
		noIn = new JTextField("");
		noIn.setBounds(15,30,150, 30);
		noIn.setFont(new Font("",Font.ITALIC,20));
			
		pane.add(no);
		pane.add(noIn);
		//pane.add(noPane);
		
	//2.姓名
		name = new JLabel("姓名:");
		name.setFont(new Font("",Font.BOLD,20));
		name.setBounds(10, 60, 66, 30);
		nameIn = new JTextField();
		nameIn.setBounds(66,60,120,30);
		nameIn.setFont(new Font("",Font.ITALIC,20));
			
		pane.add(name);
		pane.add(nameIn);
	
	//3.性别（男/女）
		sexPane = new JPanel();
		sexPane.setBounds(-40, 90, 300, 30);
		sex = new JLabel("性别:");
		sex.setFont(new Font("",Font.BOLD,20));
		sex.setBounds(10, 90, 66, 30);
		man = new JRadioButton("男",true);
		women = new JRadioButton("女");
		sexBox = new ButtonGroup();

		sexBox.add(man);
		sexBox.add(women);
			
		pane.add(sex);
		sexPane.add(man,BorderLayout.WEST);
		sexPane.add(women,BorderLayout.EAST);
		pane.add(sexPane);
		
	//4.年龄（初值20，加/减）
		age = new JLabel("年龄:");
		age.setFont(new Font("",Font.BOLD,20));
		age.setBounds(10, 120, 66, 30);
		JSpinner ageJsp = new JSpinner();
		ageJsp.setValue(20);
		ageJsp.setBounds(66, 120, 60, 30);
		ageJsp.setFont(new Font("",Font.ITALIC,20));	
		
		pane.add(age);
		pane.add(ageJsp);
		
	//5.电话号（11位大陆号）
		phone = new JLabel("电话号:(11位大陆号)");
		phone.setFont(new Font("",Font.BOLD,20));
		phone.setBounds(10, 150, 200, 30);		
		phoneIn = new JTextField("");
		phoneIn.setBounds(200, 150, 150, 30);
		phoneIn.setFont(new Font("",Font.ITALIC,20));
			
		pane.add(phone);
		pane.add(phoneIn);
		
	//确认按钮
		confirm = new JButton("确认");
		confirm.setBounds(480, 190,100,50);
		confirm.setFont(new Font("",Font.BOLD,30));
		confirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				NO = noIn.getText();
			System.out.println(NO);
				NAME = nameIn.getText();
			System.out.println(NAME);
				//String enable="false";  
				Enumeration<AbstractButton> radioBtns=sexBox.getElements();  
				while (radioBtns.hasMoreElements()) {  
				    AbstractButton btn = radioBtns.nextElement();  
				    if(btn.isSelected()){  
				        SEX=btn.getText();  
				        break;  
				    }  
				}  
				//if(sexBox.isSelected(m))
			System.out.println(SEX);
				AGE = ageJsp.getValue().toString();
			System.out.println(AGE);
				PHONE = phoneIn.getText();
			System.out.println(PHONE);
			
			String sql = "insert into employee(eno,ename,esex,eage,ephone) "
					+ "values(\'" +NO+ "\',\'" +NAME+ "\',\'" +SEX+ "\'," +AGE+ ",\'" +PHONE+"\')";
			try {
				DBLink.st.execute(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				dispose();
			}
		});
		pane.add(confirm);
		
	}
	
}
