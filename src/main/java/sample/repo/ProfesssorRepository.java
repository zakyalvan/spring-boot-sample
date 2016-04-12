package sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.entity.Professor;

@Repository
public interface ProfesssorRepository extends JpaRepository<Professor, Long> {

}
