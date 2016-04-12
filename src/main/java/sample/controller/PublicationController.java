package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sample.entity.Publication;
import sample.service.PublicationService;

@RestController
@RequestMapping(value="/publication")
public class PublicationController {
	@Autowired
	private PublicationService publicationService;
	
	@RequestMapping(method=RequestMethod.POST)
	public HttpEntity<Publication> addPublication(@RequestBody @Validated Publication publication, BindingResult bindings) {
		if(bindings.hasErrors()) {
			throw new RuntimeException();
		}
		return new ResponseEntity<Publication>(publicationService.addPublication(publication), HttpStatus.OK);
	}
}
