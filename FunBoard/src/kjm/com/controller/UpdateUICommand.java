package kjm.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjm.com.dao.JBoardDAO;
import kjm.com.dto.JBoardDTO;
import kr.co.util.main.MainCommand;
import kr.co.util.main.MainCommandAction;

public class UpdateUICommand implements MainCommand {

	@Override
	public MainCommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("num");
		int num = -1;
		if(snum != null) {
			num = Integer.parseInt(snum);
		}
		JBoardDAO dao = new JBoardDAO();
		JBoardDTO dto = dao.updateUI(num);
		request.setAttribute("dto", dto);
		return new MainCommandAction(false, "kjmupdate.jsp");

	}

}
