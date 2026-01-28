package com.zepto.password.reset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zepto.password.reset.dao.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserPasswordHistoryService historyService;

	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public boolean resetPassword(String userName, String newPassword) {
		String lastThree = newPassword.length() >= 3 ? newPassword.substring(newPassword.length() - 3) : newPassword;

		if (historyService.isLastThreeUsed(userName, lastThree)) {
			return false;
		}

		String hashed = passwordEncoder.encode(newPassword);

		userDAO.updatePassword(userName, hashed);

		historyService.saveLastThree(userName, lastThree);

		return true;
	}
}
