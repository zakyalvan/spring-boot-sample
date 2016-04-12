package sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.entity.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}
