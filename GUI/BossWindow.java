package GUI;
import DB.DBLink;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/*
 * 3.0
 * 老板管理界面
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class BossWindow extends JFrame{
	
	JPanel contentPane;
	JTabbedPane tab;
	/*
	 * 功能:
	 * 1.个人信息:修改个人信息
	 * 2.雇员管理:录取/开除雇员,设置职工工资
	 * 3.管理员管理:擢升/降职管理员,设置管理员工资
	 */
	//JMenu idInfo;
	//JMenuItem sManage,wManage,mManage;
	JPanel boss,bUp,bC,bCE,bCE1,bCE2,bCE3,bCE4;
	JLabel photo,bossLabel,bname,bnumber,bsecret;
	JButton bModify,bPhotoModify;
	JTextField na,no,sec;
	JPanel worker,wUp,wUp1,wUp2,wC,wCW,wCW1,wCW2,wCW3,wCC,wCC1,wCC2,wCC3,wCE,wCE1,wCE2,wCE3,wCE4,wCE5,wCE6;
	JButton add,sub,confirmSalary,up,down,confirmSalary1;
	JLabel workerLabel,guyuan,hintNo,yuangong,hintSet,managerLabel,hintNo1,hintSet1;
	JTextField chooseNo,setSalary,chooseNo1,setSalary1;
	
	String name,secret,wNo,wSalary,wNoM,mSalary;
//////////////////////////////////////////////////////////////////////////////// 
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
					//new BossWindow("aaaaaa",);
					//identify.setVisible(true);			
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{	}
			}
		});
	}
      
