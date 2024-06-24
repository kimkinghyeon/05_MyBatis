package com.ohgiraffers.section03.remix;

import java.util.List;

// 데이터 베이스 접근을 하기 떄문에, DAO 인터페이스
public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(int code);

    int insertMenu(MenuDTO menuDTO);

    int modifyMenu(MenuDTO menuDTO);

    int deleteMenu(int code);
}
