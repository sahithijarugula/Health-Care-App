package technica;

import javax.swing.JOptionPane;

public class User {
	// String nameFirst, String nameLast, int birth, int resultInsurance, double budget, String state, String city 
	private String nameFirst;
	private String nameLast;
	private int birth;
	int resultInsurance;
	private double budget; 
	private String state;
	private String city; 
	
	public User(String nameFirst, String nameLast, int birth, 
			int resultInsurance, double budget, String state, String city) {
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.birth = birth;
		this.resultInsurance = resultInsurance;
		this.budget = budget;
		this.state = state;
		this.city = city;
	}
	
	
	}


