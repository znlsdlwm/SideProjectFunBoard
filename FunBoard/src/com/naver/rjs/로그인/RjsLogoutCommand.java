package com.naver.rjs.로그인;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.LoginDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsLogoutCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if (login != null) {
				session.invalidate();
			}
		}
		return new RJSCommandAction(true, "select.rjs");
	}

}
