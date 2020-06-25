package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kjm.com.dao.JBoardDAO;
import kjm.com.dao.MemberDAO;
import kjm.com.dto.JBoardDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import member.domain.MemberDTO;


public class DeleteCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			MemberDTO login = (MemberDTO) session.getAttribute("login");
			System.out.println(login);
			if (login != null) {
				String id = request.getParameter("writer");
				System.out.println(id);
				if (login.getId().equals(id)) {
					System.out.println("넘어옴?");
					String  writer = request.getParameter("writer");
					System.out.println(writer);
					String snum = request.getParameter("num");
					System.out.println(snum);
					int num = -1;
						if(snum != null) {
							num = Integer.parseInt(snum);
						}
					JBoardDAO dao = new JBoardDAO();
					dao.delete(new JBoardDTO(num, writer, null, null, null, 0, 0, 0, 0));
		
		
					return new MainCommandAction(true, "kjmlist.kjm");
				} else {
					return new MainCommandAction(true, "kjmlist.kjm");
				}
			}
		}
		return new MainCommandAction(true, "kjmlist.kjm");
	}

}