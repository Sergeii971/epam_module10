package com.os.course.persistent.repository;

import com.os.course.model.entity.Sport;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SportRepository extends ReactiveCrudRepository<Sport, Integer> {
    Mono<Sport> findByName(@Param("name") String name);
}
