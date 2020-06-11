package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.BoardDTO;

import member.domain.LoginDTO;

public class deleteBoardUICommand implements Command {

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
				boolean isUser = dao.isUser(login.getId(), num);
				if (isUser) {
					BoardDTO boarddto = dao.read(dao.getFkNum(num));
					request.setAttribute("dto", boarddto);
					 return new CommandAction(false, "./kdhjsp/deleteboard.jsp");
				} else {
					return new CommandAction(true, "listboard.kdh");
				}
			} else {
				return new CommandAction(true, "listboard.kdh");
			}
		} else {
			return new CommandAction(true, "listboard.kdh");
		}
	}

}
