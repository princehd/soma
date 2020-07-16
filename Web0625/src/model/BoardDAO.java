package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private String user = "system";
	private String password = "12345";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// DB立加 皋家靛
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
	
	public BoardDTO selectOneBoard(String num) {
		return null;
	}
	
	public ArrayList<BoardDTO> selectAllBoard(){
		ArrayList<BoardDTO> list 
						= new ArrayList<BoardDTO>();
		
		getConnection(); // DB立加
		String sql = "SELECT * FROM BOARD"
				    + " ORDER BY BOARD_DATE";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int board_num = rs.getInt("board_num");
				String board_title = rs.getString("board_title");
				String board_content = rs.getString("board_content");
				String board_writer = rs.getString("board_writer");
				Date board_date = rs.getDate("board_date");
				BoardDTO dto = new BoardDTO(board_num, board_title, board_content, board_writer, board_date);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
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
