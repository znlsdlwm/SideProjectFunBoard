package com.naver.rjs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSBoardDTO;
import com.naver.rjs.RJSMemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsUpdateCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int r_num = -1;
		if (snum != null) {
			r_num = Integer.parseInt(snum);
		}
		String r_writer = request.getParameter("writer");
		String r_title = request.getParameter("title");
		String r_content = request.getParameter("content");
		RJSMemberDAO dao = new RJSMemberDAO();
		dao.update(new RJSBoardDTO(r_num, r_writer, r_title, r_content, null, -1, -1, -1, -1));
		
		return new RJSCommandAction(true, "list1.rjs");
	}

}
