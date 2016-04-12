package sample.service;

import javax.validation.constraints.NotNull;

import sample.entity.Publication;

public interface PublicationService {
	Publication addPublication(@NotNull Publication pub);
}
