package com.neuqsoft.mysqlshell.db;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Database.class)
public class DatabaseTest {

	@Autowired
	private Database base;

	@Test
	public void queryTest() throws ClassNotFoundException, SQLException {

		String sql = "select age from t_user where name = ?";
		Object[] obj = new Object[] { "ai" };
		assertNotNull(base.query(sql, Arrays.asList(obj)));
		assertEquals("21", base.query(sql, Arrays.asList(obj)));
		String sql1 = "select age from t_user";
		assertEquals("21", base.query(sql1));
	}
}
