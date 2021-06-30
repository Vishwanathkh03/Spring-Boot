package org.vishwa.springboot.employeeportal;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeProtalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProtalApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
	    return modelMapper;
	}

}
