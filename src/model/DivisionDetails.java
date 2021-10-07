package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

@Entity
public class DivisionDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Division division;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<SoccerTeam> listOfTeams;
	
	//Constructors
	public DivisionDetails() {
		
	}

	
	public DivisionDetails(int id, String listName, Division division, List<SoccerTeam> listOfTeams) {
		this.id = id;
		this.division = division;
		this.listOfTeams = listOfTeams;
		this.listName = listName;
	}
	
	public DivisionDetails(String listName, Division division, List<SoccerTeam> listOfTeams) {
		this.division = division;
		this.listOfTeams = listOfTeams;
		this.listName = listName;
	}

	public DivisionDetails(String listName, Division division) {
		this.division = division;
		this.listName = listName;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getListName() {
		return listName;
	}


	public void setListName(String listName) {
		this.listName = listName;
	}


	public Division getDivision() {
		return division;
	}


	public void setDivision(Division division) {
		this.division = division;
	}


	public List<SoccerTeam> getListOfTeams() {
		return listOfTeams;
	}


	public void setListOfTeams(List<SoccerTeam> listOfTeams) {
		this.listOfTeams = listOfTeams;
	}


	@Override
	public String toString() {
		return "DivisionDetails [id=" + id + ", listName=" + listName + ", division=" + division + ", listOfTeams="
				+ listOfTeams + "]";
	}


	


	
}