//--------------------------Window构造方法-----------------------      
    public BossWindow(String bno) throws Exception  
    {   
    	//String name = "啊啊啊";
    	DBLink.dbLink();
    	name = getBossName(bno);
        String welcome = "欢迎!Boss: "+name;
    	setTitle(welcome);
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocation(WindowXY.getXY(this.getSize()));
        // 获得屏幕宽和高
     	//Toolkit toolkit = Toolkit.getDefaultToolkit();
     	//int height = toolkit.getScreenSize().height;
     	//int width = toolkit.getScreenSize().width;
        //setSize(width/2,height/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        contentPane=new JPanel();  
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  
        contentPane.setLayout(new BorderLayout(0,0));  
        setContentPane(contentPane);  
        
/*************************************************************************/        
        //操作界面
        tab = new JTabbedPane();
        contentPane.add(tab);
      /*3.0.0老板个人信息界面
           上部NORTH：老板信息
           　　左半部分，工作照（暂时空缺，留出框）
           　　右半部分，编号，姓名，密码　
           下部SOUTH：按钮
          　　修改按钮（弹出信息填写窗口——编号，姓名，密码，确认按钮）
      */
      	boss = new JPanel();
      	boss.setBorder(new EmptyBorder(5,5,5,5));
      	boss.setLayout(new BorderLayout(0,0));
      	boss.setBackground(Color.LIGHT_GRAY);
      	boss.setVisible(true);
      	//setContentPane(boss);
      	
      	bUp = new JPanel();
      	//bUp.setSize(800, 800);
      	//bUp.setLayout(new BorderLayout(0,0));
      	JLabel bossLabel = new JLabel("Boss Info");
      	bossLabel.setFont(new Font("",Font.PLAIN,99));
      	bUp.add(bossLabel);
      	boss.add(bUp, BorderLayout.NORTH);
      	
      	bC = new JPanel();
      	bC.setLayout(new BorderLayout());
      	bCE = new JPanel();
      	bCE.setLayout(new GridLayout(4,1));
      	bCE1 = new JPanel();
      	bCE1.setLayout(new FlowLayout());
      	bCE2 = new JPanel();
      	bCE2.setLayout(new FlowLayout());
      	bCE3 = new JPanel();
      	bCE3.setLayout(new FlowLayout());
      	bCE4 = new JPanel();
      	bCE4.setLayout(new FlowLayout());
      //String pho = "test.jpg";
      	
      String bimageSql = "select bimage from boss where bno = \'"+bno+"\'";
	  String pho = ImageDemo.blobRead(bimageSql, "test.jpg");
      ImageIcon bimg = new ImageIcon(pho);
      	photo = new JLabel(bimg);
      		photo.setIcon(bimg);
      		photo.setPreferredSize(new Dimension(400, 400));
      		bC.add(photo,BorderLayout.NORTH);
      //name = "荆芳浩";
      	bname = new JLabel("姓名   ");
      		bname.setFont(new Font("",Font.PLAIN,66));
      		na = new JTextField(name,8);
      		na.setSize(200, 50);
      		na.setFont(new Font("",Font.PLAIN,66));
      //bno = "201600301199";
      	bnumber = new JLabel("工号   ");
      		bnumber.setFont(new Font("",Font.PLAIN,66));
      		no = new JTextField(bno,8);
      		no.setSize(200, 50);
      		no.setFont(new Font("",Font.PLAIN,66));
      //secret = "199836";
      secret = getBossSecret(bno);
      	bsecret = new JLabel("密码   ");
      		bsecret.setFont(new Font("",Font.PLAIN,66));
      		sec = new JTextField(secret,8);
            sec.setSize(200,50);    
            sec.setFont(new Font("",Font.PLAIN,66));
        bPhotoModify = new JButton("上传照片");
        	bPhotoModify.setFont(new Font("",Font.PLAIN,44));
        	bPhotoModify.addActionListener(new ActionListener(){
      
				@Override
        		public void actionPerformed(ActionEvent e) {
        			// TODO Auto-generated method stub
        			try {
        				//dispose();
        				
        				//String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
						//photo.setIcon(new ImageIcon(ImageDemo.blobRead(sql1, "test.jpg")));
        				
        					String sql = "update boss set bimage = ? where bno = \'"+bno+"\'";   
	        				ImageDemo.putImg(sql);
	        				
	        				/*new Thread(new Runnable(){
								public void run() {
									// TODO Auto-generated method stub
									DBLink.dbLink();
    								String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
    								String p;
									try {
										p = ImageDemo.blobRead(sql1, "test1.jpg");
										new BossWindow(bno,p);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}					
							}).start();
							Thread.sleep(100);*/
        				String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
						String p;
						try {
							p = ImageDemo.blobRead(sql1, "test1.jpg");
							//new ManagerWindow(no,p);
							photo.setIcon(new ImageIcon(p));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        					/*EventQueue.invokeLater(new Runnable() {
        						public void run() {
        							try {
        								DBLink.dbLink();
        								String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
        								String p = ImageDemo.blobRead(sql1, "test.jpg");
        								new BossWindow(bno,p);		
        								//DBLink.dbLink();//连接数据库
        							} catch (Exception e) {
        								//e.printStackTrace();
        								System.out.println(e);
        							}finally{ }
        						}
        					});	*/	
	        				
	        				//boss.repaint();
	        				//boss.show();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						System.out.println("cuooooooooooooo"+e1);
					}
        		}       		
        	});
        bModify = new JButton("确认修改个人信息");
        	bModify.setFont(new Font("",Font.PLAIN,44));
        	bModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String newBossName = na.getText();
					String newBossNo = no.getText();
					String newBossSecret = sec.getText();
					SetBossName(newBossName,bno);
					SetBossNo(newBossNo,bno);
					SetBossSecret(newBossSecret,bno);
					
					na.setText( getBossName(newBossNo) );
					no.setText(newBossNo);
					sec.setText( getBossSecret(newBossNo) );
				}       		
        	});
      	bCE1.add(bname);	
      	bCE1.add(na);
      	bCE2.add(bnumber);
      	bCE2.add(no);
      	bCE3.add(bsecret);
      	bCE3.add(sec);
      	bCE.add(bCE1);
      	bCE.add(bCE2);
      	bCE.add(bCE3);
      	bCE4.add(bPhotoModify);
      	bCE4.add(bModify);
      	bCE.add(bCE4);
      	//bC.add(bCW, BorderLayout.WEST);
      	boss.add(bCE,BorderLayout.SOUTH);
      	boss.add(bC);
      	
        tab.addTab("个人信息", boss);
