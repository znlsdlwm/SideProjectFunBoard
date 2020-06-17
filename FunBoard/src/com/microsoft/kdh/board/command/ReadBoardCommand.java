package com.microsoft.kdh.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.dao.CommentDAO;
import com.microsoft.kdh.domain.BoardDTO;
import com.microsoft.kdh.domain.CommentDTO;

public class ReadBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if(sNum!=null)
			num = Integer.parseInt(sNum);
		BoardDAO dao = new BoardDAO();
		BoardDTO boardDTO = dao.read(num);
		request.setAttribute("dto", boardDTO);
		CommentDAO cDAO = new CommentDAO();
		List<CommentDTO> c_list = cDAO.listComment(num);
		request.setAttribute("c_list", c_list);
		return new CommandAction(false, "/kdhjsp/readboard.jsp");
	}

}
