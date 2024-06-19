package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getsqlSession;

public class MenuService {

    /*
    Service

    비즈니스 로직을 수행하느 클래스라고한다.
    주로 DAO 가 DB 에서 받아온 데이터를 전달받아 가공해 Controller 로 return 해준다.,

    Mybatis 에서 Service 의 역할
    1. SqlSession 생성 및 닫기
    2. DAO(데이터 베이스 접근 객체) 의 메소드 호출
    3. 트랙젝션(commit,rollback) 제어
    * */

    private final MenuDAO menuDAO;

    // 생성자 주입
    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> selectAllMenu() {

        // 세션 열어주기
        SqlSession sqlSession = getsqlSession();

        // MenuDAo
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        // 세션 열어주기
        SqlSession sqlSession = getsqlSession();

        MenuDTO menuDTO = menuDAO.selectMenuByCode(sqlSession, code);

        sqlSession.close();

        return menuDTO;
    }
}
