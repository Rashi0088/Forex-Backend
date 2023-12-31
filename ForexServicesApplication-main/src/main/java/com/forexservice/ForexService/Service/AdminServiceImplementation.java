package com.forexservice.ForexService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forexservice.ForexService.Dto.AdminDto;
import com.forexservice.ForexService.Dto.ExchangeRateDto;
import com.forexservice.ForexService.Entity.Admin;
import com.forexservice.ForexService.Entity.ExchangeRate;
import com.forexservice.ForexService.Exception.InvalidInputException;
import com.forexservice.ForexService.Repository.AdminRepository;
import com.forexservice.ForexService.Repository.ExchangeRateRepository;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	@Autowired
	private ExchangeRateService exchangeRateService;

	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {

		Admin admin = new Admin();
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminEmail(adminDto.getAdminEmail());
		admin.setAdminPassword(adminDto.getAdminPassword());
		admin.setAdminUsername(adminDto.getAdminUsername());
		admin.setAdminName(adminDto.getAdminName());

		Admin newAdmin = adminRepository.save(admin);

		return adminDto;
	}

	@Override
	public ExchangeRateDto saveExchangeRate(ExchangeRateDto exchangeRateDto) {
		// TODO Auto-generated method stub
	return exchangeRateService.saveExchangeRate(exchangeRateDto);

		
	}

	@Override
	public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate) {
		// TODO Auto-generated method stub
		return exchangeRateService.updateExchangeRate(exchangeRate);

	}

	@Override
	public String resetPassword(String adminEmail, String adminPassword, String newPassword) throws InvalidInputException {
		Optional<Admin> loginObj= adminRepository.findByAdminEmail(adminEmail);
		String s="";
		if(loginObj.isPresent()) {
			if( loginObj.get().getAdminPassword().equals(adminPassword)) {
				Admin admin = loginObj.get();
				admin.setAdminPassword(newPassword);
				adminRepository.save(admin);
				return "Password reset successfully";
			}
			else {
				s="enter valid password";
				}
			}
		else {
			s="Enter Registered Email ID";
			}
		throw new InvalidInputException(s);
        }

	@Override
	public String resetForgotPassword(String adminEmail, String newPassword, String confirmPassword) throws InvalidInputException {
		Optional<Admin> loginObj= adminRepository.findByAdminEmail(adminEmail);
		String s="";
		if(loginObj.isPresent()) {
			if(newPassword.equals(confirmPassword)) {
				Admin admin = loginObj.get();
				admin.setAdminPassword(newPassword);
				adminRepository.save(admin);
				return "Password reset successfully";
			}
			else {
				s="password not match";
				}
			}
		else {
			s="enter valid email";
			}
		throw new InvalidInputException(s);
	}

	
	
	
	
	}
