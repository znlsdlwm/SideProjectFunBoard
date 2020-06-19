package com.microsoft.kdh.comment.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.CommentDAO;
import com.microsoft.kdh.domain.AnswerLogDTO;
import com.microsoft.kdh.domain.CommentDTO;

import member.domain.LoginDTO;

public class InsertCommentBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String b_Snum = request.getParameter("num");
		int b_num = -1;
		if(b_Snum!=null)
			b_num = Integer.parseInt(b_Snum);
		String c_writer = request.getParameter("c_writer");
		String c_password = request.getParameter("c_password");
		String c_content = request.getParameter("c_content");
		CommentDAO dao = new CommentDAO();
		dao.insertComment(new CommentDTO(0, c_writer, c_content, c_password, null, 0, 0, 0, -1, -1, -1, b_num));
		
		HttpSession session = request.getSession();
		session.setAttribute("A_Login", new AnswerLogDTO(c_writer, c_password));
		
		return new CommandAction(true, "readboard.kdh?num="+b_num);
	}

}
