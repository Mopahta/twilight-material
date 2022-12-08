package by.bsuir.Kaminsky.server.ImplemenationLayer;

import java.util.ArrayList;
import by.bsuir.Kaminsky.server.DataAccessLayer.DaoFactory;
import by.bsuir.Kaminsky.models.Book;


public class BookLogic {
		
	/** Get books by author */
	public static ArrayList<Object> findBooksByAuthor(String author,int action){
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getBooksByAuthor(author));	
		 		 		
		message.add(action);
		message.add(true);
		message.add(books);	
		System.out.println("<action> Get books by author '"+author+"'");
		return message;	
    }
	
	/** Get books by title */
	public static ArrayList<Object> findBooksByTitle(String title,int action){
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getBooksByTitle(title));	
		 			 
		message.add(action);
		message.add(true);
		message.add(books);
		System.out.println("<action> Get books by title '"+title+"'");
		return message;		 			 
    }
	
	/** Get paper books*/
	public static ArrayList<Object> findPaperBooks(int action){
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getPaperBooks());
		
		message.add(action);
		message.add(true);
		message.add(books);
		System.out.println("<action> Get paper books");
		return message;	
    }
	
	/** Get electronic books */
	public static ArrayList<Object> findElectonicBooks(int action){
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getElectonicBooks());
		
		message.add(action);
		message.add(true);
		message.add(books);
		System.out.println("<action> Get electronic books");
		return message;
    }
	
	/** Get all books */
	public static ArrayList<Object> getBooks(int action){
		ArrayList<Object> message = new ArrayList<Object>();
		ArrayList<Object> books = new ArrayList<Object>(DaoFactory.getBookDao().getBooks());
		
		message.add(action);
		message.add(true);
		message.add(books);
		System.out.println("<action> Get all books");
		return message;
	}
	
	/** Add book */
	public static ArrayList<Object> addBook(Object[] data,int action) {
		Book book;
		ArrayList<Object> message = new ArrayList<Object>();	
		
		message.add(action);
		book = new Book((String)data[0],(String)data[1],(Boolean)data[2]);
		if (!DaoFactory.getBookDao().save(book)) {
			message.add(false);
			message.add("Book already exists");
			System.out.println("<warning> Book already exists!");
		}
		else {	
			message.add(true);
			message.add("Book was added");
			System.out.println("<action> Book was added");
		}
		return message;
	}
	
	/** Delete book */
	public static ArrayList<Object> deleteBook(Object[] data,int action) {
		Book book;
		ArrayList<Object> message = new ArrayList<Object>();	
		
		message.add(action);
		book = new Book((String)data[0],(String)data[1],(Boolean)data[2]);
		if (!DaoFactory.getBookDao().delete(book)) {
			message.add(false);
			message.add("Book not found");
			System.out.println("<warning> Book not found!");
		}
		else {
			message.add(true);
			message.add("Book was deleted");
			System.out.println("<action> Book was deleted");
		}
		return message;
	}
	
	/** Modify book */
	public static ArrayList<Object> modifyBook(Object[] data,int action) {
		Book bookOld,bookNew;
		ArrayList<Object> message = new ArrayList<Object>();
		
		message.add(action);
		bookOld = new Book((String)data[0],(String)data[1],(Boolean)data[2]);
		bookNew = new Book((String)data[3],(String)data[4],(Boolean)data[5]);
		if (!DaoFactory.getBookDao().replace(bookOld, bookNew)) {
			message.add(false);
			message.add("Book not found");
			System.out.println("<warning> Book not found!");
		}
		else {
			message.add(true);
			message.add("Book was modified");
			System.out.println("<action> Book was modified");
		}
		return message;
	}
	
}
