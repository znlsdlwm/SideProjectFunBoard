package com.microsoft.kdh.comment.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.dao.CommentDAO;
import com.microsoft.kdh.dao.MemberDAO;

/**
 * Servlet implementation class CommentPasswordChecker
 */
@WebServlet("/commentpasswordcheck.kdh")
public class CommentPasswordChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentPasswordChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String c_num = request.getParameter("c_num");
		CommentDAO dao = new CommentDAO();
		boolean passwordCheck = dao.passwordCheck(c_num, password);
		if (passwordCheck) {
			response.getWriter().print("삭제 성공");
			request.setAttribute("c_num", c_num);
			request.getRequestDispatcher("deletecommentboardcommand.kdh").forward(request, response);;
		} else {
			response.getWriter().print("삭제 실패");
		}
	
	}

}
