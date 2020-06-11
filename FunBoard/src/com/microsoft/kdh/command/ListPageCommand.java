package com.microsoft.kdh.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCurPage = request.getParameter("curPage");
		int curPage = 1;
		if(sCurPage!=null)
			curPage = Integer.parseInt(sCurPage);
		
		BoardDAO dao = new BoardDAO();
		PageTO to = dao.page(curPage);
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		return new CommandAction(false, "./kdhjsp/listpage.jsp");
	}

}
