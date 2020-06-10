package kjm.com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.kjm")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		MainCommand com = null;
		
		if(sp.equalsIgnoreCase("/kjmlist.kjm")) {
			com= new ListPageCommand();
		}else if(sp.equalsIgnoreCase("/kjmInsertui.kjm")) {
		com= new insertUICommand();
		}else if(sp.equalsIgnoreCase("/kjminsert.kjm")) {
			com= new insertCommand();
		}else if(sp.equalsIgnoreCase("/kjmread.kjm")) {
			com= new readCommand();
		}else if(sp.equalsIgnoreCase("/kjmupdateui.kjm")) {
			com= new UpdateUICommand();		
		}else if(sp.equalsIgnoreCase("/kjmupdate.kjm")) {
			com= new UpdateCommand();
		}else if(sp.equalsIgnoreCase("/kjmdelete.kjm")) {
			com= new DeleteCommand();
//		}else if(sp.equalsIgnoreCase("/replyui.do")) {
//			com= new ReplyUICommand();
//		}else if(sp.equalsIgnoreCase("/reply.do")) {
//			com= new ReplyCommand();
//		}
//		
		
		
		}else {
			System.out.println("제공하지 않는 서비스입니다.");
		}
		
		if(com!=null) {
			MainCommandAction action = com.execute(request, response);
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
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
