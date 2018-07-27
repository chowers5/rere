package com.fishing.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fishing.controller.action.Action;
import com.fishing.dao.MemberDao;
import com.fishing.dto.MemberVO;

public class MemberLoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   request.setCharacterEncoding("UTF-8");
		   
		   String command = request.getParameter("command");
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      MemberVO mvo = new MemberVO();
	      HttpSession session = request.getSession();
	      MemberDao mdao = MemberDao.getInstance();
	      mvo.setId(id);
	      mvo.setPw(pw);
	      PrintWriter w = response.getWriter();
	    
	      if(mdao.login(mvo)){
	         session.setAttribute("login",mvo);
	            w.print("<script>");
	            w.print("alert('loginSuccess!!');");
	            w.print("location.href='index.jsp';");
	            w.print("</script>");
	         
	      }else{
	         System.out.println("로그인실패");
	         w.print("<script>");
	            w.print("alert('Login Fail!');");
	            w.print("location.href='member/loginForm.jsp';");
	            w.print("</script>");
	      }
	}

}
