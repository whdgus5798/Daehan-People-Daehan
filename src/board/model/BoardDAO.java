package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConnection;

public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public BoardDAO() {
		conn = new DBConnection().getConnection();
	}
	
	/////////////////////////////////////////////////////////////////////
	// ↓ BoardDAO 로직
	//무조건 다 사용할 필요없이 필요한 메서드를 골라서 사용해주세요.
	
	//게시글 등록
	public void insertBoard(String writer, String title, String content) {
		
		String sql = "INSERT INTO board (bd_id, bd_writer, bd_title, bd_content)"
				+ " VALUES (board_sequence.NEXTVAL, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//게시글 수정
	public void updateContent(int bd_id, String title, String content) {
		
		String sql = "UPDATE board SET bd_title = ?, bd_content = ? WHERE bd_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bd_id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//게시글 삭제
	public void deleteBoard(int bd_id) {
		
		String sql = "DELETE FROM board WHERE bd_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bd_id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//글 상세보기 
	public BoardVO showBoardInfo(int bd_id) {
		
		BoardVO vo = null;
		
		String sql = "SELECT * FROM board WHERE bd_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bd_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("bd_id"),
						rs.getString("bd_writer"),
						rs.getString("bd_title"),
						rs.getString("bd_content"),
						rs.getDate("bd_date"),
						rs.getInt("bd_hit")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
		
	}
	
	//전체 글 출력
	public ArrayList<BoardVO> showAllBoard() {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM board ORDER BY bd_id DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("bd_id"),
						rs.getString("bd_writer"),
						rs.getString("bd_title"),
						rs.getString("bd_content"),
						rs.getDate("bd_date"),
						rs.getInt("bd_hit")
						);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//제목으로 글 검색
	public ArrayList<BoardVO> searchBoard(String keyword) {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM board WHERE bd_title LIKE ? ORDER BY bd_id DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("bd_id"),
						rs.getString("bd_writer"),
						rs.getString("bd_title"),
						rs.getString("bd_content"),
						rs.getDate("bd_date"),
						rs.getInt("bd_hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//조회수 상승
	public void incrementHit(int bd_id) {
		
		String sql = "UPDATE board SET bd_hit = bd_hit+1 WHERE bd_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bd_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
