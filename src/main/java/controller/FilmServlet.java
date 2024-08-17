package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Film;
import model.metier.modelFilm;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Servlet implementation class FilmServlet
 */
@WebServlet("/FilmServlet")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilmServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if(action != null) {
            switch(action) {
                case "add":
                    addFilm(request, response);
                    break;
                case "delete":
                    deleteFilm(request, response);
                    break;
                case "list":
                    listFilms(request, response);
                    break;
                case "edit":
                    editFilm(request, response);
                    break;
                case "get":
                	getFilm(request,response);
                	break;
            }
        }
	}
	private void addFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String titre = request.getParameter("titre");
		String genre = request.getParameter("genre");
		String date_sortie_str = request.getParameter("date_sortie");
		java.util.Date date_sortie = null;
		try {
			date_sortie = dateFormat.parse(date_sortie_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int duree = Integer.valueOf( request.getParameter("duree"));
		Film f = new Film(0,titre,genre,new java.sql.Date(date_sortie.getTime()),duree);
		boolean ver = modelFilm.add( f  );
		if(ver == true) {
			request.setAttribute("added",true);
			response.sendRedirect("ListFilm.jsp");
		} else {
			request.setAttribute("added",false);
			request.getRequestDispatcher("/addFilm.jsp").forward(request, response);
		}
	}
	
	private void editFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int id = Integer.valueOf( request.getParameter("id"));
		String titre = request.getParameter("titre");
		String genre = request.getParameter("genre");
		String date_sortie_str = request.getParameter("date_sortie");
		java.util.Date date_sortie = null;
		try {
			date_sortie = dateFormat.parse(date_sortie_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int duree = Integer.valueOf( request.getParameter("duree"));
		Film f = new Film(id,titre,genre,new java.sql.Date(date_sortie.getTime()),duree);
		boolean ver = modelFilm.update( f  );
		if(ver == true) {
			request.setAttribute("added",true);
			response.sendRedirect("ListFilm.jsp");
		} else {
			request.setAttribute("added",false);
			request.getRequestDispatcher("/addFilm.jsp").forward(request, response);
		}
	}
	
	private void deleteFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Film f = modelFilm.getById(Integer.valueOf( request.getParameter("id")) ) ;
		if(f != null) {
			boolean ver = modelFilm.delete(Integer.valueOf( request.getParameter("id")));
		}
		response.sendRedirect("ListFilm.jsp");
	}
	private void listFilms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Film> Films = modelFilm.getAll();
		request.setAttribute("Films",Films);
		response.sendRedirect("ListFilm.jsp");
		//request.getRequestDispatcher("/ListFilm.jsp").forward(request, response);
	}
	private void getFilm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Film f = modelFilm.getById(Integer.valueOf( request.getParameter("id")));
		request.setAttribute("Film",f);
		response.sendRedirect("UpdateFilm.jsp");
	}
	

	
	


}
