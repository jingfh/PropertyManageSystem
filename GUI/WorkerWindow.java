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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DB.DBLink;

/*
 * 3.2
 * ְԱ����
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class WorkerWindow extends JFrame{
	
	JPanel contentPane;
	JTabbedPane tab;
	/*
	 * ����:
	 * 1.ҵ��:�޸�ҵ����Ϣ,��ȡ����
	 * 2.����:�޸ķ�����Ϣ
	 */
	JPanel worker,wUp,wC,wCE,wCE1,wCE2,wCE3,wCE4,wCE5,wCE6,wCE7;
	JLabel wphoto,workerLabel,wname,wno,wsex,wage,wphone,wsecret;
	JButton wModify,wPhotoModify;
	String phow,numberw,sexw,agew,phonew,secretw,namew;
	JTextField naw,now,secw,sew,agw,phw;
	
	JPanel owner,oUp,oUp1,oUp2,oC,oCW,oCW01,oCW02,oCW1,oCW2,oCW3,oCW4,oCW5,oCW6,oCW7,oCE,oCE1;
	JLabel ownerLabel,oname,ono,osex,oage,ophone,ownerHint;
	JLabel propertyLabel,utilityLabel,cableLabel,heatingLabel,parkingLabel;
	int propertyFee,utilityFee,cableFee,heatingFee,parkingFee;
	JTextField property,utility,cable,heating,parking;
	JButton propertyPay,utilityPay,cablePay,heatingPay,parkingPay;
	String numbero,sexo,phoneo,nameo,ageo;
	JButton oModify,ownerConfirm,feeConfirm;
	JTextField nao,noo,seco,seo,ago,pho,ownerNo;
	
	JPanel house,hUp,hUp1,hUp2,hC,hCW,hCW1,hCW2,hCW3,hCW4,hCW5,hCE,hCE1;
	JLabel houseLabel,houseHint,buildingLabel,unitLabel,roomLabel,ownLabel;
	String building,unit,room,own;
	JTextField houseNo,buildingNo,unitNo,roomNo,ownNo;
	JButton houseConfirm,hModify;
	JLabel propertyHint,utilityHint,cableHint,heatingHint,parkingHint;
	int propertyAdd,utilityAdd,cableAdd,heatingAdd,parkingAdd;
	JTextField propertyIn,utilityIn,cableIn,heatingIn,parkingIn;
	JButton propertySet,utilitySet,cableSet,heatingSet,parkingSet;
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
					//new WorkerWindow("aaaaaa");
					//identify.setVisible(true);			
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{	}
			}
		});
	}
      
