package com.naver.rjs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface RJSCommand {
	RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
