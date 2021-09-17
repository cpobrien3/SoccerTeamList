package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Sep 14, 2021
 */

@Entity
@Table(name="teams")
public class SoccerTeam {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="CLUB")
	private String clubName;
	@Column(name="LEAGUE")
	private String league;
	@Column(name="CITY")
	private String city;
	@Column(name="COUNTRY")
	private String country;
	
	//Default no-arg constructor
	public SoccerTeam() {
			
	}
	
	//Non-default constructor
	public SoccerTeam(String clubName, String league, String city, String country) {
		this.clubName = clubName;
		this.league = league;
		this.city = city;
		this.country = country;
	}
	

	//Declare getters and setters
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	/**
	 * Method that returns the soccer team info as a string.
	 * @return
	 */
	public String returnTeamDetails() {
		return "Club Name = " + this.clubName + ", League = " + this.league + ", City = " + this.city + ", Country = " + this.country;
	}
}
