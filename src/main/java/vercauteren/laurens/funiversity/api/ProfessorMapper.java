package vercauteren.laurens.funiversity.api;

import org.springframework.stereotype.Component;
import vercauteren.laurens.funiversity.domain.Professor;
import vercauteren.laurens.funiversity.domain.dtos.CreateProfessorDto;
import vercauteren.laurens.funiversity.domain.dtos.ProfessorDto;

@Component
public class ProfessorMapper {

	public ProfessorDto getProfessorDtoFromProfessor(Professor professor) {
		return new ProfessorDto()
				.setId(professor.getId())
				.setFirstName(professor.getFirstName())
				.setLastName(professor.getLastName());
	}

	public Professor getProfessorFromCreateProfessorDto(CreateProfessorDto createProfessorDto) {
		return new Professor(createProfessorDto.getFirstName(),
				createProfessorDto.getLastName());
	}

}
