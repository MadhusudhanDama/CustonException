package com.tendecoders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import com.tendecoders.MyException;
public class LibraryManagementDemo {
	DatabaseConnection con=new DatabaseConnection();
	public void init() throws MyException, SQLException {
		
		System.out.println("1.Add Book");
		System.out.println("2.Display Book");
		System.out.println("3.Update Book");
		System.out.println("4.Dlete Book");
		System.out.println("Enter your choice:");
		
		for(int i=0;i<1000;i++) {
			Scanner sc = new Scanner(System.in);		
			int choose = sc.nextInt();	
			switch(choose) {
			case 1 :	
					try {
						 add();
						}catch(Exception e)
					{
							System.out.println("Exception occured:"+e);
					}

				      break;
		   case 2 :
				     display();
				
					  break;
		   case 3 :
					 update();
					
				      break; 
				    
		   case 4 :
			        
			        delete();
			         
					break;
			}
		}
	}
	public void add()throws MyException{
		
				
		try {
			
			  Scanner sc = new Scanner(System.in);
			
			 PreparedStatement ps=con.con.prepareStatement("insert into college_library1 values(?,?,?,?,?)");
			
			 System.out.println("enter id");
			 int bookId=sc.nextInt();
			 if(bookId<10) {
				 throw new MyException("This is book not available in library");	
				
			 }
			 else {
				 System.out.println("continue your process");	
			 }	
			 System.out.println("enter book name");
			 String name=sc.next();
			 System.out.println("enter author name");
			 String AuthorName=sc.next();
			 System.out.println("Enter publisher");
			 String Publisher=sc.next();
			 System.out.println("enter book price");
			 int price=sc.nextInt();

			 ps.setInt(1, bookId);
			 ps.setString(2,name);
			 ps.setString(3,AuthorName);
			 ps.setString(4, Publisher);
			 ps.setInt(5, price);
			
			 int i=ps.executeUpdate();
			 System.out.println("added successfully");
	}catch(Exception e) {
			System.out.println(e);
		}
			}
	
				
	public void display() {
	try {
		  Scanner sc = new Scanner(System.in);
	      PreparedStatement ps=con.con.prepareStatement("select*from college_library1");
          ResultSet rs=ps.executeQuery();
	while(rs.next()) {
	     System.out.println(rs.getInt(1)+"  "+rs.getString(2) +"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));	
	}
	}catch(Exception e) {
		 System.out.println(e);
	}
	   System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}
	public void update() {	
	try {	
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps=con.con.prepareStatement("update college_library1 set bookName=?"+",authorName=?"+",Price=? where BookId=?");  
		System.out.println("Enter id");
		ps.setInt(1, sc.nextInt());
		System.out.println("book name");
		ps.setString(2,sc.next()); 
		System.out.println("author name");
		ps.setString(3, sc.next());
		System.out.println("Enter book Publisher");
		ps.setString(4, sc.next());
		System.out.println("price");
		ps.setInt(5,sc.nextInt());
		 ps.executeUpdate();   
		System.out.println(" records updated");
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}
	}
public void delete()  {
	try {	
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps=con.con.prepareStatement("delete from college_library1 where BookId=?");  		
		System.out.println("enter book id");
		ps.setInt(1,sc.nextInt());  		  
		ps.executeUpdate();  
		System.out.println(" records deleted"); 
		System.out.println("Enter options"+"  "+"1-add"+"  "+"2-display"+"  "+"3-update"+"  "+"4-delete");
	}catch(Exception e) {
		System.out.println(e);
	}	
}	   
public static void main(String[] args) throws MyException, SQLException {
	   LibraryManagementDemo lm = new LibraryManagementDemo();
		lm.init();
		
		
		
	}

}
