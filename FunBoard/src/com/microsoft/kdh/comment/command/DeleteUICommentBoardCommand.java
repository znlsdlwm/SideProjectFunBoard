package com.microsoft.kdh.comment.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;

public class DeleteUICommentBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_num = request.getParameter("c_num");
		request.setAttribute("c_num", c_num);
		return new CommandAction(false, "/kdhjsp/deleteuicommentboard.jsp");
	}

}
