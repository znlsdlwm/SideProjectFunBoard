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

import com.microsoft.kdh.domain.BoardDTO;
import com.microsoft.kdh.domain.PageTO;
import com.microsoft.kdh.template.GetConRowMapper;
import com.microsoft.kdh.template.JdbcTemplate;
import com.microsoft.kdh.template.PreparedStatementCreator;
import com.microsoft.kdh.template.RowMapper;

import member.domain.MemberDTO;

public class BoardDAO {
	private JdbcTemplate jdbcTemplate;

	public BoardDAO() {
		this.jdbcTemplate = new JdbcTemplate();
	}

	// Read
	public PageTO searchWriter(int curPage, String query) {
//		PageTO to = new PageTO(curPage);
//		List<BoardDTO> list = new ArrayList<BoardDTO>();
//		String sql = "select * from (" + "select rownum rnum, num, title, writer, writeday, readcnt, repIndent, repRoot, repStep from ("
//				+ "select * from board where writer like ? order by repRoot desc , repStep)) "
//				+ "where rnum>=? and rnum<=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dataFactory.getConnection();
//			int amount = getAmountWriter(conn, query);
//			to.setAmount(amount);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + query + "%");
//			pstmt.setInt(2, to.getStartNum());
//			pstmt.setInt(3, to.getEndNum());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int num = rs.getInt("num");
//				String title = rs.getString("title");
//				String writer = rs.getString("writer");
//				String writeDay = rs.getString("writeday");
//				int readcnt = rs.getInt("readcnt");
//				int repIndent = rs.getInt("repIndent");
//				
//				list.add(new BoardDTO(num, writer, title, null, writeDay, readcnt, rs.getInt("repRoot"), rs.getInt("repStep"), repIndent));
//			}
//			to.setList(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, conn);
//		}
//		return to;
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from ("
				+ "select rownum rnum, num, title, writer, writeday, readcnt, repIndent, repRoot, repStep from ("
				+ "select * from board where writer like ? order by repRoot desc , repStep)) "
				+ "where rnum>=? and rnum<=?";
		return jdbcTemplate.query(con -> {
			int amount = getAmountWriter(con, query);
			to.setAmount(amount);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, to.getStartNum());
			pstmt.setInt(3, to.getEndNum());
			return pstmt;
		}, rs -> {
			int num = rs.getInt("num");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String writeDay = rs.getString("writeday");
			int readcnt = rs.getInt("readcnt");
			int repIndent = rs.getInt("repIndent");
			list.add(new BoardDTO(num, writer, title, null, writeDay, readcnt, rs.getInt("repRoot"),
					rs.getInt("repStep"), repIndent));
			to.setList(list);
			return to;
		});
	}

