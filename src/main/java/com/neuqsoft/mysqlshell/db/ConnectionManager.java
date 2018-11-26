package com.neuqsoft.mysqlshell.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
// 指定配置文件，classpath路径根为src/main/resources/
// @PropertySource只能读取properties文件
@PropertySource({ "classpath:application.properties" })
public class ConnectionManager {

	@Value("${spring.database.driver}")
	private String driver;
	@Value("${spring.database.url}")
	private String url;
	@Value("${spring.database.name}")
	private String username;
	@Value("${spring.database.password}")
	private String password;

	public Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
