package com.example.lesson5tasks.task1.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Groups {
    private int id;
    private String group_name;
    private LocalDateTime create_at;
    private int count;
}
