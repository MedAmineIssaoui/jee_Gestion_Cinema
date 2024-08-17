package model.entities;
import java.sql.*;
public class Projection {
	private int id_projection;
	private Film film;
	private Salle salle;
	private Date full_date;
	private float prix;
	private int nbr_reservee;
	 	
	public Projection(int id_projection, Film film, Salle salle, java.sql.Date full_date, float prix, int nbr_reservee) {
        this.id_projection = id_projection;
        this.film = film;
        this.salle = salle;
        this.full_date = full_date;
        this.prix = prix;
        this.nbr_reservee = nbr_reservee;
    }

    // Getters and Setters
    public int getId_projection() {
        return id_projection;
    }

    public void setId_projection(int id_projection) {
        this.id_projection = id_projection;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Date getFull_date() {
        return full_date;
    }

    public void setFull_date(Date full_date) {
        this.full_date = full_date;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbr_reservee() {
        return nbr_reservee;
    }

    public void setNbr_reservee(int nbr_reservee) {
        this.nbr_reservee = nbr_reservee;
    }

    // Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projection that = (Projection) o;
        return id_projection == that.id_projection;
    }
}
