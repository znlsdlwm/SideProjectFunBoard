package sdj.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdj.kr.co.command.Command;
import sdj.kr.co.domain.CommandAction;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 2. DAO 객체를 만들고 해당 메소드 호출.
		MemberDAO dao = new MemberDAO();
		boolean login = dao.login(new LoginDTO(id, pw));
				
		// 3. 데이터 바인딩(pageContext, *request, session, application)

		if(login) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("login", new LoginDTO(id,null));
			return new CommandAction(true, "l_select.sdj");

		} else {
			return new CommandAction(true, "l_loginui.sdj");

		}

	}

}