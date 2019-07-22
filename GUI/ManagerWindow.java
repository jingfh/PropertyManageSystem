package GUI;

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
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DB.DBLink;

/*
 * 3.1
 * 管理者界面
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class ManagerWindow extends JFrame{
	
	JPanel contentPane;
	JTabbedPane tab;
	/*
	 * 功能:
	 * 1.个人信息:修改管理者个人信息
	 * 2.雇员管理:修改雇员信息
	 * 3.查询(周/月/年)报表********************
	 */
	
	JPanel info,mUp,mC,mCE,mCE1,mCE2,mCE3,mCE4,mCE5,mCE6,mCE7;
	JLabel mphoto,managerLabel,mname,mno,msex,mage,mphone,msecret;
	JButton mModify,mPhotoModify;
	String age,name,pho,number,sex,phone,secret;
	JTextField na,no,sec,se,ag,ph;
	
	JPanel worker,wUp,wUp1,wUp2,wC,wCE,wCE1,wCE2,wCE3,wCE4,wCE5,wCE6,wCE7;
	JLabel wphoto,workerLabel,wname,wno,wsex,wage,wphone,wsecret;
	JButton wModify,confirm,wPhotoModify;
	String phow,numberw,sexw,agew,phonew,secretw,namew;
	JTextField naw,now,secw,sew,agw,phw;
	
	JPanel finacialStatement,fUp,fC1,fC2,fC3;
	JLayeredPane fPane;
	//JTable tableMonth,tableQuarter,tableYear;
	JTable tableMonthIncome,tableMonthBalance,tableMonthCashflow;
	JTable tableQuarterIncome,tableQuarterBalance,tableQuarterCashflow;
	JTable tableYearIncome,tableYearBalance,tableYearCashflow;
	JMenuBar menu;
	JMenu month,quarter,year;
	JMenuItem monthBalance,quarterBalance,yearBalance;
	JMenuItem monthIncome,quarterIncome,yearIncome;
	JMenuItem monthCashflow,quarterCashflow,yearCashflow;
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
					//new ManagerWindow("aaaaaa");
					//identify.setVisible(true);			
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{	}
			}
		});
	}
      
