package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String alternateEmail;
	private int mailboxCapacity = 500;
	private int passwordLength;
	private String email;
	private String companySuffix = "zoyo.com";
	private int defaultPasswordLength = 10;

	// Constructor receive first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call a method asking for the department -return the department
		this.department = setDepartment();
		

		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: " + this.password);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		
	}

	// Ask for the department
	private String setDepartment() {
		System.out.print("New Employee: " + firstName
				+ ". Department Code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter Department Code: ");
		Scanner sc = new Scanner(System.in);
		int deptChoice = sc.nextInt();
		if (deptChoice == 1) {
			return "sales";
		} else if (deptChoice == 2) {
			return "deve";
		} else if (deptChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);

		}
		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email
	public void setAlternateEmail(String altemail) {
		this.alternateEmail = altemail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailBoxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + " " + "\nCOMPANY EMAIL:" + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity + "MB";
	}
}
