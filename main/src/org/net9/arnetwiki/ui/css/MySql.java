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
			System.out.println("�ر�����ʧ��!"); 
		}
	}
	public static void operation() {
		String sql_select = "select * from wiki";
		String sql_insert = "insert into wiki (info) values('testtesttest')";
		//insert(sql_insert);
		select(sql_select);
	}
	public static void connect() {
		// ��λ����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ�!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��!");
			e.printStackTrace();
		}
		// ��������
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			System.out.println("���ݿ����ӳɹ�!"); 
		} catch(SQLException e) {
			System.out.println("���ݿ�����ʧ��!"); 
		}
	}
	public static void select(String sql) {
		try {
			System.out.println("mysql.select(): " + sql);
			rs = stmt.executeQuery(sql);
			System.out.println("���ݲ�ѯ�ɹ�!");
			/*ResultSetMetaData meta_data = rs.getMetaData();//����
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
        	System.out.println("���ݲ�ѯʧ��!");
        }
	}
	public static void insert(String sql) {
		try {
			System.out.println("mysql.insert(): " + sql);
			stmt.clearBatch();
        	stmt.addBatch(sql);
        	stmt.executeBatch();
        	System.out.println("���ݲ���ɹ�!");
        }catch (Exception e) {
        	System.out.println("���ݲ���ʧ��!");
        }
		
	}
	public static void update(String sql) {
		try {
			System.out.println("mysql.update(): " + sql);
        	stmt.executeUpdate(sql);
        	System.out.println("���ݸ��³ɹ�!");
        }catch (Exception e) {
        	System.out.println("���ݸ���ʧ��!");
        	e.printStackTrace(System.out);
        }
	}
}

