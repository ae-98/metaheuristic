package Graphic.SAD;


public class Objet {
	private int valeur;
	private int poids;
	public Objet()
	{
		this.valeur=0;
		this.poids=0;
	}
	public Objet(int v,int p)
	{
		this.valeur=v;
		this.poids=p;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}
}