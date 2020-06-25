package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.domain.ASJCommandAction;

public class ReplyUiCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println(num);
		return new ASJCommandAction(false, "ASJ-WEB/boardreply.jsp?num="+num);
	}

}
