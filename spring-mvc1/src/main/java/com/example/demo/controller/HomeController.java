package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;

@Controller
public class HomeController {

	@GetMapping("/form")
	private String readForm(@ModelAttribute User user) {
		return "form";
	}

	@PostMapping("/form")
	private String confirm(@ModelAttribute User user) {
		return "confirm";
	}

	/*	上記のコードはmodelの部分が省略されても機能するようになっている。
	 * 	これはデータバインディングのおかげ。

	    @PostMapping("/form")
		private String confirm(@ModelAttribute User user, Model model) {
			model.addAttribute("user", user);
			return "confirm";
		}
	 */
}
