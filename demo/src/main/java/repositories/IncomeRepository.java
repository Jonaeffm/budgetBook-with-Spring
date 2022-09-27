package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Budget;
import domain.Income;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Long>{

}