//--------------------------Window构造方法-----------------------      
    public ManagerWindow(String id) throws Exception  
    {   
    	DBLink.dbLink();
    	//String name = "啊啊啊";
    	name = getName(id);
        String welcome = "欢迎!Manager: "+name;
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
      /*3.1.0主管个人信息界面
           
           　　左半部分，工作照（暂时空缺，留出框）
           　　右半部分，工号，姓名，密码　
      
      */
        //个人信息管理(可以修改所有信息)
      	info = new JPanel();
      	info.setBorder(new EmptyBorder(5,5,5,5));
      	info.setLayout(new BorderLayout(0,0));
      	info.setBackground(Color.LIGHT_GRAY);
      	info.setVisible(true);
      	//setContentPane(boss);
      	
      	mUp = new JPanel();
      	//bUp.setSize(800, 800);
      	//mUp.setLayout(new BorderLayout());
      	managerLabel = new JLabel("Manager Info");
      		managerLabel.setFont(new Font("",Font.PLAIN,99));
      		mUp.add(managerLabel);
      		info.add(mUp, BorderLayout.NORTH);
      	
      	mC = new JPanel();
      	mC.setLayout(new GridLayout(1,2));
      	String mimageSql = "select eimage from employee where eno = \'"+id+"\'";
	    String mpho = ImageDemo.blobRead(mimageSql, "test.jpg");
      	mphoto = new JLabel(new ImageIcon(mpho));
      		mphoto.setPreferredSize(new Dimension(600, 600));
      		mPhotoModify = new JButton("修改照片");
      		mPhotoModify.setFont(new Font("",Font.PLAIN,44));
      		mPhotoModify.addActionListener(new ActionListener(){
				@Override
        		public void actionPerformed(ActionEvent e) {
        			// TODO Auto-generated method stub
        			try {
        				//dispose();
        				
        				//String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
						//photo.setIcon(new ImageIcon(ImageDemo.blobRead(sql1, "test.jpg")));

        					String sql = "update employee set eimage = ? where eno = \'"+id+"\'";   
	        				ImageDemo.putImg(sql);
	        				
	        				/*new Thread(new Runnable(){
								public void run() {
									// TODO Auto-generated method stub
									DBLink.dbLink();
    								String sql1 = "select eimage from employee where eno = \'"+id+"\'";
    								String p;
									try {
										p = ImageDemo.blobRead(sql1, "test1.jpg");
										new ManagerWindow(id,p,p);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}					
							}).start();*/
							//Thread.sleep(100);
	        				String sql1 = "select eimage from employee where eno = \'"+id+"\'";
							String p;
							try {
								p = ImageDemo.blobRead(sql1, "test1.jpg");
								//new ManagerWindow(no,p);
								mphoto.setIcon(new ImageIcon(p));
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
      		mC.add(mphoto);
      	mCE = new JPanel();
        mCE.setLayout(new GridLayout(7,1));
      	mCE1 = new JPanel();
      	mCE1.setLayout(new FlowLayout());
      	mCE2 = new JPanel();
      	mCE2.setLayout(new FlowLayout());
      	mCE3 = new JPanel();
      	mCE3.setLayout(new FlowLayout());
      	mCE4 = new JPanel();
      	mCE4.setLayout(new FlowLayout());
      	mCE5 = new JPanel();
      	mCE5.setLayout(new FlowLayout());
      	mCE6 = new JPanel();
      	mCE6.setLayout(new FlowLayout());
      	mCE7 = new JPanel();
      	mCE7.setLayout(new FlowLayout());
      //name = "荆芳浩";
      	mname = new JLabel("姓名   ");
      		mname.setFont(new Font("",Font.PLAIN,66));
      		na = new JTextField(name,4);
      		//na.setSize(200, 50);
      		na.setFont(new Font("",Font.PLAIN,66));
      //number = "201600301199";
      //number = getManagerNo(id);
      	mno = new JLabel("工号   ");
      		mno.setFont(new Font("",Font.PLAIN,66));
      		no = new JTextField(id,9);
      		//no.setSize(200, 50);
      		no.setFont(new Font("",Font.PLAIN,66));
      //sex = "男";
      sex = getSex(id);
      	msex = new JLabel("性别   ");
        	msex.setFont(new Font("",Font.PLAIN,66));
        	se = new JTextField(sex,2);
        	se.setFont(new Font("",Font.PLAIN,66));
      //age = 20;
      age = getAge(id);
        mage = new JLabel("年龄   ");
            mage.setFont(new Font("",Font.PLAIN,66));
            ag = new JTextField(age,2);
            ag.setFont(new Font("",Font.PLAIN,66));
      //phone = "18340018992";
      phone = getPhone(id);
        mphone = new JLabel("手机号  ");
        	mphone.setFont(new Font("",Font.PLAIN,66));
        	ph = new JTextField(phone,8);
        	ph.setFont(new Font("",Font.PLAIN,66));
      //secret = "199836";
      secret = getSecret(id);
      	msecret = new JLabel(" 密码   ");
      		msecret.setFont(new Font("",Font.PLAIN,66));
      		sec = new JTextField(secret,6);
            //sec.setSize(200,50);    
            sec.setFont(new Font("",Font.PLAIN,66));
        mModify = new JButton("修改信息");
        	mModify.setFont(new Font("",Font.PLAIN,44));
        	mModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String newManagerName = na.getText();
					String newManagerNo = no.getText();
					String newManagerSecret = sec.getText();
					String newManagerSex = se.getText();
					String newManagerAge = ag.getText();
					String newManagerPhone = ph.getText();
					Set(id,newManagerName,newManagerNo,newManagerSecret,newManagerSex,newManagerAge,newManagerPhone);
				}     		
        	});
      	mCE1.add(mname);
      	mCE1.add(na);
      	mCE2.add(mno);
      	mCE2.add(no);
      	mCE3.add(msex);
      	mCE3.add(se);
      	mCE4.add(mage);	
      	mCE4.add(ag);
      	mCE5.add(mphone);
      	mCE5.add(ph);
      	mCE6.add(msecret);
      	mCE6.add(sec);
      	mCE.add(mCE1);
      	mCE.add(mCE2);
      	mCE.add(mCE3);
      	mCE.add(mCE4);
      	mCE.add(mCE5);
      	mCE.add(mCE6); 
      	mCE7.add(mPhotoModify);
      	mCE7.add(mModify);
      	mCE.add(mCE7);
      	mC.add(mCE);
      	info.add(mC);
      	
        tab.addTab("个人信息", info);
 /***********************************************************************************/       
      //员工信息管理(可修改所有信息)
        worker = new JPanel();
        worker.setBorder(new EmptyBorder(5,5,5,5));
        worker.setLayout(new BorderLayout(0,0));
        worker.setBackground(Color.LIGHT_GRAY);
        worker.setVisible(true);
      	
      	wUp = new JPanel();
      		wUp.setLayout(new BorderLayout());
      	wUp1 = new JPanel();
      	wUp2 = new JPanel();
      		wUp2.setLayout(new FlowLayout());
      //numberw = "201600301199";
        wno = new JLabel("请输入工号  ");
          	wno.setFont(new Font("",Font.PLAIN,66));
        now = new JTextField(8);
          	//no.setSize(200, 50);
          	now.setFont(new Font("",Font.ITALIC,66));
       
      	workerLabel = new JLabel("Worker Info");
      		workerLabel.setFont(new Font("",Font.PLAIN,99));
      		wUp1.add(workerLabel);
      		wUp.add(wUp1,BorderLayout.NORTH); 		
      	confirm = new JButton("确认");
      		confirm.setFont(new Font("",Font.PLAIN,66));
      		confirm.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				    numberw = now.getText();
				  //System.out.println("123***"+numberw);        
				    namew = getName(numberw);
				    sexw = getSex(numberw);
				    agew = getAge(numberw);
				    phonew = getPhone(numberw);
				    secretw = getSecret(numberw);
					
					naw.setText(namew);
					sew.setText(sexw);;
					agw.setText(agew);
					phw.setText(phonew);
					secw.setText(secretw);
				} 			
      		});
      		wUp2.add(wno);
      		wUp2.add(now);
      		wUp2.add(confirm);
      		wUp.add(wUp2,BorderLayout.SOUTH); 
      		worker.add(wUp, BorderLayout.NORTH);
      		
      	wC = new JPanel();
      	wC.setLayout(new GridLayout(1,2));
      //phow = "test.jpg";
      String wimageSql = "select eimage from employee where eno = \'"+numberw+"\'";
      String phow = ImageDemo.blobRead(wimageSql, "test.jpg");
      	wphoto = new JLabel(new ImageIcon(phow));
      		wphoto.setPreferredSize(new Dimension(600, 600));
      		wPhotoModify = new JButton("修改照片");
      		wPhotoModify.setFont(new Font("",Font.PLAIN,44));
      		wPhotoModify.addActionListener(new ActionListener(){
				@Override
        		public void actionPerformed(ActionEvent e) {
        			// TODO Auto-generated method stub
        			try {
        				//dispose();
        				
        				//String sql1 = "select bimage from boss where bno = \'"+bno+"\'";
						//photo.setIcon(new ImageIcon(ImageDemo.blobRead(sql1, "test.jpg")));
        				String no = now.getText();
        					String sql = "update employee set eimage = ? where eno = \'"+no+"\'";   
	        				ImageDemo.putImg(sql);
	        				
	        				/*new Thread(new Runnable(){
								public void run() {
									// TODO Auto-generated method stub
									DBLink.dbLink();
									//String sql2 = "select eimage from employee where eno = \'"+id+"\'";
    								String sql1 = "select eimage from employee where eno = \'"+no+"\'";
    								String p,p1;
									try {
										p = ImageDemo.blobRead(sql1, "test.jpg");
										//p1 = ImageDemo.blobRead(sql2, "test3.jpg");
										new ManagerWindow(no,"test1.jpg",p);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}					
							}).start();
							Thread.sleep(100);*/
	        				String sql1 = "select eimage from employee where eno = \'"+no+"\'";
							String p;
							try {
								p = ImageDemo.blobRead(sql1, "test2.jpg");
								//new ManagerWindow(no,p);
								wphoto.setIcon(new ImageIcon(p));
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
      		wC.add(wphoto);
      	wCE = new JPanel();
        wCE.setLayout(new GridLayout(7,1));
      	wCE1 = new JPanel();
      	wCE1.setLayout(new FlowLayout());
      	wCE2 = new JPanel();
      	wCE2.setLayout(new FlowLayout());
      	wCE3 = new JPanel();
      	wCE3.setLayout(new FlowLayout());;
      	wCE4 = new JPanel();
      	wCE4.setLayout(new FlowLayout());
      	wCE5 = new JPanel();
        wCE5.setLayout(new FlowLayout());
      	wCE6 = new JPanel();
      	wCE6.setLayout(new FlowLayout());
      	wCE7 = new JPanel();
      	wCE7.setLayout(new FlowLayout());
      //namew = "荆芳浩";
      	wname = new JLabel("姓名   ");
      		wname.setFont(new Font("",Font.PLAIN,66));
      		naw = new JTextField(namew,4);
      		//na.setSize(200, 50);
      		naw.setFont(new Font("",Font.PLAIN,66));
      //sexw = "男";
        wsex = new JLabel("性别   ");
        	wsex.setFont(new Font("",Font.PLAIN,66));
        	sew = new JTextField(sexw,2);
        	sew.setFont(new Font("",Font.PLAIN,66));
      //agew = 20;
        wage = new JLabel("年龄   ");
            wage.setFont(new Font("",Font.PLAIN,66));
            agw = new JTextField(agew,2);
            agw.setFont(new Font("",Font.PLAIN,66));
      //phonew = "18340018992";
        wphone = new JLabel("手机号  ");
        	wphone.setFont(new Font("",Font.PLAIN,66));
        	phw = new JTextField(phonew,8);
        	phw.setFont(new Font("",Font.PLAIN,66));
      //secretw = "199836";
      	wsecret = new JLabel("密码   ");
      		wsecret.setFont(new Font("",Font.PLAIN,66));
      		secw = new JTextField(secretw,4);
            //sec.setSize(200,50);    
            secw.setFont(new Font("",Font.PLAIN,66));
        wModify = new JButton("修改信息");
        	wModify.setFont(new Font("",Font.PLAIN,44));
        	wModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String newNumberw = now.getText();
			        String newNamew = naw.getText();
			        String newSexw = sew.getText();
			        String newAgew = agw.getText();
			        String newPhonew = phw.getText();
			        String newSecretw = secw.getText();
			        Set(numberw,newNamew,newNumberw,newSecretw,newSexw,newAgew,newPhonew);
				}		
        	});
      	wCE1.add(wname);	
      	wCE1.add(naw);
      	//wCE2.add(wno);
      	//wCE2.add(now);
      	wCE3.add(wsex);
      	wCE3.add(sew);
      	wCE4.add(wage);	
      	wCE4.add(agw);
      	wCE5.add(wphone);
      	wCE5.add(phw);
      	wCE6.add(wsecret);
      	wCE6.add(secw);     	
      	wCE.add(wCE1);
      	//wCE.add(wCE2);
      	wCE.add(wCE3);
      	wCE.add(wCE4);
      	wCE.add(wCE5);
      	wCE.add(wCE6);
      	wCE7.add(wPhotoModify);
      	wCE7.add(wModify);
      	wCE.add(wCE7);
      	wC.add(wCE);
      	worker.add(wC);
        tab.addTab("员工管理", worker);	
 /*************************************************************************/    
        //报表
        finacialStatement = new JPanel();
        finacialStatement.setBorder(new EmptyBorder(5,5,5,5));
        finacialStatement.setLayout(new BorderLayout(0,0));
        finacialStatement.setBackground(Color.LIGHT_GRAY);
        finacialStatement.setVisible(true);
        
        menu = new JMenuBar();
        //finacialStatement.setJMenuBar(menu);
        fC1 = new JPanel();
        	fC1.setLayout(new BorderLayout());
        fPane = new JLayeredPane();
        
        tableMonthIncome = new JTable();
        	tableMonthIncome.setSize(fC1.getSize());
        	createIncomeTable(tableMonthIncome);
        	JScrollPane jsp1 = new JScrollPane(tableMonthIncome);
        	fC1.add(jsp1);
        tableMonthBalance = new JTable();
        	tableMonthBalance.setSize(fC1.getSize());
         	createBalanceTable(tableMonthBalance);
        tableMonthCashflow = new JTable();
        	tableMonthCashflow.setSize(fC1.getSize());
         	createCashflowTable(tableMonthCashflow);
        	
        month = new JMenu("月报表");
        	month.setFont(new Font("",Font.BOLD,18));
        monthBalance = new JMenuItem("1资产负债表");
        	monthBalance.setFont(new Font("",Font.BOLD,13));
        monthIncome = new JMenuItem("2利润表");
        	monthIncome.setFont(new Font("",Font.BOLD,13));
        	monthIncome.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					//finacialStatement.add(fC1);
				}   		
        	});
        monthCashflow = new JMenuItem("3现金流动表");
        	monthCashflow.setFont(new Font("",Font.BOLD,13));
        month.add(monthBalance);
        month.add(monthIncome);
        month.add(monthCashflow);
        	
        fC2 = new JPanel();
        tableQuarterIncome = new JTable();	
        	tableQuarterIncome.setSize(fC2.getSize());
        	createIncomeTable(tableQuarterIncome);
        quarter = new JMenu("季度报表");
        	quarter.setFont(new Font("",Font.BOLD,18));    	
        quarterBalance = new JMenuItem("1资产负债表");
        	quarterBalance.setFont(new Font("",Font.BOLD,13));
        quarterIncome = new JMenuItem("2利润表");
        	quarterIncome.setFont(new Font("",Font.BOLD,13));
        quarterCashflow = new JMenuItem("3现金流动表");
        	quarterCashflow.setFont(new Font("",Font.BOLD,13));
        quarter.add(quarterBalance);
        quarter.add(quarterIncome);
        quarter.add(quarterCashflow);
        	
        fC3 = new JPanel();
        tableYearIncome = new JTable();
        	tableYearIncome.setSize(fC3.getSize());
        	createIncomeTable(tableYearIncome);
        year = new JMenu("年报表");
        	year.setFont(new Font("",Font.BOLD,18));
        yearBalance = new JMenuItem("1资产负债表");
        	yearBalance.setFont(new Font("",Font.BOLD,13));
        yearIncome = new JMenuItem("2利润表");
        	yearIncome.setFont(new Font("",Font.BOLD,13));
        yearCashflow = new JMenuItem("3现金流动表");
        	yearCashflow.setFont(new Font("",Font.BOLD,13));
        year.add(yearBalance);
        year.add(yearIncome);
        year.add(yearCashflow);
        	
        fUp = new JPanel();   
        menu.add(month);
        menu.add(quarter);
        menu.add(year);    
        fUp.add(menu);
        finacialStatement.add(fUp,BorderLayout.NORTH);
        
        
        JTableHeader  myt = tableMonthIncome.getTableHeader();
        myt.setFont(new Font("",Font.BOLD,18));
        //JTable
    	fC1.add(myt,BorderLayout.NORTH);
    	fC1.add(tableMonthCashflow);
        finacialStatement.add(fC1);
        
        
        tab.addTab("报表",finacialStatement);	
    }
    //利润表报表生成
    public static JTable createIncomeTable(JTable table){
    	
    	String[] columns={"项目","时间","收入","支出","缴税","利润"};
        int[] columnWidth={100,80,80,60,60,60};    
        int rowHeight = 30;
        table.setRowHeight(rowHeight);
        DefaultTableModel model=new DefaultTableModel(columns,20);
        table.setFont(new Font("",Font.BOLD,18));
        table.setModel(model);
        String[] rowData = {"","","收入总额","支出总额","缴税总额","合计利润"};
        model.addRow(rowData);
        String[] rowData1 = {"","","","","","",""};
        model.addRow(rowData1);
        TableColumnModel columnModel=table.getColumnModel();
        int count=columnModel.getColumnCount();
        for(int i=0;i<count;i++){
        	javax.swing.table.TableColumn column=columnModel.getColumn(i);
        	column.setPreferredWidth(columnWidth[i]);
        }
        return table;
    }
    //资产负债表生成
    public static JTable createCashflowTable(JTable table){
    	
    	String[] columns = {"行次","负债业主","房屋编号","欠款数","应还日期"};
    	 int[] columnWidth={100,80,80,60,80};    
         int rowHeight = 30;
         table.setRowHeight(rowHeight);
         DefaultTableModel model=new DefaultTableModel(columns,20);
         table.setFont(new Font("",Font.BOLD,18));
         table.setModel(model);
         String[] rowData = {"","","收入总额","支出总额","缴税总额","合计利润"};
         model.addRow(rowData);
         String[] rowData1 = {"","","","","","",""};
         model.addRow(rowData1);
         TableColumnModel columnModel=table.getColumnModel();
         int count=columnModel.getColumnCount();
         for(int i=0;i<count;i++){
         	javax.swing.table.TableColumn column=columnModel.getColumn(i);
         	column.setPreferredWidth(columnWidth[i]);
         }
    	return table;
    }
    //资金流动表
    public static JTable createBalanceTable(JTable table){
    	String[] columns = {"行次","时间","流入资金","流出资金","资金合计"};
    	 int[] columnWidth={100,80,80,60,60,60};    
         int rowHeight = 30;
         table.setRowHeight(rowHeight);
         DefaultTableModel model=new DefaultTableModel(columns,20);
         table.setFont(new Font("",Font.BOLD,18));
         table.setModel(model);
         String[] rowData = {"","","收入总额","支出总额","缴税总额","合计利润"};
         model.addRow(rowData);
         String[] rowData1 = {"","","","","","",""};
         model.addRow(rowData1);
         TableColumnModel columnModel=table.getColumnModel();
         int count=columnModel.getColumnCount();
         for(int i=0;i<count;i++){
         	javax.swing.table.TableColumn column=columnModel.getColumn(i);
         	column.setPreferredWidth(columnWidth[i]);
         }
    	return table;
    }
    //报表展示
    public static void showTable(JTable table,JPanel panel){
    	
    }
    
  //提取manager 信息
    public static String getSecret(String mno){
    	String secret = "";
    	//DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
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
    public static String getName(String mno){
    	String name = "";
    	//DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
    		DBLink.dbLink();
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				name = st.getString("ename");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return name;
    }
    public static String getSex(String mno){
    	String sex = "";
    	DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				sex = st.getString("esex");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return sex;
    }
    public static String getAge(String mno){
    	String age = "";
    	DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				age = st.getInt("eage")+"";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return age;
    }
    public static String getPhone(String mno){
    	String phone = "";
    	DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				phone = st.getString("ephone");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return phone;
    }
    //修改manager 信息
    public static void Set(String mno,String name,String no,String sec,String sex,String age,String phone){
    	DBLink.dbLink();
    	String sql1 = "update employee set ename = \'"+name+"\' where eno = \'"+mno+"\'";
    	String sql2 = "update employee set eno = \'"+no+"\' where eno = \'"+mno+"\'";
    	String sql3 = "update employee set secret = \'"+sec+"\' where eno = \'"+mno+"\'";
    	String sql4 = "update employee set esex = \'"+sex+"\' where eno = \'"+mno+"\'";
    	String sql5 = "update employee set eage = "+age+" where eno = \'"+mno+"\'";
    	String sql6 = "update employee set ephone = \'"+phone+"\' where eno = \'"+mno+"\'";
    	try {
			DBLink.st.executeUpdate(sql1);
			DBLink.st.executeUpdate(sql2);
			DBLink.st.executeUpdate(sql3);
			DBLink.st.executeUpdate(sql4);
			DBLink.st.executeUpdate(sql5);
			DBLink.st.executeUpdate(sql6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
   
    
}  

