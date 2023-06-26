package com.wadajo.clima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestClimaApplication {

	public static void main(String[] args) {
		SpringApplication.from(ClimaApplication::main).with(TestClimaApplication.class).run(args);
	}

}
