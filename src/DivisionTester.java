import java.util.List;

import controller.DivisionHelper;
import model.Division;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class DivisionTester {
	public static void main(String args[]) {
		Division two = new Division("II");
		DivisionHelper sh = new DivisionHelper();
		sh.insertDivision(two);
		List<Division> allDivisions = sh.showAllDivisions();
		Division three = new Division("III");
		sh.insertDivision(three);
		
		for(Division a: allDivisions) {
			System.out.println(a.toString());
		}
	}
}
