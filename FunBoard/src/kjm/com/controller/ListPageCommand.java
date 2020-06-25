package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.JBoardDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class ListPageCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String scurPage = request.getParameter("curPage");
		int curPage=1;
		if(scurPage!=null) curPage = Integer.parseInt(scurPage);
	
		JBoardDAO dao = new JBoardDAO();
		PageTO to = dao.page(curPage);
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList());
		
		return new MainCommandAction(false, "kjmlist.jsp");
	}

}
