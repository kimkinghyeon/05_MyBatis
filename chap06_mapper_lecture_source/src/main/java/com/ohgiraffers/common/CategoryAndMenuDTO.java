package com.ohgiraffers.common;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryAndMenuDTO {
    private int code;
    private String name;
    private Integer refCategoryCode;

    private List<MenuDTO> menuList;


}
