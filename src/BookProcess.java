import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookDb
 */
@WebServlet("/BookProcess")
public class BookProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

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
		
		BookDb _bookDb = new BookDb();
		String author = "";
		
		author = _bookDb.getBookFromDb(request.getParameter("sku"));

		request.setAttribute("author", author);

		request.getRequestDispatcher("/Outputpage.jsp").forward(request, response);
	}

}
