package com.benfante.javacourse.thelibrary.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;
import com.benfante.javacourse.thelibrary.core.model.Author;

/**
 * Servlet implementation class AuthorsServlet
 */
@WebServlet("/authors")
public class AuthorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Author> authors = DaoFactoryCreator.getDaoFactory().getAuthorDao().findAll();
		request.setAttribute("authors", authors);
		request.getRequestDispatcher("/WEB-INF/jsp/author/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
