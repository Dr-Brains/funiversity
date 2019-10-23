package vercauteren.laurens.funiversity.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

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
		return professorsById.contains(professor);
	}
}
