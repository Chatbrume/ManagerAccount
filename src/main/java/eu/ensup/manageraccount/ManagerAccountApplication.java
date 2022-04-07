package eu.ensup.manageraccount;

import eu.ensup.manageraccount.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ManagerAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerAccountApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Account.class);
        };
    }
}