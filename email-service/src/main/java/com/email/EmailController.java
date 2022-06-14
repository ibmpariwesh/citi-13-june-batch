package com.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
	@GetMapping
	public String sendMail() {
		System.out.println("sent");
		return "email sent";
	}
}