//--------------------------Window���췽��-----------------------      
    public WorkerWindow(String id) 
    {   
    	DBLink.dbLink();
    	//name = "������";
    	namew = getName(id);
        String welcome = "��ӭ!Worker: "+namew;
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
        
      //��������
        tab = new JTabbedPane();
        contentPane.add(tab);
 /********************************************************************/       
      //Ա����Ϣ����(ֻ���Ը�����)
        worker = new JPanel();
        worker.setBorder(new EmptyBorder(5,5,5,5));
        worker.setLayout(new BorderLayout(0,0));
        worker.setBackground(Color.LIGHT_GRAY);
        worker.setVisible(true);
      	//setContentPane(boss);
      	
      	wUp = new JPanel();
      	//bUp.setSize(800, 800);
      	//bUp.setLayout(new BorderLayout(0,0));
      	workerLabel = new JLabel("Worker Info");
      		workerLabel.setFont(new Font("",Font.PLAIN,99));
      		wUp.add(workerLabel);
      		worker.add(wUp, BorderLayout.NORTH);
      	
      	wC = new JPanel();
      	wC.setLayout(new GridLayout(1,2));
      //phow = "test.jpg";
      	 String wimageSql = "select eimage from employee where eno = \'"+id+"\'";
	     String phow;
		try {
			phow = ImageDemo.blobRead(wimageSql, "test.jpg");
		
      	wphoto = new JLabel(new ImageIcon(phow));
      		wphoto.setPreferredSize(new Dimension(600, 600));
      		wPhotoModify = new JButton("�޸���Ƭ");
      		wPhotoModify.setFont(new Font("",Font.PLAIN,44));
      		wPhotoModify.addActionListener(new ActionListener(){
     
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
										new WorkerWindow(id,p);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}					
							}).start();
							Thread.sleep(100);*/
	        				String sql1 = "select eimage from employee where eno = \'"+id+"\'";
							String p;
							try {
								p = ImageDemo.blobRead(sql1, "test1.jpg");
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
      		wC.add(wphoto);
   } catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
      	wCE = new JPanel();
        wCE.setLayout(new GridLayout(7,1));
      	wCE1 = new JPanel();
      	wCE1.setLayout(new FlowLayout());
      	wCE2 = new JPanel();
      	wCE2.setLayout(new FlowLayout());
      	wCE3 = new JPanel();
      	wCE3.setLayout(new FlowLayout());
      	wCE4 = new JPanel();
      	wCE4.setLayout(new FlowLayout());
      	wCE5 = new JPanel();
        wCE5.setLayout(new FlowLayout());
      	wCE6 = new JPanel();
      	wCE6.setLayout(new FlowLayout());
      	wCE7 = new JPanel();
      	wCE7.setLayout(new FlowLayout());
      //namew = "������";
      wname = new JLabel("����   ");
      	wname.setFont(new Font("",Font.PLAIN,66));
      		naw = new JTextField(namew,4);
      		//na.setSize(200, 50);
      		naw.setFont(new Font("",Font.PLAIN,66));
      //numberw = "201600301199";
      numberw = id;
      	wno = new JLabel("����   ");
      		wno.setFont(new Font("",Font.PLAIN,66));
      		now = new JTextField(numberw,9);
      		//no.setSize(200, 50);
      		now.setFont(new Font("",Font.PLAIN,66));
      //sexw = "��";
      sexw = getSex(id);
        wsex = new JLabel("�Ա�   ");
        	wsex.setFont(new Font("",Font.PLAIN,66));
        	sew = new JTextField(sexw,2);
        	sew.setFont(new Font("",Font.PLAIN,66));
      //agew = 20;
      agew = getAge(id);
        wage = new JLabel("����   ");
            wage.setFont(new Font("",Font.PLAIN,66));
            agw = new JTextField(agew,2);
            agw.setFont(new Font("",Font.PLAIN,66));
      //phonew = "18340018992";
      phonew = getPhone(id);
        wphone = new JLabel("�ֻ���  ");
        	wphone.setFont(new Font("",Font.PLAIN,66));
        	phw = new JTextField(phonew,8);
        	phw.setFont(new Font("",Font.PLAIN,66));
      //secretw = "199836";
      secretw = getSecret(id);
        wsecret = new JLabel("����   ");
            wsecret.setFont(new Font("",Font.PLAIN,66));
           	secw = new JTextField(secretw,6);
            //sec.setSize(200,50);    
            secw.setFont(new Font("",Font.PLAIN,66));
        wModify = new JButton("�޸�����");
         	wModify.setFont(new Font("",Font.PLAIN,44));
         	wModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String newSecretW = secw.getText();
					String sql = "update employee set secret = \'"+newSecretW+"\' where eno = \'"+id+"\'";
					try {
						DBLink.dbLink();
						DBLink.st.execute(sql);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						//DBLink.release(con, st, rs, pst);
					}
				}   		
         	});
      	wCE1.add(wname);	
      	wCE1.add(naw);
      	wCE2.add(wno);
      	wCE2.add(now);
      	wCE3.add(wsex);
      	wCE3.add(sew);
      	wCE4.add(wage);	
      	wCE4.add(agw);
      	wCE5.add(wphone);
      	wCE5.add(phw);
      	wCE6.add(wsecret);
      	wCE6.add(secw);
      	wCE.add(wCE1);
      	wCE.add(wCE2);
      	wCE.add(wCE3);
      	wCE.add(wCE4);
      	wCE.add(wCE5);
      	wCE.add(wCE6);
      	wCE7.add(wPhotoModify);
      	wCE7.add(wModify);
      	wCE.add(wCE7);
      	wC.add(wCE);
      	worker.add(wC);
        tab.addTab("������Ϣ", worker);	
