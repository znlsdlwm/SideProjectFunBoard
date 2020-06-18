package kjm.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kjm.com.controller.PageTO;
import kjm.com.dto.JBoardDTO;

public class JBoardDAO {
	private DataSource dataFactory;
	public JBoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public PageTO page(int curPage) {
		String sql ="select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from(select*from board order by repRoot desc, repStep asc)) where rnum>= ? and rnum<= ?";
		PageTO to = new PageTO(curPage);
		List<JBoardDTO> list = new ArrayList<JBoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			int amount = getAmount(conn);
			to.setAmount(amount);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2,to.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				JBoardDTO dto = new JBoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent);
				list.add(dto);	
			}
			to.setList(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return to;
	}	

	private int getAmount(Connection conn) {
		int amount = 0;
		PreparedStatement pstmt = null;
		String sql = "select count(num) from board";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				amount = rs.getInt(1);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		return amount;
	}


	public void insert(JBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			int num = createNum(conn);
			
			pstmt.setInt(1, num); 
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		closeAll(null, pstmt, conn);
	}
}

	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board";
		ResultSet rs= null;
		Integer num = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			  num = rs.getInt(1);
			  num +=1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		return num;
	}

	public JBoardDTO read(int num) {
		JBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num=?";
		ResultSet rs = null;
		boolean isok = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			incresereadcnt(conn,num);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content =rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				dto = new JBoardDTO(num, writer, title, content, writeday, readcnt, 0, 0, 0);
				isok = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(isok) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}
	
	private void incresereadcnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
	}
	
	public JBoardDTO updateUI(int num, String writer) {
		JBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num=? and writer=?";
		ResultSet rs= null;
		
		try {
            conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, writer);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent=rs.getInt("repIndent");		
				dto = new JBoardDTO(num, writer, title, content, null, 0, repRoot, repStep, repIndent);
				}
			} catch (Exception e) {
			e.printStackTrace();
			}finally {
			closeAll(rs, pstmt, conn);	
			}
		return dto;	
		}
	
	public void update(JBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set title=?, writer=?, content=? where num=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum()); 
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	public void delete(JBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="delete from board where num=? and writer=?";
		try {
			conn = dataFactory.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getWriter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {		
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
