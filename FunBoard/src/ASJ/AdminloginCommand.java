package ASJ;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ASJ.command.ASJCommand;
import ASJ.dao.asjDAO;
import ASJ.domain.ASJCommandAction;
import ASJ.domain.AdminDTO;
import ASJ.domain.asjDTO;

public class AdminloginCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String sPw = request.getParameter("pw");
		int pw = -1;
		if (sPw != null) {
			pw = Integer.parseInt(sPw);
		}
		asjDAO dao = new asjDAO();
		AdminDTO dto = new AdminDTO(id, pw);
		boolean admin_login = dao.Admin_login(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if (admin_login) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60);
			session.setAttribute("admin_login", new AdminDTO(id, pw));
			return new ASJCommandAction(false, "adminlist.asj");
			
		}else {
			out.println("<script language='javascript'>");
			out.println("alert('아이디 또는 비밀번호가 잘못되었습니다');");
			out.println("document.location.href='adminloginui.asj';");
			out.println("</script>");
			out.flush();
			out.close();
			return null;
		}
		
		
		
	}
	}

