package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.JBoardDAO;
import kjm.com.dto.JBoardDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class insertCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		JBoardDAO dao = new JBoardDAO();
		dao.insert(new JBoardDTO(0, writer, title, content, null, 0, 0, 0, 0));
		return new MainCommandAction(true, "kjmlist.kjm");
	}

}
