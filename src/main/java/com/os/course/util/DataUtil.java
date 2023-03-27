package com.os.course.util;

import com.os.course.model.dto.DataObjectDto;
import com.os.course.model.entity.Sport;
import com.os.course.model.mapper.SportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class DataUtil {

    @Autowired
    private WebClient webClient;

    @Autowired
    private SportMapper sportMapper;

    public Flux<Sport> getResponse() {
        return webClient.get()
                .uri("/sports")
                .retrieve()
                .bodyToMono(DataObjectDto.class)
                .flatMapMany(dataObjectDto -> Flux.fromIterable(dataObjectDto.getSports()))
                .map(sportMapper::toSport);
    }
}
