import java.util.List;
import java.util.Scanner;


import controller.SoccerTeamHelper;
import model.SoccerTeam;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static SoccerTeamHelper sth = new SoccerTeamHelper();

	/**
	 * Method that adds a club to the soccer team list from user input.
	 */
	private static void addAClub() {
		System.out.print("Enter a Soccer Club: ");
		String club = in.nextLine();
		System.out.print("Enter a league name: ");
		String league = in.nextLine();
		System.out.print("Enter a city name: ");
		String city = in.nextLine();
		System.out.print("Enter a country name: ");
		String country = in.nextLine();
		SoccerTeam toAdd = new SoccerTeam(club, league, city , country);
		sth.insertTeam(toAdd);
	}
	
	/**
	 * Method that deletes a club from the list from user input.
	 */
	private static void deleteAClub() {
		System.out.print("Enter a club to delete: ");
		String club = in.nextLine();
		System.out.print("Enter a league to delete: ");
		String league = in.nextLine();
		System.out.print("Enter a city to delete: ");
		String city = in.nextLine();
		System.out.print("Enter a country to delete: ");
		String country = in.nextLine();
		SoccerTeam toDelete = new SoccerTeam(club, league, city , country);
		sth.deleteTeam(toDelete);
	}
	
	/**
	 * Method that edits an existing club.
	 */
	private static void editAnItem() {
		// Get user input
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Club Name");
		System.out.println("2 : Search by League");
		System.out.println("3 : Search by City");
		System.out.println("4 : Search by Country");
		int searchBy = in.nextInt();
		in.nextLine();
		List<SoccerTeam> foundItems;

		//Search the database by a property selected by the user.
		if (searchBy == 1) {
			System.out.print("Enter the club name: ");
			String clubName = in.nextLine();
			foundItems = sth.searchForTeamByClubName(clubName);
		} else if (searchBy == 2) {
			System.out.print("Enter the league name: ");
			String leagueName = in.nextLine();
			foundItems = sth.searchForTeamByLeagueName(leagueName);
		} else if (searchBy == 3) {
			System.out.print("Enter the city name: ");
			String cityName = in.nextLine();
			foundItems = sth.searchForTeamByCity(cityName);
		}else {
			System.out.print("Enter the country name: ");
			String countryName = in.nextLine();
			foundItems = sth.searchForTeamByCountry(countryName);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (SoccerTeam st : foundItems) {
				System.out.println(st.getId() + " : " + st.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			SoccerTeam toEdit = sth.searchForItemById(idToEdit);
			
			System.out.println("1 : Update Club Name");
			System.out.println("2 : Update League");
			System.out.println("3 : Update City");
			System.out.println("4 : Update Country");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Club Name: ");
				String newName = in.nextLine();
				toEdit.setClubName(newName);
			} else if (update == 2) {
				System.out.print("New League: ");
				String newLeague = in.nextLine();
				toEdit.setLeague(newLeague);
			} else if (update == 3) {
				System.out.print("New City: ");
				String newCity = in.nextLine();
				toEdit.setCity(newCity);
			} else if  (update == 4) {
				System.out.print("New Country: ");
				String newCountry = in.nextLine();
				toEdit.setCountry(newCountry);
			}
			sth.updateItem(toEdit);
			
			} else {
			System.out.println("---- No results found");
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}
	
	/**
	 * Creates a menu that prompts the user for what action they want to perform.
	 */
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the Soccer Team List! ---");
		while (goAgain) {
			//Get input from the user on what action they want to run.
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a team");
			System.out.println("*  2 -- Edit a team");
			System.out.println("*  3 -- Delete a team");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			// Run the method that corresponds to the user input.
			if (selection == 1) {
				addAClub();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAClub();
			} else if (selection == 4) {
				viewTheList();
			} else {
				sth.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	
	/**
	 * Method that displays each team using a for loop.
	 */
	private static void viewTheList() {
		List<SoccerTeam> allTeams = sth.showAllClubs();
		for(SoccerTeam singleTeam : allTeams){
			System.out.println(singleTeam.returnTeamDetails());
		}
	}
}

