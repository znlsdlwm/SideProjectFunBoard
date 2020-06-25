package com.naver.rjs.게시판;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.BoardDTO;
import com.naver.rjs.MemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsListCommand1 implements RJSCommand{

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		return new RJSCommandAction(false, "RJS-web/main.jsp");
	}

}