/**************************************************************************************/        
      //雇员
        worker = new JPanel();
      	worker.setBorder(new EmptyBorder(5,5,5,5));
      	worker.setLayout(new BorderLayout(0,0));
      	worker.setBackground(Color.LIGHT_GRAY);
      	worker.setVisible(true);
      	//setContentPane(boss);
      	
      	wUp = new JPanel();
      	wUp.setLayout(new BorderLayout());
      	wUp1 = new JPanel();
      	wUp1.setLayout(new FlowLayout());
      	wUp2 = new JPanel();
      	wUp2.setLayout(new GridLayout(1,3));
      	workerLabel = new JLabel("Worker Manage");
      		workerLabel.setFont(new Font("",Font.PLAIN,99));
      	guyuan  = new JLabel("    雇员管理");
      		guyuan.setFont(new Font("",Font.PLAIN,99));
      	yuangong = new JLabel("    员工管理");
      		yuangong.setFont(new Font("",Font.PLAIN,99));
      	managerLabel = new JLabel("    主管管理");
        	managerLabel.setFont(new Font("",Font.PLAIN,99));  
      	wUp1.add(workerLabel);
      	wUp2.add(guyuan);
      	wUp2.add(yuangong);
      	wUp2.add(managerLabel);
      	wUp.add(wUp1,BorderLayout.NORTH);
      	wUp.add(wUp2,BorderLayout.SOUTH);
      	worker.add(wUp,BorderLayout.NORTH);
      	
      	wC = new JPanel();
      	wC.setLayout(new GridLayout(1,3)); 	
      	//雇员管理(录取/开除雇员)
      	wCW = new JPanel();
      	wCW.setLayout(new BorderLayout());
      	wCW1 = new JPanel();
      	wCW1.setLayout(new FlowLayout());
      	wCW2 = new JPanel();
      	wCW2.setLayout(new GridLayout(3,1));
      	wCW3 = new JPanel();
      	wCW3.setLayout(new FlowLayout());
      	hintNo = new JLabel("      输入雇员工号");
      		hintNo.setFont(new Font("",Font.PLAIN,66));
      	chooseNo = new JTextField(10);
      		chooseNo.setFont(new Font("",Font.PLAIN,55));
      	wCW1.add(chooseNo,BorderLayout.SOUTH);
      	wCW.add(wCW1,BorderLayout.NORTH);  	
      	add = new JButton("录取");
      		add.setFont(new Font("",Font.PLAIN,33));
      		add.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wNo = chooseNo.getText();
					String sql1 = "insert into worker(eno) value("
							+ "(select eno from employee where eno = \'"+wNo+"\') )";
					String sql = "select eno from employee where eno = \'"+wNo+"\'";
					String sql2 = "update employee set bno = \'"+bno+"\' where eno = \'"+wNo+"\'";
					try {
						DBLink.dbLink();
						ResultSet rs = DBLink.st.executeQuery(sql);
						if(rs.next()){
							DBLink.st.execute(sql2);
							DBLink.st.execute(sql1);
					System.out.println("Add to Worker: "+wNo);
						}else{
							final String s= "***不存在该employee***\n"
									+ "*******请重新输入*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "错误",
											JOptionPane.DEFAULT_OPTION);
										chooseNo.setText("");
									}					
								}).start();
								Thread.sleep(100);
							}catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								//new Login();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
				}   			
      		});
      	sub = new JButton("开除");
      		sub.setFont(new Font("",Font.PLAIN,33));
      		sub.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wNo = chooseNo.getText();
					String sql1 = "delete from employee where eno = \'"+wNo+"\'";
					//String sql2 = "delete from worker where"
							//+ "(wno not in(select eno from employee)"
							//+ " union "
							//+ "delete from manager where"
							//+ "(mno not in(select eno from employee)";//数据完整性
					//String sql3 = "alter worker nocheck constraint all";
					//String sql4 = "alter worker check constraint all";				
					//String sql5 = "alter manager nocheck constraint all";
					//String sql6 = "alter manager check constraint all";
					String sql = "select eno from employee where eno = \'"+wNo+"\'";
					try {
						ResultSet rs = DBLink.st.executeQuery(sql);
						if(rs.next()){
							//DBLink.st.execute(sql3);
							//DBLink.st.execute(sql5);
							DBLink.st.execute(sql1);
							//DBLink.st.execute(sql4);
							//DBLink.st.execute(sql6);
							//DBLink.st.execute(sql2);
					System.out.println("Delete from Employee: "+wNo);
						}else{
							final String s= "***不存在该employee***\n"
									+ "*******请重新输入*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "错误",
											JOptionPane.DEFAULT_OPTION);
										chooseNo.setText("");
									}					
								}).start();
								Thread.sleep(100);
							}catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								//new Login();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
      		});
      	wCW1.add(add);
      	wCW1.add(sub);
      	wCW3.add(chooseNo);
      	wCW2.add(hintNo);
      	wCW2.add(wCW3);
      	wCW2.add(wCW1);
      	wCW.add(wCW2,BorderLayout.NORTH);
      	wC.add(wCW); 	
