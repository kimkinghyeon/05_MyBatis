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

    public boolean registMenu(MenuDTO menuDTO) {

        SqlSession sqlSession = getsqlSession();

        int result = menuDAO.insertMenu(sqlSession,menuDTO);

        // result 결과 값에 따라서 insert,update,delete 는 트랜젝션 처리를 해줘야함

        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyMenu(MenuDTO menuDTO) {

        SqlSession sqlSession = getsqlSession();

        int result = menuDAO.updateMenu(sqlSession,menuDTO);

        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMenu(int code) {

        SqlSession sqlSession = getsqlSession();

        int result = menuDAO.deleteMenu(sqlSession,code);

        if (result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
