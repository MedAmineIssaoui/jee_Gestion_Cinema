package util;

import java.sql.Connection;

import dao.daoUSer;
import model.entities.User;

public class test {
	public static void main(String []args) {
		daoUSer daoUser = new daoUSer();
		singletonConnexion st = new singletonConnexion();
		Connection conn = singletonConnexion.getConnection();
		User u = daoUser.getUser(new User("admin","admin123"));
		System.out.print( "username:" +u.getUsername() + "\n Password:" + u.getPassword()+"\n Profil: " + u.getProfil() );
	}
}
//daoClient --> full CRUD