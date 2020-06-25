package ASJ.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ASJ.domain.ASJCommandAction;

public interface ASJCommand {
	ASJCommandAction execute(HttpServletRequest request, HttpServletResponse response)
														throws ServletException,IOException;

}
