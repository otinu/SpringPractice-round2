package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Controller
public class CommentController {

	// フィールドをfinalにできる
	private final CommentRepository repository;

	// コンストラクタインジェクション
	// Springがオブジェクトを管理・注入する
	public CommentController(CommentRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")

	// 一見、「@ModelAttribute Comment comment」は必要ないように見えるものの、これがないとエラーが発生してしまう。
	public String getAllComments(@ModelAttribute Comment comment, Model model) {
		model.addAttribute("comments", repository.findAll());
		return "list";
	}

	@PostMapping("/add")
	public String addComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "list";
		}

		// 下記の2行は順番が前後逆でも結果は同じになる。
		// 「DBに保存」 ⇒ 「DBから全件取得」 という処理の流れではない様子

		repository.save(comment); //おそらく、この行はDataLoaderクラスの機能で正常に動作する。
		model.addAttribute("comment", repository.findAll());

		// 順序が逆でも動作するのは、もしかするとfindAll()の実行タイミングはリダイレクトする直前なのかもしれない。

		return "redirect:/";
	}
}
