package com.microsoft.kdh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.kdh.domain.CommentDTO;

public class CommentDAO {
	private DataSource dataFactory;

	public CommentDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//Create
	public void insertComment(CommentDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into b_comment(c_num,c_writer,c_content,c_password,c_good,c_bad,c_warning,c_root,c_step,c_indent,b_num)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, createC_Num(conn));
			pstmt.setString(2, dto.getC_writer());
			pstmt.setString(3, dto.getC_content());
			
			pstmt.setString(4, dto.getC_password());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, createC_Num(conn));
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, dto.getB_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(null, pstmt, conn);
		}
	}
	public int createC_Num(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select max(c_num) num from b_comment";
		Integer c_num = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c_num = rs.getInt(1);
				c_num += 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, null);
		}
		return c_num;
	}
	// Read
	public List<CommentDTO> listComment(int b_num) {
		List<CommentDTO> c_list = new ArrayList<CommentDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_comment where b_num=? order by c_root desc , c_step";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				c_list.add(new CommentDTO(rs.getInt("c_num"), 
						rs.getString("c_writer"),
						rs.getString("c_content"),
						rs.getString("c_password"), 
						rs.getString("c_writeday"), 
						rs.getInt("c_good"), 
						rs.getInt("c_bad"),
						rs.getInt("c_warning"), 
						rs.getInt("c_root"), 
						rs.getInt("c_step"),
						rs.getInt("c_indent"),
						b_num));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, conn);
		}
		return c_list;
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
