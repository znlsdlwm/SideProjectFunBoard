package com.microsoft.kdh.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.PageTO;

public class ListBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCurPage = request.getParameter("curPage");
		String query = request.getParameter("query");
		if(query==null) {
			query="";
		}
		int curPage = limitPage(sCurPage);
		
		BoardDAO dao = new BoardDAO();
//		PageTO to = dao.page(curPage);
		PageTO to = dao.searchQuery(curPage, query);
		if(curPage>to.getTotalPage())
			curPage = to.getTotalPage();
//		to = dao.page(curPage);
		to = dao.searchQuery(curPage, query);
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		request.setAttribute("query", query);
		return new CommandAction(false, "./kdhjsp/listpage.jsp");
	}
	
	private int limitPage(String sCurPage) {
		int curPage = 1;
		try {
			if(sCurPage!=null) {
				Double d = Double.parseDouble(sCurPage);
				curPage = (int) Math.floor(d);
				if(curPage<0) {
					curPage = 1;
				}
			}
		} catch (NumberFormatException e) {
			curPage = 1;
		}
		return curPage;
	}
}
