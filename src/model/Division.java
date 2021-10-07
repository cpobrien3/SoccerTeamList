package model;

/**
 * @author Christian O'Brien - cpobrien3
 * CIS175 - Fall 2021
 * Oct 6, 2021
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="division")
public class Division {
	@Id
	@GeneratedValue
	private int id;
	private String divisionName;
	
	public Division() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Division(int id, String divisionName) {
		super();
		this.id = id;
		this.divisionName = divisionName;
	}

	public Division( String divisionName) {
		this.divisionName = divisionName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDivisionLevel() {
		return divisionName;
	}

	public void setDivisionLevel(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return " Division Name= " + divisionName;
	}
	
	
	
	
}
