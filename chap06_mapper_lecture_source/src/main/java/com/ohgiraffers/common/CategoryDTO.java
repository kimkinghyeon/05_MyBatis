package com.ohgiraffers.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class CategoryDTO {
    private int code;
    private String name;
    private Integer refCategoryCode;
}
