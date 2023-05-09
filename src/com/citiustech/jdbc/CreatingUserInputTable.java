package com.citiustech.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CreatingUserInputTable {
	
	public static void main(String[] args) throws Exception{
		try
			//Class.forName("com.mysql.cj.jdbc.Driver");
			(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root")){
			
			System.out.println("Database Connected succesfully");
			//prepare Statement
			try(Statement st=con.createStatement()){
			//create BufferedReader
			Scanner sc=new Scanner(System.in);
			//take table name as dynamic input
			System.out.println("Enter table name");
			String tname=(String)sc.next();
			//prepare SQLQuery
			
			String sql="create table " + tname + "(eno int,ename varchar(10),esal int)";
			//execute SQL Query
			st.execute(sql);
			System.out.println("Query executed sucessfully");
			con.close();
			}catch(Exception e){
				System.out.println("Query not executed");
			}
		}catch(Exception e){
			System.out.println("Database not Connected Sucessfully");
		}
		
	}

}
