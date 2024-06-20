package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    /*
    DAO (Date Access Object)
    DB 의 데이터에 접근하기 위한 객체를 의미한다.
    DB 에 접근하는 로직을 분리하기 위해 사용함
    * * */

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession){

        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode",code);

    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menuDTO) {

        return sqlSession.insert("MenuMapper.insertMenu",menuDTO);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menuDTO) {

        return sqlSession.update("MenuMapper.updateMenu",menuDTO);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {

        return sqlSession.delete("MenuMapper.deleteMenu",code);
    }
}
