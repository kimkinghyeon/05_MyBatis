package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application01 {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {

        /*
        MyBatis Mapper 사용방식 두가지

        1. 자바 인테페이스 파일을 사용하는 방법
        -> 추상 메소드에 어노테이션으로 쿼리를 입력하고, getMapper 로 쿼리를 불러와 실행
        -> SQL 구문을 메소드처럼 호출해서 사용하는 장점
        -> 간결해서 가독성이 좋다.
        -> 쿼리문 작성이 힘들다.
        2. xml 파일을 사용하는 방법
        -> xml 에 직접 SQL 문을 정의하여 가져와서 사용
        -> sql 구문을 작성하기 떄문에 복잡한 쿼리 작성할 떄 용이하다.
        -> 태그들을 통해 넓은 방법으로 쓸수 있음
        -> sql 문과 자바 코드가 분리되어있음

        * */

        Environment environment = new Environment(
                "dev",                                      // 환경정보 이름
                new JdbcTransactionFactory(),
                // 수동커밋인지 자동 커밋인지 트랜젝션 매니저 결정 (JDBC OR MANAGED) (수동 or 자동)
                new PooledDataSource(DRIVER, URL, USER, PASSWORD) // ConnectionPoll 사용 유무
        );
                /*
                DB 접속에 관한 환경설정
                --------------------------------
                JDBCTransactionFactory : 수동 커밋
                ManagedTransactionFactory : 자동 커밋
                --------------------------------
                PooledDataSource : ConnectionPoll 사용
                UbPooledDataSource : ConnectionPoll 미사용

                Environment : DB 접속에 관한 환경
                * */

        // 순서 2. Configuration
        Configuration configuration = new Configuration(environment);

        // 순서 3.  configuration 에 Mapper 등록
        configuration.addMapper(Mapper.class);

                /*
                SqlTransactionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
                SqlTransactionFactoryBuilder : SqlTransactionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드

                build() :
                설정에 대한정보를 담고있는 Configuration 타입 객체를 받아 SqlSessionFactory 객체를 반환하는 메소드
                 */

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        /*
        openSession () : SqlSession 인터페이스 타입의 객체를 반환하는 메소드
                         boolean 타입을 인자로 전달
        - false : Connection 인터페이스 타입 객체로 DML 수횅 후
                  Auto commit 에 대한 옵션을 false 로 지정 (권장되는 방식)
        - true : Connection 인터페이스 타입 객체로 DML 수횅 후
                  Auto commit 에 대한 옵션을 true 로 지정
        * * */

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        // getMapper() : configuration 에 등록된 매퍼를 동일 타입에 대해 반환해준다.
        Mapper mapper = sqlSession.getMapper(Mapper.class);

//        Date date = mapper.selectSysdate();
java.util.Date date = mapper.selectSysdate();
        System.out.println(date);

        // close() : SqlSession 객체 반납
        sqlSession.close();
    }
}
