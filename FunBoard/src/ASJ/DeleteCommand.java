package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.asjDTO;

public class DeleteCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			asjDTO dto = (asjDTO) session.getAttribute("login");
			if (dto != null) {
				String id = request.getParameter("id");
				if (dto.getId().equals(id)) {
					asjDAO dao = new asjDAO();
					dao.delete(id);
					session.invalidate();
					return new ASJCommandAction(true,"info.asj");
				}else {
					return new ASJCommandAction(true, "info.asj");
				}
			}else {
				return new ASJCommandAction(true,"loginui.asj");
			}
		}else {
			return new ASJCommandAction(true,"loginui.asj");
		}
		
	}

}
