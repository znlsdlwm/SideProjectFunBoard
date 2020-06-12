package kjm.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.domain.MemberDTO;

public class MemberDAO {
	private DataSource dataFactory;
public MemberDAO() {
	try {
		Context ctx = new InitialContext();
		dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();
			if (conn != null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member (id, name, age, pw) values (?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public boolean login(MemberDTO dto) {
		boolean login = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=? and pw=?";
		ResultSet rs= null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				login = true;
				System.out.println(login);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
			closeAll(null, pstmt, conn);
			}
		return login;
	}
	public MemberDTO selectById(String id) {
		MemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member where id=?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String pw = rs.getString("pw");
				
				dto = new MemberDTO(id, name, age, pw);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			}finally {
			closeAll(null, pstmt, conn);
			
			}
		return dto;
		}
}
	
