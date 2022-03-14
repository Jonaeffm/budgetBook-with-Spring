package repositories;

import org.springframework.data.repository.CrudRepository;

import domain.Budget;

public interface budgetRepository extends CrudRepository<Budget, Long>{

}
