package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.BoardDTO;

public class ReplyeBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		int orgnum = -1;
		if(sNum!=null) {
			orgnum = Integer.valueOf(sNum);
		}
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(-1, writer, title, content, null,
				0, -1, -1, -1);
		dao.reply(orgnum, dto);
		
		
		return new CommandAction(true, "listboard.kdh");
	}

}
