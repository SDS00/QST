package sds.qst.repo;

import org.springframework.data.repository.CrudRepository;
import sds.qst.entity.Currency;

public interface CurrencyRepo extends CrudRepository<Currency, Long> {
    Currency getById(Long id);
}
