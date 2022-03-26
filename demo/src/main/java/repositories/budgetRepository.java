package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Budget;

@Repository
public interface budgetRepository extends CrudRepository<Budget, Long>{

}
