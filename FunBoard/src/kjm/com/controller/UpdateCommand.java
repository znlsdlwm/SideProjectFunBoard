package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.JBoardDAO;
import kjm.com.dto.JBoardDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class UpdateCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) num = Integer.parseInt(snum);
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		JBoardDAO dao = new JBoardDAO();
		dao.update(new JBoardDTO(num, writer, title, content, null, -1, -1, -1, -1));
		
		return new MainCommandAction(true, "kjmlist.kjm");
	}

}
