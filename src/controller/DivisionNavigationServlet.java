package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DivisionDetails;
/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

/**
 * Servlet implementation class DivisionNavigationServlet
 */
@WebServlet("/divisionNavigationServlet")
public class DivisionNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DivisionNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DivisionDetailsHelper dao = new DivisionDetailsHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/division-list.jsp").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				DivisionDetails listToDelete = dao.searchForListDetailsById(tempId);
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
		getServletContext().getRequestDispatcher("/new-division.jsp").forward(request, response);
		}
	}

}
