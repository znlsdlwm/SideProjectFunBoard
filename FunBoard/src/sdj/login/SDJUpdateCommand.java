package sdj.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdj.kr.co.command.Command;
import sdj.kr.co.domain.CommandAction;

public class SDJUpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name= request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if(sAge != null) {
			age =Integer.parseInt(sAge);
		}
		String pw = request.getParameter("pw");
		
		new MemberDAO().update(new MemberDTO(id, name, age, pw));
		return new CommandAction(true, "l_selectById.sdj?id="+id);
	}

}
