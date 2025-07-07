package dvd.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class DvdDAO {

	public void insert(DvdDTO dvd) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO dvd_tbl VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, ?)";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvd.getDvd_id());
			pstmt.setString(2, dvd.getDvd_name());
			pstmt.setInt(3, dvd.getDvd_unitPrice());
			pstmt.setString(4, dvd.getDvd_author());
			pstmt.setString(5, dvd.getDvd_description());
			pstmt.setString(6, dvd.getDvd_publisher());
			pstmt.setString(7, dvd.getDvd_category());
			pstmt.setInt(8, dvd.getDvd_unitsInStock());
//			pstmt.setDate(9, 1);
			pstmt.setString(9, dvd.getDvd_condition());
			pstmt.setString(10, dvd.getDvd_thumbnailUrl());

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

	public DvdDTO findById(String dvdId) {

		DvdDTO dvd = new DvdDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM dvd_tbl WHERE dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvdId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dvd.setDvd_id(rs.getString("dvd_id"));
				dvd.setDvd_name(rs.getString("dvd_name"));
				dvd.setDvd_unitPrice(rs.getInt("dvd_unitPrice"));
				dvd.setDvd_author(rs.getString("dvd_author"));
				dvd.setDvd_description(rs.getString("dvd_description"));
				dvd.setDvd_publisher(rs.getString("dvd_publisher"));
				dvd.setDvd_category(rs.getString("dvd_category"));
				dvd.setDvd_unitsInStock(rs.getInt("dvd_unitsInStock"));
				dvd.setDvd_releaseDate(rs.getDate("dvd_releaseDate"));
				dvd.setDvd_condition(rs.getString("dvd_condition"));
				dvd.setDvd_thumbnailUrl(rs.getString("dvd_thumbnailUrl"));
			}

			return dvd;

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

		return null;
	}

	public ArrayList<DvdDTO> findAll() {

		ArrayList<DvdDTO> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM dvd_tbl";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DvdDTO dvd = new DvdDTO();
				dvd.setDvd_id(rs.getString("dvd_id"));
				dvd.setDvd_name(rs.getString("dvd_name"));
				dvd.setDvd_unitPrice(rs.getInt("dvd_unitPrice"));
				dvd.setDvd_author(rs.getString("dvd_author"));
				dvd.setDvd_description(rs.getString("dvd_description"));
				dvd.setDvd_publisher(rs.getString("dvd_publisher"));
				dvd.setDvd_category(rs.getString("dvd_category"));
				dvd.setDvd_unitsInStock(rs.getInt("dvd_unitsInStock"));
				dvd.setDvd_releaseDate(rs.getDate("dvd_releaseDate"));
				dvd.setDvd_condition(rs.getString("dvd_condition"));
				dvd.setDvd_thumbnailUrl(rs.getString("dvd_thumbnailUrl"));

				result.add(dvd);
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

	public void update(String dvdId, DvdDTO updateDvd) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "UPDATE dvd_tbl SET dvd_name = ?, dvd_unitPrice = ?,"
				+ " dvd_author = ?, dvd_description = ?, dvd_publisher = ?,"
				+ " dvd_category = ?, dvd_unitsInStock = ?, dvd_releaseDate = NOW(),"
				+ " dvd_condition = ?, dvd_thumbnailUrl = ?"
				+ " WHERE dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateDvd.getDvd_name());
			pstmt.setInt(2, updateDvd.getDvd_unitPrice());
			pstmt.setString(3, updateDvd.getDvd_author());
			pstmt.setString(4, updateDvd.getDvd_description());
			pstmt.setString(5, updateDvd.getDvd_publisher());
			pstmt.setString(6, updateDvd.getDvd_category());
			pstmt.setInt(7, updateDvd.getDvd_unitsInStock());
//			pstmt.setDate(8, 1);
			pstmt.setString(9, updateDvd.getDvd_condition());
			pstmt.setString(10, updateDvd.getDvd_thumbnailUrl());
			pstmt.setString(11, dvdId);

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

	public void delete(String dvd_id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "DELETE dvd_tbl WHERE dvd_id = ?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvd_id);

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
