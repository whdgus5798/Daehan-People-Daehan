package page.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConn.DBConnection;

public class FestaDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public FestaDAO() {
		conn = new DBConnection().getConnection();
	}
	
	/////////////////////////////////////////////////////////////////////
	// ↓ FestaDAO 로직
	//무조건 다 사용할 필요없이 필요한 메서드를 골라서 사용해주세요.
	
	//축제 등록
	public void registFestival(FestaVO vo) {
		
		String sql = "INSERT INTO festival VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFesta_img());
			pstmt.setString(2, vo.getFesta_name());
			pstmt.setString(3, vo.getFesta_period());
			pstmt.setString(4, vo.getFesta_content());
			pstmt.setString(5, vo.getFesta_tel());
			pstmt.setString(6, vo.getFesta_url());
			pstmt.setString(7, vo.getFesta_address());
			pstmt.setString(8, vo.getFesta_location());
			pstmt.setString(9, vo.getFesta_host());
			pstmt.setString(10, vo.getFesta_charge());
			pstmt.setString(11, vo.getFesta_coodinate());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//축제 수정
	public void updateFestival(FestaVO vo, String festa_name) {
					  //수정 정보가 담겨있는 vo객체	//기존에 작성된 축제 이름
		String sql = "UPDATE festival SET festa_img = ?, "
				+ "festa_name=?, "
				+ "festa_period=?, "
				+ "festa_content=?, "
				+ "festa_tel=?, "
				+ "festa_url=?, "
				+ "festa_address=?, "
				+ "festa_location=?, "
				+ "festa_host=?, "
				+ "festa_charge=?, "
				+ "festa_coodinate=? "
				+ "WHERE festa_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getFesta_img());
			pstmt.setString(2, vo.getFesta_name());
			pstmt.setString(3, vo.getFesta_period());
			pstmt.setString(4, vo.getFesta_content());
			pstmt.setString(5, vo.getFesta_tel());
			pstmt.setString(6, vo.getFesta_url());
			pstmt.setString(7, vo.getFesta_address());
			pstmt.setString(8, vo.getFesta_location());
			pstmt.setString(9, vo.getFesta_host());
			pstmt.setString(10, vo.getFesta_charge());
			pstmt.setString(11, vo.getFesta_coodinate());
			pstmt.setString(12, festa_name);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//축제 삭제
	public void deleteFestival(String festa_name) {
		String sql = "DELETE FROM festival WHERE festa_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, festa_name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//축제 전체 불러오기
	public ArrayList<FestaVO> showAllFestival() {
		ArrayList<FestaVO> list = new ArrayList<FestaVO>();
		
		String sql = "SELECT * FROM festival ORDER BY festa_period";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FestaVO vo = new FestaVO(
						rs.getString("festa_img"), 
						rs.getString("festa_name"), 
						rs.getString("festa_period"), 
						rs.getString("festa_content"), 
						rs.getString("festa_tel"), 
						rs.getString("festa_url"), 
						rs.getString("festa_address"), 
						rs.getString("festa_location"), 
						rs.getString("festa_host"), 
						rs.getString("festa_charge"), 
						rs.getString("festa_coodinate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//축제 하나만 불러오기
	public FestaVO showOneFestival(String festa_name) {
		FestaVO vo = null;
		
		String sql = "SELECT * FROM festival WHERE festa_name=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, festa_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new FestaVO(
						rs.getString("festa_img"), 
						rs.getString("festa_name"), 
						rs.getString("festa_period"), 
						rs.getString("festa_content"), 
						rs.getString("festa_tel"), 
						rs.getString("festa_url"), 
						rs.getString("festa_address"), 
						rs.getString("festa_location"), 
						rs.getString("festa_host"), 
						rs.getString("festa_charge"), 
						rs.getString("festa_coodinate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vo;
	}
	
	//축제명으로 검색
	public ArrayList<FestaVO> searchFestival(String keyword) {
		ArrayList<FestaVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM festival WHERE festa_name LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FestaVO vo = new FestaVO(
						rs.getString("festa_img"), 
						rs.getString("festa_name"), 
						rs.getString("festa_period"), 
						rs.getString("festa_content"), 
						rs.getString("festa_tel"), 
						rs.getString("festa_url"), 
						rs.getString("festa_address"), 
						rs.getString("festa_location"), 
						rs.getString("festa_host"), 
						rs.getString("festa_charge"), 
						rs.getString("festa_coodinate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
