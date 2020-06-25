package sdj.kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		System.out.println(list);
		
		return new CommandAction(false, "sdj_list.jsp");
	}

}
