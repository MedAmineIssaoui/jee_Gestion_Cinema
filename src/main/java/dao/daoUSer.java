package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.User;
import util.singletonConnexion;
public class daoUSer implements IDaoUser {
	private Connection con = singletonConnexion.getConnection();
	@Override
	public User getUser(User U){
		User u2 = null;
		try {
			con = singletonConnexion.getConnection();
			PreparedStatement ps = 
					con.prepareStatement("select * from user where username=? and password = ? ");
			ps.setString(1, U.getUsername());
			ps.setString(2, U.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u2 = new User();
				u2.setId(rs.getInt(1));
				u2.setUsername(rs.getString(2));
				u2.setPassword(rs.getString(3));
				u2.setProfil(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u2;
	}
}
