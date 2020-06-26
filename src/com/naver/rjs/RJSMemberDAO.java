package com.naver.rjs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.naver.rjs.RJSBoardDTO;

import com.naver.rjs.RJSPageTO;
import member.domain.LoginDTO;
import com.naver.rjs.RJSMemberDTO;

public class RJSMemberDAO {

	private DataSource dataFactory = null;
	
	public RJSMemberDAO() {
		try {
			Context ctx = new InitialContext();
			
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean login(LoginDTO ldto) {
		boolean login = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member_rjs where r_id = ? and r_pw = ?";
		ResultSet rs = null;
	
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ldto.getId());
			pstmt.setString(2, ldto.getPw());
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				login = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return login;
	
	}
	
	public void membership(RJSMemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member_rjs (r_id,r_name,r_age,r_pw) values(?,?,?,?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getR_id());
			pstmt.setString(2, dto.getR_name());
			pstmt.setInt(3, dto.getR_age());
			pstmt.setString(4, dto.getR_pw());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public void boardinsert(RJSBoardDTO bdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_rjs (r_num, r_writer, r_title, r_content, r_repRoot, r_repStep, r_repIndent)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			int num = createNum(conn);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, bdto.getR_writer());
			pstmt.setString(3, bdto.getR_title());
			pstmt.setString(4, bdto.getR_content());
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
		String sql = "select max(r_num) from board_rjs";
		ResultSet rs = null;
		Integer num = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				num = rs.getInt(1);
				
				num += 1;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		return num;
	}
	public List<RJSBoardDTO> list() {
		List<RJSBoardDTO> list = new ArrayList<RJSBoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board_rjs order by r_repRoot desc, r_repStep asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int r_num = rs.getInt("num");
				String r_writer = rs.getString("writer");
				String r_title = rs.getString("title");
				String r_writeday = rs.getString("writeday");
				int r_readcnt = rs.getInt("readcnt");
				int r_repRoot = rs.getInt("repRoot");
				int r_repStep = rs.getInt("repStep");
				int r_repIndent = rs.getInt("repIndent");
				
				list.add(new RJSBoardDTO(r_num, r_writer, r_title, null, r_writeday, r_readcnt, r_repRoot, r_repStep, r_repIndent));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				closeAll(rs, pstmt, conn);
		}
		return list;
	}
	public void reply(int orgnum, RJSBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_rjs (r_num, r_writer, r_title, r_content," + "r_repRoot, r_repStep, r_repIndent) values" + "(?, ?, ?, ?, ?, ?, ?)";
		
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			int num = createNum(conn);
			
			RJSBoardDTO orgDTO = updateUI(orgnum);
			
			stepPlus1(conn, orgDTO);
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getR_writer());
			pstmt.setString(3, dto.getR_title());
			pstmt.setString(4, dto.getR_content());
			pstmt.setInt(5, orgDTO.getR_repRoot());
			pstmt.setInt(6, orgDTO.getR_repStep()+1);
			pstmt.setInt(7, orgDTO.getR_repIndent()+1);
			
			pstmt.executeUpdate();
			
