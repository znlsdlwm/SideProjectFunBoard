package sdj.kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;

public class ReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sNum = request.getParameter("num");
		int orgnum = -1;
		if(sNum!=null) {
			orgnum = Integer.parseInt(sNum);
		}
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(-1, writer, title, content, null, 0, -1, -1, -1);

		dao.reply(orgnum,dto);
		
		
		return new CommandAction(true,"sdj_list.sdj");
	}

}
