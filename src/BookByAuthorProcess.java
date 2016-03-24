

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookByAuthorProcess
 */
@WebServlet("/BookByAuthorProcess")
public class BookByAuthorProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Preprocess request: we actually don't need to do any business stuff, so just display JSP.
		//request.getRequestDispatcher("/FirstPage.jsp").forward(request, response);
		//doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Postprocess request: gather and validate submitted data and display the result in the same JSP.
		// Prepare messages.
		
		
		//Book _book = new Book();
		BookDb _bookDb = new BookDb();
		String books = "";
		
		books =  _bookDb.getBookByAuthorFromDb(request.getParameter("aut"));

		request.setAttribute("title", books);

		request.getRequestDispatcher("/OutputByAuthor.jsp").forward(request, response);


	}

}

