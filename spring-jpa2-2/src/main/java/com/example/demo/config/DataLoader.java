package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

//@Component と implements CommandLineRunner を実装することで、
// Springがこのクラスをスキャンし、コマンドラインとして実行してくれる。
//この機能を「コンポーネントスキャン」という。

// このクラスはモデルやコントローラなどどこからも呼び出される記述がないのに、稼働する。

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

	private final CommentRepository repository;

	/* @RequiredArgsConstructorにより下記のコンストラクタが自動生成
	 *
	 * public DataLoader(CommentRepository repository) {	//この部分が自動生成
	 * 		this.repository = repository;
	 * }
	 */

	@Override
	public void run(String... args) throws Exception {
		Comment comment = new Comment();
		comment.setContent("こんにちは");
		repository.save(comment);

		comment = new Comment();
		comment.setContent("テストコメント");
		repository.save(comment);
	}
}
