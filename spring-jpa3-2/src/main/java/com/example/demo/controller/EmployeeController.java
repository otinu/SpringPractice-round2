package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EmployeeController {

	private final EmployeeRepository repository;

	// repositoryのコンストラクタは自動生成され、オブジェクトはIoCから注入される

	@GetMapping("/")
	public String showList(Model model) {
		model.addAttribute("employees", repository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		return "form";
	}


	@PostMapping("/process")
	public String process(@Validated @ModelAttribute Employee employee, BindingResult result) {

		if(result.hasErrors()) {
			return "form";
		}
		repository.save(employee);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")

	// @PathVariable によって、パスの値を変数に格納する
	// ⇒「http://localhost:8080/edit/2」にアクセスすると、「2」が取得できる
	public String editEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee", repository.findById(id));
		return "form";
	}
}
