package com.microsoft.kdh.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.PageTO;

public class ListBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCurPage = request.getParameter("curPage");
		String query = request.getParameter("query");
		String option = request.getParameter("option");
		BoardDAO dao = new BoardDAO();
		
		if(query==null) {
			query="";
		}
		int curPage = limitPage(sCurPage);
		
		PageTO to = dao.searchTitle(curPage, query);
		
		if(option!=null && option.equals("2")) {
			to = dao.searchWriter(curPage, query);
		}
		
		if(to.getCurPage()>to.getTotalPage()) {
			to.setCurPage(to.getTotalPage());
		}
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		request.setAttribute("query", query);
		return new CommandAction(false, "./kdhjsp/listboard.jsp");
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
