package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SpringIocAopApplication implements CommandLineRunner {

	private final ApplicationContext appContext;

/*	@Slf4jは下記のコードを自動生成
 *
 * 	private static final Logger log = LoggerFactory.getLogger(SpringIocAopApplication.class);
 */


	public static void main(String[] args) {
		SpringApplication.run(SpringIocAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] allBeanNames = appContext.getBeanDefinitionNames(); //IoCコンテナ内のBeanを取得
		for (String beanName: allBeanNames) {
			log.info("Bean名: {}", beanName);
		}
	}

}
