package com.naver.rjs.게시판;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.BoardDTO;
import com.naver.rjs.MemberDAO;
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
		MemberDAO dao = new MemberDAO();
		BoardDTO dto = dao.updateUI(r_num);
		
		request.setAttribute("dto", dto);
		
		return new RJSCommandAction(false, "RJS-web/update.jsp");
	}

}
