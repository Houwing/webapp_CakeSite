package houwing.top.cake_site.global;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class DaoFactory {
    /*
    * 单例模式
    * →确保该对象一个项目只创建一次
    * 1. 创建该类成员变量
    * 2. 构造方法私有化
    * 3. 提供公有的静态的获取变量方法
    * */
    private static  DaoFactory daoFactory;
    private SqlSessionFactory sessionFactory;
    private DaoFactory(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        try {
            sessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static DaoFactory getInstance(){
        if(daoFactory==null)
            daoFactory=new DaoFactory();
        return daoFactory;
    }
    public <T> T getDao(Class<T> tClass){

        //自动提交
        return sessionFactory.openSession(true).getMapper(tClass);
    }
}
