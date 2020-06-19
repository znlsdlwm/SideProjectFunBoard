package com.microsoft.kdh.board.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.EventTotal;
import com.microsoft.kdh.dao.BoardEventDAO;
import com.microsoft.kdh.dao.MemberDAO;
import com.microsoft.kdh.domain.BoardEventDTO;

/**
 * Servlet implementation class BoardEventListen
 */
@WebServlet("/BoardEventListen")
public class BoardEventListen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEventListen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String m_id = request.getParameter("login");
		String num_ = request.getParameter("num");
		int b_num = -1;
		if(num_!=null) {
			b_num = Integer.parseInt(num_);
		}
		BoardEventDAO dao = new BoardEventDAO();
		BoardEventDTO dto = new BoardEventDTO(type, b_num, m_id);
		if(dao.alreadyEvent(dto)) {
			response.getWriter().print(-1);
		} else {
			dao.eventListener(dto);
			Integer result = dao.getTotal(b_num, type);
			response.getWriter().print(result);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
