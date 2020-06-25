package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.AsjBoardDTO;
import ASJ.domain.asjDTO;

public class BoardInsertCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		asjDAO dao  = new asjDAO();
		asjDTO dto = new asjDTO();
		dao.boardinsert(new AsjBoardDTO(-1, writer, title, content,null, 0, 0, 0, 0));
		
		
			return new ASJCommandAction(false,"list.asj");
		
		
	}

}
