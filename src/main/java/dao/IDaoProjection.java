package dao;
import java.util.ArrayList;

import model.entities.Projection;
public interface IDaoProjection {
	Projection getById(int id);
	ArrayList<Projection> getAll();
	boolean add(Projection f);
	boolean update(Projection f);
	boolean delete(int id);
}
