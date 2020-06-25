package sdj.kr.co.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sdj.kr.co.command.Command;
import sdj.kr.co.command.DeleteCommand;
import sdj.kr.co.command.InsertCommand;
import sdj.kr.co.command.InsertUICommand;

import sdj.kr.co.command.ListPageCommand;
import sdj.kr.co.command.ReadCommand;
import sdj.kr.co.command.ReplyCommand;
import sdj.kr.co.command.ReplyUICommand;


import sdj.kr.co.command.UpdateCommand;
import sdj.kr.co.command.UpdateUICommand;
import sdj.kr.co.domain.CommandAction;

import sdj.login.LoginCommand;
import sdj.login.LoginUICommand;
import sdj.login.LogoutCommand;

import sdj.login.SDJDeleteCommand;
import sdj.login.SDJInsertCommand;
import sdj.login.SDJInsertUICommand;
import sdj.login.SDJSelectByIdCommand;
import sdj.login.SDJSelectCommand;
import sdj.login.SDJUpdateCommand;
import sdj.login.SDJUpdateUICommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.sdj")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());

		Command com = null;
		if (sp.equalsIgnoreCase("/sdj_list.sdj")) {
			/*com = new ListCommand();*/
			com = new ListPageCommand();
		} else if (sp.equalsIgnoreCase("/sdj_insertui.sdj")) {
			com = new InsertUICommand();
		} else if (sp.equalsIgnoreCase("/sdj_insert.sdj")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/sdj_read.sdj")) {
			com = new ReadCommand();
		} else if (sp.equalsIgnoreCase("/sdj_updateui.sdj")) {
			com = new UpdateUICommand();
		} else if (sp.equalsIgnoreCase("/sdj_update.sdj")) {
			com = new UpdateCommand();
		} else if (sp.equalsIgnoreCase("/sdj_delete.sdj")) {
			com = new DeleteCommand();
		} else if (sp.equalsIgnoreCase("/sdj_replyui.sdj")) {
			com = new ReplyUICommand();
		} else if (sp.equalsIgnoreCase("/sdj_reply.sdj")) {
			com = new ReplyCommand();
		} else if(sp.equalsIgnoreCase("/l_insertui.sdj")) {
			com = new SDJInsertUICommand();
		} else if(sp.equalsIgnoreCase("/l_insert.sdj")) {
			com =  new SDJInsertCommand();
		} else if(sp.equalsIgnoreCase("/l_select.sdj")) {
			com =  new SDJSelectCommand();
		} else if(sp.equalsIgnoreCase("/l_selectById.sdj")) {
			com = new SDJSelectByIdCommand();
		} else if(sp.equalsIgnoreCase("/l_updateui.sdj")) {
			com = new SDJUpdateUICommand();
		} else if(sp.equalsIgnoreCase("/l_update.sdj")) {
			com = new SDJUpdateCommand();
		} else if(sp.equalsIgnoreCase("/l_delete.sdj")) {
			com = new SDJDeleteCommand();
		} else if(sp.equalsIgnoreCase("/l_loginui.sdj")) {
			com =  new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/l_login.sdj")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/l_logout.sdj")) {
			com =  new LogoutCommand();
		} else if(sp.equalsIgnoreCase("/l_delete.sdj")) {
			com = new SDJDeleteCommand();
		} else {
			System.out.println("제공하지 않는 서비스 입니다.");
		} 
		
		if (com != null) {
			CommandAction action = null;
			try {
				action = com.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
