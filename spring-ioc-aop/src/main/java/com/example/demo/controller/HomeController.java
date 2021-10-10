package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {

		private final ApplicationContext appContext;

		@GetMapping("/")
		public String showList(Model model) {

			// メソッドの引数部分 "coffeeRepository" 先頭小文字に注意
			// getBean()により、IoCコンテナからBeanを取得
			CoffeeRepository repository = (CoffeeRepository)appContext.getBean("coffeeRepository");

			model.addAttribute("toString", this.toString());
			model.addAttribute("allCoffee", repository.findAll());

			return "index";
		}
}
