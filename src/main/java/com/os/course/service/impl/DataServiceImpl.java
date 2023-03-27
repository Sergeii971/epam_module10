package com.os.course.service.impl;

import com.os.course.model.dto.SportDto;
import com.os.course.model.entity.Sport;
import com.os.course.model.mapper.SportMapper;
import com.os.course.persistent.repository.SportRepository;
import com.os.course.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DataServiceImpl implements DataService {
    private final SportRepository sportRepository;
    private final SportMapper sportMapper;

    public DataServiceImpl(SportRepository sportRepository,
                           SportMapper sportMapper) {
        this.sportRepository = sportRepository;
        this.sportMapper = sportMapper;
    }

    @Override
    public Mono<Void> create(Flux<Sport> sportPublisher) {
        long numberOfObjects = sportPublisher.count().blockOptional().isPresent() ?
                sportPublisher.count().blockOptional().get() : 0;
        sportRepository.saveAll(sportPublisher)
//                .log()
//                .limitRate(20)
//                .subscribe();
                .log()
                .subscribe(sport -> {},
                err -> log.error(err.getMessage()),
                () -> {},
                subscription -> {
//            for (int i = 0; i < (numberOfObjects / 20); i ++) {
                subscription.request(20);
//            }
        });
        return sportPublisher.then();
    }

    @Override
    public Mono<SportDto> create(String name) {
        Sport sport = new Sport();
        sport.setName(name);
        return sportRepository.save(sport)
                .map(sportMapper::toDto);
    }

    @Override
    public Mono<SportDto> getSportBy(String name) {
        return sportRepository.findByName(name)
                .map(sportMapper::toDto);
    }
}
