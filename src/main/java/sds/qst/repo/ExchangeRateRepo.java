package sds.qst.repo;

import org.springframework.data.repository.CrudRepository;
import sds.qst.entity.Currency;
import sds.qst.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateRepo extends CrudRepository<ExchangeRate, Long> {
    List<ExchangeRate> getByFromAndTo(Currency from, Currency to);
}
