package repositories;

import org.springframework.data.repository.CrudRepository;

import domain.ProgramUser;


public interface ProgramUserRepository extends CrudRepository<ProgramUser, Long> {
    ProgramUser findByUsername(String username);
}