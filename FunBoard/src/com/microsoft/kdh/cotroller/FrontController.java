package com.microsoft.kdh.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.board.command.DeleteBoardCommand;
import com.microsoft.kdh.board.command.DeleteBoardUICommand;
import com.microsoft.kdh.board.command.InsertBoardCommand;
import com.microsoft.kdh.board.command.InsertBoardUICommand;
import com.microsoft.kdh.board.command.ListBoardCommand;
import com.microsoft.kdh.board.command.ReadBoardCommand;
import com.microsoft.kdh.board.command.ReplyeBoardCommand;
import com.microsoft.kdh.board.command.ReplyeBoardUICommand;
import com.microsoft.kdh.board.command.UpdateBoardCommand;
import com.microsoft.kdh.board.command.UpdateBoardUICommand;
import com.microsoft.kdh.calculator.command.CalculatorCommand;
import com.microsoft.kdh.calculator.command.CalculatorUICommand;
import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.command.InsertCommand;
import com.microsoft.kdh.command.InsertUICommand;
import com.microsoft.kdh.command.KDHHomeCommand;
import com.microsoft.kdh.command.ListCommand;
import com.microsoft.kdh.comment.command.DeleteCommentBoardCommand;
import com.microsoft.kdh.comment.command.DeleteUICommentBoardCommand;
import com.microsoft.kdh.comment.command.InsertCommentBoardCommand;
import com.microsoft.kdh.log.command.LoginCommand;
import com.microsoft.kdh.log.command.LoginUICommand;
import com.microsoft.kdh.log.command.LogoutCommand;

/**
 * Servlet implementation class KDHFrontController
 */
@WebServlet("*.kdh")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());

		Command com = null;

		if (sp.equalsIgnoreCase("/home.kdh")) {
			com = new KDHHomeCommand();
		} else if (sp.equalsIgnoreCase("/calculatorui.kdh")) {
			com = new CalculatorUICommand();
		} else if (sp.equalsIgnoreCase("/calculator.kdh")) {
			com = new CalculatorCommand();
		} else if (sp.equalsIgnoreCase("/loginui.kdh")) {
			com = new LoginUICommand();
		} else if (sp.equalsIgnoreCase("/insertui.kdh")) {
			com = new InsertUICommand();
		} else if (sp.equalsIgnoreCase("/insert.kdh")) {
			com = new InsertCommand();
		} else if (sp.equalsIgnoreCase("/list.kdh")) {
			com = new ListCommand();
		} else if (sp.equalsIgnoreCase("/loginui.kdh")) {
			com = new LoginUICommand();
		} else if (sp.equalsIgnoreCase("/login.kdh")) {
			com = new LoginCommand();
		} else if (sp.equalsIgnoreCase("/logout.kdh")) {
			com = new LogoutCommand();
		} else if (sp.equalsIgnoreCase("/listboard.kdh")) {
			com = new ListBoardCommand();
		} else if (sp.equalsIgnoreCase("/insertboardui.kdh")) {
			com = new InsertBoardUICommand();
		} else if (sp.equalsIgnoreCase("/insertboard.kdh")) {
			com = new InsertBoardCommand();
		} else if (sp.equalsIgnoreCase("/readboard.kdh")) {
			com = new ReadBoardCommand();
		} else if (sp.equalsIgnoreCase("/updateboardui.kdh")) {
			com = new UpdateBoardUICommand();
		} else if (sp.equalsIgnoreCase("/updateboard.kdh")) {
			com = new UpdateBoardCommand();
		} else if (sp.equalsIgnoreCase("/deleteboardui.kdh")) {
			com = new DeleteBoardUICommand();
		} else if (sp.equalsIgnoreCase("/deleteboard.kdh")) {
			com = new DeleteBoardCommand();
		} else if (sp.equalsIgnoreCase("/replyboardui.kdh")) {
			com = new ReplyeBoardUICommand();
		} else if (sp.equalsIgnoreCase("/replyboard.kdh")) {
			com = new ReplyeBoardCommand();
		} else if (sp.equalsIgnoreCase("/insertcommentboard.kdh")) {
			com = new InsertCommentBoardCommand();
		} else if (sp.equalsIgnoreCase("/deleteuicommentboard.kdh")) {
			com = new DeleteUICommentBoardCommand();
		} else if (sp.equalsIgnoreCase("/deletecommentboardcommand.kdh")) {
			com = new DeleteCommentBoardCommand();
		} else {
			System.out.println("제공하지 않는 서비스 입니다.");
		}

		if (com != null) {
			CommandAction action = com.execute(request, response);
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
		doGet(request, response);
	}

}
