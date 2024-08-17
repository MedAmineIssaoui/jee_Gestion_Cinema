package dao;

import java.util.ArrayList;

import model.entities.Salle;

public interface IDaoSalle {
	Salle getById(int id);
	ArrayList<Salle> getAll();
	boolean add(Salle S);
	boolean update(Salle S);
	boolean delete(int id);
}
