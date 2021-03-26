package page.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConnection;

public class RouteDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public RouteDAO() {
		conn = new DBConnection().getConnection();
	}
	/////////////////////////////////////////////////////////////////////
	// ↓ RouteDAO 로직
	//무조건 다 사용할 필요없이 필요한 메서드를 골라서 사용해주세요.
	
	//모든 루트 조회
	public ArrayList<RouteVO> showAllRoute(String condition) {
		ArrayList<RouteVO> list = new ArrayList<>();
		String sql = "";
		if(condition.equals("최신순")) {
			sql = "SELECT * FROM route ORDER BY route_regdate DESC";			
		} else if(condition.equals("조회순")) {
			sql = "SELECT * FROM route ORDER BY route_hit DESC";
		} else {
			sql = "SELECT * FROM route ORDER BY route_name ASC";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RouteVO vo = new RouteVO(rs.getString("route_img"),
						rs.getString("route_name"), 
						rs.getInt("route_hit"), 
						rs.getDate("route_regdate"), 
						rs.getString("route_schedule"), 
						rs.getString("route_theme"), 
						rs.getString("route_hashtag"), 
						rs.getString("route_content"), 
						rs.getString("route_coordinate"), 
						rs.getString("route_addimage1"), 
						rs.getString("route_addaddress1"), 
						rs.getString("route_addname1"), 
						rs.getString("route_addimage2"), 
						rs.getString("route_addaddress2"), 
						rs.getString("route_addname2"), 
						rs.getString("route_addimage3"), 
						rs.getString("route_addaddress3"), 
						rs.getString("route_addname3"));
						
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//특정 루트 하나 조회
	public RouteVO showOneRoute(String route_name) {
		RouteVO vo = null;
		
		String sql = "SELECT * FROM route WHERE route_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, route_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new RouteVO(
						rs.getString("route_img"),
						rs.getString("route_name"), 
						rs.getInt("route_hit"), 
						rs.getDate("route_regdate"), 
						rs.getString("route_schedule"), 
						rs.getString("route_theme"), 
						rs.getString("route_hashtag"), 
						rs.getString("route_content"), 
						rs.getString("route_coordinate"), 
						rs.getString("route_addimage1"), 
						rs.getString("route_addaddress1"), 
						rs.getString("route_addname1"), 
						rs.getString("route_addimage2"), 
						rs.getString("route_addaddress2"), 
						rs.getString("route_addname2"), 
						rs.getString("route_addimage3"), 
						rs.getString("route_addaddress3"), 
						rs.getString("route_addname3"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	
	}
	
	//루트 총 갯수
	public int Routecount() {
		String sql = "SELECT COUNT(*) FROM route";
		int count = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void increaseHit(String route_name) {
		
		String sql = "UPDATE route SET route_hit=route_hit+1 WHERE route_name = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, route_name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}