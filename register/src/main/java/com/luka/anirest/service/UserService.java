package com.luka.anirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luka.anirest.exception.UserAlreadyExistsException;
import com.luka.anirest.exception.UserNotFoundException;
import com.luka.anirest.exception.WrongPasswordException;
import com.luka.anirest.model.LoginUser;
import com.luka.anirest.model.PasswordlessUser;
import com.luka.anirest.model.User;
import com.luka.anirest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	private PasswordlessUser userToPasswordless(User user) {
		return new PasswordlessUser(user.getIdUser(), user.getName(), user.getSurname(), user.getUsername(),
				user.getEmail());
	}

	public PasswordlessUser returnUser(LoginUser user) throws UserNotFoundException, WrongPasswordException {
		Optional<User> repoUser = userRepository.findByUsername(user.getUsername());

		if (repoUser.isEmpty()) {
			User userModel = new User();
			userModel.setUsername(user.getUsername());
			throw new UserNotFoundException(userModel, "The user could not be found in the database");
		}

		if (!user.getPassword().equals(repoUser.get().getPassword()))
			throw new WrongPasswordException(userToPasswordless(repoUser.get()), "Bro forgor password 💀");

		return userToPasswordless(repoUser.get());
	}

	public User returnUser(User user) throws UserNotFoundException {

		Optional<User> repoUser = userRepository.findByUsername(user.getUsername());
		if (repoUser.isEmpty())
			throw new UserNotFoundException(user, "The user could not be found in the database");

		return repoUser.get();
	}

	public PasswordlessUser addUser(User user) throws UserAlreadyExistsException {
		User repoUser = null;

		try {
			repoUser = returnUser(user);
		} catch (UserNotFoundException e) {
			userRepository.save(user);
			return userToPasswordless(user);
		}

		PasswordlessUser passwordlessUser = userToPasswordless(user);
		PasswordlessUser passwordlesRepoUser = userToPasswordless(repoUser);

		throw new UserAlreadyExistsException(passwordlessUser, passwordlesRepoUser,
				"The user with the same username already exists in the database");
	}
}