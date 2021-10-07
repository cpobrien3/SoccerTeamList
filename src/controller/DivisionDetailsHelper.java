package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DivisionDetails;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */
public class DivisionDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SoccerTeamList");
	
	public void insertNewTeamDetails(DivisionDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<DivisionDetails> getDivisions() {
		EntityManager em = emfactory.createEntityManager();
		List<DivisionDetails> allDetails = em.createQuery("SELECT d FROM DivisionDetails d").getResultList();
		return allDetails;
	}
		
	public void deleteList(DivisionDetails toDelete) {

			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<DivisionDetails> typedQuery = em.createQuery("select detail from DivisionDetails detail where detail.id = :selectedId", DivisionDetails.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedId", toDelete.getId());
			// we only want one result
			typedQuery.setMaxResults(1);
			// get the result and save it into a new list item
			DivisionDetails result = typedQuery.getSingleResult();
			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
	
	
		public DivisionDetails searchForListDetailsById(Integer tempId) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			DivisionDetails found = em.find(DivisionDetails.class, tempId);
			em.close();
			return found;
		}
}
