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
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SoccerTeamHelper dao = new SoccerTeamHelper();
		String name = request.getParameter("club");
		String league = request.getParameter("league");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		SoccerTeam teamToUpdate = dao.searchForItemById(tempId);
		teamToUpdate.setClubName(name);
		teamToUpdate.setLeague(league);
		teamToUpdate.setCity(city);
		teamToUpdate.setCountry(country);
		
		dao.updateItem(teamToUpdate);
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
