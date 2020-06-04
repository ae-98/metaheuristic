package Graphic.SAD;



import java.util.ArrayList;
import java.util.List;

public class AlgorithmeTrajectoir {

	protected static  Sacados sac;
	protected static  int nbrItiration;
	static ArrayList<Objet> liste=new ArrayList<Objet>();
	public AlgorithmeTrajectoir(Sacados my_sac,int nbrItiration)
	{
		 sac = my_sac;
		 this.nbrItiration=nbrItiration;
		 ArrayList<Objet> liste=sac.getListe();
	}
	public static  int calucluLoadValue(ArrayList<Objet> arrayList,ArrayList<Integer> instance)
	{
		int i,valeur=0;
		for(i=0;i<arrayList.size();i++)
		{
			if(instance.get(i)==1)
			{
				valeur+=((Objet) arrayList.get(i)).getValeur();
			}
		}
		return valeur;
	}
	public static  int calculeLoadWeight(ArrayList<Objet> arrayList,ArrayList<Integer> instance)
	{
		int i,weight=0;
		for(i=0;i<arrayList.size();i++)
		{
			if(instance.get(i)==1)
			{
				weight+=((Objet) arrayList.get(i)).getPoids();
			}
		}
		return weight;
	}
	public static  ArrayList<Integer>  HammingNeighbor(ArrayList<Objet> arrayList,ArrayList<Integer> instance,int capacite)
	{
		ArrayList<Integer> Neighbor=new ArrayList<Integer>(instance.size());
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
		
		for(ArrayList<Integer> voisin : ListNeighbor)
		{
			int ValueVoisin    = calucluLoadValue(arrayList,voisin);
			if(calculeLoadWeight(arrayList,voisin)<=capacite)
			{
				Neighbor=voisin;
				for(ArrayList<Integer> v : ListNeighbor)
				{
					int valeur  = calucluLoadValue(arrayList,voisin);
                    int poid = calculeLoadWeight(arrayList,v);
					if(valeur<ValueVoisin && poid<capacite)
					{
						Neighbor=voisin;		
					}	
				}	
				break;
			}
		}
		return Neighbor;
	}
}
