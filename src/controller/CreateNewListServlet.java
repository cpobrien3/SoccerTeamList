package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Division;
import model.DivisionDetails;

import model.SoccerTeam;
/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SoccerTeamHelper sth = new SoccerTeamHelper();
		String listName = request.getParameter("listName");
		
		String divisionName = request.getParameter("divisionName");
	
		
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<SoccerTeam> selectedTeamsInList = new ArrayList<SoccerTeam>();
	
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
			
				SoccerTeam c = sth.searchForItemById(Integer.parseInt(selectedItems[i]));
				selectedTeamsInList.add(c);
			}
		}
		Division division = new Division(divisionName);
		DivisionDetails sld = new DivisionDetails(listName,  division);
	
		sld.setListOfTeams(selectedTeamsInList);
		DivisionDetailsHelper slh = new DivisionDetailsHelper();
		slh.insertNewTeamDetails(sld);
	
		getServletContext().getRequestDispatcher("/viewAllDivisionsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
