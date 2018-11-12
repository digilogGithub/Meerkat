package com.digilog.meerkat.DBcontroller.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DatabaseDAO {

	String databaseType, IP, port, sid, userID, passWord, SQL;
	int disNum;
	
	private DatabaseDAO oraDao = null;
	private Alert alertError = new Alert(AlertType.ERROR);
	private Alert alertInfo = new Alert(AlertType.INFORMATION);
	
	public DatabaseDAO() {
		
	}
	public DatabaseDAO(String databaseType, String IP, String port, String sid, String userID, String passWord) {
		this.databaseType = databaseType;
		this.IP = IP;
		this.port = port;
		this.sid = sid;
		this.userID = userID;
		this.passWord = passWord;

	}
	
	public void resetOraInstance() {
		if (oraDao != null)
			oraDao = null;
	}
	
	public DatabaseDAO getOraInstance() {
		return oraDao;
	}

	public DatabaseDAO getOraInstance(String databaseType, String IP, String port, String sid, String userID, String passWord) {
//		if (oraDao == null)
//			oraDao = new OraDAO(IP, port, sid, userID, passWord);
//		return oraDao;
		return new DatabaseDAO(databaseType, IP, port, sid, userID, passWord);
	}

//	// db connection, SQL, Result
	BasicDataSource ds = new BasicDataSource();
	private Connection conn;
	// db connection
	public Connection dbConnectHandle() {
////		boolean result = false;
		try {
			ds.setInitialSize(0); //처음 생성할 Connection 수(기본 0)
		    ds.setMaxTotal(1);//Connection 생성 최대 개수(기본 8)
		    ds.setMaxIdle(1);//대여가능한 Connection의 최대개수(기본 8)
////		conn = DriverManager.getConnection("jdbc:oracle:thin:@//" + IP + ":" + port + "/" + sid, userID, passWord);
			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		    ds.setUsername(userID);
		    ds.setPassword(passWord);
		    ds.setUrl("jdbc:oracle:thin:@//" + IP + ":" + port + "/" + sid);  
			conn = ds.getConnection();
//		    result = true;
		} catch (Exception e) {
			showErrorMessageBox(e.getMessage());
			return null;
		}
		return conn;
	}
	
	public Connection connectTest(String sqlstatement,String test) {
		
//		Connection conn = dbConnectHandle();
		conn = dbConnectHandle();
		
			if(conn!=null) {
				
				try {
				PreparedStatement pstmt;
				ResultSet rs;
//				try {
				pstmt = conn.prepareStatement(sqlstatement);
				rs = pstmt.executeQuery();
		
				if(rs!=null)
				{
					if(rs.next())
						showMessageBox(rs.getString(1));
					rs.close();
					pstmt.close();
					if(test==null)
						return conn;
					else {
						conn.close();
						conn = null;
						return null;
					}
					
				}
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					showErrorMessageBox(e.getMessage());
					return null;
				}
			}
		return null;
	}

	
	public void showMessageBox(String meassge) {				
		alertInfo.setTitle("Information Dialog");
		alertInfo.setHeaderText("DATABASE CONNECTION INFO");
		alertInfo.setContentText(meassge);
		alertInfo.showAndWait();
	}

	public void showErrorMessageBox(String errorMeassge) {
		alertError.setTitle("Information Dialog");
		alertError.setHeaderText("DATABASE CONNECTION INFO");
		alertError.setContentText(errorMeassge);
		alertError.showAndWait();
	}
}
	// db close
//	public void close() {
//		try {
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
////		} finally {
////			close();
//		}
//	}

//	public ResultSet exeSql(String sqlStatement) {
//
//		String sql = sqlStatement;
//
//		if (connect()) {
//			try {
//				
////				if (pstmt != null)
//					pstmt = conn.prepareStatement(sql);
//					rs = pstmt.executeQuery();
//				// stmt.close();
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//		}
//
//		return rs;
//	}

//	public ResultSet exeSql(String sqlStatement, String tableName) {
//
//		String sql = sqlStatement;
//		String l_tableName = tableName;
//
//		if (connect()) {
//			try {
////				if (pstmt != null)
//					pstmt = conn.prepareStatement(sql + l_tableName + "' and a.table_name=b.table_name");
//					rs = pstmt.executeQuery();
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, e.getMessage());
//			}
//		}
//		return rs;
//	}
//
//	public ResultSet exeSql(String sqlStatement, Table tableComm, int disNum) {
//		
//		this.disNum = disNum;
//		String sql = sqlStatement;
//		Table l_tableComm = tableComm;
//
//		if (connect()) {
//			try {
////				if (pstmt != null)
//					pstmt = conn.prepareStatement("select * from (select " + l_tableComm.getCname() + ", count(*) from "
//							+ l_tableComm.getTname() + " group by " + l_tableComm.getCname()
//							+ " order by count(*) desc) a where rownum <= " + disNum);
//					rs = pstmt.executeQuery();
//					
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, e.getMessage());
////			} finally {
////				close();
//			}
//		}
//		return rs;
//	}
//}
