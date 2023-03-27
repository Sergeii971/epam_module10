package com.os.course.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SportApiDto implements BaseDto {
    private AttributeDto attributes;

}
