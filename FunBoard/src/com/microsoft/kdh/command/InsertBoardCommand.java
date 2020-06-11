package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.BoardDTO;

public class InsertBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title =request.getParameter("title");
		String writer =request.getParameter("writer");
		String content =request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		dao.insert(new BoardDTO(0, writer, title, content, null, 0, 0, 0, 0));
		return new CommandAction(true, "listpage.kdh");
	}

}
