package com.yc.mavemybatis;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yc.bean.Classes;
import com.yc.bean.Teacher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp() throws IOException
    {
    			String resource = "mybatis-config.xml";
    			InputStream inputStream = Resources.getResourceAsStream(resource);
    			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    			//System.out.println(sqlSessionFactory.toString());
    			
    			SqlSession session = sqlSessionFactory.openSession();
    			try {
    				// selectONe(mapper路径+查询语句id, 用户id)
    				//Users user=new Users("taoge","cc");
//    			Users u = session.selectOne("com.yc.mapper.UserMapper.userInsert", user);
    			Teacher t=session.selectOne("com.yc.mapper.UserMapper.selectTeacher3",1);
//    			session.commit();
    			//Teacher u1 = session.selectOne("com.yc.mapper.UserMapper.selectUser", 3);
    			System.out.println(t);
    			} finally {
    			session.close();
    			}
    	
    

    }
    public void testApp1() throws IOException
    {
    			String resource = "mybatis-config.xml";
    			InputStream inputStream = Resources.getResourceAsStream(resource);
    			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    			//System.out.println(sqlSessionFactory.toString());
    			
    			SqlSession session = sqlSessionFactory.openSession();
    			try {
    				// selectONe(mapper路径+查询语句id, 用户id)
    				//Users user=new Users("taoge","cc");
//    			Users u = session.selectOne("com.yc.mapper.UserMapper.userInsert", user);
    			Classes t=session.selectOne("com.yc.mapper.UserMapper.selectTeacher4",1);
//    			session.commit();
    			//Teacher u1 = session.selectOne("com.yc.mapper.UserMapper.selectUser", 3);
    			System.out.println(t);
    			} finally {
    			session.close();
    			}
    	
    

    }
}
