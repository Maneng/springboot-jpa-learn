package com.maneng.jpa.demo;

import com.maneng.jpa.demo.config.enable.EnableServer;
import com.maneng.jpa.demo.config.enable.Server;
import com.maneng.jpa.demo.config.enable.ServerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableServer(type = ServerType.FTP)
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		Server server = applicationContext.getBean(Server.class);
		server.run();
		server.stop();
	}

}
