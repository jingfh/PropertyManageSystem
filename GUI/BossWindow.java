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
 * �ϰ�������
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class BossWindow extends JFrame{
	
	JPanel contentPane;
	JTabbedPane tab;
	/*
	 * ����:
	 * 1.������Ϣ:�޸ĸ�����Ϣ
	 * 2.��Ա����:¼ȡ/������Ա,����ְ������
	 * 3.����Ա����:ߪ��/��ְ����Ա,���ù���Ա����
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
      
//--------------------------Window���췽��-----------------------      
    public BossWindow(String bno) throws Exception  
    {   
    	//String name = "������";
    	DBLink.dbLink();
    	name = getBossName(bno);
        String welcome = "��ӭ!Boss: "+name;
    	setTitle(welcome);
    	setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLocation(WindowXY.getXY(this.getSize()));
        // �����Ļ��͸�
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
        //��������
        tab = new JTabbedPane();
        contentPane.add(tab);
      /*3.0.0�ϰ������Ϣ����
           �ϲ�NORTH���ϰ���Ϣ
           ������벿�֣������գ���ʱ��ȱ��������
           �����Ұ벿�֣���ţ����������롡
           �²�SOUTH����ť
          �����޸İ�ť��������Ϣ��д���ڡ�����ţ����������룬ȷ�ϰ�ť��
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
      //name = "������";
      	bname = new JLabel("����   ");
      		bname.setFont(new Font("",Font.PLAIN,66));
      		na = new JTextField(name,8);
      		na.setSize(200, 50);
      		na.setFont(new Font("",Font.PLAIN,66));
      //bno = "201600301199";
      	bnumber = new JLabel("����   ");
      		bnumber.setFont(new Font("",Font.PLAIN,66));
      		no = new JTextField(bno,8);
      		no.setSize(200, 50);
      		no.setFont(new Font("",Font.PLAIN,66));
      //secret = "199836";
      secret = getBossSecret(bno);
      	bsecret = new JLabel("����   ");
      		bsecret.setFont(new Font("",Font.PLAIN,66));
      		sec = new JTextField(secret,8);
            sec.setSize(200,50);    
            sec.setFont(new Font("",Font.PLAIN,66));
        bPhotoModify = new JButton("�ϴ���Ƭ");
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
        								//DBLink.dbLink();//�������ݿ�
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
        bModify = new JButton("ȷ���޸ĸ�����Ϣ");
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
      	
        tab.addTab("������Ϣ", boss);
/**************************************************************************************/        
      //��Ա
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
      	guyuan  = new JLabel("    ��Ա����");
      		guyuan.setFont(new Font("",Font.PLAIN,99));
      	yuangong = new JLabel("    Ա������");
      		yuangong.setFont(new Font("",Font.PLAIN,99));
      	managerLabel = new JLabel("    ���ܹ���");
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
      	//��Ա����(¼ȡ/������Ա)
      	wCW = new JPanel();
      	wCW.setLayout(new BorderLayout());
      	wCW1 = new JPanel();
      	wCW1.setLayout(new FlowLayout());
      	wCW2 = new JPanel();
      	wCW2.setLayout(new GridLayout(3,1));
      	wCW3 = new JPanel();
      	wCW3.setLayout(new FlowLayout());
      	hintNo = new JLabel("      �����Ա����");
      		hintNo.setFont(new Font("",Font.PLAIN,66));
      	chooseNo = new JTextField(10);
      		chooseNo.setFont(new Font("",Font.PLAIN,55));
      	wCW1.add(chooseNo,BorderLayout.SOUTH);
      	wCW.add(wCW1,BorderLayout.NORTH);  	
      	add = new JButton("¼ȡ");
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
							final String s= "***�����ڸ�employee***\n"
									+ "*******����������*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "����",
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
      	sub = new JButton("����");
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
							//+ "(mno not in(select eno from employee)";//����������
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
							final String s= "***�����ڸ�employee***\n"
									+ "*******����������*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "����",
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
      	//Ա������(����Ա�����ʣ�
      	wCC = new JPanel();
      	wCC.setLayout(new BorderLayout());
      	wCC1 = new JPanel();
      	wCC1.setLayout(new FlowLayout());
      	wCC2 = new JPanel();
      	wCC2.setLayout(new GridLayout(3,1));
      	wCC3 = new JPanel();
      	wCC3.setLayout(new FlowLayout());
      	hintSet = new JLabel("      ����Ա������");
      		hintSet.setFont(new Font("",Font.PLAIN,66));
      	setSalary = new JTextField(6);
      		setSalary.setFont(new Font("",Font.PLAIN,55));
      	confirmSalary = new JButton("ȷ��");
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
        //����Ա����(ߪ��/��ְ����Ա,���ù���Ա����)
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
        hintNo1 = new JLabel("       ����Ա������");
  			hintNo1.setFont(new Font("",Font.PLAIN,66));
  	    chooseNo1 = new JTextField(8);
  			chooseNo1.setFont(new Font("",Font.PLAIN,44));  	
  		up = new JButton("ߪ��");
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
							final String s= "***�����ڸ�worker***\n"
									+ "*******����������*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "����",
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
  		down = new JButton("��ְ");
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
							final String s= "***�����ڸ�manager***\n"
									+ "*******����������*******";
							try{
								new Thread(new Runnable(){
									public void run() {
										// TODO Auto-generated method stub
										JOptionPane.showConfirmDialog(worker,s, "����",
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
  		hintSet1 = new JLabel("       �������ܹ���");
			hintSet1.setFont(new Font("",Font.PLAIN,66));
		setSalary1 = new JTextField(6);
			setSalary1.setFont(new Font("",Font.PLAIN,44));
		confirmSalary1 = new JButton("ȷ��");
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
        //tab.addTab("����Ա����", manager);		  
        worker.add(wC);
      	
        tab.addTab("��Ա����", worker);	
    }
    
    //��ȡboss ��Ϣ
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
    //�޸�boss��Ϣ
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

