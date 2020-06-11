package com.microsoft.kdh.command;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");

		String result = "0";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("result")) {
					result = c.getValue();
					break;
				}
			}
		} 
		String resultAll = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("resultAll")) {
					resultAll = c.getValue();
					break;
				}
			}
		}
		
		// 계산
		result = calValue(value, result);
		result = calDot(dot, result);
		if (operator != null) {
			if(operator.equals("+/-")) {
				BigDecimal input = new BigDecimal(result);
				result = input.multiply(new BigDecimal("-1")).toString();
			} else if(operator.equals("BS")&& result.length()>0) {
				result = result.substring(0, result.length()-1);
				if(result.length()==0) result = "0";
			} else if(operator.equals("*")) {
				resultAll += result+"*";
				result = "0";
			} else if(operator.equals("%")) {
				resultAll += result+"%";
				result = "0";
			} else if(operator.equals("/")) {
				resultAll += result+"/";
				result = "0";
			} else if(operator.equals("+")) {
				resultAll += result+"+";
				result = "0";
			} else if(operator.equals("-")) {
				resultAll += result+"-";
				result = "0";
			} else if(operator!=null && operator.equals("CE")) {
				result = "0";
				resultAll = "";
			} else if(operator.equals("=")) {
				// GraalVM 으로 추후 대체가능
				ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
				try {
					result = String.valueOf(engine.eval(resultAll+result));
					resultAll = "";
				} catch (ScriptException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		// 쿠키 설정
		Cookie resultCookie = new Cookie("result", result);
		Cookie resultAllCookie = new Cookie("resultAll", resultAll);
		
		resultCookie.setMaxAge(60*60);
		resultAllCookie.setMaxAge(60*60);
		
		response.addCookie(resultCookie);
		response.addCookie(resultAllCookie);
		return new CommandAction(true, "calculatorui.kdh");
	}
	private String calValue(String value, String result) {
		String rs = result;
		if (value != null) {
			if(rs.length()==1&&rs.equals("0")) {
					return rs = value;
			}
			return rs += value;
		}
		return rs;
	}

	private String calDot(String dot, String result) {
		String rs = result;
		if (dot != null) {
			if(rs.length()==0)
				return rs+="0.";
			if(rs.length()>0 && !rs.contains("."))
				return rs+=".";
		}
		return rs;
	}
}