/***********************************************************************************************/
      	//员工管理(设置员工工资）
      	wCC = new JPanel();
      	wCC.setLayout(new BorderLayout());
      	wCC1 = new JPanel();
      	wCC1.setLayout(new FlowLayout());
      	wCC2 = new JPanel();
      	wCC2.setLayout(new GridLayout(3,1));
      	wCC3 = new JPanel();
      	wCC3.setLayout(new FlowLayout());
      	hintSet = new JLabel("      设置员工工资");
      		hintSet.setFont(new Font("",Font.PLAIN,66));
      	setSalary = new JTextField(6);
      		setSalary.setFont(new Font("",Font.PLAIN,55));
      	confirmSalary = new JButton("确认");
      		confirmSalary.setFont(new Font("",Font.PLAIN,33));
      		confirmSalary.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wSalary = setSalary.getText();
					String sql = "update worker set salary = \'"+wSalary+"\'";
					try {
						DBLink.st.execute(sql);
				System.out.println("Set Worker Salary: "+wSalary);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 			
      		});
      	wCC2.add(hintSet);
      	wCC3.add(setSalary);
      	wCC2.add(wCC3);
      	wCC1.add(confirmSalary);
      	wCC2.add(wCC1);
      	wCC.add(wCC2,BorderLayout.NORTH);
      	wC.add(wCC);
