package page.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConnection;

public class PopularityDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public PopularityDAO() {
		conn = new DBConnection().getConnection();
	}
	//인기 등록
	public void registPopular(PopularityVO vo) {
		String sql = "INSERT INTO popularity VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPopular_img());
			pstmt.setString(2, vo.getPopular_name());
			pstmt.setString(3, vo.getPopular_location());
			pstmt.setString(4, vo.getPopular_content());
			pstmt.setString(5, vo.getPopular_subtitle());
			pstmt.setString(6, vo.getPopular_tel());
			pstmt.setString(7, vo.getPopular_url());
			pstmt.setString(8, vo.getPopular_address());
			pstmt.setString(9, vo.getPopular_charge());
			pstmt.setString(10, vo.getPopular_coodinate());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//인기 수정
	public void updatePoplar(PopularityVO vo,String popular_name) {
		String sql = "UPDATE popularity SET popular_img = ?, "
				+ "popular_name=?, "
				+ "popular_location=?, "
				+ "popular_content=?, "
				+ "popular_subtitle=?,"
				+ "popular_tel=?, "
				+ "popular_url=?, "
				+ "popular_address=?, "
				+ "popular_charge=?, "
				+ "popular_coodinate=? "
				+ "WHERE popular_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPopular_img());
			pstmt.setString(2, vo.getPopular_name());
			pstmt.setString(3, vo.getPopular_location());
			pstmt.setString(4, vo.getPopular_content());
			pstmt.setString(5, vo.getPopular_subtitle());
			pstmt.setString(6, vo.getPopular_tel());
			pstmt.setString(7, vo.getPopular_url());
			pstmt.setString(8, vo.getPopular_address());
			pstmt.setString(9, vo.getPopular_charge());
			pstmt.setString(10, vo.getPopular_coodinate());
			pstmt.setString(12, popular_name);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//인기 삭제
	public void deletePopularity(String popular_name) {
		String sql = "DELETE FROM festival WHERE popular_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, popular_name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//인기 전체 불러오기
	public ArrayList<PopularityVO> showAllPopularity(){
		ArrayList<PopularityVO> list = new ArrayList<PopularityVO>();
		
		String sql = "SELECT * FROM popularity";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PopularityVO vo = new PopularityVO(
						rs.getString("popular_img"),
						rs.getString("popular_name"),
						rs.getString("popular_location"),
						rs.getString("popular_content"),
						rs.getString("popular_subtitle"),
						rs.getString("popular_tel"),
						rs.getString("popular_url"),
						rs.getString("popular_address"),
						rs.getString("popular_charge"),
						rs.getString("popular_coodinate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public PopularityVO showOnePopularity(String popular_name) {
		PopularityVO vo = null;
		
		String sql = "SELECT * FROM popularity WHERE popular_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, popular_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new PopularityVO(
						rs.getString("popular_img"),
						rs.getString("popular_name"),
						rs.getString("popular_location"),
						rs.getString("popular_content"),
						rs.getString("popular_subtitle"),
						rs.getString("popular_tel"),
						rs.getString("popular_url"),
						rs.getString("popular_address"),
						rs.getString("popular_charge"),
						rs.getString("popular_coodinate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	
	}
	
	
}