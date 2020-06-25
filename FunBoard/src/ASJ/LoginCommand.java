package ASJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.asjDTO;
import javafx.scene.control.Alert;

public class LoginCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		asjDAO dao = new asjDAO();
		asjDTO dto = new asjDTO(id, null, 0, pw);
		boolean login = dao.login(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if (login) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("login", new asjDTO(id, null, 0, null));
			return new ASJCommandAction(false, "main.asj");
			
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('아이디 또는 비밀번호가 잘못되었습니다');");
			out.println("document.location.href='loginui.asj';");
			out.println("</script>");
			out.flush();
			out.close();
			return null;
		}
		
		
		
	}


}
