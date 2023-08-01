package br.mic.ggmb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = {"br.mic.ggmb.model"})
@ComponentScan
public class GerenciarGraficaMainBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarGraficaMainBookApplication.class, args);
	}

}
