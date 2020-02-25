package com.sinan.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBUtil {
    private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory factory = null;

    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            factory = builder.build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        SqlSession session = tol.get();
        if (session == null) {
            session = factory.openSession();
            tol.set(session);
        }
        return session;
    }

    public static Object getDao(Class dao) {
        SqlSession session = openSession();
        return session.getMapper(dao);
    }

    public static void close() {
        SqlSession session = openSession();
        session.close();
        tol.remove();
    }

    public static void rollBack() {
        SqlSession session = openSession();
        session.rollback();
        close();
    }

    public static void commit() {
        SqlSession session = openSession();
        session.commit();
        close();
    }
}
