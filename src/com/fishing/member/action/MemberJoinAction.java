package com.fishing.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fishing.controller.action.Action;
import com.fishing.dao.MemberDao;
import com.fishing.dto.MemberVO;

public class MemberJoinAction implements Action {
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
		
		String url ="index.jsp";
		MemberVO mvo = new MemberVO();
		
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickName");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");

		
		System.out.println(id);
		
		mvo.setId(id);
		mvo.setName(name);
		mvo.setNickName(nickName);
		mvo.setPw(pw);
		mvo.setEmail(email);
		mvo.setBirthday(birthday);
		mvo.setPhone(phone);
		mvo.setAddr(addr);
		
		MemberDao.getInstance().joinMember(mvo);

		RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
	}

}
