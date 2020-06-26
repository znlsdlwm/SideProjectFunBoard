package com.naver.rjs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsInsertUICommand1 implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return new RJSCommandAction(false, "RJS-web/insert.jsp");
	}

}
