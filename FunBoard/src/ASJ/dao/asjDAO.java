package ASJ.dao;

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

import ASJ.domain.ASJadminDTO;
import ASJ.domain.AdminDTO;
import ASJ.domain.AsjBoardDTO;
import ASJ.domain.PageDTO;
import ASJ.domain.asjDTO;



public class asjDAO {
	private DataSource dataFactory;
	public asjDAO() {
		try {
			Context ctx = new InitialContext();
			
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
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


	public void insert(asjDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "insert into member_asj(id,name,age,pw) values (?,?,?,?)";
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
	
	
	
	
	public boolean login(asjDTO dto) {
		boolean login = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from member_ASJ where id = ? and pw = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				login = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return login;
	}


	public asjDTO selectById(String id) {
		asjDTO dto = null;
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql = "select *from member_asj where id = ?";
		ResultSet rs  = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name =rs.getString("name");
				int age = rs.getInt("age");
				
				dto = new asjDTO(id, name, age, null);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}


	public List<asjDTO> selectAll() {
		List<asjDTO>list = new ArrayList<asjDTO>();
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql = "select *from member_asj";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt(3);
				
				asjDTO dto = new asjDTO(id, name, age, null);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		
		
		return list;
	}
	public void update(asjDTO dto) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql = "update member_asj set name = ? ,age = ? where id = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}


	public asjDTO updateUI(String id) {
		
		return selectById(id);
	}


	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "delete from member_asj where id = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}


	public List<AsjBoardDTO> list() {
		List<AsjBoardDTO> list = new ArrayList<AsjBoardDTO>();
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql = "select *from board_asj order by repRoot desc, repStep asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				list.add(new AsjBoardDTO(num, writer, title, null,writeday, readcnt, repRoot, repStep, repIndent));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}
	private int createNum(Connection conn) {
		PreparedStatement pstmt =null;
		String sql = "select max(num) from board_asj";
		ResultSet rs= null;
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
	private int createNum_admin(Connection conn) {
		PreparedStatement pstmt =null;
		String sql = "select max(num) from admin_board_asj";
		ResultSet rs= null;
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


	public void boardinsert(AsjBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "insert into board_asj(num, writer, title, content, repRoot, repStep, repIndent)values (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt =conn.prepareStatement(sql);
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


	public AsjBoardDTO read(int num) {
		AsjBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from board_asj where num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		try {
			conn= dataFactory.getConnection();
			increaseReadCnt(conn,num);
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				String content = rs.getString("content");
				dto = new AsjBoardDTO(num, writer, title, content,writeday, readcnt+1, 0, 0, 0);
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
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
	private void increaseReadCnt(Connection conn, int num) {
		PreparedStatement pstmt =null;
		String sql = "update board_asj set readcnt = readcnt+1 where num = ?";
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


	public AsjBoardDTO boardupdateUI(int num) {
		AsjBoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "select *from board_asj where num = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()){
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				dto = new AsjBoardDTO(num, writer, title, content, null, 0, repRoot, repStep, repIndent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}


	public void boardupdate(AsjBoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board_asj set writer = ?,title = ?,content = ? where num = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}


	public void boarddelete(int num) {
		Connection conn =null;
		PreparedStatement pstmt =null;
		String sql = "delete from board_asj where num = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
		
	}


	public void reply(int orgnum, AsjBoardDTO dto) {
		Connection conn  =null;
		PreparedStatement pstmt = null;
		String sql = "insert into board_asj (num,writer,title,content,"
				+"repRoot, repStep, repIndent) values"
				+"(?,?,?,?,?,?,?)";
		
		boolean isOk = false;
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			int num = createNum(conn);
			
			AsjBoardDTO orgDTO= boardupdateUI(orgnum); 
			
			stepPlus1(conn,orgDTO);
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, orgDTO.getRepRoot());
			pstmt.setInt(6, orgDTO.getRepStep()+1);
			pstmt.setInt(7, orgDTO.getRepIndent()+1);
			
			
			pstmt.executeUpdate();
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
					conn.commit();
				}else {
					conn.rollback();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
		
	}
	private void stepPlus1(Connection conn, AsjBoardDTO orgDTO) {
		PreparedStatement pstmt = null;
		String sql = "update board_asj set repStep = repStep+1"
				+ "where"
				+ "repRoot = ? and repStep > ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,orgDTO.getRepRoot());
			pstmt.setInt(2,orgDTO.getRepStep());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, null);
		}
		
	}


	public PageDTO page(int curPage) {
		String sql = "select *from("
				+ "select rownum rnum, num, title, writer, writeday, readcnt, repIndent from("
				+ "select *from board_asj order by repRoot desc, repStep asc))where rnum>=? and rnum<=?";
		
		PageDTO to = new PageDTO(curPage);
		List<AsjBoardDTO> list = new ArrayList<AsjBoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			int amount = getAmount(conn);
			to.setAmount(amount);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
			String title =rs.getString("title");
			String writer = rs.getString("writer");
			String writeday = rs.getString("writeday");
			int readcnt = rs.getInt("readcnt");
			int repIndent = rs.getInt("repIndent");
			
			AsjBoardDTO dto = new AsjBoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent);
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
		String sql = "select count(num) from board_asj";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()){
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
	
		return amount;
	}


	public List<ASJadminDTO> adminlist() {
		List<ASJadminDTO> list = new ArrayList<ASJadminDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from admin_board_asj order by repRoot desc, repStep asc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				list.add(new ASJadminDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}


	public void admininsert(ASJadminDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into admin_board_asj(num, writer, title, content, repRoot, repStep, repIndent) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			int num = createNum_admin(conn);
			pstmt.setInt(1,num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5,num);
			pstmt.setInt(6,0);
			pstmt.setInt(7,0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(null, pstmt, conn);
		}
	}


	public boolean Admin_login(AdminDTO dto) {
		boolean login = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from admin_asj where id = ? and pw = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				login = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, conn);
		}
		return login;
	}


	public ASJadminDTO admin_read(int num) {
		ASJadminDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select *from admin_board_asj where num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		try {
			conn= dataFactory.getConnection();
			increaseReadCnt(conn,num);
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				String content = rs.getString("content");
				dto = new ASJadminDTO(num, writer, title, content,writeday, readcnt+1, 0, 0, 0);
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (isOk) {
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

		
		
	


	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	

