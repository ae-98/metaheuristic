package Graphic.SAD;



import java.util.ArrayList;
import java.util.Random;


public class SacRecuitSimple {
	protected static  Sacados sac;
	protected static  int nbrItiration;
	public SacRecuitSimple(Sacados sac,int nbrItiration){
		this.sac=sac;
		this.nbrItiration=nbrItiration;
	}
	public static int calucleLoadValue(ArrayList<Objet> liste,ArrayList<Integer> instance)
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
			if(calucleLoadValue(liste, Neighbor)<calucleLoadValue(liste, ListNeighbor.get(i)) 
					&& calculeLoadWeight(liste, ListNeighbor.get(i))<=capacite)
			{
				Neighbor=ListNeighbor.get(i);
			}
		}
		return Neighbor;
	}
	public static double P(ArrayList<Objet> liste,ArrayList<Integer>solution,ArrayList<Integer>nieghbor,int T)
	{
		int s=calucleLoadValue(liste, solution),ss=calucleLoadValue(liste, nieghbor);
		return Math.exp((ss-s)/T);
	}
	public static ArrayList<Integer> RecuitSimple(Sacados sac,int t){
		ArrayList<Integer> solution=sac.gloutonInit().getInstance(),neighbor=new ArrayList<Integer>(solution.size());
		Random rand=new Random();
		double r;
		while(t!=0)
		{
			neighbor=HammingNeighbor(sac.getListe(),solution,sac.getCapacite());
			r=rand.nextDouble();
			if (r<P(sac.getListe(),solution,neighbor,t) && calculeLoadWeight(sac.getListe(), neighbor)<=sac.getCapacite())
			{
				solution=neighbor;
			}
			else
			{
				break;
			}
			t-=10;
		}
		return solution;
		
	}
	
	
}
