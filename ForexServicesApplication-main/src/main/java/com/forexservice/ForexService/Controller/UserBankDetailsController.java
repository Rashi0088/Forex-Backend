package com.forexservice.ForexService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.forexservice.ForexService.Dto.UserBankDetailsDto;
import com.forexservice.ForexService.Entity.UserBankDetails;
import com.forexservice.ForexService.Repository.UserBankDetailsRepository;
import com.forexservice.ForexService.Service.UserBankDetailsService;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController

public class UserBankDetailsController {
	
	@Autowired
	private UserBankDetailsRepository userBankDetailsRepository;
	
	@Autowired
	private UserBankDetailsService iUserBankDetails;
	
	
	@PostMapping("/UserBankDetails/save")
	public ResponseEntity<UserBankDetailsDto> addBankDetails( @Validated @RequestBody UserBankDetailsDto userBankDetails )
	{
		 UserBankDetailsDto newUserBankDetails = iUserBankDetails.saveBankDetails(userBankDetails);
		ResponseEntity<UserBankDetailsDto> responseEntity = new ResponseEntity<>(newUserBankDetails, HttpStatus.CREATED);
		return responseEntity;
	}
	
	 @GetMapping("/UserBankDetails/user/{userId}")
	    public ResponseEntity<List<UserBankDetails>> getBankDetailsByUserId(@PathVariable int userId) {
		 System.out.println(userId);
		 return new ResponseEntity<>(userBankDetailsRepository.findByUser_UsersId(userId), HttpStatus.OK);
		 
	    }
}	