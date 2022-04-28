package com.mis.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {

	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "MIS2022";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception {
		
		// 1) JDBC 드라이버 로드
		Class.forName(DRIVER);
		
		// 2) 데이터베이스 접속
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println("JUNIT : " + conn);
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		};
		
	}
	
}
