package com.example.chartographer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ChartographerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		Map<String, String> m = new HashMap<>();
		try {
			m.get("key");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
