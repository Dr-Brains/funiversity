package vercauteren.laurens.funiversity.services;

import org.springframework.stereotype.Service;
import vercauteren.laurens.funiversity.domain.Professor;
import vercauteren.laurens.funiversity.domain.dtos.CreateProfessorDto;
import vercauteren.laurens.funiversity.domain.dtos.ProfessorDto;

@Service
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
