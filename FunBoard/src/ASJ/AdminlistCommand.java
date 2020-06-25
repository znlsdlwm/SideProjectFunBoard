package ASJ;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.ASJadminDTO;
import ASJ.domain.AdminDTO;

public class AdminlistCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		asjDAO dao = new asjDAO();
		List<ASJadminDTO> admin_list = dao.adminlist();
		request.setAttribute("admin_list", admin_list);
		return new ASJCommandAction(false, "ASJ-WEB/adminlist.jsp");
	}

}
