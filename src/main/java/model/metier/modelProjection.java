package model.metier;

import java.util.ArrayList;

import model.entities.Projection;
import dao.DaoProjection;

public class modelProjection {
	static DaoProjection daop = new DaoProjection();
	public static Projection getById(int id) {
		return daop.getById(id);
	}
	public static ArrayList<Projection> getAll(){
		return daop.getAll();
	}
	public static boolean add(Projection P) {
		return daop.add(P);
	}
	public static boolean update(Projection P) {
		return daop.update(P);
	}
	public static boolean delete(int id) {
		return daop.delete(id);
	}
}
