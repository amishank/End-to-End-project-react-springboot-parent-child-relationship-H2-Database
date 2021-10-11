package com.assignment.daofab.controller;

import com.assignment.daofab.model.Installment;
import com.assignment.daofab.repository.InstallmentRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amit shankar
 * 
 * Installment controller class provides api to result in installment details 
 * with transaction Id for a particular transaction.
 *   
 * 
**/

@RestController@CrossOrigin(origins="*")
public class InstallmentController {

	@Autowired
	private InstallmentRepository installmentRepository;

	@GetMapping("/transaction/{transactionId}/installment")
	public List<Installment> getAllInstallmentByTransactionId(@PathVariable (value = "transactionId")
	Long transactionId) {
		return installmentRepository.findByTransactionId(transactionId,Sort.by(Sort.Direction.ASC, "id"));
	}
}
