package Graphic.SAD;



import java.util.ArrayList;
import java.util.Random;

public class DesendeMethode {
	protected static  Sacados sac;
	protected static  int nbrItiration;
	public DesendeMethode(Sacados sac,int nbrItiration){
		this.sac=sac;
		this.nbrItiration=nbrItiration;
	}

	public static int calucluLoadValue(ArrayList<Objet> liste,ArrayList<Integer> instance)
	{
		int i,valeur=0;
		for(i=0;i<liste.size();i++)
		{
			if(instance.get(i)==1)
			{
				valeur+=liste.get(i).getValeur();
			}
		}
		return valeur;
	}
	public static int calculeLoadWeight(ArrayList<Objet> liste,ArrayList<Integer> instance)
	{
		int i,weight=0;
		for(i=0;i<liste.size();i++)
		{
			if(instance.get(i)==1)
			{
				weight+=liste.get(i).getPoids();
			}
		}
		return weight;
	}
	
	public static ArrayList<Integer>  HammingNeighbor(ArrayList<Objet> liste,ArrayList<Integer> instance,int capacite)
	{
		ArrayList<Integer> Neighbor=new ArrayList<Integer>(instance);
		ArrayList<ArrayList<Integer>>ListNeighbor=new ArrayList<ArrayList<Integer>>();
		int i;
		for(i=0;i<instance.size();i++)
		{
			Neighbor=new ArrayList<Integer>(instance);
			if(Neighbor.get(i)==1)
			{
				Neighbor.set(i, 0);
			}
			else
			{
				Neighbor.set(i, 1);
			}
			ListNeighbor.add(Neighbor);
		}
		
		for(i=1;i<ListNeighbor.size();i++)
		{
			if(calucluLoadValue(liste, Neighbor)<calucluLoadValue(liste, ListNeighbor.get(i)) 
					&& calculeLoadWeight(liste, ListNeighbor.get(i))<=capacite)
			{
				Neighbor=ListNeighbor.get(i);
			}
		}
		return Neighbor;
	}
	public static ArrayList<Integer> decent(Sacados sac,int nbriter){
		ArrayList<Integer> slolutionInit=sac.gloutonInit().getInstance();
		ArrayList<Integer> neighbor=new ArrayList<Integer>(slolutionInit.size());
	
		while(nbriter!=0)
		{
			neighbor=HammingNeighbor(sac.getListe(),slolutionInit,sac.getCapacite());
			if(calucluLoadValue(sac.getListe(),slolutionInit)>calucluLoadValue(sac.getListe(),neighbor) &&
				calculeLoadWeight(sac.getListe(), slolutionInit)<=sac.getCapacite())
			{
				
				break;
			}
			slolutionInit=neighbor;
			nbriter--;
		}
		return slolutionInit;
		
	}
	
}
