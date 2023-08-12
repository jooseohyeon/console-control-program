package com.ohgiraffers.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER = "C##OHGIRAFFERS";
    private static String PASSWORD = "OHGIRAFFERS";

    /* SqlSessionFactory는 애플리케이션이 실행되는 동안 존재해야하며,
    * 여러 차례 다시 빌드하지 않는 것이 가장 좋은 형태이다.
    * 애플리케이션 스코프를 관리하기 위해 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다. */
    private static SqlSessionFactory sqlSessionFactory;
    //static을 붙여서 클래식 변수로 만들어 프로그램이 실행 될 때 저장공간이 생기도록 만드러

    public static SqlSession getSqlSession(){

        if(sqlSessionFactory == null){  //최초로 호출될 때 sqlsession을 최초로 생성하는 코두
            Environment environment = new Environment("dev"
                    , new JdbcTransactionFactory()
                    , new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(TravelMapper.class);
            //클래스 타입을 전달해줘야함ㅁ

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        /* SqlSession은 스레드에 안전하지 않고 공유 되지 않아야 하므로 요청 시마다 생성해야 한다. */
        SqlSession sqlSession = sqlSessionFactory.openSession(false);

//        System.out.println("sqlSessionFactory의 hashCode() :" + sqlSessionFactory.hashCode());
//        System.out.println("SqlSession의 hashCode() : " + sqlSession.hashCode());

        return sqlSession;
    }
}
