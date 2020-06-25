package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.AsjBoardDTO;


public class BoardReadCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) {
			num = Integer.parseInt(snum);
		}
		
		asjDAO dao = new asjDAO();
		AsjBoardDTO dto = dao.read(num);
		request.setAttribute("dto", dto);
		
		return new ASJCommandAction(false, "ASJ-WEB/boardread.jsp");
	}

}
