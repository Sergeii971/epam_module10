package com.os.course.web.controller;

import com.os.course.model.entity.Sport;
import com.os.course.service.DataService;
import com.os.course.util.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/data")
public class DataObjectController {
    private final DataService dataService;
    private final DataUtil dataUtil;

    public DataObjectController(DataService dataService, DataUtil dataUtil) {
        this.dataService = dataService;
        this.dataUtil = dataUtil;
    }
    @PostMapping("/sports")
    Mono<Void> create() {
        Flux<Sport> sportFlux = dataUtil.getResponse();
        return dataService.create(sportFlux).then();
    }
}
