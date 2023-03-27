package com.os.course.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Sport implements BaseEntity {
    @Id
    private Integer id;
    private String name;

}
