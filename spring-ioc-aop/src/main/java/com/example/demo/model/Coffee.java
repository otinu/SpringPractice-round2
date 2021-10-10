package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//	application.propertiesの1行目の設定により、テーブル作成をこの@Entityでは実行せず、
//	schema.sqlの自動読み込みで実行する
@Entity
public class Coffee {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

}
