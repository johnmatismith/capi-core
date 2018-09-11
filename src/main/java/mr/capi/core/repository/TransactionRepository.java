package mr.capi.core.repository;

import mr.capi.core.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Collection;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @RestResource(path = "by-date")
    Collection<Transaction> findByDateBetween(@Param("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                              @Param("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to);

}
