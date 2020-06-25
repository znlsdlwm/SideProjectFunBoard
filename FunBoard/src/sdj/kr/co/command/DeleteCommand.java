package sdj.kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sdj.kr.co.dao.BoardDAO;
import sdj.kr.co.domain.BoardDTO;
import sdj.kr.co.domain.CommandAction;
import sdj.login.LoginDTO;
import sdj.login.MemberDAO;


public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			if(login != null) {
				
//				String id= request.getParameter("id");
				String id= request.getParameter("writer");
				
				if(login.getId().equals(id)) {
					
					String writer = request.getParameter("writer");
					
					String sNum=request.getParameter("num");
					int num = -1;
					if(sNum != null) {
						num = Integer.parseInt(sNum);
					}				
					BoardDAO dao = new BoardDAO();
					dao.delete(new BoardDTO(num, writer, null, null, null, 0, 0, 0, 0));

					
					
					return new CommandAction(true,"sdj_list.sdj");
				} else {
					return new CommandAction(true,"l_login.sdj");
				}
			}
		} 
		
		
		return new CommandAction(true, "sdj_list.sdj");
	}

}
