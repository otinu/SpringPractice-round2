package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

	@GetMapping("/")
	public String greeting() {
		return "hello";
	}

	//パターン①

	@GetMapping("/greeting")
	public String greeting(@RequestParam("message") String reciever, Model model) {
		model.addAttribute("sample", reciever );
		return "hello";
	}

	/*	パターン②
	 *
	 * @GetMapping("/greeting")
		public String greeting(@RequestParam(required = false) String message, Model model) {
		model.addAttribute("sample", reciever);
		return "hello";
	 */
}




/* 18行目 @RequestParam("message") String reciever について
 *
 * @RequestParam("message")の部分でパラメータを取得できるようになる。
 * 例えば、 http://localhost:8080/greeting?message=tinu とアクセスすれば
 * パラメータとして「message=tinu」がコントローラに送られる。
 *
 * リクエストパラメータを String reciever が受け取る(reciever = tinu)となる。
 *
 *
 *
 * model.addAttribute("sample", reciever);について
 *
 * modelにaddAttributeを渡すことでthymeleafへのレスポンスをする。
 * この場合、「"sample" = tinu(recieverの値)」となる。
 *
 * 「return "hello"」とあるため、hello.html にレスポンスが返る。
 */



/*	パターン②について
 *
 * パターン①では、http://localhost:8080/greeting だとエラーになってしまう(ルートパスは問題ないのに)。
 * そこで、@RequestParam(required = false) とするとルートパスへのアクセスと同じ挙動になる。
 *
 * パターン①の場合、「リクエスト元からの"message"をrecieverで受け取る」ようになっているが、
 * パターン②では「messageで受け取る」ようにしか見受けられない。
 * パターン②では、暗黙的に「リクエスト元からの"message"をmessageで受け取る」ようになっている。
 */






















