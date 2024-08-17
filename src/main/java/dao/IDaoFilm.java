package dao;

import java.util.ArrayList;

import model.entities.Film;

public interface IDaoFilm {
	Film getById(int id);
	ArrayList<Film> getAll();
	boolean add(Film f);
	boolean update(Film f);
	boolean delete(int id);
}
