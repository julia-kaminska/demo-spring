package pl.kaminska.julia.demo.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kaminska.julia.demo.spring.repository.TranslationRepository;

@SpringBootTest
class DemoSpringApplicationTests {

	@Autowired
	TranslationRepository translationRepository;

	@Test
	void contextLoads() {
	}

}