	public PageTO searchTitle(int curPage, String query) {
//		PageTO to = new PageTO(curPage);
//		List<BoardDTO> list = new ArrayList<BoardDTO>();
//		String sql = "select * from ("
//				+ "select rownum rnum, num, title, writer, writeday, readcnt, repIndent, repRoot, repStep from ("
//				+ "select * from board where title like ? order by repRoot desc , repStep)) "
//				+ "where rnum>=? and rnum<=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dataFactory.getConnection();
//			int amount = getAmountTitle(conn, query);
//			to.setAmount(amount);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + query + "%");
//			pstmt.setInt(2, to.getStartNum());
//			pstmt.setInt(3, to.getEndNum());
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				int num = rs.getInt("num");
//				String title = rs.getString("title");
//				String writer = rs.getString("writer");
//				String writeDay = rs.getString("writeday");
//				int readcnt = rs.getInt("readcnt");
//				int repIndent = rs.getInt("repIndent");
//				list.add(new BoardDTO(num, writer, title, null, writeDay, readcnt, rs.getInt("repRoot"),
//						rs.getInt("repStep"), repIndent));
//			}
//			to.setList(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, conn);
//		}
//		return to;
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select * from ("
				+ "select rownum rnum, num, title, writer, writeday, readcnt, repIndent, repRoot, repStep from ("
				+ "select * from board where title like ? order by repRoot desc , repStep)) "
				+ "where rnum>=? and rnum<=?";
		Object isNull = jdbcTemplate.query(con -> {
			int amount = getAmountTitle(con, query);
			to.setAmount(amount);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			pstmt.setInt(2, to.getStartNum());
			pstmt.setInt(3, to.getEndNum());
			return pstmt;
		}, rs -> {
			list.add(new BoardDTO(rs.getInt("num"), rs.getString("writer"), rs.getString("title"), null,
					rs.getString("writeday"), rs.getInt("readcnt"), rs.getInt("repRoot"), rs.getInt("repStep"),
					rs.getInt("repIndent")));
			return null;
		});
		to.setList(list);
		return to;
	}

	public BoardDTO read(int num) {
//		BoardDTO dto = new BoardDTO();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from board where num=?";
//		boolean isOk = false;
//		try {
//			conn = dataFactory.getConnection();
//			conn.setAutoCommit(false);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				dto.setNum(rs.getInt("num"));
//				dto.setContent(rs.getString("content"));
//				dto.setReadcnt(rs.getInt("readcnt") + 1);
//				dto.setRepIndent(rs.getInt("RepIndent"));
//				dto.setRepRoot(rs.getInt("repRoot"));
//				dto.setRepStep(rs.getInt("repStep"));
//				dto.setTitle(rs.getString("title"));
//				dto.setWriteDay(rs.getString("writeDay"));
//				dto.setWriter(rs.getString("writer"));
//				increaseReadCnt(conn, num);
//				isOk = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			transaction(conn, isOk);
//			clossAll(rs, pstmt, conn);
//		}
//		return dto;
		BoardDTO dto = new BoardDTO();
		String sql = "select * from board where num=?";
		return jdbcTemplate.queryForOnce(con -> {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt;
		}, (con, rs) -> {
			dto.setNum(rs.getInt("num"));
			dto.setContent(rs.getString("content"));
			dto.setReadcnt(rs.getInt("readcnt") + 1);
			dto.setRepIndent(rs.getInt("RepIndent"));
			dto.setRepRoot(rs.getInt("repRoot"));
			dto.setRepStep(rs.getInt("repStep"));
			dto.setTitle(rs.getString("title"));
			dto.setWriteDay(rs.getString("writeDay"));
			dto.setWriter(rs.getString("writer"));
			increaseReadCnt(con, num);
			return dto;
		});
	}

	private void increaseReadCnt(Connection conn, int num) {
//		PreparedStatement pstmt = null;
//		String sql = "update board set readcnt=readcnt+1 where num =?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(null, pstmt, null);
//		}
		String sql = "update board set readcnt=readcnt+1 where num =?";
		jdbcTemplate.update(conn, con -> {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt;
		});
	}

	public Boolean isUser(String id, int num) {
//		boolean isUser = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from (select num, writer from (select * from board order by repRoot desc , repStep)) where writer=? and num=?";
//		try {
//			conn = dataFactory.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setInt(2, num);
//			rs = pstmt.executeQuery();
//			if (rs.next())
//				isUser = true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, conn);
//		}
//		return isUser;
		String sql = "select * from (select num, writer from (select * from board order by repRoot desc , repStep)) where writer=? and num=?";
		return jdbcTemplate.queryForOnce(con -> {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			return pstmt;
		}, rs -> {
			rs.getInt("num");
			if (rs.wasNull())
				return false;
			else
				return true;
		});
	}

	// Create
	public int insert(BoardDTO dto) {
//		int num = -1;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "insert into board(num,writer,title,content,repRoot,repStep,repIndent)"
//				+ " values (?,?,?,?,?,?,?)";
//		try {
//			conn = dataFactory.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			num = createNum(conn);
//			pstmt.setInt(1, num);
//			pstmt.setString(2, dto.getWriter());
//			pstmt.setString(3, dto.getTitle());
//			pstmt.setString(4, dto.getContent());
//			pstmt.setInt(5, num);
//			pstmt.setInt(6, dto.getRepStep());
//			pstmt.setInt(7, dto.getRepIndent());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(null, pstmt, conn);
//		}
//		return num;
		String sql = "insert into board(num,writer,title,content,repRoot,repStep,repIndent)"
					+ " values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(con -> {
			PreparedStatement pstmt = con.prepareStatement(sql);
			int num = createNum(con);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, dto.getRepStep());
			pstmt.setInt(7, dto.getRepIndent());
			return pstmt;
		});
		int num = selectNum();
		return num;
	}

	public void reply(int orgnum, BoardDTO dto) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "insert into board(num,writer,title,content,repRoot,repStep,repIndent)"
