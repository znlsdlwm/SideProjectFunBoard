package com.microsoft.kdh.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.dao.BoardEventDAO;
import com.microsoft.kdh.domain.BoardDTO;

import member.domain.LoginDTO;

public class InsertBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title =request.getParameter("title");
		LoginDTO dto = (LoginDTO) request.getSession().getAttribute("login");
		String writer = dto.getId();
		String content =request.getParameter("content");
		BoardDAO dao = new BoardDAO();
		int num = dao.insert(new BoardDTO(0, writer, title, content, null, 0, 0, 0, 0));
		// 게시글 추가정보
		BoardEventDAO Edao = new BoardEventDAO();
		Edao.createTotal(num);
		return new CommandAction(true, "listboard.kdh");
	}

}
