package com.naver.rjs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.rjs.RJSMemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommandAction;
import member.domain.LoginDTO;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsLoginCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean login = new RJSMemberDAO().login(new LoginDTO(id, pw));
		if (login) {
			HttpSession session = request.getSession();
			session.setAttribute("login", new LoginDTO(id, null));
			return new RJSCommandAction(false, "list1.rjs");
		}else {
			return new RJSCommandAction(false, "loginui.rjs");
		}
	}

}
