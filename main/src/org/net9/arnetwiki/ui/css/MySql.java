package org.net9.arnetwiki.ui.css;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

	public static String url = "jdbc:mysql://localhost:3306/test";//characterEncoding=GBK
	public static String username = "root";
	public static String password = "root";
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;
	
	static {
		connect();
	}
	public static void closecont(){
		try{
			stmt.close();
			con.close();
			rs.close();
		} catch(SQLException e) {
			System.out.println("关闭连接失败!"); 
		}
	}
	public static void operation() {
		String sql_select = "select * from wiki";
		String sql_insert = "insert into wiki (info) values('testtesttest')";
		//insert(sql_insert);
		select(sql_select);
	}
	public static void connect() {
		// 定位驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动失败!");
			e.printStackTrace();
		}
		// 建立连接
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			System.out.println("数据库连接成功!"); 
		} catch(SQLException e) {
			System.out.println("数据库连接失败!"); 
		}
	}
	public static void select(String sql) {
		try {
			System.out.println("mysql.select(): " + sql);
			rs = stmt.executeQuery(sql);
			System.out.println("数据查询成功!");
			/*ResultSetMetaData meta_data = rs.getMetaData();//列名
			for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
				System.out.print(meta_data.getColumnLabel(i_col) + "   ");
			}
			System.out.println();
			while (rs.next()) {
				for (int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++) {
					System.out.print(rs.getString(i_col) + "  ");
				}
				System.out.println();
			}
			rs.close();*/
        }catch (Exception e) {
        	System.out.println("数据查询失败!");
        }
	}
	public static void insert(String sql) {
		try {
			System.out.println("mysql.insert(): " + sql);
			stmt.clearBatch();
        	stmt.addBatch(sql);
        	stmt.executeBatch();
        	System.out.println("数据插入成功!");
        }catch (Exception e) {
        	System.out.println("数据插入失败!");
        }
		
	}
	public static void update(String sql) {
		try {
			System.out.println("mysql.update(): " + sql);
        	stmt.executeUpdate(sql);
        	System.out.println("数据更新成功!");
        }catch (Exception e) {
        	System.out.println("数据更新失败!");
        	e.printStackTrace(System.out);
        }
	}
}

