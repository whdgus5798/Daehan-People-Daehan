package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConnection;

public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public UserDAO() {
		conn = new DBConnection().getConnection();
	}
	/////////////////////////////////////////////////////////////////////
	// ↓ UserDAO 로직
	//무조건 다 사용할 필요없이 필요한 메서드를 골라서 사용해주세요.
	
	//아이디 유효성 검사(로그인)
	public int confirmLogin(String id, String pw) {
		int result = 0;
		
		String sql = "SELECT * FROM members WHERE user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("user_pw").equals(pw)) result = 1;  
								//result == 1 >>> 아이디: 일치 / 비밀번호: 일치
				else result = -1;									
								//result == -1 >>> 아이디: 일치 / 비밀번호: 불일치
			} else result = 0;
								//result = 0 >>> 아이디: 불일치 / 비밀번호: 검사하지 않음
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//회원가입
	public void registMember(String id, String pw, String name) {
		
		String sql = "INSERT INTO members VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//아이디 중복체크
	public boolean doubleCheckId(String id) {
		boolean result = false;
		
		String sql = "SELECT user_id FROM members WHERE user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) result = false;
						//result == false >> 아이디 중복(등록된 아이디가 존재)
			else result = true;
						//result == true >> 아이디 중복되지 않음(등록된 아이디가 존재하지 않음)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//하나의 회원정보 출력
	public UserVO getUserInfo(String id) {
		UserVO vo = null;
		
		String sql = "SELECT * FROM members WHERE user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new UserVO(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	//회원 탈퇴
	public void deleteUser(String id) {
		
		String sql = "DELETE FROM members WHERE user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//회원정보 변경(비밀번호 변경 포함)
	public void changeUserInfo(UserVO vo) {
		
		String sql = "UPDATE members SET user_pw = ?, user_name = ? WHERE user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_pw());
			pstmt.setString(2, vo.getUser_name());
			pstmt.setString(3, vo.getUser_id());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
