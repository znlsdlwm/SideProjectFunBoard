package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.dao.MemberDAO;
import com.microsoft.kdh.domain.BoardDTO;

import member.domain.LoginDTO;

public class UpdateBoardUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		HttpSession session = request.getSession();
		LoginDTO dto = (LoginDTO) session.getAttribute("login");
		BoardDAO dao = new BoardDAO();
		boolean isUser = dao.isUser(dto.getId(), num);
		if (isUser) {
			BoardDTO boarddto =dao.read(dao.getFkNum(num));
			request.setAttribute("dto", boarddto);
			return new CommandAction(false, "./kdhjsp/updateboard.jsp");
		} else {
			return new CommandAction(true, "listboard.kdh");
		}
	}

}
