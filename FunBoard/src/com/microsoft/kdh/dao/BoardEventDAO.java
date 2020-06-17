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
	public boolean alreadyEvent(BoardEventDTO dto) {
		boolean already = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_event where m_id=? and b_num=? and "+dto.getType()+"=1";
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
	public void eventListener(BoardEventDTO dto) {
		if(canEvent(dto)) {
			updateEvent(dto);
		} else {
			insertEvent(dto);
		}
	}
	public void insertEvent(BoardEventDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into b_event(b_num, m_id, "+ dto.getType() +") values (?,?,1)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_num());
			pstmt.setString(2, dto.getM_id());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, conn);
		}
	}
	
	public void updateEvent(BoardEventDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update b_event set "+dto.getType()+"=1 where m_id=? and b_num=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setInt(2, dto.getB_num());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, conn);
		}
	}
	
	public boolean canEvent(BoardEventDTO dto) {
		boolean can = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_event where m_id=? and b_num=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setInt(2, dto.getB_num());
			rs = pstmt.executeQuery();
			if (rs.next())
				can = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		return can;
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
