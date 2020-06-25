package sdj.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.command.Command;
import sdj.kr.co.domain.CommandAction;

public class SDJSelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectById(id);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "l_selectById.jsp");
		

	}

}
