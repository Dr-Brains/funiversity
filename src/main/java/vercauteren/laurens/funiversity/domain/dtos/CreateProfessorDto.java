package vercauteren.laurens.funiversity.domain.dtos;

public class CreateProfessorDto {

	private final String firstName;
	private final String lastName;

	public CreateProfessorDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
