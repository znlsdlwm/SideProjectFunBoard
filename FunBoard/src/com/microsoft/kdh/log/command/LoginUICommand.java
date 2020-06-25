package com.microsoft.kdh.log.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;

public class LoginUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new CommandAction(false, "./kdhjsp/loginui.jsp");
	}

}
