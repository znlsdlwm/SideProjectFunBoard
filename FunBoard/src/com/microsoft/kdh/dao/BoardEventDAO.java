package com.microsoft.kdh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.kdh.domain.BoardEventDTO;
import com.microsoft.kdh.domain.BoardEventCNT;

public class BoardEventDAO {
	private DataSource dataFactory;

	public BoardEventDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// public
	public BoardEventCNT getTotal(int b_num) {
		BoardEventCNT total = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_eventTotal where b_num=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Integer good = rs.getInt("b_good_total");
				Integer bad = rs.getInt("b_bad_total");
				Integer warning = rs.getInt("b_warning_total");
				total = new BoardEventCNT(b_num, good, bad, warning);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		return total;
	}
	public Integer getTotal(int b_num, String type) {
		Integer result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select " + type + "_total from b_eventTotal where b_num=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		return result;
	}
	public void eventListener(BoardEventDTO dto) {
		boolean isOk = false;
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			if (canEvent(conn, dto))
				updateEvent(conn, dto);
			else
				insertEvent(conn, dto);
			
			if (countEvent(conn, dto) != null)
				increaseCntEvent(conn, dto);
			else
				createCntEvent(conn, dto);
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction(conn, isOk);
			clossAll(null, null, conn);
		}
	}

	public boolean alreadyEvent(BoardEventDTO dto) {
		boolean already = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_event where m_id=? and b_num=? and " + dto.getType() + "=1";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setInt(2, dto.getB_num());
			rs = pstmt.executeQuery();
			if (rs.next())
				already = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		return already;
	}

	public Integer countEvent(Connection conn, BoardEventDTO dto) {
		Integer cnt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select " + dto.getType() + "_total from b_eventTotal where b_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_num());
			rs = pstmt.executeQuery();
			if (rs.next())
				cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
		return cnt;
	}
	public void createTotal(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into b_eventTotal(b_num) values (?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
	}
	// private
	private void createCntEvent(Connection conn, BoardEventDTO dto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into b_eventTotal(b_num, " + dto.getType() + "_total) values (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_num());
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
	}

	private void increaseCntEvent(Connection conn, BoardEventDTO dto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update b_eventTotal set " + dto.getType() + "_total =? where b_num=?";
		try {
			int set = countEvent(conn, dto);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, set + 1);
			pstmt.setInt(2, dto.getB_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
	}

	private void insertEvent(Connection conn, BoardEventDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "insert into b_event(b_num, m_id, " + dto.getType() + ") values (?,?,1)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_num());
			pstmt.setString(2, dto.getM_id());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, null);
		}
	}

	private void updateEvent(Connection conn, BoardEventDTO dto) {
		PreparedStatement pstmt = null;
		String sql = "update b_event set " + dto.getType() + "=1 where m_id=? and b_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setInt(2, dto.getB_num());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, null);
		}
	}

	private boolean canEvent(Connection conn, BoardEventDTO dto) {
		boolean can = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_event where m_id=? and b_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setInt(2, dto.getB_num());
			rs = pstmt.executeQuery();
			if (rs.next())
				can = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
		return can;
	}

	private void transaction(Connection conn, boolean isOk) {
		try {
			if (isOk) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clossAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
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
