package com.scottmarden.greatnumbergame.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameCtrl
 */
@WebServlet("/game")
public class GameCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Integer randNum() {
    		Random rand = new Random();
    		return (rand.nextInt(100))+1;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
//		session.invalidate();
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Game.jsp");
		if (session.getAttribute("num") == null) {
			Integer num = randNum();
			session.setAttribute("num", num);
			request.removeAttribute("guess");
		}
		if(request.getParameter("guess") != null) {
			int guess =  Integer.parseInt(request.getParameter("guess"));
			if (guess == (Integer) session.getAttribute("num")) {
				request.setAttribute("result", "correct");
				request.setAttribute("guess", guess);
			}else if(guess < (Integer) session.getAttribute("num")) {
				request.setAttribute("result", "low");
				request.setAttribute("guess", guess);
			}else {
				request.setAttribute("result", "high");
				request.setAttribute("guess", guess);
			}
		}
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
