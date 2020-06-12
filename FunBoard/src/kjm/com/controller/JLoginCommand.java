package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kjm.com.dao.MemberDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import member.domain.MemberDTO;

public class JLoginCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		boolean login = dao.login(new MemberDTO(id, null, 0, pw));
		
		if(login) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(3600);
			session.setAttribute("login", new MemberDTO(id, null, 0, pw));
			return new MainCommandAction(true, "kjmlist.kjm");
	
		}else {
			return new MainCommandAction(true, "kjmlist.kjm");
		}
	}
}
