package sdj.kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;
import sdj.kr.co.domain.PageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String scurPage = request.getParameter("curPage");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		BoardDAO dao = new BoardDAO();
		
		int curPage = 1;
		if (scurPage != null) {
			curPage = Integer.parseInt(scurPage);
		}
		PageTO to = null;
		if(keyWord==null) {
			keyWord = "";
		}
		if(keyField==null) {
			keyField= "title";
			to = dao.searchList(curPage, keyField, keyWord);
		} else if (keyField!=null){
			to = dao.searchList(curPage, keyField, keyWord);
		}
		
		request.setAttribute("list", to.getList());
		request.setAttribute("to", to);
		
		return new CommandAction(false, "sdj_list.jsp");
		
		
		
	}

}
