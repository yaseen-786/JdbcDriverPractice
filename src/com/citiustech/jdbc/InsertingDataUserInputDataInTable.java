package com.citiustech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class InsertingDataUserInputDataInTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root") ){
			System.out.println("Database Connected Sucessfully");
			Scanner sc = new Scanner(System.in);
			Statement st = con.createStatement();
			while(true){
				System.out.println("Enter the id");
				int eno = sc.nextInt();
				System.out.println("Enter the name");
				String ename = sc.next();
				System.out.println("Enter the salary");
				int sal = sc.nextInt();
				System.out.println("Enter yes to continue no to exit");
				String flag = sc.next();
				String sql = "insert into demo values("+eno+",'"+ename+"',"+sal+")";
				st.executeUpdate(sql);
				
				System.out.println("Query Inserted");
				if(flag.toLowerCase().equals("no")){
					con.close();
					
					
					System.exit(0);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
