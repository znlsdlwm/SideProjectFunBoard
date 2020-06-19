package com.microsoft.kdh.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.dao.BoardEventDAO;
import com.microsoft.kdh.dao.CommentDAO;
import com.microsoft.kdh.domain.BoardDTO;
import com.microsoft.kdh.domain.CommentDTO;
import com.microsoft.kdh.domain.EventTotal;

public class ReadBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if(sNum!=null)
			num = Integer.parseInt(sNum);
		// 게시글 정보
		BoardDAO dao = new BoardDAO();
		BoardDTO boardDTO = dao.read(num);
		request.setAttribute("dto", boardDTO);
		// 댓글 정보
		CommentDAO cDAO = new CommentDAO();
		List<CommentDTO> c_list = cDAO.listComment(num);
		request.setAttribute("c_list", c_list);
		// 게시글 추가 정보
		BoardEventDAO Edao = new BoardEventDAO();
		EventTotal total = Edao.getTotal(num);
		request.setAttribute("total", total);
		
		request.setAttribute("comment", "comment");
		return new CommandAction(false, "/kdhjsp/readboard.jsp");
	}

}
