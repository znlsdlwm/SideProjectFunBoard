package com.microsoft.kdh.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.BoardDTO;

import member.domain.LoginDTO;

public class ReplyeBoardUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession(false);
		if (session != null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				String sNum = request.getParameter("num");
				int num = -1;
				if (sNum != null) {
					num = Integer.parseInt(sNum);
				}
				BoardDTO boarddto = dao.read(num);
				request.setAttribute("dto", boarddto);
				return new CommandAction(false, "/kdhjsp/replyboard.jsp");
			}
		} else {
			return new CommandAction(true, "listboard.kdh");
		}
		return new CommandAction(true, "listboard.kdh");

	}

}
