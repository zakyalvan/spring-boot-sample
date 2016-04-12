package sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SampleApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(SampleApplication.class)
				.web(true)
				.run(args);
	}
}
