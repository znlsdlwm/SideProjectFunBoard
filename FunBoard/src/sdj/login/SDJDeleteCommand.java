package sdj.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdj.kr.co.command.Command;
import sdj.kr.co.domain.CommandAction;

public class SDJDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if(login != null) {
				String id= request.getParameter("id");
				
				if(login.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					
					session.invalidate();
					
					
					return new CommandAction(true,"l_select.sdj");
				} else {
					return new CommandAction(true,"l_login.sdj");
				}
			}
		} 
	
		return new CommandAction(true, "l_loginui.sdj");
	}
}
