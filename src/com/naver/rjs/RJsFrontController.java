 package com.naver.rjs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.rjs.board.RjsDeleteCommand;
import com.naver.rjs.board.RjsInsertCommand1;
import com.naver.rjs.board.RjsInsertUICommand1;
import com.naver.rjs.board.RjsListPageCommand;
import com.naver.rjs.board.RjsMainCommand;
import com.naver.rjs.board.RjsReadCommand;
import com.naver.rjs.board.RjsReplyCommand;
import com.naver.rjs.board.RjsReplyUICommand;
import com.naver.rjs.board.RjsUpdateCommand;
import com.naver.rjs.board.RjsUpdateUICommand;
import com.naver.rjs.login.RjsInsertCommand;
import com.naver.rjs.login.RjsInsertUICommand;
import com.naver.rjs.login.RjsListCommand;
import com.naver.rjs.login.RjsLoginCommand;
import com.naver.rjs.login.RjsLoginUICommand;
import com.naver.rjs.login.RjsLogoutCommand;
import com.naver.rjs.login.RjsMemberShipSelectByIdCommand;
import com.naver.rjs.login.RjsMemberShipSelectCommand;
import com.naver.rjs.login.RjsMemberShipUpdateCommand;
import com.naver.rjs.login.RjsMemberShipUpdateUICommand;
import com.naver.rjs.login.RjsMembershipCommand;
import com.naver.rjs.login.RjsMembershipUICommand;


/**
 * Servlet implementation class MainFrontController
 */
@WebServlet("*.rjs")
public class RJsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RJsFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		RJSCommand com = null;
		if(sp.equalsIgnoreCase("/main.rjs")) {
			com = new RjsMainCommand();
		}else if (sp.equalsIgnoreCase("/loginui.rjs")) {	
			com = new RjsLoginUICommand();
		}else if (sp.equalsIgnoreCase("/login.rjs")) {
			com = new RjsLoginCommand();
		}else if (sp.equalsIgnoreCase("/membershipui.rjs")) {
			com = new RjsMembershipUICommand();
		}else if (sp.equalsIgnoreCase("/membership.rjs")) {
			com = new RjsMembershipCommand();
		}else if (sp.equalsIgnoreCase("/insertui.rjs")) {
			com = new RjsInsertUICommand();
		}else if (sp.equalsIgnoreCase("/insert.rjs")) {
			com = new RjsInsertCommand();
		}else if (sp.equalsIgnoreCase("/list.rjs")) {
			com = new RjsListCommand();
		}else if (sp.equalsIgnoreCase("/list1.rjs")) {
//			com = new RjsListCommand1();
			com = new RjsListPageCommand();
		}else if (sp.equalsIgnoreCase("/read.rjs")) {
			com = new RjsReadCommand();
		}else if (sp.equalsIgnoreCase("/replyui.rjs")) {
			com = new RjsReplyUICommand();
		}else if (sp.equalsIgnoreCase("/reply.rjs")) {
			com = new RjsReplyCommand();
		}else if (sp.equalsIgnoreCase("/updateui.rjs")) {
			com = new RjsUpdateUICommand();
		}else if (sp.equalsIgnoreCase("/update.rjs")) {
			com = new RjsUpdateCommand();
		}else if (sp.equalsIgnoreCase("/insertui1.rjs")) {
			com = new RjsInsertUICommand1();
		}else if (sp.equalsIgnoreCase("/insert1.rjs")) {
			com = new RjsInsertCommand1();
		}else if (sp.equalsIgnoreCase("/logout.rjs")) {
			com = new RjsLogoutCommand();
		}else if (sp.equalsIgnoreCase("/select.rjs")) {
			com = new RjsMemberShipSelectCommand();
		}else if (sp.equalsIgnoreCase("/delete.rjs")) {
			com = new RjsDeleteCommand();
		}else if (sp.equalsIgnoreCase("/membershipupdate.rjs")) {
			com = new RjsMemberShipUpdateCommand();
		}else if (sp.equalsIgnoreCase("/membershipupdateui.rjs")) {
			com = new RjsMemberShipUpdateUICommand();
		}else if (sp.equalsIgnoreCase("/selectByid.rjs")) {
			com = new RjsMemberShipSelectByIdCommand();
		}
		else {
			System.out.println("제공하지 않는 서비스 입니다.");
		}
		if (com!=null) {
			RJSCommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			} 
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
