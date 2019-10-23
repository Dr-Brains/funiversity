package vercauteren.laurens.funiversity.domain.dtos;

public class ProfessorDto {

	private int id;
	private String firstName;
	private String lastName;

	public int getId() {
		return id;
	}

	public ProfessorDto setId(int id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public ProfessorDto setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public ProfessorDto setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

}