/*********************************************************************/		
		//ҵ��(�޸���Ϣ���ɷ�
        owner = new JPanel();
        owner.setBorder(new EmptyBorder(5,5,5,5));
        owner.setLayout(new BorderLayout(0,0));
        owner.setBackground(Color.LIGHT_GRAY);
        owner.setVisible(true);
      	//setContentPane(boss);
      	
      	oUp = new JPanel();
      	oUp.setLayout(new BorderLayout());
      	oUp1 = new JPanel();
      	oUp1.setLayout(new FlowLayout());
    	oUp2 = new JPanel();
      	oUp2.setLayout(new FlowLayout());
      	
  		oC = new JPanel();
  		oC.setLayout(new BorderLayout());
  		oCW = new JPanel();
  		oCW.setLayout(new GridLayout(6,1));
  		oCW1 = new JPanel();
  		oCW1.setLayout(new FlowLayout());
  		oCW2 = new JPanel();
  		oCW2.setLayout(new FlowLayout());
  		oCW3 = new JPanel();
  		oCW3.setLayout(new FlowLayout());
  		oCW4 = new JPanel();
  		oCW4.setLayout(new FlowLayout());
  		oCW5 = new JPanel();
  		oCW5.setLayout(new FlowLayout());
  		oCW6 = new JPanel();
  		oCW6.setLayout(new FlowLayout());   	
  		//nameo = "������";
  			oname = new JLabel("���� ");
  			oname.setFont(new Font("",Font.PLAIN,66));
  			nao = new JTextField(4);
  			//na.setSize(200, 50);
  			nao.setFont(new Font("",Font.PLAIN,66));
  		//numbero = "201600301199";
  			ono = new JLabel("ҵ����� ");
  			ono.setFont(new Font("",Font.PLAIN,66));
  			noo = new JTextField(4);
  			noo.setFont(new Font("",Font.ITALIC,66));
  			//no.setSize(200, 50);
  			noo.setFont(new Font("",Font.PLAIN,66));
  		//sexo = "��";
  			osex = new JLabel("�Ա� ");
  			osex.setFont(new Font("",Font.PLAIN,66));
  			seo = new JTextField(2);
  			seo.setFont(new Font("",Font.PLAIN,66));
  		//ageo = 20;
  			oage = new JLabel("���� ");
  			oage.setFont(new Font("",Font.PLAIN,66));
  			ago = new JTextField(2);
  			ago.setFont(new Font("",Font.PLAIN,66));
  		//phoneo = "18340018992";
  			ophone = new JLabel(" �ֻ��� ");
  			ophone.setFont(new Font("",Font.PLAIN,66));
  			pho = new JTextField(8);
  			pho.setFont(new Font("",Font.PLAIN,66));
  		
  		ownerLabel = new JLabel("Owner Service");
  	  		ownerLabel.setFont(new Font("",Font.PLAIN,99));
  	  	ownerHint = new JLabel("����ҵ�����");
			ownerHint.setFont(new Font("",Font.PLAIN,66));
		ownerNo = new JTextField(4);
			ownerNo.setFont(new Font("",Font.ITALIC,66));
		
			//propertyFee = 100;
	  		propertyLabel = new JLabel("��ҵ��");
	        	propertyLabel.setFont(new Font("",Font.PLAIN,66));
	        property = new JTextField(4);
	        	property.setFont(new Font("",Font.PLAIN,66));
	        propertyPay= new JButton("�ɷ�");
	        	propertyPay.setFont(new Font("",Font.PLAIN,44));
	        	propertyPay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String no = ownerNo.getText();
						String sql = "select propertyFee from fee where hno in ("
		        		+ "select hno from house where ono = \'"+no+"\')";
						try {
							DBLink.dbLink();
							ResultSet rs = DBLink.st.executeQuery(sql);
							if(rs.next()){
								String propertyFee = rs.getInt("propertyFee")+"";
								String propertyAccept = property.getText();
								String sql1 = "update fee set propertyFee = "+propertyFee+"-"+propertyAccept
										+ " where hno in (select hno from house where ono = \'"+no+"\')";
								DBLink.st.executeUpdate(sql1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
						}
					}      		
	        	});
	        //utilityFee = 100;
	        utilityLabel = new JLabel("ˮ������");
	        	utilityLabel.setFont(new Font("",Font.PLAIN,66));
	        utility = new JTextField(4);
	        	utility.setFont(new Font("",Font.PLAIN,66));
	        utilityPay= new JButton("�ɷ�");
	        	utilityPay.setFont(new Font("",Font.PLAIN,44));	
	        	utilityPay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String no = ownerNo.getText();
						String sql = "select utilityFee from fee where hno in ("
		        		+ "select hno from house where ono = \'"+no+"\')";
						try {
							DBLink.dbLink();
							ResultSet rs = DBLink.st.executeQuery(sql);
							if(rs.next()){
								String utilityFee = rs.getInt("utilityFee")+"";
								String utilityAccept = utility.getText();
								String sql1 = "update fee set utilityFee = "+utilityFee+"-"+utilityAccept
										+ " where hno in (select hno from house where ono = \'"+no+"\')";
								DBLink.st.executeUpdate(sql1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
						}
					}      		
	        	});
	        //cableFee = 30;
	        cableLabel = new JLabel("���ߵ��ӷ�");
	        	cableLabel.setFont(new Font("",Font.PLAIN,66));
	        cable = new JTextField(4);
	        	cable.setFont(new Font("",Font.PLAIN,66));
	        cablePay= new JButton("�ɷ�");
	        	cablePay.setFont(new Font("",Font.PLAIN,44));	
	        	cablePay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String no = ownerNo.getText();
						String sql = "select cableFee from fee where hno in ("
		        		+ "select hno from house where ono = \'"+no+"\')";
						try {
							DBLink.dbLink();
							ResultSet rs = DBLink.st.executeQuery(sql);
							if(rs.next()){
								String cableFee = rs.getInt("cableFee")+"";
								String cableAccept = cable.getText();
								String sql1 = "update fee set cableFee = "+cableFee+"-"+cableAccept
										+ " where hno in (select hno from house where ono = \'"+no+"\')";
								DBLink.st.executeUpdate(sql1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
						}
					}      		
	        	});
	        //heatingFee = 300;
	        heatingLabel = new JLabel("ů����");
	        	heatingLabel.setFont(new Font("",Font.PLAIN,66));
	        heating = new JTextField(4);
	         	heating.setFont(new Font("",Font.PLAIN,66));
	        heatingPay= new JButton("�ɷ�");
	        	heatingPay.setFont(new Font("",Font.PLAIN,44));
	        	heatingPay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String no = ownerNo.getText();
						String sql = "select heatingFee from fee where hno in ("
		        		+ "select hno from house where ono = \'"+no+"\')";
						try {
							DBLink.dbLink();
							ResultSet rs = DBLink.st.executeQuery(sql);
							if(rs.next()){
								String heatingFee = rs.getInt("heatingFee")+"";
								String heatingAccept = heating.getText();
								String sql1 = "update fee set heatingFee = "+heatingFee+"-"+heatingAccept
										+ " where hno in (select hno from house where ono = \'"+no+"\')";
								DBLink.st.executeUpdate(sql1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
						}
					}      		
	        	});
	        //parkingFee = 100;
	        parkingLabel = new JLabel("��λ��");
	        	parkingLabel.setFont(new Font("",Font.PLAIN,66));
	        parking = new JTextField(4);
	        	parking.setFont(new Font("",Font.PLAIN,66));
	        parkingPay= new JButton("�ɷ�");
	        	parkingPay.setFont(new Font("",Font.PLAIN,44));	
	        	parkingPay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String no = ownerNo.getText();
						String sql = "select parkingFee from fee where hno in ("
		        		+ "select hno from house where ono = \'"+no+"\')";
						try {
							DBLink.dbLink();
							ResultSet rs = DBLink.st.executeQuery(sql);
							if(rs.next()){
								String parkingFee = rs.getInt("parkingFee")+"";
								String parkingAccept = parking.getText();
								String sql1 = "update fee set parkingFee = "+parkingFee+"-"+parkingAccept
										+ " where hno in (select hno from house where ono = \'"+no+"\')";
								DBLink.st.executeUpdate(sql1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}finally{
							DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
						}
					}      		
	        	});
	  			
			
		ownerConfirm = new JButton("ȷ��");
			ownerConfirm.setFont(new Font("",Font.PLAIN,66));
			ownerConfirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String oNo = ownerNo.getText();
				nameo = getOwnerName(oNo);
				sexo = getOwnerSex(oNo);
				ageo = getOwnerAge(oNo);
				phoneo = getOwnerPhone(oNo); 
				try {
					DBLink.dbLink();
					String sql = "select propertyFee,utilityFee,cableFee,heatingFee,parkingFee "
							+ "from fee where hno in ("
			        		+ "select hno from house where ono = \'"+oNo+"\')";
					ResultSet rs =  DBLink.st.executeQuery(sql);
					if(rs.next()){
						propertyFee = rs.getInt("propertyFee");
						utilityFee = rs.getInt("utilityFee");
						cableFee = rs.getInt("cableFee");
						heatingFee = rs.getInt("heatingFee");
						parkingFee = rs.getInt("parkingFee");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				noo.setText(oNo);
				nao.setText(nameo);
				seo.setText(sexo);
				ago.setText(ageo);
				pho.setText(phoneo);
				property.setText(propertyFee+"");
				utility.setText(utilityFee+"");
				cable.setText(cableFee+"");
				heating.setText(heatingFee+"");
				parking.setText(parkingFee+"");
			}			
			});
  	  		oUp1.add(ownerLabel);		
  	  		oUp2.add(ownerHint);
  	  		oUp2.add(ownerNo);
  	  		oUp2.add(ownerConfirm);
  	  		oUp.add(oUp1,BorderLayout.NORTH);
  	  		oUp.add(oUp2,BorderLayout.SOUTH);
  	  		owner.add(oUp, BorderLayout.NORTH); 

  		oModify = new JButton("ȷ���޸�ҵ����Ϣ");
      		oModify.setFont(new Font("",Font.PLAIN,66));
      		oModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//String newONo = ownerNo.getText();
					String oNo = ownerNo.getText();
					String newNameo = nao.getText();
					String newSexo = seo.getText();
					String newAgeo = ago.getText();
					String newPhoneo = pho.getText();
					SetOwner(oNo,newNameo,newSexo,newAgeo,newPhoneo);
				}			
  			});
        oCW1.add(oname);	
      	oCW1.add(nao);
      	//oCW2.add(ono);
      	//oCW2.add(noo);
      	oCW3.add(osex);
      	oCW3.add(seo);
      	oCW4.add(oage);	
      	oCW4.add(ago);
      	oCW5.add(ophone);
      	oCW5.add(pho);
      	oCW6.add(oModify);
      	oCW.add(oCW1);
      	//oCW.add(oCW2);
      	oCW.add(oCW3);
      	oCW.add(oCW4);
      	oCW.add(oCW5);
      	oCW.add(oCW6);
      	oC.add(oCW,BorderLayout.WEST);
      	
      	oCE = new JPanel();
        oCE.setLayout(new BorderLayout());
        oCE1 = new JPanel();
        oCE1.setLayout(new GridLayout(5,3));
        //oCE2 = new JPanel();
        //oCE2.setLayout(new GridLayout());
       
        
        oCE1.add(propertyLabel);
        oCE1.add(property);
        oCE1.add(propertyPay);
        oCE1.add(utilityLabel);
        oCE1.add(utility);
        oCE1.add(utilityPay);
        oCE1.add(cableLabel);
        oCE1.add(cable);
        oCE1.add(cablePay);
        oCE1.add(heatingLabel);
        oCE1.add(heating);
        oCE1.add(heatingPay);
        oCE1.add(parkingLabel);
        oCE1.add(parking);
        oCE1.add(parkingPay);
        oCE.add(oCE1);
        oC.add(oCE,BorderLayout.EAST);
      	owner.add(oC);
        tab.addTab("ҵ��", owner);	

