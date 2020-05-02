package com.mycoursework.tasker.web.сontrollers;

import com.mycoursework.tasker.configs.Constants;
import com.mycoursework.tasker.services.UserService;
import com.mycoursework.tasker.web.dto.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(Constants.USERS_URLS)
public class UsersController {

	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserProfile>> getUsersList() {
		List<UserProfile>  resToSend = UserProfile.fromUsers(userService.getAllUsers());
		return new ResponseEntity<>(resToSend, HttpStatus.OK);
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserProfile> getUserByUsername(@PathVariable String username) {
		UserProfile res = UserProfile.fromUser(userService.getByUsername(username));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}



}
