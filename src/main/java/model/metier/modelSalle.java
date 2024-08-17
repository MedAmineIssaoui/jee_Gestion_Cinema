package model.metier;

import java.util.ArrayList;

import model.entities.Salle;
import dao.DaoSalle;

public class modelSalle {
	static DaoSalle daoS = new DaoSalle();
	public static Salle getById(int id) {
		return daoS.getById(id);
	}
	public static ArrayList<Salle> getAll(){
		return daoS.getAll();
	}
	public static boolean add(Salle S) {
		return daoS.add(S);
	}
	public static boolean update(Salle S) {
		return daoS.update(S);
		
	}
	public static boolean delete(int id) {
		return daoS.delete(id);
	}
}
