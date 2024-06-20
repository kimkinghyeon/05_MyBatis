package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /*
    SqlSessionFactory 는 어플리케이션 실행하는 동안 존재해야한다.
    어플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory 를 다시 빌드하지 않는 것이 좋은 형태
    따라서, 어플리케이션 스코프를 관리하기 위한 가장 간단한 싱글톤 패턴을 사용해서 관리한다.
    * * */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        /*
        SqlSessionFactoryBuilder 는 SqlSession 을 생성한 후에 유지할 필요가 없다.
        따라서, 메소드(어플리케이션) 스코프로 만든다.
        * * */

        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";


            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory 의 hashcode() : " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession 의 hashcode() : " + sqlSession.hashCode());
        return sqlSession;
    }
}
