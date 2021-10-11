package com.assignment.daofab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.daofab.model.Transaction;

/** 
*
* @author amit shankar
*
* Transaction Repository provides JPA and call inside controller method, and it is an interface extends
* with JPA Repository.
* 
**/

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
