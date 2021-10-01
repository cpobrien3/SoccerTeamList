package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Sep 29, 2021
 */

/**
 * Servlet implementation class ViewAllTeamsServlet
 */
@WebServlet("/viewAllTeamsServlet")
public class ViewAllTeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllTeamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SoccerTeamHelper dao = new SoccerTeamHelper();
		request.setAttribute("allTeams", dao.showAllClubs());
		String path = "/soccer-list.jsp";
		if(dao.showAllClubs().isEmpty()){
		path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
