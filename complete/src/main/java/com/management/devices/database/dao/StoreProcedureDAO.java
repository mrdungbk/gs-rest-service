package com.management.devices.database.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StoreProcedureDAO {
    public List getAgencyAll(Map<String, String> params){
        SqlSessionFactory sqlSessionFactory = ConnectorFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        List agencies = session.selectList("Agency.getAgencyAll", params);
        session.close();
        return agencies;
    }

    public void login(Map<String, String> params){
        SqlSessionFactory sqlSessionFactory = ConnectorFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        session.selectOne("User.login", params);
        session.close();
    }

    public void logout(Map<String, String> params){
        SqlSessionFactory sqlSessionFactory = ConnectorFactory.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        session.selectOne("User.logout", params);
        session.close();
    }
}
