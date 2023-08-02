package technica;

import javax.swing.JOptionPane;

public class HealthcareApp {

	public static void main(String[] args) {

		/*
		 * Variables created: String nameFirst, String nameLast, int birth,
		 * resultInsurance, double budget, String state, String city
		 */

		// Main Choices:
		String urgentC = "I would like to find a healthcare provider or center that fits my needs.";
		String insuranceClass = "I would like to look into types of healthcare insurances that will fit my identity, budget, and age.";
		String chatBot = "I would like to be given quick medical and home remedy information based on my medical symptoms.";

		String[] threeChoices = { urgentC, insuranceClass, chatBot };

		String choiceMade = (String) JOptionPane.showInputDialog(null, "Hello! What would you like to do?", "",
				JOptionPane.QUESTION_MESSAGE, null, threeChoices, threeChoices[0]);

		JOptionPane.showMessageDialog(null,
				"You will need to create an account in order "
						+ "to personalize your aid. Your data will be kept private, and "
						+ "it will only be used to find a solution that best fits your needs.");

		// User Profile:
		boolean validFName = false;
		String nameFirst;
		do {
			nameFirst = JOptionPane.showInputDialog(null, "Enter your first name:");
			if (nameFirst.isBlank()) {
				JOptionPane.showMessageDialog(null, "Your input was blank. Please enter your first name:");
			} else {
				validFName = true;
				nameFirst = nameFirst.substring(0, 1).toUpperCase().trim()
						+ nameFirst.substring(1, nameFirst.length()).toLowerCase().trim();
			}
		} while (validFName == false);

		boolean validLName = false;
		String nameLast;
		do {
			nameLast = JOptionPane.showInputDialog(null, "Enter your last name:");
			if (nameLast.isBlank()) {
				JOptionPane.showMessageDialog(null, "Your input was blank. Please enter your last name:");
			} else {
				validLName = true;
				nameLast = nameLast.substring(0, 1).toUpperCase().trim()
						+ nameLast.substring(1, nameLast.length()).toLowerCase().trim();
			}
		} while (validLName == false);

		String birthStr;

		// need try catch
		int birth = 0;
		boolean validBirth = false;
		do {
			try {
				birthStr = JOptionPane.showInputDialog("Enter your year of birth (xxxx):");
				if (nameLast.isBlank() || birthStr.length() != 4) {
					JOptionPane.showMessageDialog(null,
							"Your input did not meet the xxxx year format. Please enter your birth year.");
				} else {
					birth = Integer.parseInt(birthStr);
					validBirth = true;
				}
			} catch (IllegalArgumentException e) {
				System.out.println(
						"You must input your birth year without any special characters or letters in the form xxxx. Please re-enter your birth year:");
			}

		} while (validBirth == false);

		int resultInsurance = JOptionPane.showConfirmDialog(null, "Do you have healthcare insurance?");
		switch (resultInsurance) {
		case JOptionPane.YES_OPTION:
			break;
		case JOptionPane.NO_OPTION:
			break;
		}
		if (resultInsurance == 0) {

			String insurance = JOptionPane.showInputDialog("Enter your insurance provider:");
			insurance = insurance.trim().toLowerCase();
		}

		boolean validBudget = false;
		String budgetStr;
		double budget = 0;
		do {
			try {
				budgetStr = JOptionPane.showInputDialog("Enter your budget in numeric form (USD):");
				budget = Double.parseDouble(budgetStr);
				validBudget = true;
			} catch (IllegalArgumentException e) {
				System.out.println(
						"You must input your budget without any special characters or letters in the form xx.xx or xx. Please re-enter your budget:");
			}
		} while (validBudget == false);

		String[] statesArray = { "Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
				"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho",
				"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
				"Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
				"Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
				"Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
				"South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont",
				"Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
		String state = (String) JOptionPane.showInputDialog(null, "What state do you reside in?", "",
				JOptionPane.QUESTION_MESSAGE, null, statesArray, statesArray[0]);

		boolean validCity = false;
		String city;
		do {
			city = JOptionPane.showInputDialog(null, "Enter your city:");
			if (city.isBlank()) {
				JOptionPane.showMessageDialog(null, "Your input was blank. Please enter your city:");
			} else {
				validCity = true;
				city = city.substring(0, 1).toUpperCase().trim()
						+ city.substring(1, city.length()).toLowerCase().trim();
			}
		} while (validCity == false);

		User user1 = new User(nameFirst, nameLast, birth, resultInsurance, budget, state, city);

		if (choiceMade.equals(urgentC)) {
			// Urgent Care
			String a = "I am in immense pain.";
			String b = "I am in pain that is bearable.";
			String c = "I am having trouble breathing/light headed.";
			String d = "I have symptoms of an illness.";
			String e = "I need a check up.";

			String[] choices = { a, b, c, d, e };
			String input = (String) JOptionPane.showInputDialog(null,
					"Why do you need to see a healthcare professional?", "", JOptionPane.QUESTION_MESSAGE, null,
					choices, choices[0]);
			System.out.println(input);

			String opening = "The best options for healthcare for you are:\n";
			String urgentCare = "Urgent Care near you:\n" + "Express Healthcare - (301) 542-1152\n"
					+ "AdmitFirst - (240) 657-6483\n" + "MedicineNow - (301) 895-3154";
			String clinics = "Clinics near you:\n" + "Family MedCenter - (301) 468-6482\n"
					+ "Wellness Care - (866) 548-6815\n" + "Ace Clinic - (684) 694-6845";
			String telemedicine = "Telemedicine near you:\n" + "MedCircle - (203) 635-1249\n"
					+ "BridgePoint - (658) 650-5873\n" + "TeleMed - (866) 097-8096\n";
			String hospitals = "Hospitals near you:\n" + "BridgePoint - (658) 650-5873\n"
					+ "PG General - (203) 874-0354\n" + "Alexandria Point - (203) 678-3486";
			String radiology = "Radiology near you:\n" + "Clinical Radiologists - (301) 601-9823\n"
					+ "Radiology Associates - (203) 085-8762\n" + "QLab - (866) 765-6512";

			if (input == a) {
				String output = opening + "Emergency services (Call 911), Urgent Care\n\n" + urgentCare;
				JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
			} else if (input == b) {
				String output = opening + "Urgent Care, Clinic, Telemedicine\n\n" + urgentCare + "\n\n" + clinics
						+ "\n\n" + telemedicine;
				JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
			} else if (input == c) {
				String output = opening + "Urgent Care, Clinic\n\n" + urgentCare + "\n\n" + clinics;
				JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
			} else if (input == d) {
				String output = opening + "Hospital, Clinic, Telemedicine\n\n" + hospitals + "\n\n" + clinics + "\n\n"
						+ telemedicine;
				JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
			} else {
				String output = opening + "Hospital, Radiology, Telemedicine\n\n" + hospitals + "\n\n" + radiology
						+ "\n\n" + telemedicine;
				JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
			}

			// Insurance:
		} else if (choiceMade.equals(insuranceClass)) {
			String a = "Medilove";
			String b = "Children’s Health Insurance Scheme ";
			String c = "Pink Cross Pink Shield";
			String d = "Caresecond Inc.";
			String e = "Divided Health Care";
			String f = "Amworse";
			String g = "WashingtonCare";
			String i = "NonTherapeutic Sandpaper";
			String j = "Jason & Jason";
			String k = "WalRed Sandals Enemies Inc.";
			char separator = ',';
			String[] optionsForCitizenshipStatus = { "I am a U.S. citizen", "I am NOT a U.S. citizen" };

			String citizen = (String) JOptionPane.showInputDialog(null, "What is your current citizenship status?", "",
					JOptionPane.QUESTION_MESSAGE, null, optionsForCitizenshipStatus, optionsForCitizenshipStatus[0]);

			if (citizen.equals("I am a U.S. citizen")) {
				if (budget <= 500.0) {
					if (birth <= 18) {
						JOptionPane.showMessageDialog(null,
								"If you are a citizen, have a budget less than or equal to $500, and are 18 or under, here are your option(s): "
										+ a + separator + b);
					} else {
						JOptionPane.showMessageDialog(null,
								"If you are a citizen, have a budget less than or equal to $500, and are over 18, here are your option(s): "
										+ a + separator + c + separator + d + separator + e);
					}
				} else {
					if (birth <= 18) {

						JOptionPane.showMessageDialog(null,
								"If you are a citizen, have a budget more than $500, and are 18 or under, here are your option(s): "
										+ j + separator + g + separator + i);
					} else {
						JOptionPane.showMessageDialog(null,
								"If you are a citizen, , have a budget more than $500, and are over 18, here are your option(s): "
										+ f + separator + k + separator + a);

					}
				}
			} else {
				if (budget <= 500.0) {
					if (birth <= 18) {
						JOptionPane.showMessageDialog(null,
								"If you are NOT a citizen, have a budget less than or equal to $500, and are 18 or under, here are your option(s): "
										+ i + separator + j);
					} else {
						JOptionPane.showMessageDialog(null,
								"If you are NOT a citizen, have a budget less than or equal to $500, and are over 18, here are your option(s): "
										+ k);
					}
				} else {
					if (birth <= 18) {

						JOptionPane.showMessageDialog(null,
								"If you are NOT a citizen, have a budget more than $500, are 18 or under, here are your option(s): "
										+ a + separator + d + separator + k);
					} else {
						JOptionPane.showMessageDialog(null,
								"If you are NOT a citizen, have a budget more than $500, are over 18, here are your option(s): "
										+ g + separator + b + separator + e);

					}
				}
			}

			// Chat Bot (Remedies):
		} else if (choiceMade.equals(chatBot)) {
			new Remedy();
		} else {

		}

	}

}


