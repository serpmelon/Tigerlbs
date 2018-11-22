package com.neuqsoft.mysqlshell;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neuqsoft.mysqlshell.conf.Properties;
import com.neuqsoft.mysqlshell.db.Database;

/**
 * Hello world!
 *
 */
public class App {
	
	@Autowired
	Properties pp;
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Database.class);
		context.refresh();
		Database base = (Database) context.getBean("Database");
		System.out.println(base.a);
		try {
			base.insert();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String sql = "select * from t_user";
//		Database db = new Database();
//		try {
//			db.insert();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		Properties p1 = new Properties();
//		p1.print();
	}
}
