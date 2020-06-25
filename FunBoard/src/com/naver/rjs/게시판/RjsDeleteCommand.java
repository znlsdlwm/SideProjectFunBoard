package com.naver.rjs.게시판;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.MemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;

public class RjsDeleteCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int r_num = -1;
		if (sNum != null) {
			r_num = Integer.parseInt(sNum);
		}
		
		MemberDAO dao =new MemberDAO();
		dao.delete(r_num);
		
		return new RJSCommandAction(true, "list1.rjs");
	}

}
