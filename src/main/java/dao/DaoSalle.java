package dao;
import java.sql.*;
import java.util.ArrayList;
import model.entities.Salle;
import util.singletonConnexion;

public class DaoSalle implements IDaoSalle {
	Connection con = singletonConnexion.getConnection();

	public Salle getById(int id){
		String Sql = "select * from salle where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return new Salle(res.getInt(1),res.getString(2),res.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Salle> getAll(){
		String Sql = "select * from salle";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ResultSet res = ps.executeQuery();
			ArrayList<Salle> Salles = new ArrayList<>();
			while(res.next()) {
				Salles.add( new Salle(res.getInt(1),res.getString(2),res.getInt(3)) );
			}
			return Salles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean add(Salle S){
		String Sql = "insert into salle values(null,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setString(1, S.getNom());
			ps.setInt(2, S.getCapacite());
			int res = ps.executeUpdate();
			return res > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Salle S){
		String Sql = "update salle set nom = ? , capacite = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setString(1, S.getNom());
			ps.setInt(2, S.getCapacite());
			ps.setInt(3, S.getId());
			int res = ps.executeUpdate();
			return res > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id){
		String Sql = "delete from salle where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			return res > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
