package com.naver.rjs.로그인;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.MemberDAO;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import com.naver.rjs.MemberDTO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

public class RjsMemberShipUpdateCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String r_id = request.getParameter("id");
		String r_name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int r_age = 0;
		if (sAge != null) {
			r_age = Integer.parseInt(sAge);
		}
		String r_pw = request.getParameter("pw");
		
		new MemberDAO().membershipupdate(new MemberDTO(r_id, r_name, r_age, r_pw));
		return new RJSCommandAction(true, "selectById.rjs?r_id="+r_id);
	}

}