/*******************************************************************************************/       
        //管理员管理(擢升/降职管理员,设置管理员工资)
        wCE = new JPanel();
        wCE.setLayout(new GridLayout(3,1));
        wCE1 = new JPanel();
        wCE1.setLayout(new BorderLayout());
        wCE2 = new JPanel();
        wCE2.setLayout(new BorderLayout());
        wCE3 = new JPanel();
        wCE3.setLayout(new FlowLayout());
        wCE4 = new JPanel();
        wCE4.setLayout(new FlowLayout());
        wCE5 = new JPanel();
        wCE5.setLayout(new FlowLayout());
        wCE6 = new JPanel();
        wCE6.setLayout(new FlowLayout());
        hintNo1 = new JLabel("       输入员工工号");
  			hintNo1.setFont(new Font("",Font.PLAIN,66));
  	    chooseNo1 = new JTextField(8);
  			chooseNo1.setFont(new Font("",Font.PLAIN,44));  	
  		up = new JButton("擢升");
  			up.setFont(new Font("",Font.PLAIN,33));
  			up.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wNoM = chooseNo1.getText();
					String sql = "insert into manager(eno) values("
							+ "(select eno from employee where eno = \'"+wNoM+"\') )";
					String sql1 = "select eno from worker where eno = \'"+wNoM+"\'";
					try {
						ResultSet rs = DBLink.st.executeQuery(sql1);
						if(rs.next()){
							DBLink.st.execute(sql);
					System.out.println("Add to Manager: "+wNoM);
						}else{
							final String s= "***不存在该worker***\n"
									+ "*******请重新输入*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "错误",
											JOptionPane.DEFAULT_OPTION);
										chooseNo1.setText("");
									}					
								}).start();
								Thread.sleep(100);
							}catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								//new Login();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 				
  			});
  		down = new JButton("降职");
  			down.setFont(new Font("",Font.PLAIN,33));
  			down.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wNoM = chooseNo1.getText();
					String sql = "select eno from manager where eno = \'"+wNoM+"\'";
					String sql1 = "delete from manager where eno = \'"+wNoM+"\'";
					//String sql2 = "insert into worker(en where eno = \'"+wNoM+"\'";
					try {
						ResultSet rs = DBLink.st.executeQuery(sql);
						if(rs.next()){						
							DBLink.st.execute(sql1);
					System.out.println("GoDown to Worker: "+wNoM);
						}else{
							final String s= "***不存在该manager***\n"
									+ "*******请重新输入*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "错误",
											JOptionPane.DEFAULT_OPTION);
										chooseNo1.setText("");
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
  		//wCE.add(managerLabel,BorderLayout.NORTH);
  		//wCE.add(managerLabel);	
  		wCE1.add(hintNo1,BorderLayout.NORTH);	
  		wCE5.add(chooseNo1);
  		wCE1.add(wCE5);
  		wCE3.add(up);
  		wCE3.add(down);
  		wCE1.add(wCE3,BorderLayout.SOUTH);
  		wCE.add(wCE1);
  		hintSet1 = new JLabel("       设置主管工资");
			hintSet1.setFont(new Font("",Font.PLAIN,66));
		setSalary1 = new JTextField(6);
			setSalary1.setFont(new Font("",Font.PLAIN,44));
		confirmSalary1 = new JButton("确认");
		    confirmSalary1.setFont(new Font("",Font.PLAIN,33));
		    confirmSalary1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mSalary = setSalary1.getText();
					String sql = "update manager set salary = \'"+mSalary+"\'";
					try {
						DBLink.st.execute(sql);
				System.out.println("Set Manager Salary: "+mSalary);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 			
      		});
		wCE2.add(hintSet1,BorderLayout.NORTH);
		wCE6.add(setSalary1);
		wCE2.add(wCE6);
		wCE4.add(confirmSalary1);
		wCE2.add(wCE4,BorderLayout.SOUTH);
		//wCE.add(wCE2,BorderLayout.SOUTH);
		wCE.add(wCE2);
        wC.add(wCE);
        //tab.addTab("管理员管理", manager);		  
        worker.add(wC);
      	
        tab.addTab("雇员管理", worker);	
    }
    
    //提取boss 信息
    public static String getBossSecret(String bno){
    	String secret = "";
    	//DBLink.dbLink();
    	String sql = "select * from boss where bno = \'"+bno+"\'";
    	try {
    		DBLink.dbLink();
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				secret = st.getString("secret");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return secret;
    }
    public static String getBossName(String bno){
    	String name = "";
    	//DBLink.dbLink();
    	String sql = "select * from boss where bno = \'"+bno+"\'";
    	try {
    		DBLink.dbLink();
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				name = st.getString("bname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return name;
    }
    //修改boss信息
    public static void SetBossName(String name,String bno){
    	//DBLink.dbLink();
    	String sql = "update boss set bname = \'"+name+"\' where bno = \'"+bno+"\'";
    	try {
    		DBLink.dbLink();
			DBLink.st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
    public static void SetBossNo(String no,String bno){
    	//DBLink.dbLink();
    	String sql = "update boss set bno = \'"+no+"\' where bno = \'"+bno+"\'";
    	try {
    		DBLink.dbLink();
			DBLink.st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
    public static void SetBossSecret(String sec,String bno){
    	//DBLink.dbLink();
    	String sql = "update boss set secret = \'"+sec+"\' where bno = \'"+bno+"\'";
    	try {
    		DBLink.dbLink();
			DBLink.st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  

