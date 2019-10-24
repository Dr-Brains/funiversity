package vercauteren.laurens.funiversity.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vercauteren.laurens.funiversity.domain.Professor;
import vercauteren.laurens.funiversity.domain.dtos.CreateProfessorDto;
import vercauteren.laurens.funiversity.domain.dtos.ProfessorDto;
import vercauteren.laurens.funiversity.services.ProfessorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = ProfessorController.PROFESSOR_CONTROLLER_RESOURCE_URL)
public class ProfessorController {

	public static final String PROFESSOR_CONTROLLER_RESOURCE_URL = "/profs";

	private ProfessorService professorService;
	private ProfessorMapper professorMapper;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	Logger logger = LoggerFactory.getLogger(ProfessorController.class);

	@Autowired
	public ProfessorController(ProfessorService professorService, ProfessorMapper professorMapper) {
		this.professorService = professorService;
		this.professorMapper = professorMapper;
	}

	//get all professors
	@GetMapping(produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<ProfessorDto> getProfessors() {
		logger.info("Getting all professors in the repository");
		return professorService.getAll().stream()
				.map(professorMapper::getProfessorDtoFromProfessor)
				.collect(Collectors.toList());
	}

	//add professor
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ProfessorDto addProfessor(@RequestBody CreateProfessorDto professorToAdd) {
		logger.info(String.format("Trying to create professor with firstName: %s and lastName: %s",
				professorToAdd.getFirstName(), professorToAdd.getLastName()));
		Professor profToAdd = professorMapper.getProfessorFromCreateProfessorDto(professorToAdd);
		try {
			professorService.add(profToAdd);
		} catch (IllegalArgumentException e) {

		}
		logger.info(String.format("Professor %s successfully added, assigned ID: %s",
				profToAdd.getLastName(), profToAdd.getId()));
		return professorMapper.getProfessorDtoFromProfessor(profToAdd);
	}
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	protected void ProfessorAlreadyExistsException{
//
//	}


}
