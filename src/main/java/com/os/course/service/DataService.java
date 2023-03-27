package com.os.course.service;

import com.os.course.model.dto.SportDto;
import com.os.course.model.entity.Sport;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DataService {
    Mono<Void> create(Flux<Sport> dataFlux);

    Mono<SportDto> create(String name);

    Mono<SportDto> getSportBy(String name);
}
