package model.metier;

import java.util.ArrayList;

import model.entities.Film;
import dao.*;

public class modelFilm {
	private static IDaoFilm daoF = new DaoFilm();
	public static Film getById(int id) {
		return daoF.getById(id);
	}
	public static ArrayList<Film> getAll(){
		return daoF.getAll();
	}
	public static boolean add(Film f) {
		return daoF.add(f);
	}
	public static boolean update(Film f) {
		return daoF.update(f);
	}
	public static boolean delete(int id) {
		return daoF.delete(id);
	}
}
