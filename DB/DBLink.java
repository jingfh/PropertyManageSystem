package DB;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLink{
	
	private static String dburl,dbuser,dbpassword;
	public static Connection con;
	
	public static Statement st;//sql����ִ��
	public static PreparedStatement pst;//Ԥ����
	public static ResultSet rs;//�����

///////////////////////////////////////////////////////////////////////////////////////
	//�������ݿ�
	public static void dbLink(){
		
		try{
			//����JDBC��������
			Class.forName("com.mysql.jdbc.Driver");				
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			System.out.println("������������ɹ�!!!");
		}
		try{
			//�������ݿ�
			dburl="jdbc:mysql://localhost:3306/managesystem?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			dbuser="root";
			dbpassword="root";
			con=DriverManager.getConnection(dburl, dbuser, dbpassword);
		}catch(SQLException sqle){
			System.out.println("SQL:::connectionException:"+sqle);
		}finally{
			if(con!=null){
				System.out.println("���ݿ����ӳɹ�!!!");
			}else{
				System.out.println("���ݿ�����ʧ��!!!");
			}
		}	
		try {
			//��������
			con=DriverManager.getConnection(dburl, dbuser, dbpassword);
			st=con.createStatement();
		} catch(SQLException sqle){
			System.out.println("SQL:::statementException:"+sqle);
		}		
	}
	//�ͷ����ݿ�
	 public static void release(Connection con , Statement st,ResultSet rs,PreparedStatement pst){//�ر����ݿ�����
         if(st != null){
                try {
                       st.close();
                } catch (SQLException e) {
                       e.printStackTrace();
                }
         }
         if(con != null){
                try {
                       con.close();
                } catch (SQLException e) {
                       e.printStackTrace();
                }
         }       
         if(pst != null){
             try {
                    pst.close();
             } catch (SQLException e) {
                    e.printStackTrace();
             }
         }
         if(rs != null){
             try {
                    rs.close();
             } catch (SQLException e) {
                    e.printStackTrace();
             }
         }       
         System.out.println("���ݿ��ѶϿ�");
   }
}

	

