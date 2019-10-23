package vercauteren.laurens.funiversity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "vercauteren.laurens.funiversity")
@EnableSwagger2
public class FuniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuniversityApplication.class, args);
	}

}
