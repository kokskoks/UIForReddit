package pl.lodz.p.edu.ppkwu.ind187824and179640;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.lodz.p.iis.ppkwu.reddit.api.Reddit;
import pl.lodz.p.iis.ppkwu.reddit.api.Util;

@SpringBootApplication
public class UiforspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiforspringApplication.class, args);
	}
	
	@Bean
	public Reddit reddit(){
		return Util.redditBuilder().build();
	}

}
