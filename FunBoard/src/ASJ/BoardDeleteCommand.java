package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;

public class BoardDeleteCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num  = -1;
		if (sNum != null) {
			num = Integer.parseInt(sNum);
		}
		asjDAO dao = new asjDAO();
		dao.boarddelete(num);
		
		return new ASJCommandAction(true, "list.asj");
	}

}
