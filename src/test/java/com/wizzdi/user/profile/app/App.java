package com.wizzdi.user.profile.app;

import com.wizzdi.dynamic.properties.converter.EnableDynamicProperties;
import com.wizzdi.flexicore.boot.base.annotations.plugins.EnableFlexiCorePlugins;
import com.wizzdi.flexicore.boot.jpa.annotations.EnableFlexiCoreJPAPlugins;
import com.wizzdi.flexicore.boot.rest.annotations.EnableFlexiCoreRESTPlugins;
import com.wizzdi.flexicore.security.annotations.EnableFlexiCoreSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@EnableFlexiCorePlugins
@EnableFlexiCoreJPAPlugins
@EnableFlexiCoreSecurity
@EnableFlexiCoreRESTPlugins
@SpringBootApplication(scanBasePackages = {"com.wizzdi.user.profile","com.wizzdi.flexicore.file"})
@EnableDynamicProperties
public class App {


	private static final Logger logger= LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(App.class);
		app.addListeners(new ApplicationPidFileWriter());
		ConfigurableApplicationContext context=app.run(args);

	}



	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			System.out.println("total of "+beanNames.length +" beans");



		};
	}
}