//				+ " values (?,?,?,?,?,?,?)";
//		boolean isOk = false;
//		try {
//			conn = dataFactory.getConnection();
//			conn.setAutoCommit(false);
//			BoardDTO orgDTO = getAllAsNum(conn, orgnum);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, createNum(conn));
//			pstmt.setString(2, dto.getWriter());
//			pstmt.setString(3, titleRePlus(orgDTO.getRepIndent() + 1) + dto.getTitle());
//
//			pstmt.setString(4, dto.getContent());
//			pstmt.setInt(5, orgDTO.getRepRoot());
//
//			int step = getMaxStep(conn, orgDTO);
//			pstmt.setInt(6, step);
//
//			pstmt.setInt(7, orgDTO.getRepIndent() + 1);
//			repStepOthersPlus1(conn, orgDTO, step);
//			pstmt.executeUpdate();
//			isOk = true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			transaction(conn, isOk);
//			clossAll(null, pstmt, conn);
//		}
		String sql = "insert into board(num,writer,title,content,repRoot,repStep,repIndent)"
				+ " values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(con->{
				BoardDTO orgDTO = getAllAsNum(con, orgnum);
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, createNum(con));
				pstmt.setString(2, dto.getWriter());
				pstmt.setString(3, titleRePlus(orgDTO.getRepIndent() + 1) + dto.getTitle());
				pstmt.setString(4, dto.getContent());
				pstmt.setInt(5, orgDTO.getRepRoot());
				int step = getMaxStep(con, orgDTO);
				pstmt.setInt(6, step);
				pstmt.setInt(7, orgDTO.getRepIndent() + 1);
				repStepOthersPlus1(con, orgDTO, step);
				return pstmt;
		});
	}

	public BoardDTO getAllAsNum(Connection conn, int orgnum) {
//		BoardDTO dto = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from board where num=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, orgnum);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				dto = new BoardDTO(rs.getInt("num"), rs.getString("writer"), rs.getString("title"),
//						rs.getString("content"), null, rs.getInt("readcnt"), rs.getInt("repRoot"), rs.getInt("repStep"),
//						rs.getInt("repIndent"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, null);
//		}
//		return dto;
		return jdbcTemplate.queryForOnce(con->{
			PreparedStatement pstmt = conn.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, orgnum);
			return pstmt;
		},rs -> {
			return new BoardDTO(rs.getInt("num"), rs.getString("writer"), rs.getString("title"),
					rs.getString("content"), null, rs.getInt("readcnt"), rs.getInt("repRoot"), rs.getInt("repStep"),
					rs.getInt("repIndent"));
		});
	}

	private int getMaxStep(Connection conn, BoardDTO orgDTO) {
//		int replyStep = -1;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select NVL(max(repStep), -99) from board where repRoot= ? and repIndent =? and repstep>?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, orgDTO.getRepRoot());
//			pstmt.setInt(2, orgDTO.getRepIndent() + 1);
//			pstmt.setInt(3, orgDTO.getRepStep());
//			rs = pstmt.executeQuery();
//			if (rs.next())
//				replyStep = rs.getInt(1);
//			if (replyStep == -99)
//				replyStep = orgDTO.getRepStep() + 1;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, null);
//		}
//		return replyStep;
		String sql = "select NVL(max(repStep), -99) from board where repRoot= ? and repIndent =? and repstep>?";
		return jdbcTemplate.queryForOnce(con->{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepIndent() + 1);
			pstmt.setInt(3, orgDTO.getRepStep());
			return pstmt;
		}, rs->{
			int replyStep = rs.getInt(1);
			if (replyStep == -99)
				replyStep = orgDTO.getRepStep() + 1;
			return replyStep;
		});
	}

	private void repStepOthersPlus1(Connection conn, BoardDTO orgDTO, int step) {
//		PreparedStatement pstmt = null;
//		String sql = "update board set repstep=repstep+1 where repRoot=? and repStep>=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, orgDTO.getRepRoot());
//			pstmt.setInt(2, step);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(null, pstmt, null);
//		}
		String sql = "update board set repstep=repstep+1 where repRoot=? and repStep>=?";
		jdbcTemplate.update(conn, con->{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, step);
			pstmt.executeUpdate();
			return pstmt;
		});
	}

	private String titleRePlus(int repIndent) {
		String result = "";
		for (int i = 0; i < repIndent; i++) {
			result += "re: ";
		}
		return result;
	}

	// Delete
	public void delete(int num) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "delete from board where num=?";