			isOk = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}
	private void stepPlus1(Connection conn, RJSBoardDTO orgDTO) {
		PreparedStatement pstmt = null;
		String sql = "update board_rjs set r_repStep = r_repStep+1"
				+ "where" 
				+ "r_repRoot = ? and r_repStep > ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orgDTO.getR_repRoot());
			pstmt.setInt(2, orgDTO.getR_repStep());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
	
	}
	public RJSBoardDTO read(int r_num) {
		RJSBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board_rjs where r_num = ?";
		ResultSet rs = null;
		
		boolean isOk = false;
		
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			increaseReadCnt(conn, r_num);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String r_writer = rs.getString("r_writer");
				String r_title = rs.getString("r_title");
				String r_writeday = rs.getString("r_writeday");
				int r_readcnt = rs.getInt("r_readcnt");
				String r_content = rs.getString("r_content");
				
				dto = new RJSBoardDTO(r_num, r_writer, r_title, r_content, r_writeday, r_readcnt+1, 0, 0, 0);
				isOk = true;
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}
	private void increaseReadCnt(Connection conn, int r_num) {
		PreparedStatement pstmt = null;
		String sql = "update board_rjs set r_readcnt = r_readcnt + 1 where r_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
		
	}
	public void update(RJSBoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board_rjs set r_writer = ?, r_title = ?, r_content = ? where r_num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, boardDTO.getR_writer());
			pstmt.setString(2, boardDTO.getR_title());
			pstmt.setString(3, boardDTO.getR_content());
			pstmt.setInt(4, boardDTO.getR_num());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public RJSBoardDTO updateUI(int r_num) {
		RJSBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board_rjs where r_num = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				String r_writer = rs.getString("r_writer");
				String r_title = rs.getString("r_title");
				String r_content = rs.getString("r_content");
				int r_repRoot = rs.getInt("r_repRoot");
				int r_repStep = rs.getInt("r_repStep");
				int r_repIndent = rs.getInt("r_repIndent");
				
				dto = new RJSBoardDTO(r_num, r_writer, r_title, r_content, null, 0, r_repRoot, r_repStep, r_repIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return dto;
	}
	public List<RJSMemberDTO> selectAll() {
		List<RJSMemberDTO> list = new ArrayList<RJSMemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select r_id, r_name 이름, r_age 나이 from member_rjs order by r_id asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String r_id = rs.getString("r_id");
				String r_name = rs.getString("이름");
				int r_age = rs.getInt("나이");
				list.add(new RJSMemberDTO(r_id, r_name, r_age, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}
	public RJSPageTO page(int curPage) {
		String sql = "select * from (select rownum rnum, r_num, r_title,"
				+ " r_writer, r_writeday, r_readcnt, r_repIndent from"
				+ "(select * from board_rjs order by r_repRoot desc, r_repStep asc))" 
				+ "where rnum>=? and rnum <=?";
	
	RJSPageTO to = new RJSPageTO(curPage);
	List<RJSBoardDTO> list = new ArrayList<RJSBoardDTO>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = dataFactory.getConnection();
		int amount = getAmount(conn);
		to.setAmount(amount);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, to.getStartNum());
		pstmt.setInt(2, to.getEndNum());
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int r_num = rs.getInt("r_num");
			String r_title = rs.getString("r_title");
			String r_writer = rs.getString("r_writer");
			String r_writeday = rs.getString("r_writeday");
			int r_readcnt = rs.getInt("r_readcnt");
			int r_repIndent = rs.getInt("r_repIndent");
			
			RJSBoardDTO dto = new RJSBoardDTO(r_num, r_writer, 
					r_title, null, r_writeday, 
					r_readcnt, -1, -1, r_repIndent);
			
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
		String sql = "select count(r_num) from board_rjs";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return amount;
	}
	public void delete(int r_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board_rjs where r_num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public RJSMemberDTO selectById(String r_id) {
		RJSMemberDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member_rjs where r_id = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String r_name = rs.getString("name");
				int r_age = rs.getInt("age");
				
				dto = new RJSMemberDTO(r_id, r_name, r_age, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}
	public void membershipupdate(RJSMemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member_rjs set r_name = ? , r_age = ? where r_id = ? and r_pw = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getR_name());
			pstmt.setInt(2, dto.getR_age());
			pstmt.setString(3, dto.getR_id());
			pstmt.setString(4, dto.getR_pw());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public RJSMemberDTO membershipupdateui(String id) {
		return selectById(id);
	}
	public void membershipdelete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member_rjs where r_id = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public void insert(RJSMemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member_rjs(id,name,ape,pw) values(?,?,?,?)";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getR_id());
			pstmt.setString(2, dto.getR_name());
			pstmt.setInt(3, dto.getR_age());
			pstmt.setString(4, dto.getR_pw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}
	public RJSPageTO searchList(int curPage, String keyField, String keyWord) {
	      RJSPageTO to = new RJSPageTO(curPage);
	      List<RJSBoardDTO> list = new ArrayList<RJSBoardDTO>();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql = "select * from(select rownum rnum, r_num, r_title, r_writer, r_writeday, r_readcnt, r_repIndent from(select * from board_rjs where r_title like ? order by r_repRoot desc, r_repStep asc)) where rnum between ? and ?";
	      ResultSet rs = null;
	      try {
	         conn = dataFactory.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%" + keyWord + "%");
	         int amount = getAmount(conn, sql);
	         to.setAmount(amount);
	         pstmt.setInt(2, to.getStartNum());
	         pstmt.setInt(3, to.getEndNum());
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            int r_num = rs.getInt("r_num");
	            String r_writer = rs.getString("r_writer");
	            String r_title = rs.getString("r_title");
	            String r_writeday = rs.getString("r_writeday");
	            int r_readcnt = rs.getInt("r_readcnt");
	            int r_repIndent = rs.getInt("r_repIndent");
	            RJSBoardDTO dto = new RJSBoardDTO(r_num, r_writer, r_title, null, r_writeday, r_readcnt, 0 , 0, r_repIndent);
	            list.add(dto);
	         }

	         to.setList(list);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         closeAll(rs, pstmt, conn);
	      }
	      return to;
	   }
	private int getAmount(Connection conn, String query) {

	      int amount = 0;

	      PreparedStatement pstmt = null;
	      String sql = "select count(r_num) from board_rjs";
	      ResultSet rs = null;

	      try {
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            amount = rs.getInt(1);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         closeAll(rs, pstmt, null);
	      }

	      return amount;
	   }

	
	
}