/*********************************************8*******************************/
      //������Ϣ����(�޸���Ϣ��Ƿ��
        house = new JPanel();
        house.setBorder(new EmptyBorder(5,5,5,5));
        house.setLayout(new BorderLayout(0,0));
        house.setBackground(Color.LIGHT_GRAY);
        house.setVisible(true);
      	
      	hUp = new JPanel();
      	hUp.setLayout(new BorderLayout());
      	hUp1 = new JPanel();
        hUp1.setLayout(new FlowLayout());
        hUp2 = new JPanel();
        hUp2.setLayout(new FlowLayout());
	 	
        hC = new JPanel();
        hC.setLayout(new BorderLayout());
        hCW = new JPanel();
        hCW.setLayout(new GridLayout(5,1));
        hCW1 = new JPanel();
        hCW1.setLayout(new FlowLayout());
        hCW2 = new JPanel();
        hCW2.setLayout(new FlowLayout());
        hCW3 = new JPanel();
        hCW3.setLayout(new FlowLayout());
        hCW4 = new JPanel();
        hCW4.setLayout(new FlowLayout()); 	
        hCW5 = new JPanel();
        hCW5.setLayout(new FlowLayout());
        //building = 11;
        	buildingLabel = new JLabel("¥�� ");
        	buildingLabel.setFont(new Font("",Font.PLAIN,66));
        	buildingNo = new JTextField(4);
        	buildingNo.setFont(new Font("",Font.PLAIN,66));
        //unit = 1;
        	unitLabel = new JLabel("��Ԫ�� ");
        	unitLabel.setFont(new Font("",Font.PLAIN,66));
        	unitNo = new JTextField(4);
        	unitNo.setFont(new Font("",Font.PLAIN,66));
        //room = 301;
        	roomLabel = new JLabel("����� ");
        	roomLabel.setFont(new Font("",Font.PLAIN,66));
        	roomNo = new JTextField(4);
        	roomNo.setFont(new Font("",Font.PLAIN,66));
        //own = 1000;
        	ownLabel = new JLabel("������� ");
        	ownLabel.setFont(new Font("",Font.PLAIN,66));
        	ownNo = new JTextField(4);
        	ownNo.setFont(new Font("",Font.PLAIN,66));
      
      	houseLabel = new JLabel("House Manage");
      		houseLabel.setFont(new Font("",Font.PLAIN,99));	
       	houseHint = new JLabel("���뷿�ݱ�� ");
       		houseHint.setFont(new Font("",Font.PLAIN,66));
       	houseNo = new JTextField(7);
       		houseNo.setFont(new Font("",Font.ITALIC,66));
       		
       	//propertyAdd = 100;
            propertyHint = new JLabel("��ҵ��");
            	propertyHint.setFont(new Font("",Font.BOLD,66));
            propertyIn = new JTextField(4);
                propertyIn.setFont(new Font("",Font.PLAIN,66));
            propertySet= new JButton("���");
                propertySet.setFont(new Font("",Font.PLAIN,44));
                propertySet.addActionListener(new ActionListener(){
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String hNo = houseNo.getText();
    					String property = propertyIn.getText();
    					try {
    						DBLink.dbLink();
    						String sql = "select propertyFee from fee where hno = \'"+hNo+"\'";
    						ResultSet rs =  DBLink.st.executeQuery(sql);
    						if(rs.next()){
    							propertyAdd = rs.getInt("propertyFee");
    						}
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					String sql = "update fee set propertyFee = "+property+"+"+propertyAdd+" where hno = \'"+hNo+"\'";
    					try {
    						DBLink.dbLink();
    						DBLink.st.executeUpdate(sql);
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}finally{
    						DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
    					}
    				}       	
                });
            //utilityAdd = 100;
            utilityHint = new JLabel("ˮ������");
                utilityHint.setFont(new Font("",Font.BOLD,66));
            utilityIn = new JTextField(4);
                utilityIn.setFont(new Font("",Font.PLAIN,66));
            utilitySet= new JButton("���");
                utilitySet.setFont(new Font("",Font.PLAIN,44));	
                utilitySet.addActionListener(new ActionListener(){
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String hNo = houseNo.getText();
    					String utility = utilityIn.getText();
    					try {
    						DBLink.dbLink();
    						String sql = "select utilityFee from fee where hno = \'"+hNo+"\'";
    						ResultSet rs =  DBLink.st.executeQuery(sql);
    						if(rs.next()){
    							utilityAdd = rs.getInt("utilityFee");						
    						}
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					String sql = "update fee set utilityFee = "+utility+"+"+utilityAdd+" where hno = \'"+hNo+"\'";
    					try {
    						DBLink.dbLink();
    						DBLink.st.executeUpdate(sql);
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}finally{
    						DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
    					}
    				}       	
                });
            //cableAdd = 30;
            cableHint = new JLabel("���ߵ��ӷ�");
                cableHint.setFont(new Font("",Font.BOLD,66));
            cableIn = new JTextField(4);
                cableIn.setFont(new Font("",Font.PLAIN,66));
            cableSet= new JButton("���");
                cableSet.setFont(new Font("",Font.PLAIN,44));	
                cableSet.addActionListener(new ActionListener(){
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String hNo = houseNo.getText();
    					String cable = cableIn.getText();
    					try {
    						DBLink.dbLink();
    						String sql = "select cableFee from fee where hno = \'"+hNo+"\'";
    						ResultSet rs =  DBLink.st.executeQuery(sql);
    						if(rs.next()){
    							cableAdd = rs.getInt("cableFee");
    						}
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					String sql = "update fee set cableFee = "+cable+"+"+cableAdd+" where hno = \'"+hNo+"\'";
    					try {
    						DBLink.dbLink();
    						DBLink.st.executeUpdate(sql);
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}finally{
    						DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
    					}
    				}       	
                });
            //heatingAdd = 300;
            heatingHint = new JLabel("ů����");
            	heatingHint.setFont(new Font("",Font.BOLD,66));
            heatingIn = new JTextField(4);
                heatingIn.setFont(new Font("",Font.PLAIN,66));
            heatingSet= new JButton("���");
                heatingSet.setFont(new Font("",Font.PLAIN,44));
                heatingSet.addActionListener(new ActionListener(){
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String hNo = houseNo.getText();
    					String heating = heatingIn.getText();
    					try {
    						DBLink.dbLink();
    						String sql = "select heatingFee from fee where hno = \'"+hNo+"\'";
    						ResultSet rs =  DBLink.st.executeQuery(sql);
    						if(rs.next()){
    							heatingAdd = rs.getInt("heatingFee");
    						}
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					String sql = "update fee set heatingFee = "+heating+"+"+heatingAdd+" where hno = \'"+hNo+"\'";
    					try {
    						DBLink.dbLink();
    						DBLink.st.executeUpdate(sql);
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}finally{
    						DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
    					}
    				}       	
                });
            //parkingAdd = 100;
            parkingHint = new JLabel("��λ��");
               	parkingHint.setFont(new Font("",Font.BOLD,66));
            parkingIn = new JTextField(4);
                parkingIn.setFont(new Font("",Font.PLAIN,66));
            parkingSet= new JButton("���");
                parkingSet.setFont(new Font("",Font.PLAIN,44));
                parkingSet.addActionListener(new ActionListener(){
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String hNo = houseNo.getText();
    					String parking = parkingIn.getText();
    					try {
    						DBLink.dbLink();
    						String sql = "select parkingFee from fee where hno = \'"+hNo+"\'";
    						ResultSet rs =  DBLink.st.executeQuery(sql);
    						if(rs.next()){
    							parkingAdd = rs.getInt("parkingFee");
    						}
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
    					String sql = "update fee set parkingFee = "+parking+"+"+parkingAdd+" where hno = \'"+hNo+"\'";
    					try {
    						DBLink.dbLink();
    						DBLink.st.executeUpdate(sql);
    					} catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}finally{
    						DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
    					}
    				}       	
                });	
       		
       	houseConfirm = new JButton("ȷ��");
       		houseConfirm.setFont(new Font("",Font.PLAIN,66));
       		houseConfirm.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String hNo = houseNo.getText();
					try {
						DBLink.dbLink();
						String sql = "select propertyFee,utilityFee,cableFee,heatingFee,parkingFee "
								+ "from fee where hno = \'"+hNo+"\'";
						ResultSet rs =  DBLink.st.executeQuery(sql);
						if(rs.next()){
							propertyAdd = rs.getInt("propertyFee");
							utilityAdd = rs.getInt("utilityFee");
							cableAdd = rs.getInt("cableFee");
							heatingAdd = rs.getInt("heatingFee");
							parkingAdd = rs.getInt("parkingFee");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					building = getBuildingNo(hNo);
					unit = getUnitNo(hNo);
					room = getRoomNo(hNo);
					own = getOwnerNo(hNo);
					buildingNo.setText(building);
					unitNo.setText(unit);
					roomNo.setText(room);
					ownNo.setText(own);
					propertyIn.setText(propertyAdd+"");
					utilityIn.setText(utilityAdd+"");
					cableIn.setText(cableAdd+"");
					heatingIn.setText(heatingAdd+"");
					parkingIn.setText(parkingAdd+"");
				}     		
        	});
       	hModify = new JButton("ȷ���޸ķ�����Ϣ");
       		hModify.setFont(new Font("",Font.PLAIN,66));
       		hModify.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String hNo = houseNo.getText();
					String newBuilding = buildingNo.getText();
					String newUnit = unitNo.getText();
					String newRoom = roomNo.getText();
					String newOno = ownNo.getText();
					SetHouse(hNo,newBuilding,newUnit,newRoom,newOno);
				}     		
       		});
        hUp1.add(houseLabel);	
        hUp2.add(houseHint);
       	hUp2.add(houseNo);
       	hUp2.add(houseConfirm);
       	hUp.add(hUp1, BorderLayout.NORTH);
       	hUp.add(hUp2, BorderLayout.SOUTH);
       	house.add(hUp,BorderLayout.NORTH);
   
        hCW1.add(buildingLabel);	
        hCW1.add(buildingNo);
        hCW2.add(unitLabel);
       	hCW2.add(unitNo);
       	hCW3.add(roomLabel);
       	hCW3.add(roomNo);
       	hCW4.add(ownLabel);	
       	hCW4.add(ownNo);
       	hCW5.add(hModify);
       	hCW.add(hCW1);
       	hCW.add(hCW2);
       	hCW.add(hCW3);
       	hCW.add(hCW4);
       	hCW.add(hCW5);
        hC.add(hCW,BorderLayout.WEST);
           	
        hCE = new JPanel();
        hCE.setLayout(new BorderLayout());
        hCE1 = new JPanel();
        hCE1.setLayout(new GridLayout(5,3));
        //oCE2 = new JPanel();
        //oCE2.setLayout(new GridLayout());
        
        hCE1.add(propertyHint);
        hCE1.add(propertyIn);
        hCE1.add(propertySet);
        hCE1.add(utilityHint);
        hCE1.add(utilityIn);
        hCE1.add(utilitySet);
        hCE1.add(cableHint);
        hCE1.add(cableIn);
        hCE1.add(cableSet);
        hCE1.add(heatingHint);
        hCE1.add(heatingIn);
        hCE1.add(heatingSet);
        hCE1.add(parkingHint);
        hCE1.add(parkingIn);
        hCE1.add(parkingSet);
        hCE.add(hCE1);
        hC.add(hCE,BorderLayout.EAST);
             
        house.add(hC);
      		
      	tab.add("����",house);
    }
