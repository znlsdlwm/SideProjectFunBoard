package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.MemberDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import member.domain.MemberDTO;

public class JLogInsertCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sage = request.getParameter("age");
		String pw = request.getParameter("pw");
		int age=0;
		if(sage != null) {
			age = Integer.parseInt(sage);	
		}
		
		MemberDAO dao = new MemberDAO();
		dao.insert(new MemberDTO(id, name, age, pw));
		return new MainCommandAction(true, "kjmlist.kjm");
	}
}
