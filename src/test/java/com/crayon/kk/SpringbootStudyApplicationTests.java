package com.crayon.kk;

import com.crayon.kk.service.impl.AopServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootStudyApplicationTests {

	@Autowired
	private AopServiceImpl  aopService;

	@Test
	void contextLoads() {
		System.out.println("test");
	}

	@Test
	public void aopTest(){
		aopService.processData(10,2);
	}

}
