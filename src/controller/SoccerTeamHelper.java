package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.SoccerTeam;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */
public class SoccerTeamHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoccerTeamList");
	
	/**
	 * Method that adds a soccer team to the list.
	 * @param sc
	 */
	public void insertTeam(SoccerTeam sc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sc);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Method that displays each soccer team in the list.
	 * @return allClubs - Each team/club in the list
	 */
	public List<SoccerTeam> showAllClubs(){
		EntityManager em = emfactory.createEntityManager();
		List<SoccerTeam> allClubs = em.createQuery("select i from SoccerTeam i").getResultList();
		return allClubs;
		}
	
	/**
	 * Method that deletes a team from the list.
	 * @param toDelete
	 */
	public void deleteTeam(SoccerTeam toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select sc from SoccerTeam sc where sc.clubName = :selectedClubName and sc.league = :selectedLeague and sc.city = :selectedCity and sc.country = :selectedCountry", SoccerTeam.class);

		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedClubName", toDelete.getClubName());
		typedQuery.setParameter("selectedLeague", toDelete.getLeague());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		//Only get one result
		typedQuery.setMaxResults(1);
		//Save the result into a new list. 
		SoccerTeam result = typedQuery.getSingleResult();
		//Remove the result
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	/**
	 * Method the searches for a team using the Id# 
	 * @param idToEdit
	 * @return found - the SoccerTeam found by the search
	 */
	public SoccerTeam searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		SoccerTeam found = em.find(SoccerTeam.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * Method that updates a SoccerTeam object.
	 * @param toEdit
	 */
	public void updateItem(SoccerTeam toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/** Method that searches for a team using the club name.
	 * @param clubName
	 * @return foundTeam - the SoccerTeam found by the search
	 */
	public List<SoccerTeam> searchForTeamByClubName(String clubName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select sc from SoccerTeam sc where sc.clubName = :selectedClubName", SoccerTeam.class);
				
		typedQuery.setParameter("selectedClubName", clubName);
				
		List<SoccerTeam> foundTeam = typedQuery.getResultList();
		em.close();
		return foundTeam;
	}

	/**
	 * Method that searches for a team using the league name.
	 * @param league
	 * @return foundTeam - the SoccerTeam found by the search
	 */
	public List<SoccerTeam> searchForTeamByLeagueName(String league) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select sc from SoccerTeam sc where sc.league = :selectedLeague", SoccerTeam.class);
				
		typedQuery.setParameter("selectedLeague", league);
		List<SoccerTeam> foundTeam = typedQuery.getResultList();
		em.close();
		return foundTeam;
	}
	
	/**
	 * Method that searches for a team using the city name.
	 * @param city
	 * @return foundTeam - the SoccerTeam found by the search
	 */
	public List<SoccerTeam> searchForTeamByCity(String city) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select sc from SoccerTeam sc where sc.city = :selectedCity", SoccerTeam.class);
				
		typedQuery.setParameter("selectedCity", city);
		List<SoccerTeam> foundTeam = typedQuery.getResultList();
		em.close();
		return foundTeam;
	}
	
	/**
	 * Method that searches for a team using the country name.
	 * @param country
	 * @return
	 */
	public List<SoccerTeam> searchForTeamByCountry(String country) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select sc from SoccerTeam sc where sc.country = :selectedCountry", SoccerTeam.class);
				
		typedQuery.setParameter("selectedCity", country);
		List<SoccerTeam> foundTeam = typedQuery.getResultList();
		em.close();
		return foundTeam;
	}
	
	public void cleanUp() {
		emfactory.close();	
	}
}
