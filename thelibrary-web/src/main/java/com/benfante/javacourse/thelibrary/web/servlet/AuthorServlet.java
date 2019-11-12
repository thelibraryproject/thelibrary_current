package com.benfante.javacourse.thelibrary.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;
import com.benfante.javacourse.thelibrary.core.model.Author;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		if (sId != null) {
			Long id = Long.valueOf(sId);
			Author author = DaoFactoryCreator.getDaoFactory().getAuthorDao().findById(id);
			request.setAttribute("author", author);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/author/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String sId = request.getParameter("id");
		if (firstName != null && lastName != null && !firstName.trim().equals("") && !lastName.trim().equals("")) {
			if ("".equals(sId)) {
				Author author = DaoFactoryCreator.getDaoFactory().getAuthorDao().getOrCreateAuthor(firstName, lastName);
			} else {
				Author author = new Author(Long.valueOf(sId), firstName, lastName);
				DaoFactoryCreator.getDaoFactory().getAuthorDao().save(author);
			}
			response.sendRedirect(request.getContextPath()+"/authors");
		} else {
			request.setAttribute("message", "First and last names are mandatory");
			request.getRequestDispatcher("/WEB-INF/jsp/author/edit.jsp").forward(request, response);			
		}
	}

}
