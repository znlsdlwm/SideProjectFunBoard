package ASJ;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.AsjBoardDTO;

public class ListCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		asjDAO dao = new asjDAO();
		List<AsjBoardDTO> list = dao.list();
		
		request.setAttribute("list", list);
		return new ASJCommandAction(false, "ASJ-WEB/list.jsp");
	}

}
