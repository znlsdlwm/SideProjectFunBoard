package com.microsoft.kdh.log.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;

import member.domain.LoginDTO;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if(login!=null) {
				session.invalidate();
			}
		}
		return new CommandAction(true, "home.kdh");
	}

}
