package com.naver.rjs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.rjs.RJSBoardDTO;
import com.naver.rjs.RJSMemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import member.domain.LoginDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsInsertCommand1 implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
//		LoginDTO dto = (LoginDTO)session.getAttribute("login");
//		if (session != null) {
//			dto.getId();
//			dto.getPw();
//		}
		String r_writer = request.getParameter("writer");
		String r_title = request.getParameter("title");
		String r_content = request.getParameter("content");
		
		RJSMemberDAO dao = new RJSMemberDAO();
		dao.boardinsert(new RJSBoardDTO(-1, r_writer, r_title, r_content, null, 0, 0, 0, 0));
		
		return new RJSCommandAction(true, "list1.rjs");
	}

}
