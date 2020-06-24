package com.microsoft.kdh.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcTemplate {
	private DataSource dataFactory;

	public JdbcTemplate() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public <T> T queryForOnce(Connection conn, PreparedStatementCreator psc, RowMapper<T> rowMapper) {
		List<T> list = new ArrayList<T>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = psc.createPreparedStatement(conn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> T queryForOnce(PreparedStatementCreator psc, RowMapper<T> rowMapper) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = psc.createPreparedStatement(conn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> T queryForOnce(PreparedStatementCreator psc, GetConRowMapper<T> getConRowMapper) {
		List<T> list = new ArrayList<T>();
		boolean isOk = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = psc.createPreparedStatement(conn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(getConRowMapper.getConMapRow(conn, rs));
			}
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction(conn, isOk);
			clossAll(rs, pstmt, conn);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public <T> T query(PreparedStatementCreator psc, RowMapper<T> rowMapper) {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = psc.createPreparedStatement(conn);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public <T> T query(PreparedStatementCreator psc, GetConRowMapper<T> getConRowMapper) {
		List<T> list = new ArrayList<T>();
		boolean isOk = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = psc.createPreparedStatement(conn);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getConRowMapper.getConMapRow(conn, rs));
			}
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction(conn, isOk);
			clossAll(rs, pstmt, conn);
		}
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public void update(PreparedStatementCreator preparedStatementCreator) {
		boolean isOk = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataFactory.getConnection();

			pstmt = preparedStatementCreator.createPreparedStatement(conn);

			pstmt.executeUpdate();
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transaction(conn, isOk);
			clossAll(null, pstmt, conn);
		}
	}
	public void update(Connection conn,PreparedStatementCreator preparedStatementCreator) {
		PreparedStatement pstmt = null;
		try {

			pstmt = preparedStatementCreator.createPreparedStatement(conn);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, null);
		}
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
