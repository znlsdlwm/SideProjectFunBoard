package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.dao.BoardDAO;

import member.domain.LoginDTO;

public class UpdateBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if(login!=null) {
				String writer = login.getId();
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String sNum = request.getParameter("num");
				System.out.println(sNum);
				int num = -1;
				if(sNum!=null)
					num = Integer.parseInt(sNum);
				dao.update(writer, title, content, num);
			}
		}
		return new CommandAction(true, "listboard.kdh");
	}

}
