package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Film;
import model.metier.modelFilm;
import model.metier.modelProjection;
import model.entities.Projection;
import model.entities.Salle;

/**
 * Servlet implementation class ProjectionServlet
 */
@WebServlet("/ProjectionServlet")
public class ProjectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjectionServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        try {
            if(action != null) {
                switch(action) {
                    case "add":
                        addProjection(request, response);
                        break;
                    case "delete":
                        deleteProjection(request, response);
                        break;
                    case "list":
                        listProjection(request, response);
                        break;
                    case "edit":
                        editProjection(request, response);
                        break;
                    case "get":
                        getProjection(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
	}

	private void addProjection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int id_projection = Integer.valueOf(request.getParameter("id_projection"));
		int id_film = Integer.valueOf(request.getParameter("id_film"));
		int id_salle = Integer.valueOf(request.getParameter("id_salle"));
		String full_date_str = request.getParameter("full_date");
		Float prix = Float.valueOf(request.getParameter("prix"));
		int nbr_reservee = Integer.valueOf(request.getParameter("nbr_reservee"));
		java.util.Date full_date = null;
		try {
			full_date = dateFormat.parse(full_date_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Salle s = model.metier.modelSalle.getById(id_salle);
		Film f = model.metier.modelFilm.getById(id_film);
		Projection P = new Projection(-1, f, s, new java.sql.Date(full_date.getTime()), prix, nbr_reservee);		
		boolean ver = modelProjection.add(P);
		if(ver) {
			request.setAttribute("added", true);
			response.sendRedirect("ListProjection.jsp");
		} else {
			request.setAttribute("added", false);
			request.getRequestDispatcher("/addProjection.jsp").forward(request, response);
		}
	}

	private void deleteProjection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_projection = Integer.valueOf(request.getParameter("id_projection"));
		boolean ver = modelProjection.delete(id_projection);
		if(ver) {
			request.setAttribute("deleted", true);
		} else {
			request.setAttribute("deleted", false);
		}
		response.sendRedirect("ProjectionServlet?action=list");
	}

	private void listProjection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Projection> projections = modelProjection.getAll();
		request.setAttribute("projections", projections);
		request.getRequestDispatcher("/ListProjection.jsp").forward(request, response);
	}

	private void editProjection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int id_projection = Integer.valueOf(request.getParameter("id_projection"));
		int id_film = Integer.valueOf(request.getParameter("id_film"));
		int id_salle = Integer.valueOf(request.getParameter("id_salle"));
		String full_date_str = request.getParameter("full_date");
		Float prix = Float.valueOf(request.getParameter("prix"));
		int nbr_reservee = Integer.valueOf(request.getParameter("nbr_reservee"));
		java.util.Date full_date = null;
		try {
			full_date = dateFormat.parse(full_date_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Salle s = model.metier.modelSalle.getById(id_salle);
		Film f = model.metier.modelFilm.getById(id_film);
		Projection P = new Projection(id_projection, f, s, new java.sql.Date(full_date.getTime()), prix, nbr_reservee);
		boolean ver = modelProjection.update(P);
		if(ver) {
			request.setAttribute("updated", true);
		} else {
			request.setAttribute("updated", false);
		}
		response.sendRedirect("ProjectionServlet?action=list");
	}

	private void getProjection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_projection = Integer.valueOf(request.getParameter("id_projection"));
		Projection projection = modelProjection.getById(id_projection);
		request.setAttribute("projection", projection);
		request.getRequestDispatcher("/editProjection.jsp").forward(request, response);
	}
}
