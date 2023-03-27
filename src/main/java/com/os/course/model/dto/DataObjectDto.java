package com.os.course.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataObjectDto implements BaseDto {
    @JsonProperty("data")
   List<SportApiDto> sports = new ArrayList<>();

}