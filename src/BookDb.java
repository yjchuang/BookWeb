import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDb {
	static Connection con = null;
	

	public String getBookFromDb(String _sku)
	{
		Statement stmt = null;
		ResultSet rs = null;
		
		//Book book = new Book();
		String _author = "";

		String sql = "select author from books where sku='" + _sku + "'";
		
		try{
			con = connectToBooksDb();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				//book.setSku(_sku);
				_author = rs.getString("author");
				//book.setDescription(rs.getString("description"));
				//book.setTitle(rs.getString("title"));
				//book.setPrice(rs.getDouble("price"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return _author;
	}
	
	public String getBookByAuthorFromDb(String _author)
	{
		Statement stmt = null;
		ResultSet rs = null;
		
		//Book book = new Book();
		String _books = "";

		String sql = "select title from books where author='" + _author + "'";
		
		try{
			con = connectToBooksDb();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				_books +="<tr><td>"+rs.getString("title")+"</td></tr>";
			}
System.out.println(_books);
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return _books;
	}

	
	

	public static void insertBookToDb(Book _book)
	{
		int count=0;

		String update_sql = "insert into Books (sku, title, author, description, price) values (?, ?, ?, ?, ?)";
		try{
			con = connectToBooksDb();

			PreparedStatement pstmt = con.prepareStatement(update_sql);

			pstmt.setString(1, _book.getSku());
			pstmt.setString(2, _book.getTitle());
			pstmt.setString(3, _book.getAuthor());
			pstmt.setString(4, _book.getDescription());
			pstmt.setDouble(5, _book.getPrice());


			count = pstmt.executeUpdate();
			if (count == 0)
				System.out.println("No record found");;

		}catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				//rs.close();
				//stmt.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	public static void updateBookToDb(Book _book)
	{
		int count=0;

		String update_sql = "update Books SET title = ?, author= ?, description = ?, price = ? WHERE sku = ?";

		try{
			con = connectToBooksDb();

			PreparedStatement pstmt = con.prepareStatement(update_sql);
			pstmt.setString(1, _book.getTitle());
			pstmt.setString(2, _book.getAuthor());
			pstmt.setString(3, _book.getDescription());
			pstmt.setDouble(4, _book.getPrice());
			pstmt.setString(5, _book.getSku());

			count = pstmt.executeUpdate();
			if (count == 0)
				System.out.println("No record found");;

		}catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}


	public static void deleteBookToDb(String _sku)
	{

		String delete_sql = "delete from Books WHERE sku = ?";
		try{
			con = connectToBooksDb();

			PreparedStatement pstmt = con.prepareStatement(delete_sql);
			pstmt.setString(1, _sku);
			int count = pstmt.executeUpdate();
			if (count == 0)
				System.out.println("No record found");;

		}catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	public static Connection connectToBooksDb()
	{
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

	
		return con;
	}
}
