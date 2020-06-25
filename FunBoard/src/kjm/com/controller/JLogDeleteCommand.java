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

public class JLogDeleteCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			if (login != null) {
				String id = request.getParameter("id");
				
				if (login.getId().equals(id)) {
					MemberDAO dao = new MemberDAO();
					dao.delete(new MemberDTO(id, null, 0, null));

					session.invalidate();

					return new MainCommandAction(true, "kjmlist.kjm");

				} else {
					return new MainCommandAction(true, "kjmlist.kjm");
				}
			}
		}
		return null;
	}

}
