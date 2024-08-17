package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entities.*;
import model.metier.modelFilm;
import model.metier.modelSalle;
/**
 * Servlet implementation class SalleServlet
 */
@WebServlet("/SalleServlet")
public class SalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalleServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        if(action != null) {
            switch(action) {
                case "add":
                    addSalle(request, response);
                    break;
                case "delete":
                    deleteSalle(request, response);
                    break;
                case "list":
                    listSalle(request, response);
                    break;
                case "edit":
                    editSalle(request, response);
                    break;
                case "get":
                	getSalle(request,response);
                	break;
            }
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void addSalle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String nom = request.getParameter("nom");
		int capacite = Integer.valueOf( request.getParameter("capacite") );
		Salle s = new Salle(-1,nom,capacite);
		boolean res = model.metier.modelSalle.add(s);
		if(res) {
			response.sendRedirect("ListSalle.jsp");
		}else {
			response.sendRedirect("ListSalle.jsp");
		}
		
	}
	private void deleteSalle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Salle f = modelSalle.getById( Integer.valueOf( request.getParameter("id")) ) ;
		if(f != null) {
			boolean ver = modelSalle.delete(Integer.valueOf( request.getParameter("id")));
		}
		response.sendRedirect("ListSalle.jsp");
	}
	private void listSalle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ArrayList<Salle> salles = modelSalle.getAll();
		request.setAttribute("Salles",salles);
		response.sendRedirect("ListSalle.jsp");
	}
	private void editSalle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id") );
		String nom = request.getParameter("nom");
		int capacite = Integer.valueOf( request.getParameter("capacite") );
		Salle s = new Salle(id,nom,capacite);
		boolean res = model.metier.modelSalle.update(s);
		if(res) {
			response.sendRedirect("ListSalle.jsp");
		}else {
			
		}
	}
	private void getSalle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Salle s = modelSalle.getById(Integer.valueOf( request.getParameter("id")));
		request.setAttribute("Salle",s);
		response.sendRedirect("UpdateFilm.jsp");
	}

}
