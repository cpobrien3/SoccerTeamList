package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Division;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

public class DivisionHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoccerTeamList");
	
	public void insertDivision(Division d) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Division> showAllDivisions() {
		EntityManager em = emfactory.createEntityManager();
		List<Division> allDivisions = em.createQuery("SELECT s FROM Division s").getResultList();
		return allDivisions;
	}
		 
}
