package vercauteren.laurens.funiversity.domain;

import java.util.concurrent.ConcurrentHashMap;

public class ProfessorRepository {

	private ConcurrentHashMap<String , Professor> professorsById;


	public Professor getById(String id) throws IllegalArgumentException{
		var foundProfessor = professorsById.get(id);
		if(foundProfessor == null) {
			throw new IllegalArgumentException("No Professor could be found for id " + id);
		}
		return foundProfessor;
	}
}
