package com.microsoft.kdh.board.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.kdh.command.Command;
import com.microsoft.kdh.command.CommandAction;
import com.microsoft.kdh.dao.BoardDAO;

public class DeleteBoardCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String sNum = request.getParameter("num");
		int num = -1;
		if(sNum!=null) {
			num = Integer.parseInt(sNum);
		}
		dao.delete(num);
		return new CommandAction(true, "listboard.kdh");
	}

}
