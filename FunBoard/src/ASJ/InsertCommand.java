package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.asjDTO;

public class InsertCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = -1;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		asjDAO dao = new asjDAO();
		 dao.insert(new asjDTO(id, name, age, pw));
		
		
		return new ASJCommandAction(false, "/ASJ-WEB/mainASJ.jsp");
	}

}
