package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.JBoardDAO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class DeleteCommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) {
			num = Integer.parseInt(snum);
		}
		JBoardDAO dao = new JBoardDAO();
		dao.delete(num);
		
		return new MainCommandAction(true, "kjmlist.kjm");
	}

}