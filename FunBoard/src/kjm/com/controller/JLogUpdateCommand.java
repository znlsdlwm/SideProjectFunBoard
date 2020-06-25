package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.MemberDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import member.domain.MemberDTO;

public class JLogUpdateCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		String pw = request.getParameter("pw");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}

		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, age, pw));
		
		return new MainCommandAction(true, "LogSelectById.kjm?id="+id);
	}

}
