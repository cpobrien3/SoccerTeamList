package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SoccerTeam;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Sep 29, 2021
 */


/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String club = request.getParameter("club");
		String league = request.getParameter("league");
		String city = request.getParameter("city");
		String country = request.getParameter("country");		
		
		SoccerTeam st = new SoccerTeam(club, league, city, country);
		SoccerTeamHelper dao = new SoccerTeamHelper();
		dao.insertTeam(st);
				
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
