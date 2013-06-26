package com.company.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.product.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home/admin/userPage", method = RequestMethod.GET)
	public ModelAndView addUserPage() {

		ModelAndView modelAndView = new ModelAndView("secure/admin/addUser");
		modelAndView.addObject("user", new com.company.product.domain.User());

		return modelAndView;
	}

	@RequestMapping(value = "/home/showUsers", method = RequestMethod.GET)
	public ModelAndView showUsers(
			@ModelAttribute com.company.product.domain.User user) {

		ModelAndView modelAndView = new ModelAndView("/secure/admin/admin");

		List<com.company.product.domain.User> users = userService.getAllUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("message", "Showing users");

		return modelAndView;

	}

	@RequestMapping(value = "/home/admin/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(
			@Valid @ModelAttribute com.company.product.domain.User user,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("secure/admin/addUser");
		} else {

			ModelAndView modelAndView = new ModelAndView("/secure/admin/admin");
			userService.saveUser(user);

			List<com.company.product.domain.User> users = userService
					.getAllUsers();
			modelAndView.addObject("users", users);

			String message = "User saved successfully.";
			modelAndView.addObject("message", message);

			return modelAndView;
		}

	}

	@RequestMapping(value = "/home/admin/updateUser/{id}", method = RequestMethod.POST)
	public ModelAndView updateUser(@PathVariable Long id,
			@ModelAttribute com.company.product.domain.User user) {
		ModelAndView modelAndView = new ModelAndView("/secure/admin/admin");
		user.setId(id);
		userService.updateUser(user);

		List<com.company.product.domain.User> users = userService.getAllUsers();
		modelAndView.addObject("users", users);

		String message = "User updated successfully.";
		modelAndView.addObject("message", message);

		return modelAndView;

	}

	@RequestMapping(value = "/home/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("secure/admin/editUser");
		com.company.product.domain.User user = userService.getUserById(id);
		modelAndView.addObject("user", user);

		return modelAndView;
	}

	@RequestMapping(value = "/home/deleteUser/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("secure/admin/admin");
		userService.deleteUser(id);
		List<com.company.product.domain.User> users = userService.getAllUsers();
		modelAndView.addObject("users", users);

		String message = "User deleted successfully.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
}
