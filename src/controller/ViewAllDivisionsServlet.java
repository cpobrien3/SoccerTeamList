package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ViewAllDivisionsServlet
 */
@WebServlet("/viewAllDivisionsServlet")
public class ViewAllDivisionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllDivisionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DivisionDetailsHelper slh = new DivisionDetailsHelper();
		List<DivisionDetails> abc = slh.getDivisions();
		request.setAttribute("allLists", abc);
		if(abc.isEmpty()){
			request.setAttribute("allLists", " ");
		}
		getServletContext().getRequestDispatcher("/division-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
