package user.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class UserDAO {

	public void insert(UserDTO newUser) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO user_tbl_old VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), 0, null)";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newUser.getUser_id());
			pstmt.setString(2, newUser.getUser_pw());
			pstmt.setString(3, newUser.getUser_name());
			pstmt.setString(4, newUser.getUser_gender());
			pstmt.setDate(5, newUser.getUser_birth());
			pstmt.setString(6, newUser.getUser_email());
			pstmt.setString(7, newUser.getUser_phone());
			pstmt.setString(8, newUser.getUser_address());
//			pstmt.setDate(9, newUser.getUser_registdate());
//			pstmt.setInt(10, newUser.isAdmin());
//			pstmt.setString(11, newUser.getAuth_token());

			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public UserDTO findById(String userId) {

		UserDTO user = new UserDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM user_tbl_old WHERE user_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_gender(rs.getString("user_gender"));
				user.setUser_birth(rs.getDate("user_birth"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_registdate(rs.getDate("user_registdate"));
				user.setIs_admin(rs.getInt("is_admin"));
				user.setAuth_token(rs.getString("auth_token"));
			}

			return user;

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return null;
	}

	public ArrayList<UserDTO> findAll() {
		return null;
	}

	public void registToken(String userId, String token) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE SET user_tbl_old"
				+ " (auth_token = ?)"
				+ " WHERE user_id = ?";

		try {
			
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, token);

			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void releaseToken(String userId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE SET user_tbl_old"
				+ " (auth_token = null)"
				+ " WHERE user_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public void update(String userId, UserDTO updateUser) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE SET user_tbl_old"
				+ " (user_pw = ?)"
				+ " (user_name = ?)"
				+ " (user_gender = ?)"
				+ " (user_birth = ?)"
				+ " (user_email = ?)"
				+ " (user_phone = ?)"
				+ " (user_address = ?)"
				+ " (user_registdate = ?)"
				+ " WHERE user_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateUser.getUser_pw());
			pstmt.setString(2, updateUser.getUser_name());
			pstmt.setString(3, updateUser.getUser_gender());
			pstmt.setDate(4, updateUser.getUser_birth());
			pstmt.setString(5, updateUser.getUser_email());
			pstmt.setString(6, updateUser.getUser_phone());
			pstmt.setString(7, updateUser.getUser_address());
			pstmt.setDate(8, updateUser.getUser_registdate());

			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void delete(String userId) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		String sql = "DELETE cart_tbl WHERE user_id = ? AND dvd_id = ?";
//
//		try {
//			conn = DBConnection.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, user_id);
//			pstmt.setString(2, dvd_id);
//
//			pstmt.executeUpdate();
//
//		} catch (Exception e) {
//
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//			}
//		}
	}

}
