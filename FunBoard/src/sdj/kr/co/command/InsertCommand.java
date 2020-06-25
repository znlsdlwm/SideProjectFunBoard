package sdj.kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		
		
		return new CommandAction(true, "sdj_list.sdj");
	}

}
