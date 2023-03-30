package com.example.accessingdatamysql;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

	@Autowired
	private UserMapper userMapper;

	@PostMapping() // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam(required = false) String name
			, @RequestParam(required = false) String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		int a = userMapper.addUser("name111", "email222");
		System.out.println(a);
		return "Saved";
	}

	@GetMapping()
	public @ResponseBody ArrayList<User> getAllUsers() {
		// This returns a JSON or XML with the users
		// return userMapper.findByName("zhangsan");
		return userMapper.findAll();
	}

	@GetMapping(path="/{username}")
	public @ResponseBody User getUser(@PathVariable String username) {
		return userMapper.findByName(username);
	}

	@DeleteMapping()
	public @ResponseBody String deleteAllUsers() {
		userMapper.deleteAll();
		return "All data deleted";
	}

	@PatchMapping()
	public @ResponseBody String updateAllUsers() {
		int a = userMapper.update();
		System.out.println(a);
		return "All data updated";
	}

}
