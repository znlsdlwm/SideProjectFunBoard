package kdh.com.microsoft.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdh.com.microsoft.command.Command;
import kdh.com.microsoft.command.CommandAction;
import kdh.com.microsoft.dao.MemberDAO;
import member.domain.MemberDTO;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		request.setAttribute("list", list);
		return new CommandAction(false, "./kdhjsp/list.jsp");
	}

}
