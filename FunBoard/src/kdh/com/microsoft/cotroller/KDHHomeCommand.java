package kdh.com.microsoft.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdh.com.microsoft.command.Command;
import kdh.com.microsoft.command.CommandAction;

public class KDHHomeCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new CommandAction(false, "./kdh_JSP/kdhhome.jsp");
	}

}
