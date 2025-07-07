package cart.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class CartDAO {

	public void insert(String user_id, String dvd_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO cart_tbl VALUES (?, ?, 1)";

		System.out.println("1:"+user_id);
		System.out.println("2:"+dvd_id);
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, dvd_id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public CartDTO findById(String user_id, String dvd_id) {

		CartDTO cart = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM cart_tbl WHERE user_id = ? AND dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, dvd_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cart = new CartDTO();
				cart.setUser_id(rs.getString("user_id"));
				cart.setDvd_id(rs.getString("dvd_id"));
				cart.setDvd_count(rs.getInt("dvd_count"));
			}

			return cart;

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

	public ArrayList<CartDTO> findAll(String user_id) {

		ArrayList<CartDTO> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM cart_tbl WHERE user_id = ? AND (dvd_count > 0)";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CartDTO cart = new CartDTO();
				cart.setUser_id(rs.getString("user_id"));
				cart.setDvd_id(rs.getString("dvd_id"));
				cart.setDvd_count(rs.getInt("dvd_count"));

				result.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public void update(String user_id, String dvd_id, int addCount) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE cart_tbl SET dvd_count = dvd_count + ? WHERE user_id = ? AND dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, addCount);
			pstmt.setString(2, user_id);
			pstmt.setString(3, dvd_id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String user_id, String dvd_id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "DELETE FROM cart_tbl WHERE user_id = ? AND dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, dvd_id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteAll(String user_id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "DELETE FROM cart_tbl WHERE user_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);

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

}
