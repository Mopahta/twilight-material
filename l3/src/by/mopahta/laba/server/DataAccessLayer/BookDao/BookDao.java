package by.bsuir.Kaminsky.server.DataAccessLayer.BookDao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import by.bsuir.Kaminsky.models.Book;


public class BookDao implements IBookDao{
	
	/** Path to books database */
	private String fileName;
	
	/** Constructor set the path to books database */	
	public BookDao()
	{
		fileName = getDatabasePath();
	}
		
	/**
	 * Delete book from books database
	 * @param book - Book entity
	 * @return true if book was successfully deleted from books database,else return false
	 */
	public Boolean delete(Book book) {
		int counter = 0;
		Boolean flag = false;
		ArrayList<Book> books = getBooks();
		
		for (Book currentBook : books) {
			if (currentBook.equals(book)){	
				flag = true;
				break;
			}
			counter++;
		}
		if (flag)
		{			
			books.remove(counter);
			try {
				SerializeBooks(books, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * Save book to books database
	 * @param book - Book entity
	 * @return true if book was successfully added to books database,else return false
	 */
	public Boolean save(Book book) {
		Boolean flag = false;
		File f = new File(fileName);	
		Book searchBook = null;
		ArrayList<Book> books = getBooks();		
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		for (Book currentBook : books) {
			if (currentBook.equals(book))
			{
				searchBook = currentBook;
				break;
			}
		}
		if (searchBook == null)
		{
			books.add(book);
			flag = true;
				
			try {
				SerializeBooks(books, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		return flag;
	}
	
	/**
	 * Replace book from books database by new book
	 * @param bookOld - Old book entity
	 * @param bookNew - New book entity
	 * @return true if book was successfully replace by new book,else return false
	 */
	public Boolean replace(Book bookOld,Book bookNew) {
		int counter = 0;
		Boolean flag = false;
		ArrayList<Book> books = getBooks();
		
		for (Book currentBook : books) {
			if (currentBook.equals(bookOld)){	
				flag = true;
				break;
			}
			counter++;
		}
		if (flag)
		{			
			books.remove(counter);
			books.add(counter, bookNew);
			try {
				SerializeBooks(books, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * Give all books from books database
	 * @return list of books if they was successfully load from database, else return empty list
	 */
	public ArrayList<Book> getBooks(){
		File f = new File(fileName);
		ArrayList<Book> books = new ArrayList<Book>();
					
		if(f.exists() && !f.isDirectory()) {			
			try {
				books = DeserializeBooks(fileName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
		return books;
	}
	
	/**
	 * Give all books with specified title from books database
	 * @param title - Book title
	 * @return list of books if they was successfully load from database, else return empty list
	 */
	public ArrayList<Book> getBooksByTitle(String title){
		ArrayList<Book> books = getBooks();
		ArrayList<Book> result= new ArrayList<Book>();
		
		for (Book book : books) {
			if ((book.getTitle().toLowerCase()).equals(title.toLowerCase()))
				result.add(book);
		}
		return result;
	}
	
	/**
	 * Give all books by specified author from books database
	 * @param author - Book author
	 * @return list of books if they was successfully load from database, else return empty list
	 */
	public ArrayList<Book> getBooksByAuthor(String author){
		ArrayList<Book> books = getBooks();
		ArrayList<Book> result= new ArrayList<Book>();
		
		for (Book book : books) {
			if ((book.getAuthor().toLowerCase()).equals(author.toLowerCase()))
				result.add(book);
		}
		return result;
	}
	
	/**
	 * Give all paper books from books database
	 * @return list of books if they was successfully load from database, else return empty list
	 */
	public ArrayList<Book> getPaperBooks(){
		ArrayList<Book> books = getBooks();
		ArrayList<Book> result= new ArrayList<Book>();
		
		for (Book book : books) {
			if (!book.getIsElectronic())
				result.add(book);
		}
		return result;
	}
	
	/**
	 * Give all electronic books from books database
	 * @return list of books if they was successfully load from database, else return empty list
	 */
	public ArrayList<Book> getElectonicBooks(){
		ArrayList<Book> books = getBooks();
		ArrayList<Book> result= new ArrayList<Book>();
		
		for (Book book : books) {
			if (book.getIsElectronic())
				result.add(book);
		}
		return result;
	}
	
	 /**
     * Serialize list of book entities to book database
     * @param books - List of book entities
     * @param fileName - path to books database
     */
	private void SerializeBooks(ArrayList<Book> books,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
	    XMLEncoder encoder = new XMLEncoder(fileStream);
	    
	    encoder.writeObject(books);
	    encoder.close();
	    fileStream.close();
	}
	
	/**
     * Deserialize list of book entities from book database
     * @param fileName - path to book database
     * @return list of book entities if they was successfully loaded from file, else return empty list
     */
	@SuppressWarnings("unchecked")
	private ArrayList<Book> DeserializeBooks(String fileName) throws IOException, ClassNotFoundException{
		ArrayList<Book> result;
		FileInputStream fileStream = new FileInputStream(fileName);
	    XMLDecoder decoder = new XMLDecoder(fileStream);
		
		result = (ArrayList<Book>)decoder.readObject();
		decoder.close();
	    fileStream.close();
	    return result;
	}

	/**
     * Calculate path to books database
     * @return path to books database
     */
	private String getDatabasePath(){
		return new File("").getAbsolutePath()+"\\src\\by\\bsuir\\Kaminsky\\server\\database\\BooksDatabase.xml";
	}	
}

