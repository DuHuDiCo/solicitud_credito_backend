package com.estudio_credito_preaprobado.estudio_credito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication //Para indicarle a SpringBoot que esta es la clase de entrada del proyecto y además una clase de 'Configuracion'.
public class EstudioCreditoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EstudioCreditoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EstudioCreditoApplication.class);
    }

}
