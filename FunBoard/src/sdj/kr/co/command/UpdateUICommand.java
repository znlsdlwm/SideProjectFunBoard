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

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String sNum = request.getParameter("num");
//		int num = -1;
//		if(sNum != null) {
//			num = Integer.parseInt(sNum);
//		}
//		
//		
//		BoardDAO dao = new BoardDAO();
//		BoardDTO dto = dao.updateUI(num);
//		
//		request.setAttribute("dto", dto);
		HttpSession session = request.getSession(false);
		if(session!=null) {
			LoginDTO login = (LoginDTO) session.getAttribute("login");
			
			
			if(login != null) {
				String id= request.getParameter("writer");
				
				
				if(login.getId().equals(id)) {
					
					String writer = request.getParameter("writer");
					String sNum=request.getParameter("num");
					int num = -1;
					if(sNum != null) {
						num = Integer.parseInt(sNum);
					}				
					BoardDAO dao = new BoardDAO();
					BoardDTO dto = dao.updateUI(num, writer);
					request.setAttribute("dto", dto);
					
					
					return new CommandAction(false,"sdj_update.jsp");
				} else {
					return new CommandAction(true,"sdj_list.sdj");
				}
			}
		} 
		return new CommandAction(true,"sdj_list.sdj");
	}

}
