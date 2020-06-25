package ASJ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.domain.ASJCommandAction;

/**
 * Servlet implementation class ASJFrontControl
 */
@WebServlet("*.asj")
public class ASJFrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ASJFrontControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("type/html;charset = utf-8");
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		ASJCommand com = null;
		if(sp.equalsIgnoreCase("/main.asj")) {
			com = new MainHomeCommand();
		}else if(sp.equalsIgnoreCase("/home.asj")) {
			com = new StartCommand();
		}else if(sp.equalsIgnoreCase("/insertui.asj")) {
			com = new InsertUiCommand();
		}else if(sp.equalsIgnoreCase("/insert.asj")) {
			com = new InsertCommand();
		}else if(sp.equalsIgnoreCase("/loginui.asj")) {
			com = new LoginUiCommand();
		}else if(sp.equalsIgnoreCase("/login.asj")) {
			com = new LoginCommand();
		}else if(sp.equalsIgnoreCase("/logout.asj")) {
			com = new LogoutCommand();
		}else if(sp.equalsIgnoreCase("/selectbyId.asj")) {
			com = new SelectByIdCommand();
		}else if(sp.equalsIgnoreCase("/info.asj")) {
			com = new InfoCommand();
		}else if(sp.equalsIgnoreCase("/update.asj")) {
			com = new UpdateCommand();
		}else if(sp.equalsIgnoreCase("/updateui.asj")) {
			com = new UpdateUiCommand();
		}else if(sp.equalsIgnoreCase("/delete.asj")) {
			com = new DeleteCommand();
		}else if(sp.equalsIgnoreCase("/list.asj")) {
			com = new ASJlistPageCommand();
		}else if(sp.equalsIgnoreCase("/boardinsertui.asj")) {
			com = new BoardInsertUiCommand();
		}else if(sp.equalsIgnoreCase("/boardinsert.asj")) {
			com = new BoardInsertCommand();
		}else if(sp.equalsIgnoreCase("/boardread.asj")) {
			com = new BoardReadCommand();
		}else if(sp.equalsIgnoreCase("/boardupdateui.asj")) {
			com = new BoardUpdateUiCommand();
		}else if(sp.equalsIgnoreCase("/boardupdate.asj")) {
			com = new BoardUpdateCommand();
		}else if(sp.equalsIgnoreCase("/boarddelete.asj")) {
			com = new BoardDeleteCommand();
		}else if(sp.equalsIgnoreCase("/boardreplyui.asj")) {
			com = new ReplyUiCommand();
		}else if(sp.equalsIgnoreCase("/boardreply.asj")) {
			com = new ReplyCommand();
		}else if(sp.equalsIgnoreCase("/adminlist.asj")) {
			com = new AdminlistCommand();
		}else if(sp.equalsIgnoreCase("/admininsert.asj")) {
			com = new AdminInsertCommand();
		}else if(sp.equalsIgnoreCase("/admininsertui.asj")) {
			com = new AdminInsertuiCommand();
		}else if(sp.equalsIgnoreCase("/adminloginui.asj")) {
			com = new AdminloginuiCommand();
		}else if(sp.equalsIgnoreCase("/adminlogin.asj")) {
			com = new AdminloginCommand();
		}else if(sp.equalsIgnoreCase("/adminlogout.asj")) {
			com = new AdminlogoutCommand();
		}else if(sp.equalsIgnoreCase("/adminread.asj")) {
			com = new AdminReadCommane();
		}else if(sp.equalsIgnoreCase("/filelist.asj")) {
			com = new FileListCommand();
		}

			
		
		if (com != null) {
			ASJCommandAction action = com.execute(request, response);
			if (action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere())
				.forward(request, response);
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
