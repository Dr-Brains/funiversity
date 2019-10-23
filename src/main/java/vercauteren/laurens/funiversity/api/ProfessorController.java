package vercauteren.laurens.funiversity.api;

import org.springframework.stereotype.Controller;
import vercauteren.laurens.funiversity.services.ProfessorService;

@Controller
public class ProfessorController {

	private ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}
}
