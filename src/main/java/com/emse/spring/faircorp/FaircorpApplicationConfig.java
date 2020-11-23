package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration// (1)
public class FaircorpApplicationConfig {

    @Bean// (2)
    public CommandLineRunner greetingCommandLine(GreetingService greeting_service) { // (3)
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                greeting_service.greet("Spring");// (4)
            }
        };
    }
}
