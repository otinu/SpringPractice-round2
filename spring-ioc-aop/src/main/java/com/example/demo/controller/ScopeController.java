package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

// BeanのスコープをHTTPリクエストに設定
@Scope("request")

@RequiredArgsConstructor
@Controller
public class ScopeController {

	private final CoffeeRepository repository;

	@GetMapping("/scope")
	public String showList(Model model) {
		model.addAttribute("toString", this.toString()); 	// ここのthisはローカル変数model ？
		model.addAttribute("allCoffee", repository.findAll());

		return "index";
	}
}
