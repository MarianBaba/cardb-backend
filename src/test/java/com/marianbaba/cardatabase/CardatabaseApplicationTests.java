package com.marianbaba.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marianbaba.cardatabase.web.CarController;

@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarController controller;
	
	@Test
	@DisplayName("First test")
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
