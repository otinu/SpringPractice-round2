package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity	//エンティティであることを指定
public class Book {
    @Id	//主キー指定
    @GeneratedValue	//主キーの値を自動連番
    private Long id;

    private String title;
    private String detail;
}