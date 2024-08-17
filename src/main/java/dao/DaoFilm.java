package dao;

import java.util.ArrayList;

import model.entities.Film;
import util.singletonConnexion;
import java.sql.*;

public class DaoFilm implements IDaoFilm{
	private Connection con = singletonConnexion.getConnection();

	public Film getById(int id) {
		String Sql = "select * from film where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return new Film(res.getInt(1),res.getString(2),res.getString(3),res.getDate(4),res.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<Film> getAll() {
		String Sql = "select * from Film";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ArrayList<Film> Films = new ArrayList<>();
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Film f = new Film(res.getInt(1),res.getString(2),res.getString(3),res.getDate(4),res.getInt(5));
				Films.add(f);
			}
			return Films;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean add(Film f) {
		String Sql = "insert into film values(null,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setString(1, f.getTitre());
			ps.setString(2, f.getGenre());
			ps.setDate(3, f.getDate_sortie());
			ps.setInt(4, f.getDuree());
			int res = ps.executeUpdate();
			return res>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean update(Film f) {
		String Sql = "update film set titre = ? , genre = ? , date_sortie = ?, duree = ? where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setString(1, f.getTitre());
			ps.setString(2, f.getGenre());
			ps.setDate(3, f.getDate_sortie());
			ps.setInt(4, f.getDuree());
			ps.setInt(5, f.getId());
			int res = ps.executeUpdate();
			return res>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean delete(int id) {
		String Sql = "delete from film where id = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			return res>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
