package vercauteren.laurens.funiversity.domain;

import org.springframework.stereotype.Repository;
import vercauteren.laurens.funiversity.domain.dtos.CreateProfessorDto;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ProfessorRepository {

	private ConcurrentHashMap<Integer , Professor> professorsById;

	public ProfessorRepository() {
		professorsById = new ConcurrentHashMap<>();
	}

	public Professor add(Professor professor) {
		if(assertIfProfessorIsAlreadyInRepository(professor)){
			throw new IllegalArgumentException("Professor already exists");
		}
		professorsById.put(professor.getId(), professor);
		return professor;
	}

	public Professor getById(int id) throws IllegalArgumentException{
		var foundProfessor = professorsById.get(id);
		if(foundProfessor == null) {
			throw new IllegalArgumentException("No Professor could be found for id " + id);
		}
		return foundProfessor;
	}

	public Collection<Professor> getAll() {
		return professorsById.values();
	}

	public boolean assertIfProfessorIsAlreadyInRepository(Professor professor){
		//get list of all professors without ID and compare them.
		List<CreateProfessorDto> collectedProfessors = professorsById.keySet().stream()
				.map(key -> new CreateProfessorDto(professorsById.get(key).getFirstName(), professorsById.get(key).getLastName()))
				.collect(Collectors.toList());
		CreateProfessorDto professorToCheck = new CreateProfessorDto(professor.getFirstName(),professor.getLastName());
		return collectedProfessors.contains(professorToCheck);
	}
}
