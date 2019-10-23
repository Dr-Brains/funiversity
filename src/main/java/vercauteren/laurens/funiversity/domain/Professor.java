package vercauteren.laurens.funiversity.domain;

import java.util.UUID;

public class Professor {

	static int idCounter = 0;
	private int id;
	private final String firstName;
	private final String lastName;

	public Professor(String firstName, String lastName) {
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
