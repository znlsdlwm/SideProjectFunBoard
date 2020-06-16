package com.microsoft.kdh.comment.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.CommentDAO;

public class DeleteCommentBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c_Snum = request.getParameter("c_num");
		String num = request.getParameter("num");
		int c_num = -1;
		if(c_Snum!=null)
			c_num = Integer.parseInt(c_Snum);
		CommentDAO dao = new CommentDAO();
		dao.delete(c_num);
		return new CommandAction(true, "readboard.kdh?num="+num);
	}

}
