package com.Proyect.ModelSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class corsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        CorsConfiguration configConsulta = new CorsConfiguration();

        // permitir solicitudes desde todos los origenes
        // // config.addAllowedOrigin("*");
        config.addAllowedOrigin("http://127.0.0.1:5500");
        configConsulta.addAllowedOrigin("http://127.0.0.1:5500");
        config.addAllowedOrigin("http://127.0.0.1:57015");
        // config.addAllowedOrigin("n cantidad de servidores");

        // permitir solicitudes con estos metodos HTTP
        configConsulta.addAllowedMethod("GET");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");

        // permitir el envio de ciertos encabezados en las solicitudes
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");
        // config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        source.registerCorsConfiguration("/**", configConsulta);
        return new CorsFilter(source);
    }

}
