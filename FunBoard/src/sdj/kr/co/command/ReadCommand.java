package sdj.kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 클라이언트가 보내준 데이터 획득 및 가공
		
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) {
			num=Integer.parseInt(snum);
		}
		
		
		
		// 2. DAO 객체 생성 및 해당 메서드 호출
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.read(num);
		
		// 3. 데이터 바인딩(pageContext, request, session, application)
		request.setAttribute("dto", dto);
		
		// 4. 포워딩
		return new CommandAction(false, "sdj_read.jsp");
	}

}
