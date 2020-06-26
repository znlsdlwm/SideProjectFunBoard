package com.naver.rjs.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSMemberDAO;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import com.naver.rjs.RJSMemberDTO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

public class RjsMemberShipSelectCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RJSMemberDAO dao = new RJSMemberDAO();
		List<RJSMemberDTO> list= dao.selectAll();
		request.setAttribute("list", list);
		
		return new RJSCommandAction(false, "RJS-web/login.jsp");
	}

}