/********************************************************************************/   
  //��ȡworker ��Ϣ
    public static String getSecret(String mno){
    	String secret = "";
    	DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
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
    	DBLink.dbLink();
    	String sql = "select * from employee where eno = \'"+mno+"\'";
    	try {
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
    		DBLink.dbLink();
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
    //�޸�worker ��Ϣ
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
   
    //��ȡowner ��Ϣ
    public static String getOwnerName(String ono){
    	String name = "";
    	DBLink.dbLink();
    	String sql = "select * from owner where ono = \'"+ono+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				name = st.getString("oname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return name;
    }
    public static String getOwnerSex(String ono){
    	String sex = "";
    	DBLink.dbLink();
    	String sql = "select * from owner where ono = \'"+ono+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				sex = st.getString("osex");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return sex;
    }
    public static String getOwnerAge(String ono){
    	String age = "";
    	DBLink.dbLink();
    	String sql = "select * from owner where ono = \'"+ono+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				age = st.getInt("oage")+"";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return age;
    }
    public static String getOwnerPhone(String ono){
    	String phone = "";
    	DBLink.dbLink();
    	String sql = "select * from owner where ono = \'"+ono+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				phone = st.getString("ophone");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return phone;
    }
    //�޸�owner ��Ϣ
    public static void SetOwner(String ono,String name,String sex,String age,String phone){
    	DBLink.dbLink();
    	String sql1 = "update owner set oname = \'"+name+"\' where ono = \'"+ono+"\'";
    	//String sql2 = "update owner set ono = \'"+no+"\' where eno = \'"+ono+"\'";
    	String sql2 = "update owner set osex = \'"+sex+"\' where ono = \'"+ono+"\'";
    	String sql3 = "update owner set oage = "+age+" where ono = \'"+ono+"\'";
    	String sql4 = "update owner set ophone = \'"+phone+"\' where ono = \'"+ono+"\'";
    	try {
			DBLink.st.executeUpdate(sql1);
			DBLink.st.executeUpdate(sql2);
			DBLink.st.executeUpdate(sql3);
			DBLink.st.executeUpdate(sql4);
			//DBLink.st.executeUpdate(sql5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
    
    //��ȡhouse ��Ϣ
    public static String getBuildingNo(String hno){
    	String name = "";
    	DBLink.dbLink();
    	String sql = "select * from house where hno = \'"+hno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				name = st.getString("buildingNo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return name;
    }
    public static String getUnitNo(String hno){
    	String sex = "";
    	DBLink.dbLink();
    	String sql = "select * from house where hno = \'"+hno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				sex = st.getString("unitNo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return sex;
    }
    public static String getRoomNo(String hno){
    	String age = "";
    	DBLink.dbLink();
    	String sql = "select * from house where hno = \'"+hno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				age = st.getInt("roomNo")+"";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return age;
    }
    public static String getOwnerNo(String hno){
    	String phone = "";
    	DBLink.dbLink();
    	String sql = "select * from house where hno = \'"+hno+"\'";
    	try {
			ResultSet st = DBLink.st.executeQuery(sql);
			if(st.next()){
				phone = st.getString("ono");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    	return phone;
    }
    //�޸�house ��Ϣ
    public static void SetHouse(String hno,String buildingNo,String unitNo,String roomNo,String ono){
    	DBLink.dbLink();
    	String sql1 = "update house set buildingNo = "+buildingNo+" where hno = \'"+hno+"\'";
    	String sql2 = "update house set unitNo = "+unitNo+" where hno = \'"+hno+"\'";
    	String sql3 = "update house set roomNo = "+roomNo+" where hno = \'"+hno+"\'";
    	String sql4 = "update house set ono = \'"+ono+"\' where hno = \'"+hno+"\'";
    	try {
			DBLink.st.executeUpdate(sql1);
			DBLink.st.executeUpdate(sql2);
			DBLink.st.executeUpdate(sql3);
			DBLink.st.executeUpdate(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
    }
}  

