package com.assignment.daofab.controller;

import com.assignment.daofab.model.Transaction;
import com.assignment.daofab.repository.InstallmentRepository;
import com.assignment.daofab.repository.TransactionRepository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author amit shankar
 * 
 * Transaction controller class provides api to results list of Transaction details 
 * and sum of total paid amount.
 *   
 * 
**/

@RestController@CrossOrigin(origins="*")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private InstallmentRepository installmentRepo;

	@GetMapping("/transaction")
	public Page<Transaction> getAllTransaction(Pageable pageable) {
		Page<Transaction> transactionDetail = transactionRepository.findAll(pageable);
		List<Transaction> transactionList = transactionDetail.getContent();
		for(Transaction transaction: transactionList) {
			if(!Objects.isNull(transaction) && transaction.getTotalPaidAmount()==0){
				Integer totalPaidAmount = installmentRepo.sumTotalPaidAmount(transaction.getId());
				if(!Objects.isNull(totalPaidAmount)) {
					transaction.setTotalPaidAmount(totalPaidAmount);
				}
				else {
					transaction.setTotalPaidAmount(0);
				}
			}
		}
		return transactionDetail;
	}
}