//		try {
//			conn = dataFactory.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(null, pstmt, conn);
//		}
		String sql = "delete from board where num=?";
		jdbcTemplate.update(con->{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			return pstmt;
		});
	}

	public void update(String writer, String title, String content, int num) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		String sql = "update board set writer=?,title=?,content=? where num=?";
//		try {
//			conn = dataFactory.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, writer);
//			pstmt.setString(2, title);
//			pstmt.setString(3, content);
//			pstmt.setInt(4, num);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(null, pstmt, conn);
//		}
		String sql = "update board set writer=?,title=?,content=? where num=?";
		jdbcTemplate.update(con->{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, num);
			return pstmt;
		});
	}

	private int getAmountTitle(Connection conn, String query) {
//		int amount = 0;
//
//		PreparedStatement pstmt = null;
//		String sql = "select count(num) from board where title like ?";
//		ResultSet rs = null;
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + query + "%");
//			rs = pstmt.executeQuery();
//			if (rs.next())
//				amount = rs.getInt(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, null);
//		}
//
//		return amount;
		return jdbcTemplate.queryForOnce(con->{
			PreparedStatement pstmt = conn.prepareStatement("select count(num) from board where title like ?");
			pstmt.setString(1, "%" + query + "%");
			return pstmt;
		}, rs-> rs.getInt(1));
	}

	private int getAmountWriter(Connection conn, String query) {
//		int amount = 0;
//		PreparedStatement pstmt = null;
//		String sql = "select count(num) from board where writer like ?";
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%" + query + "%");
//			rs = pstmt.executeQuery();
//			if (rs.next())
//				amount = rs.getInt(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, null);
//		}
//
//		return amount;
		return jdbcTemplate.queryForOnce(conn, con->{
			PreparedStatement pstmt = conn.prepareStatement("select count(num) from board where writer like ?");
			pstmt.setString(1, "%" + query + "%");
			return pstmt;
		}, rs->rs.getInt(1));
	}

	public int createNum(Connection conn) {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select max(num) num from board";
//		Integer num = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				num = rs.getInt(1);
//				num += 1;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			clossAll(rs, pstmt, null);
//		}
//		return num;
		return jdbcTemplate.queryForOnce(conn, con->{
			return conn.prepareStatement("select max(num) num from board");
		}, rs->{
			Integer num = new Integer(rs.getInt(1));
			num += 1;
			return num;
		});
	}

	public int selectNum() {
		return jdbcTemplate.queryForOnce(con -> {
			return con.prepareStatement("select max(num) num from board");
		}, rs->rs.getInt(1));
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
