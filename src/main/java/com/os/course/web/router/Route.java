package com.os.course.web.router;

import com.os.course.web.handler.SportHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class Route {
    @Bean
    public RouterFunction<ServerResponse> getSportByName(SportHandler handler) {
        return route(GET("/api/v1/sports").and(accept(MediaType.APPLICATION_JSON)), handler::getSportByName)
                .andRoute(POST("/api/v1/sports/{sportName}"), handler::createSport);
    }
}
