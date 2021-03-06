package com.saurav.bankingapp.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurav.bankingapp.exceptions.ResourceNotFoundException;
import com.saurav.bankingapp.model.User;
import com.saurav.bankingapp.model.enums.UserType;
import com.saurav.bankingapp.repository.UserRepository;
import com.saurav.bankingapp.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	

	@Override
	public void add(String name, String email, String password, String phone, String address, UserType type) {
		
		User user = new User(name, email, encoder.encode(password), phone, address, new Date(), type);
		userRepository.save(user);	
		
	}

	@Override
	public void delete(long id) {
		
		if (!hasUser(id))
			throw new ResourceNotFoundException(Long.toString(id), "User not found");
		
		userRepository.deleteById(id);
	}

	@Override
	public void update(long id, User user){
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String phone) {
		
		Optional<User> user = userRepository.findByPhone(phone);

		if (!user.isPresent())
			throw new ResourceNotFoundException(phone, "User not found");

		return user.get();
	}

	@Override
	public User getById(long id) {
		
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new ResourceNotFoundException(Long.toString(id), "User not found");

		return user.get();
	}

	@Override
	public boolean hasUser(String phone) {
		return userRepository.findByPhone(phone).isPresent();
	}

	@Override
	public boolean hasUser(long id) {
		return userRepository.findById(id).isPresent();
	}

}
