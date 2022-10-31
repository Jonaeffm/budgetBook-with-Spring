package repositories;

import org.springframework.data.repository.CrudRepository;

import domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}