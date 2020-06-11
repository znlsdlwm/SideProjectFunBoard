package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.dao.MemberDAO;
import com.microsoft.kdh.domain.BoardDTO;

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
		return new CommandAction(false, "./kdhjsp/readboard.jsp");
	}

}
