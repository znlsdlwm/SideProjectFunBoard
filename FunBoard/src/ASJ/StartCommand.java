package ASJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.command.ASJCommand;
import ASJ.domain.ASJCommandAction;

public class StartCommand implements ASJCommand {

	@Override
	public ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		return new ASJCommandAction(false, "ASJ-WEB/StartASJ.jsp");
	}

}
