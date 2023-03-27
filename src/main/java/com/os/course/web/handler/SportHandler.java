package com.os.course.web.handler;

import com.os.course.model.dto.ErrorDto;
import com.os.course.model.dto.SportDto;
import com.os.course.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class SportHandler {
    private final DataService dataService;

    public SportHandler(DataService dataService) {
        this.dataService = dataService;
    }

    public Mono<ServerResponse> getSportByName(ServerRequest request) {
        String sportName = request.queryParam("q")
                .orElse("");
        return ServerResponse.ok().body(dataService.getSportBy(sportName), SportDto.class);
    }

    public Mono<ServerResponse> createSport(ServerRequest request) {
        return Objects.isNull(dataService.getSportBy(request.pathVariable("sportName")).block()) ?
                ServerResponse.status(HttpStatus.CREATED)
                        .body(dataService.create(request.pathVariable("sportName")), SportDto.class) :
                ServerResponse.badRequest().body(Mono.just(new ErrorDto("resource already exist",
                        HttpStatus.BAD_REQUEST.value())), SportDto.class);
    }
}
