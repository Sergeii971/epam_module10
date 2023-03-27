package com.os.course.model.mapper;

import com.os.course.model.dto.SportApiDto;
import com.os.course.model.dto.SportDto;
import com.os.course.model.entity.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SportMapper {
    @Mapping(target = "name", source = "attributes.name")
    Sport toSport(SportApiDto sportApiDto);


    SportDto toDto(Sport sport);

    Sport toEntity(SportDto sportDto);
}
