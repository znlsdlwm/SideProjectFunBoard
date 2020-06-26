package com.naver.rjs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSMemberDAO;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import com.naver.rjs.RJSMemberDTO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

public class RjsMemberShipUpdateUICommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		RJSMemberDAO dao = new RJSMemberDAO();
		RJSMemberDTO dto = dao.membershipupdateui(id);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return new RJSCommandAction(false, "RJS-web/membershipupdate.jsp");
	}

}
