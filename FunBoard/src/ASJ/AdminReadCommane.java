package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.ASJadminDTO;
import ASJ.domain.AsjBoardDTO;

public class AdminReadCommane implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) {
			num = Integer.parseInt(snum);
		}
		
		asjDAO dao = new asjDAO();
		ASJadminDTO admin_dto = dao.admin_read(num);
		request.setAttribute("admin_dto", admin_dto);
		
		return new ASJCommandAction(false, "ASJ-WEB/adminread.jsp");
	}

}
