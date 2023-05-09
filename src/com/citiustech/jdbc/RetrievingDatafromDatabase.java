package com.citiustech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrievingDatafromDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root")){
			System.out.println("Database Connected");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select eno nb ,ename,esal from demo");
			System.out.println("eid\tename\tesal\t");
			System.out.println("----------------------------");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
				
			}
			con.close();
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}

	}

}
