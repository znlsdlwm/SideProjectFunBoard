package ASJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.ASJadminDTO;


public class AdminInsertCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		asjDAO dao  = new asjDAO();
		
		dao.admininsert(new ASJadminDTO(-1, writer, title, content, null, 0, 0, 0, 0));
		return new ASJCommandAction(false, "adminlist.asj");
		
	}

}
