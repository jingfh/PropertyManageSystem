package GUI;

import DB.DBLink;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import net.sf.json.JSONObject;

import java.io.BufferedReader;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;



//import net.sf.json.JSONObject;
/*
 * 2.3
 * �һ��������
 * copyright@2018.07.20 by JingFanghao
 */
@SuppressWarnings("serial")
public class GetBackPW extends JFrame{

	private JLabel hint,info,confirmLabel,phoneLabel;
	//private JPanel top,in,down;
	private JButton confirm,send,submit;
	private JTextField no,confirmNo;

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
					new GetBackPW();
					//identify.setVisible(true);			
				} catch (Exception e) {
					//e.printStackTrace();
					System.out.println(e);
				}finally{	}
			}
		});
		
		//���Թ���
		String result = getResult("18340018992");
	    System.out.println("��֤�룺"+randNum+"\t"+result);

	     //MD5("123456") ;
	    
	}
	
//���캯��
	public GetBackPW(){
		
		super("GetBackPW");
		setResizable(false);
		//setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		setSize(300,300);
		//setBounds(100, 100, 300, 300);
		setLocation(WindowXY.getXY(this.getSize()));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	//1.���������	
		//top = new JPanel();
		//top.setBounds(0,0,300, 60);
		String s = "���������Ĺ���:";
		hint = new JLabel(s);
		hint.setFont(new Font("",Font.PLAIN,23));
		hint.setBounds(30,20,300,30);
		//top.add(hint);
		no = new JTextField("");
		no.setBounds(30,50,150,30);
		//top.add(no);
		//getContentPane().add(top);
		getContentPane().add(hint);
		getContentPane().add(no);
		
		confirm = new JButton("ȷ��");
		confirm.setBounds(200,50, 70, 30);
		confirm.setFont(new Font("",Font.BOLD,20));
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBLink.dbLink();
				String id = no.getText();
				String sql = "select * from employee where eno = \'"+id+"\'";
				try {
					ResultSet st = DBLink.st.executeQuery(sql);
					if(st.next()){
						String ephone = st.getString("ephone");
						phoneLabel.setText(ephone);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}		
		});
		getContentPane().add(confirm);
		
	//2.��֤��
		//in = new JPanel();
		//in.setBounds(110,84,50, 100);
		String st = "ȷ�Ϸ�����֤�뵽�ֻ���";
		confirmLabel = new JLabel(st);
		confirmLabel.setBounds(30,100, 300,30);
		confirmLabel.setFont(new Font("",Font.PLAIN,23));
		getContentPane().add(confirmLabel);
		
	String phone = "00000000000";
		phoneLabel = new JLabel(phone);
		phoneLabel.setBounds(30,130, 200,30);
		phoneLabel.setFont(new Font("",Font.ITALIC,23));
		getContentPane().add(phoneLabel);
		
		send = new JButton("����");
		send.setBounds(200,130, 70, 30);
		send.setFont(new Font("",Font.BOLD,20));
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}		
		});
		getContentPane().add(send);
		
		String ss = "���������յ�����֤��:";
		info = new JLabel(ss);
		info.setBounds(30,180, 300, 30);
		info.setFont(new Font("",Font.PLAIN,23));
		getContentPane().add(info);
		
		confirmNo = new JTextField("");
		confirmNo.setBounds(30,210,100,30);
		getContentPane().add(confirmNo);
	    //getContentPane().add(in);
		
	//3.�ύ��ť
		submit = new JButton("�ύ");
		submit.setFont(new Font("",Font.BOLD,20));
		submit.setBounds(200, 210, 70,30);
		getContentPane().add(submit);
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
	}
/*******************************************************************************/	
	//������λ�����
	public static String getRandNum() {
        String randNum = new Random().nextInt(1000000)+"";
      //System.out.println("����"+randNum);
        if (randNum.length()!=6) {
            return getRandNum();
        }
        return randNum;
    }
	
	//
	public static String queryArguments(String ACCOUNT_SID,String AUTH_TOKEN, String smsContent,String to) {

        String timestamp = getTimestamp(); //ʱ���
        String sig =  MD5(ACCOUNT_SID,AUTH_TOKEN,timestamp);//ǩ����֤

        String str = "accountSid="+ACCOUNT_SID+"&smsContent="+
                smsContent+"&to="+to+"&timestamp="+timestamp+"&sig="+sig;
        return str;
    }
    /*MD5���� */
    public static String MD5(String... args){ //��̬����
        StringBuffer result = new StringBuffer();
        if (args == null || args.length == 0) {
            return "";
        } else {
            StringBuffer str = new StringBuffer();
            for (String string : args) {
                str.append(string);
            }
            System.out.println("����ǰ��\t"+str.toString());

            try {
            	
                MessageDigest digest = MessageDigest.getInstance("MD5");//��ϢժҪ�㷨
                byte[] bytes = digest.digest(str.toString().getBytes());
                for (byte b : bytes) {
                    String hex = Integer.toHexString(b&0xff);  //ת��ʮ������
                    if (hex.length() == 1) {
                        result.append("0"+hex);
                    }else{
                        result.append(hex);
                    }
                }

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        System.out.println("���ܺ�\t"+result.toString());
        return result.toString();
    }
    /*��ȡʱ���*/
    public static String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return sdf.format(date);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////////////////////////////
    /*�û�ID*/
    public static final String ACCOUNT_SID = "c42e54d811274649b45bcc0270ea510c";

    /*��Կ*/
    public static final String AUTH_TOKEN = "a9b0405*******ab6";

    /*�����ַǰ�벿��*/
    public static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//�����ַ

    public static  String randNum = getRandNum();

    public  static String smsContent = "�������Ƽ���������֤��Ϊ"+randNum+"������"+5+"��������ȷ���룬��Ǳ��˲���������Դ˶��š�";
    
    /*(��ȡ������֤��)*/
    public static String getResult(String to) {
        randNum = getRandNum();
        String smsContent = "�������Ƽ���������֤��Ϊ"+randNum+"������"+5+"��������ȷ���룬��Ǳ��˲���������Դ˶��š�";            
        //�����randNum �� smsContent������ľ�̬������һ���ģ���ɾ���ɱ���
        String args = queryArguments(ACCOUNT_SID, AUTH_TOKEN, smsContent, to);
        OutputStreamWriter out = null;
        //InputStream in = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();

        try {
            URL url = new URL(BASE_URL);
            URLConnection connection = url.openConnection(); //������
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);  //�������ӳ�ʱ
            connection.setReadTimeout(10000);    //���ö�ȡ��ʱ

            //�ύ����
            out = new OutputStreamWriter(connection.getOutputStream(),"utf-8");
            out.write(args);
            out.flush();

            //��ȡ��������
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          String line = "";
            while((line = br.readLine())!=null){
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
                if (out!=null) {
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        /*JSONObject jsonObject = JSONObject.fromObject(sb.toString());
      System.out.println(jsonObject);
        Object object = jsonObject.get("respCode");
      System.out.println("״̬�룺"+object+"��֤�룺"+randNum);
      System.out.println(!object.equals("00000"));
        if (!object.equals("00000")) {
            return object.toString();
        }else{
            return randNum;
        }*/return randNum;
    }

}