package com.example.sb.basicspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.sb.basicspringboot.user.model.User;
import com.example.sb.basicspringboot.user.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class DemoApplication {

	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(UserRepository userDao) {
		return args -> {
			User user1 = new User();
			user1.setFirstName("FTest");
			user1.setLastName("LTest");
			user1.setSalary(12345);
			user1.setAge(23);
			user1.setUsername("one");
			user1.setPassword(passwordEncoder.encode("one"));
			userDao.save(user1);

			User user2 = new User();
			user2.setFirstName("FTest2");
			user2.setLastName("LTest2");
			user2.setSalary(4567);
			user2.setAge(34);
			user2.setUsername("two");
			user2.setPassword(passwordEncoder.encode("two"));
			userDao.save(user2);
		};
	}	
	
	/*
	 * @Bean public WebMvcConfigurer webMvcConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addResourceHandlers( ResourceHandlerRegistry registry )
	 * { registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations(
	 * "classpath:/META-INF/resources/" ); registry.addResourceHandler(
	 * "/webjars/**" ).addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/" ); } }; }
	 */

}
