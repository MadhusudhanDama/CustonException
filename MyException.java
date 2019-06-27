package com.tendecoders;
//import com.tendecoders.LibraryManagementDemo;;
public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public 	MyException(String bookId) {
	super(bookId);
	}
}
