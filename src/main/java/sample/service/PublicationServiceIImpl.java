package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import sample.entity.Publication;
import sample.repo.PublicationRepository;

@Service
@Validated
@Transactional
public class PublicationServiceIImpl implements PublicationService {
	@Autowired
	private PublicationRepository publications;
	
	@Override
	public Publication addPublication(Publication pub) {
		return publications.saveAndFlush(pub);
	}
}
