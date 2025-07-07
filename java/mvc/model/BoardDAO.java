package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mvc.database.DBConnection;

public class BoardDAO {

	private static BoardDAO instance;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}
	//board 테이블의 레코드 개수
	public int getListCount(String items, String text) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		String sql;

		if (items == null && text == null)
			sql = "select count(*) from board_tbl";
		else
			sql = "SELECT count(*) FROM board_tbl where " + items + " like '%" + text + "%'";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);

		} catch (Exception ex) {
			System.out.println("getListCount() 레코드수 : " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return x;
	}
	//board 테이블의 레코드 가져오기
	public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int total_record = getListCount(items, text );
		int start = (page - 1) * limit;
		int index = start + 1;

		String sql;

		if (items == null && text == null)
			sql = "select * from board_tbl ORDER BY board_index DESC";
		else
			sql = "SELECT  * FROM board_tbl where " + items + " like '%" + text + "%' ORDER BY board_index DESC ";

		ArrayList<BoardDTO> list = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();


			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = pstmt.executeQuery();

			while (rs.absolute(index)) {
				BoardDTO board = new BoardDTO();
				board.setNum(rs.getInt("board_index"));
				board.setId(rs.getString("board_id"));
				board.setName(rs.getString("board_name"));
				board.setSubject(rs.getString("board_subject"));
				board.setContent(rs.getString("board_content"));
				board.setRegist_day(rs.getString("board_regist_day"));
				board.setHit(rs.getInt("board_hit"));
				board.setIp(rs.getString("board_ip"));
				list.add(board);



				if (index < (start + limit) && index <= total_record)
					index++;
				else
					break;
			}
			return list;
		} catch (Exception ex) {
			System.out.println("getBoardList() ���� : " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return null;
	}
	//member 테이블에서 인증된 id의 사용자명 가져오기
	public String getLoginNameById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String name=null;
		String sql = "select * from user_tbl_old where user_id = ? ";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				name = rs.getString("user_name");

			return name;
		} catch (Exception ex) {
			System.out.println("getBoardByNum() ���� : " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return null;
	}

	//board 테이블에 새로운 글 삽입하기
	public void insertBoard(BoardDTO board)  {



		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();

			String sql = "insert into board_tbl values(?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getNum());
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getSubject());
			pstmt.setString(5, board.getContent());
			pstmt.setString(6, board.getRegist_day());
			pstmt.setInt(7, board.getHit());
			pstmt.setString(8, board.getIp());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("insertBoard() ���� : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
	//선택된 글의 조회 수 증가시키기
	public void updateHit(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();

			String sql = "select board_hit from board_tbl where board_index = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			int hit = 0;

			if (rs.next())
				hit = rs.getInt("board_hit") + 1;


			sql = "update board_tbl set board_hit=? where board_index=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hit);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("updateHit() ���� : " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
	//선택된 글 상세 내용 가져오기
	public BoardDTO getBoardByNum(int num, int page) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO board = null;

		updateHit(num);
		String sql = "select * from board_tbl where board_index = ? ";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new BoardDTO();
				board.setNum(rs.getInt("board_index"));
				board.setId(rs.getString("board_id"));
				board.setName(rs.getString("board_name"));
				board.setSubject(rs.getString("board_subject"));
				board.setContent(rs.getString("board_content"));
				board.setRegist_day(rs.getString("board_regist_day"));
				board.setHit(rs.getInt("board_hit"));
				board.setIp(rs.getString("board_ip"));
			}

			return board;
		} catch (Exception ex) {
			System.out.println("getBoardByNum() ���� : " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
		return null;
	}
	//선택된 글 내용 수정하기
	public void updateBoard(BoardDTO board) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "update board_tbl set board_name=?, board_subject=?, board_content=? where board_index=?";

			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getNum());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception ex) {
			System.out.println("updateBoard() ���� : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
	//선택된 글 삭제하기
	public void deleteBoard(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from board_tbl where board_index=?";

		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("deleteBoard() ���� : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
}
