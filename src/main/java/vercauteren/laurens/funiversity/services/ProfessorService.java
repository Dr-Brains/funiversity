package vercauteren.laurens.funiversity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vercauteren.laurens.funiversity.domain.Professor;
import vercauteren.laurens.funiversity.domain.ProfessorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;

	@Autowired
	public ProfessorService(ProfessorRepository professorRepository){
		this.professorRepository = professorRepository;
	}

	public void add(Professor professorToAdd) {
		professorRepository.add(professorToAdd);
	}

	public List<Professor> getAll() {
		return new ArrayList<>(professorRepository.getAll());
	}
}
