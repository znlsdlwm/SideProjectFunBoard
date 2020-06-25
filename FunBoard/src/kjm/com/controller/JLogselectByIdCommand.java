package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.MemberDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;
import member.domain.MemberDTO;

public class JLogselectByIdCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		request.setAttribute("dto", dto);
		
		return new MainCommandAction(false, "JLogselectByid.jsp");	
	}
}
