package com.fishing.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fishing.dao.CommunityDAO;
import com.fishing.dto.CommunityVO;


public class CommunityListAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outputUrl = "communityboard/communityboardList.jsp";
		String command = request.getParameter("command");
		System.out.println(command);
		CommunityDAO cDao = CommunityDAO.getInstance();
		
		System.out.println(request.getParameter("page"));
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		List<CommunityVO> list = cDao.selectAllBoard(page);
		int allNum= cDao.AllBoardcount();
		System.out.println(allNum);
		System.out.println(list);
		
		
		
		request.setAttribute("communityList", list);
		request.setAttribute("allNum", allNum);
		
		
		RequestDispatcher rd = request.getRequestDispatcher(outputUrl);
		rd.forward(request, response);

	}

}
