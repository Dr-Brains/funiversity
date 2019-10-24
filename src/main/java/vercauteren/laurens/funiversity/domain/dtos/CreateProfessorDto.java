package vercauteren.laurens.funiversity.domain.dtos;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CreateProfessorDto that = (CreateProfessorDto) o;
		return Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}
}
