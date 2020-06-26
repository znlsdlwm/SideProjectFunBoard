package com.naver.rjs.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.RJSBoardDTO;
import com.naver.rjs.RJSMemberDAO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsUpdateUICommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int r_num = -1;
		if (snum != null) {
			r_num = Integer.parseInt(snum);
		}
		RJSMemberDAO dao = new RJSMemberDAO();
		RJSBoardDTO dto = dao.updateUI(r_num);
		
		request.setAttribute("dto", dto);
		
		return new RJSCommandAction(false, "RJS-web/update.jsp");
	}

}
