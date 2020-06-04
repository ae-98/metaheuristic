package Graphic.SAD;



import java.util.ArrayList;
import java.util.List;

public class Solution {
	protected ArrayList<Integer> instance=new ArrayList<Integer>();
	protected double valeur;
	public Solution(){
		
	}
	public Solution(int n)
	{
		int i;
		 instance=new ArrayList<Integer>(n);
		 for(i=0;i<n;i++)
		 {
			 instance.add(0);
		 }
		 valeur=0;
	}
	public ArrayList<Integer> getInstance() {
		return instance;
	}
	public void takeSolution(int i)
	{
		instance.set(i,1);
	}
	public void setInstance(ArrayList<Integer> instance) {
		this.instance = instance;
	}
	public double getValeur() {
		return valeur;
	}
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	
}
