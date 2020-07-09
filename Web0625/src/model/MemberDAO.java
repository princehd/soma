package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private String user = "system";
	private String password = "12345";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// DB���� �޼ҵ�
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean join(MemberDTO dto) {
		// TODO Auto-generated method stub
		getConnection();
		String sql = "insert into member values(?,?,?)";
		int rows = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			rows = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		if(rows == 0)
			return false;
		else
			return true;
	}

	public boolean login(MemberDTO dto) {
		getConnection();
		String sql = "select * from member"+
					 " where id = ? and pw = ?";
		String name = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();
			if(rs.next()) {
				// �α��� ����
				name = rs.getString("name");
				// ���� ���� -> ��Ű,����	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		if(name == null)
			return false;
		else
			return true;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}




