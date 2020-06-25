package sdj.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.command.Command;
import sdj.kr.co.domain.CommandAction;

public class SDJSelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득 및 가공
		
		// 2. DAO 객체 생성 및 해당 메서드 호출
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		// 3. 데이터 바인딩(pageContext, request, session, application)
		request.setAttribute("list", list);
		
		// 4. 포워딩
		return new CommandAction(false, "l_select.jsp");
	}

}
