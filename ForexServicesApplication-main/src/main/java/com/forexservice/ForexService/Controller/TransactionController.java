package com.forexservice.ForexService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.forexservice.ForexService.Dto.TransactionDto;
import com.forexservice.ForexService.Entity.Transaction;
import com.forexservice.ForexService.Repository.TransactionRepository;
import com.forexservice.ForexService.Service.TransactionService;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	

	@Autowired
	private TransactionRepository transactionRepository;
		
	
	
	
	@PostMapping("/transaction/save")
	public ResponseEntity<TransactionDto> addTransaction( @RequestBody TransactionDto transactionDto) {
		TransactionDto newTransaction = transactionService.saveTransaction(transactionDto);
		ResponseEntity<TransactionDto> responseEntity = new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/transaction/{id}")
	public ResponseEntity<Transaction> fetchTransactionDetails(@PathVariable("id") int transactionId) {
		Transaction transaction = transactionService.getTransactionById(transactionId);
		ResponseEntity<Transaction> responseEntity = new ResponseEntity<>(transaction, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/transcation/all")
	public List<Transaction> fetchAllTransactions() {
		List<Transaction> list = transactionService.getAllTransactions();
		return list;
	}
	
	@GetMapping("/transaction/sender/{senderName}")
    public ResponseEntity<List<Transaction>> fetchTransactionsBySender(@PathVariable("senderName") String senderName) {
        List<Transaction> transactions = transactionRepository.findBySenderName(senderName);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

	

}