package com.company.product.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private boolean isRolePresent(Collection<GrantedAuthority> authorities,
			String role) {
		boolean isRolePresent = false;
		for (GrantedAuthority grantedAuthority : authorities) {
			isRolePresent = grantedAuthority.getAuthority().equals(role);
			if (isRolePresent)
				break;
		}
		return isRolePresent;
	}


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		if (isRolePresent(SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities(), "ROLE_NORMAL")) {
			model.addAttribute("isAdmin", false);
			model.addAttribute("message", "User has role ROLE_NORMAL");
			return "/landingPage";
		}

		else if (isRolePresent(SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities(), "ROLE_ADMIN")) {
			model.addAttribute("isAdmin", true);
			model.addAttribute("message", "User has role ROLE_ADMIN");
			return "/landingPage";
		} else
			return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("isLogedIn", true);
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "login";

	}

}