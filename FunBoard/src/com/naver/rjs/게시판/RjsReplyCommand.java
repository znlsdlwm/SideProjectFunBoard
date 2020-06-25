package com.naver.rjs.게시판;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.BoardDTO;
import com.naver.rjs.MemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsReplyCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		System.out.println(sNum);
		int orgnum = -1;
		if (sNum != null) {
			orgnum = Integer.parseInt(sNum);
		}
		
		String r_writer = request.getParameter("writer");
		String r_title = request.getParameter("title");
		String r_content = request.getParameter("content");
		
		MemberDAO dao = new MemberDAO();
		BoardDTO dto = new BoardDTO(-1, r_writer, r_title, r_content, null, 0, 0, 0, 0); 
		dao.reply(orgnum, dto);
//		dao.reply(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		return new RJSCommandAction(true, "list1.rjs");
	}

}
