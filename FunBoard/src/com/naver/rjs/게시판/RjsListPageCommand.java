package com.naver.rjs.게시판;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.MemberDAO;
import com.naver.rjs.PageTO;
import com.naver.rjs.RJSCommand;
import com.naver.rjs.RJSCommandAction;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class RjsListPageCommand implements RJSCommand {

	@Override
	public RJSCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scurPage = request.getParameter("curPage");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		MemberDAO dao = new MemberDAO();
		
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		
		PageTO to = null;
		if (keyWord == null) {
			keyWord = "";
		}
		if (keyField == null) {
			keyField = "title";
			 to = dao.searchList(curPage, keyField, keyWord);
	      } else if (keyField!=null){
	         to = dao.searchList(curPage, keyField, keyWord);

		}
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		
		return new RJSCommandAction(false, "RJS-web/main.jsp");
	}

}
