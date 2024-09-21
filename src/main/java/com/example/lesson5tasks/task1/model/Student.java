package com.example.lesson5tasks.task1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    private int id;
    private String full_name;
    private LocalDateTime create_at;
    private int group_id;
    private int age;
}
