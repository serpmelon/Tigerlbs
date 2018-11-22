package com.neuqsoft.mysqlshell.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.neuqsoft.mysqlshell.common.MD5;
import com.neuqsoft.mysqlshell.common.UuidUtil;

@Configuration
@Component("Database")
@ComponentScan
public class Database {
	
	public String a = "123";
	private final String driver = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://192.168.67.233:3306/hlwjzwfw_outer_test";
	private final String username = "hlwjzwfw";
	private final String password = "hlwjzwfw1";

	public void query(String sql) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {

			System.out.println(result.getString(1));
		}
	}

	public void insert() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql1 = "INSERT INTO t_account (id,account,password,user_id,account_category_code,enabled) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt1 = connection.prepareStatement(sql1);
		String sql2 = "INSERT INTO t_user (id,name,default_account_id,user_category_code,org_code,status) "
				+ "VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt2 = connection.prepareStatement(sql2);
		
		for (int i = 0; i < 1000; i++) {

			String accountId = UuidUtil.idNoline();
			String userId = UuidUtil.idNoline();
			pstmt1.setString(1, accountId);
			pstmt1.setString(2, "tyn"+i);
			pstmt1.setString(3, MD5.md5("tyn"+i + "1"));
			pstmt1.setString(4, userId);
			pstmt1.setString(5, "1");
			pstmt1.setString(6, "1");

			pstmt2.setString(1, userId);
			pstmt2.setString(2, "tyn"+i);
			pstmt2.setString(3, accountId);
			pstmt2.setString(4, "officer");
			pstmt2.setString(5, "SN7ifYch.9RTA35rp.turFEGHO");
			pstmt2.setString(6, "1");
			
			pstmt1.executeUpdate();
			pstmt2.executeUpdate();
			System.out.println(i);
		}

	}
}
