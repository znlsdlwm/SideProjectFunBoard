package com.microsoft.kdh.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;
import com.microsoft.kdh.domain.LookUpBoardDTO;

public class KDHHomeCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<LookUpBoardDTO> readcnt = dao.getMaxReadcnt();
		List<LookUpBoardDTO> best = dao.getBest();
		request.setAttribute("readcnt", readcnt);
		request.setAttribute("best", best);
		return new CommandAction(false, "./kdhjsp/kdhhome.jsp");
	}

}
