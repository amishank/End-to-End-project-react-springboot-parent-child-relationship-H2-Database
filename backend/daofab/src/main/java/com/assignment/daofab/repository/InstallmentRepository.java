package com.assignment.daofab.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.assignment.daofab.model.Installment;

/** 
 *
 * @author amit shankar
 *
 * Installment Repository provides JPA and call inside controller method.
 * It is an interface extends with JPA Repository and having two methods.
 * first method findByTransactionId provide the details of the list of records of installment by filter with transaction Id.
 * second method results in the sum of the total paid amount from installment records.
 *
 **/

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {

	List<Installment> findByTransactionId(Long transactionId, Sort sort);

	@Query(value="SELECT SUM(PAID_AMOUNT) FROM INSTALLMENT GROUP BY TRANSACTION_ID HAVING TRANSACTION_ID=:transactionId" , nativeQuery = true)
	public Integer sumTotalPaidAmount(@Param("transactionId") Long transactionId);

}
