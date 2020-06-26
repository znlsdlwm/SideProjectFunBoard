package com.naver.rjs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSBoardDTO;
import com.naver.rjs.RJSMemberDAO;
import com.naver.rjs.RJSMemberDTO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsInsertCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String r_id = request.getParameter("id");
		String r_name = request.getParameter("name");
		String sAge = request.getParameter("age");
		String r_pw = request.getParameter("pw");
		int r_age = 0;
		if (sAge != null) {
			r_age = Integer.parseInt(sAge);
		}
			RJSMemberDAO dao = new RJSMemberDAO();
			dao.insert(new RJSMemberDTO(r_id, r_name, r_age, r_pw));
					
		return new RJSCommandAction(true, "list1.rjs");
	}

}
