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
	
	public static Statement st;//sql命令执行
	public static PreparedStatement pst;//预处理
	public static ResultSet rs;//结果集

///////////////////////////////////////////////////////////////////////////////////////
	//连接数据库
	public static void dbLink(){
		
		try{
			//加载JDBC驱动程序
			Class.forName("com.mysql.jdbc.Driver");				
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			System.out.println("加载驱动程序成功!!!");
		}
		try{
			//连接数据库
			dburl="jdbc:mysql://localhost:3306/managesystem?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			dbuser="root";
			dbpassword="root";
			con=DriverManager.getConnection(dburl, dbuser, dbpassword);
		}catch(SQLException sqle){
			System.out.println("SQL:::connectionException:"+sqle);
		}finally{
			if(con!=null){
				System.out.println("数据库连接成功!!!");
			}else{
				System.out.println("数据库连接失败!!!");
			}
		}	
		try {
			//建立连接
			con=DriverManager.getConnection(dburl, dbuser, dbpassword);
			st=con.createStatement();
		} catch(SQLException sqle){
			System.out.println("SQL:::statementException:"+sqle);
		}		
	}
	//释放数据库
	 public static void release(Connection con , Statement st,ResultSet rs,PreparedStatement pst){//关闭数据库连接
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
         System.out.println("数据库已断开");
   }
}

	

