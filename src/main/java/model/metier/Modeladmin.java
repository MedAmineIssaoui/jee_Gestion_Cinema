package model.metier;
import model.entities.User;
import dao.*;

public class Modeladmin {
	private User user;
	private IDaoUser daoUser = new daoUSer();
	public User getUser() {
		return this.user;
	}
	public void setUser(User User) {
		this.user = User ;
	}
	
	public boolean authentification() {
		User u = daoUser.getUser(user);
		if ( u.equals(user)) {
			return true;
		}
		return false;
	}
}
