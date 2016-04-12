package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sample.entity.Professor;
import sample.repo.ProfesssorRepository;

@RestController
@RequestMapping(value="/professor")
public class ProfessorController {
	@Autowired
	private ProfesssorRepository professsors;
	
	@RequestMapping(method=RequestMethod.POST)
	public HttpEntity<Professor> registerProfessor(@RequestBody @Validated Professor professor, 
			BindingResult bindings) {
		if(bindings.hasErrors()) {
			throw new RuntimeException();
		}
		
		Professor newProfessor = professsors.saveAndFlush(professor);
		return new ResponseEntity<>(newProfessor, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Page<Professor> listProfessors(Pageable pageable) {
		return professsors.findAll(pageable);
	}
}
