package com.scyllacore.jblogweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class JBlogWebApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void passwordEncode(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPwd = "asd123!";
		String encodedPwd = encoder.encode(rawPwd);

		System.out.println("원본 : " + rawPwd);
		System.out.println("인코딩 : " + encodedPwd);
		System.out.println("비교 : " + encoder.matches(rawPwd,encodedPwd));
	}

}
