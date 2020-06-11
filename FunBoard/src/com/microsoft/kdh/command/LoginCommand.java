package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.dao.MemberDAO;

import member.domain.LoginDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		boolean isUser = dao.login(new LoginDTO(id, pw));
		
		if(isUser) {
			LoginDTO login = new LoginDTO(id, null);
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1500);
			session.setAttribute("login", login);
			return new CommandAction(true, "home.kdh");
		} else {
			return new CommandAction(true, "loginui.kdh");
		}
		
	}

}
