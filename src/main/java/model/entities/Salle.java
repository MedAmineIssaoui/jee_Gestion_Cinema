package model.entities;

public class Salle {
	private int id;
	private String nom;
	private int capacite;
	public Salle(int id, String nom, int capacite) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
    }
	
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Salle salle = (Salle) o;
	        return id == salle.id;
	    }
}
