package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.entities.*;
import util.singletonConnexion;

public class DaoProjection implements IDaoProjection{
	private Connection con = singletonConnexion.getConnection();
	private IDaoFilm fdao = new DaoFilm();
	private IDaoSalle sdao = new DaoSalle();
	public Projection getById(int id) {
		String Sql = "select * from projections where id_projection = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				Film f = fdao.getById(res.getInt(2));
				Salle s = sdao.getById(res.getInt(3));
				return new Projection(res.getInt(1) , f, s,res.getDate(4),res.getFloat(5),res.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<Projection> getAll() {
		String Sql = "select * from projections";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ResultSet res = ps.executeQuery();
			ArrayList<Projection> projections= new ArrayList<>();
			while(res.next()) {
				Film f = fdao.getById(res.getInt(2));
				Salle s = sdao.getById(res.getInt(3));
				Projection P = new Projection(res.getInt(1) , f, s,res.getDate(4),res.getFloat(5),res.getInt(6)) ;
				projections.add(P);
			}
			return projections;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean add(Projection f) {
		String Sql = "insert into projections values(null,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1 , f.getFilm().getId() );
			ps.setInt(2 ,f.getSalle().getId() );
			ps.setDate(3 , f.getFull_date() );
			ps.setFloat(4,f.getPrix());
			ps.setInt(5, f.getNbr_reservee());
			int res = ps.executeUpdate();
			return res > 0 ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean update(Projection f) {
		String Sql = "update projections "
				+ "set id_film = ? "
				+ "set id_salle = ? "
				+ "set full_date = ? "
				+ "set prix = ? "
				+ "set nbr_reservee = ? "
				+ "where id_projection = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1 , f.getFilm().getId() );
			ps.setInt(2 ,f.getSalle().getId() );
			ps.setDate(3 , f.getFull_date() );
			ps.setFloat(4,f.getPrix());
			ps.setInt(5, f.getNbr_reservee());
			ps.setInt(6 , f.getId_projection() );
			int res = ps.executeUpdate();
			return res > 0 ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean delete(int id) {
		String Sql = "delete from projections "
				+ "where id_projection = ?";
		try {
			PreparedStatement ps = con.prepareStatement(Sql);
			ps.setInt(1 , id );
			int res = ps.executeUpdate();
			return res > 0 ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
