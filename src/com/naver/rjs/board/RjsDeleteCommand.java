package com.naver.rjs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSMemberDAO;
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
		
		RJSMemberDAO dao =new RJSMemberDAO();
		dao.delete(r_num);
		
		return new RJSCommandAction(true, "list1.rjs");
	}

}
