import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.callback.LanguageCallback;


public class dbDemo {


	public static void main(String[] args) {
		dbDemo demo=new dbDemo();
		//	demo.testconnection();
		//	demo.testBlob();
		//  demo.testJava2rs();
		demo.testTransaction();

	}

	
	// Object Relation mapping just introduction to Hibernet
	
	public void testTransaction() {
		Connection con=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
			System.out.println(con);
			
			con.setAutoCommit(false);
			
			String sql1="update employee set fname='xxx' where id=1";
			String sql2="update employee set fname='Chandani' where id=5";
			
			Statement stmt=con.createStatement();
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			
			int[] n=stmt.executeBatch();
			
			System.out.println(n[0]+" "+n[1]);
			con.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.close();
							} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}


	public void testJava2rs() {
		Connection con=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
			System.out.println(con);
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select * from employee");
			
			rs.last();
			rs.previous();
			rs.moveToInsertRow();
			rs.updateInt(1,75);
			rs.updateString(2,"my");
			rs.updateString(3,"surname");
			rs.insertRow();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void testBlob() {
		Connection con=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
			System.out.println(con);

			String create=
				"CREATE TABLE BLOBDEMO (ID INT NOT NULL,PHOTO blob,PRIMARY KEY (ID)) ENGINE=INNODB";

			Statement stmt=con.createStatement();
			//System.out.println(stmt.execute(create));

			String insert ="insert into blobdemo(id,PHOTO) values(?,?) ";
			PreparedStatement ps=con.prepareStatement(insert);
			File file=new File("c:\\tiger.jpg");
			FileInputStream fis=new FileInputStream(file);

			ps.setInt(1,23);
			ps.setBinaryStream(2,fis,(int)file.length()); // check once again important
			ps.execute();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	public void testconnection() {

		//1. Register Database Drivers
		//2.add jar into workspace
		//3.Get the connection from Driver

		Connection con=null;
		Statement stat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
			System.out.println(con);
			stat=con.createStatement();
			String query="insert into employee(id,fname,lname) values"+
			"(4,'dr sud','hagavane'),(5,'kuldeep','gaikwad'),"+
			"(6,'sudarshan','gaikwad'),(7,'dipali','gaikwad')";

			//	int n=stat.executeUpdate(query);
			//	System.out.println("Rows updated : "+n);

			/* * Retrive from employee  */

			String select="select * from employee";
			ResultSet rs=stat.executeQuery(select);
			ResultSetMetaData rs1=rs.getMetaData();

			System.out.println(rs1.getTableName(1));
			System.out.println(rs1.getColumnLabel(1)+" "+rs1.getColumnLabel(2)+" "+rs1.getColumnLabel(3));

			while (rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2); // by id fname=
				String lname=rs.getString("lname");
				System.out.println(id+ " " +fname +" "+lname);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
