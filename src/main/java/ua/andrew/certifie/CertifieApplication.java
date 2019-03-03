package ua.andrew.certifie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class CertifieApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertifieApplication.class, args);
    }
}
