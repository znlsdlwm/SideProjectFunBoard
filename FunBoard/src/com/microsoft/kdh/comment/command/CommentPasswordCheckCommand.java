package com.microsoft.kdh.comment.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

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
		request.setAttribute("num", num);
		
		int c_num = -1;
		if(c_Snum!=null)
			c_num = Integer.parseInt(c_Snum);
		CommentDAO dao = new CommentDAO();
		boolean passwordCheck = dao.passwordCheck(c_num, password);
		if (passwordCheck) {
			dao.delete(c_num, password);
			request.setAttribute("alertresult", "삭제 성공");
			return new CommandAction(false, "/kdhjsp//dcmrs.jsp");
		} else {
			request.setAttribute("alertresult", "삭제 실패");
			return new CommandAction(false, "/kdhjsp/dcmrs.jsp");
		}
		
	}

}
