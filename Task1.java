package management;

import java.sql.*;
import java.util.Scanner;

public class Task1
{
	static Connection con;
	public static Connection conn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/Mithun","root","");
			//System.out.println("Connection Succesful");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static void main(String[] args) throws SQLException
	{
		int ch;
		System.out.println("CONTENT MANAGEMENT SYSTEM \n");
		while(0==0)
		{
			System.out.println("1.Add a new contact\n");
			System.out.println("2.View the contact \n");
			System.out.println("3.Edit the existing contact \n");
			System.out.println("4.Delete the contact \n");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:add();break;
			case 2:view();break;
			case 3:edit();break;
			case 4:delete();break;
			case 5:exit();break;
			}
		}
		
		
	}
	private static void exit() 
	{
		System.exit(0);
		
	}
	private static void edit() throws SQLException
	{
		String querry="Select name from employee";
		Connection con=conn();
		Statement statement=con.createStatement();
		ResultSet output=statement.executeQuery(querry);
		System.out.println("Names:");
		while(output.next()) {
			String name=output.getString("name");
			System.out.println(name);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a name for edit their details:");
		String prename=sc.next();
		String querry1="update employee set name=?,phone=?,mail_id=? where name=?";
		System.out.println("Enter your new name:");
		String name,email;
		name=sc.next();
		System.out.println("Enter your new Email:");
		email=sc.next();
		System.out.println("Enter the new phone number:");
		double number=sc.nextDouble();
		try {
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(querry1);
			ps.setString(1, name);
			ps.setDouble(2, number);
			ps.setString(3, email);
			ps.setString(4, prename);
			ps.execute();
			System.out.println("Contact inserted successfully...........!\n\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Successfully updated...........!\n");
		
		
		
	}
	private static Connection conection() {
		// TODO Auto-generated method stub
		return null;
	}
	private static void delete() throws SQLException 
	{
		System.out.println("Click 1 to delete a particular data");
		System.out.println("Click 2 to delete entire data ");
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		Connection cn=conn();
		
		if(n==1)
		{
			String query="Select *from employee";
			Statement s=cn.createStatement();
			ResultSet output=s.executeQuery(query);
			
			System.out.println("Names");
			while(output.next())
			{
				String name=output.getString("name");
				System.out.println(name);
			}
			System.out.println("Enter the name to delete a particular data:");
			String name;
			name=sc.next();
			String query1="delete from employee where name=?";
			PreparedStatement ps=cn.prepareStatement(query1);
			ps.setString(1, name);
			ps.execute();
			System.out.println("Succesfully deleted a selected data");
		}
		else if(n==2)
		{
			String query="delete from employee";
			PreparedStatement ps=cn.prepareStatement(query);
			ps.execute();
			System.out.println("Successfully deleted the entire data");
		}
		else
		{
			System.out.println("please select the mentioned above option only");
		}
		
	}
	private static void view() throws SQLException 
	{
		String query="Select * from employee";
		Connection cn=conn();
		int count=1;
		System.out.println("\n");
		Statement s=cn.createStatement();
		ResultSet output=s.executeQuery(query);
		while(output.next())
		{
			String name=output.getString("name");
			String mail=output.getString("mail_id");
			String phone=output.getString("phone");
			System.out.println(count+".Name:"+name+"\n  Mail id:"+mail+"\n  Phone Number:"+phone);
		}
		
	}
	private static void add()
	{
		String name,mail;
		double phone;
		String querry="insert into employee values(?,?,?)";
		System.out.println("Enter your name");
		Scanner sc=new Scanner(System.in);
		name=sc.next();
		
		System.out.println("Enter your mail");
		mail=sc.next();
		
		System.out.println("Enter your Phone Number");
		phone=sc.nextDouble();
		
		System.out.println("\n");
		Connection cn=conn();
		try 
		{
			PreparedStatement ps=(PreparedStatement) cn.prepareStatement(querry);
			ps.setString(1, name);
			ps.setString(2, mail);
			ps.setDouble(3, phone);
			ps.execute();
			System.out.println("Contact inserted successfully...........!\n\n");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

