package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;

import com.mysql.jdbc.Blob;

import DB.DBLink;

public class ImageDemo {

	 
	private static File file = null;
	
	// 上传图片
	public static void putImg(String sql) {
		DBLink.dbLink();
		try {
			//DefaultListModel<File> model=new DefaultListModel<>();
			JFileChooser chooser=new JFileChooser(); 
			chooser.setMultiSelectionEnabled(false);//多选，不支持
	        int v=chooser.showOpenDialog(null);
	        if(v==JFileChooser.APPROVE_OPTION){  	
	            //File file=chooser.getSelectedFile();
	        	file=chooser.getSelectedFile();
	        	/*for(int i=0;i<files.length;i++){
	        		//String path=files[i].getAbsolutePath();
	        		//String name=files[i].getName();
	        		model.addElement(files[i]);
	        	}*/
	        }
			//file = new File("c://blog.jpg");
			InputStream photoStream = new FileInputStream(file);
		//sql = "update boss set bimage = ? where bno = \'"+bno+"\'";	     
			//sql = "INSERT INTO boss(bimage) VALUES (?)";	   
			DBLink.pst = DBLink.con.prepareStatement(sql);
			//DBLink.pst.setBinaryStream(1, photoStream, (int) file.length());
			DBLink.pst.setBlob(1, photoStream, (int) file.length());
			DBLink.pst.executeUpdate();
			
		} catch (Exception e) {
		   e.printStackTrace();
		}finally{
			DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
		}
	}
		/*public static void main(String args[]){
		PutImg pi=new PutImg();
		pi.putimg();
		}*/
	
	// 显示图片
		public static String blobRead(String sql,String photo) throws Exception {
			try {	
				DBLink.dbLink();
				//String sql = "SELECT picture FROM animal WHERE id=5";
	            DBLink.pst = DBLink.con.prepareStatement(sql);
	            DBLink.rs = DBLink.pst.executeQuery();
	            if(DBLink.rs.next()){            
	                 Blob picture = (Blob) DBLink.rs.getBlob(1);//得到Blob对象
	                 //开始读入文件
	                 InputStream in = picture.getBinaryStream();
	                 
	                 file = new File(photo);
	                 if (!file.exists()) {
	                  file.createNewFile(); // 如果文件不存在，则创建
	                 }
	                 @SuppressWarnings("resource")
					OutputStream out = new FileOutputStream(file);
	               
	                 byte[] buffer = new byte[16000000];
	                 int len = 0;
	                 while((len = in.read(buffer)) != -1){
	               	  	out.write(buffer, 0, len);
	                 }	                
	            }	
	            //DBLink.rs.update();
	            //DBLink.pst.executeUpdate();
			} catch (Exception e) {
				System.out.println( "aaaaa"+e.getMessage());
			} finally {
				DBLink.release(DBLink.con, DBLink.st, DBLink.rs, DBLink.pst);
			}
			return photo;
		}
		/*public static void main(String[] args) {
		try {
		   GetImg gi=new GetImg();
		   gi.blobRead("c:/getimgs/1.jpg", 5);
		} catch (Exception e) {
		   System.out.println("[Main func error: ]" + e.getMessage());
		}
		}*/
}
