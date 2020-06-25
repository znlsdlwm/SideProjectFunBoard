package ASJ;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.asjDTO;

public class SelectByIdCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException {
		String id = request.getParameter("id");
		asjDAO dao = new asjDAO();
		asjDTO dto = dao.selectById(id);
		
		request.setAttribute("dto", dto);
		
		return new ASJCommandAction(false, "ASJ-WEB/selectByid.jsp");
		
	}

}
