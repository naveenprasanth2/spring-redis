package com.dailycodebuffer.springredis.model;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String department;
}
