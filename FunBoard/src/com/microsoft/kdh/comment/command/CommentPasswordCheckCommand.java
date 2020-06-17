package com.microsoft.kdh.comment.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.CommentDAO;

public class CommentPasswordCheckCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String c_Snum = request.getParameter("c_num");
		String num = request.getParameter("num");
		int c_num = -1;
		if(c_Snum!=null)
			c_num = Integer.parseInt(c_Snum);
		CommentDAO dao = new CommentDAO();
		boolean passwordCheck = dao.passwordCheck(c_num, password);
		if (passwordCheck) {
			request.setAttribute("alert", "성공");
			dao.delete(c_num, password);
			return new CommandAction(true, "readboard.kdh?num="+num);
		} else {
			request.setAttribute("alert", "실패");
			return new CommandAction(false, "readboard.kdh?num="+num);
		}
		
	}

}
