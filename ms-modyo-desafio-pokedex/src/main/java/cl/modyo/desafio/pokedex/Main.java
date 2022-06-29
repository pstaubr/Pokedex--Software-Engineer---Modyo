package cl.modyo.desafio.pokedex;
/**
 * @author pstaubr
 * Desafío Software Engineer - Modyo
 * Pablo Staub Ramirez
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cl.modyo.desafio.pokedex"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
