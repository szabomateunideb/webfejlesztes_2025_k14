package hu.unideb.inf.autokolcsonzo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.modelmbean.ModelMBean;

@SpringBootApplication
public class AutokolcsonzoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutokolcsonzoApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper m = new ModelMapper();
		return m;
	}

}
