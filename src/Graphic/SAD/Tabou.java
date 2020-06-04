package Graphic.SAD;

/*import java.util.ArrayList;
public class Tabou extends AlgorithmeTrajectoir{

	public Tabou(Sacados my_sac,int nbrItiration)
	{
		super(my_sac, nbrItiration);
		
	}
	public ArrayList<Integer> tabou(ArrayList<Integer> slolutionInit)
	{
		ArrayList<ArrayList<Integer>> listeTabou=new ArrayList<ArrayList<Integer>>();
		int nbr=nbrItiration;
		ArrayList<Integer> solution=slolutionInit;
		ArrayList<Integer> neighbor=new ArrayList<Integer>(solution.size());
		while(nbr!=0)
		{
			neighbor=HammingNeighbor(sac.getListe(),solution,sac.getCapacite());
			if(!listeTabou.contains(neighbor))
			{
				listeTabou.add(neighbor);
				if(calucluLoadValue(liste,solution)<calucluLoadValue(liste,neighbor) &&
						calculeLoadWeight(liste,neighbor)<=sac.getCapacite())
					{
						
					solution=neighbor;
					}
				
			}
			nbr--;
		}
		return solution;
	}
	public static void main(String argv[])
	{
		//initialisation du sac
		Sacados sac = new Sacados(5,20);
		//solution initial
		ArrayList<Integer> solution=sac.glouton().getInstance(),neighbor=new ArrayList<Integer>(solution.size());
		System.out.print("\nsolutioninit:");
		solution.stream().forEach(v->System.out.print(v+" "));
		System.out.println();
		int nbr=1000;
		while(nbr!=0)
		{
			neighbor=HammingNeighbor(sac.getListe(),solution,sac.getCapacite());
			if(calucluLoadValue(sac.getListe(),solution)>calucluLoadValue(sac.getListe(),neighbor) &&
				calculeLoadWeight(sac.getListe(), solution)<=sac.getCapacite())
			{
				System.out.print("best neighbor:");
				neighbor.stream().forEach(v->System.out.print(v+" "));
				break;
			}
			solution=neighbor;
			nbr--;
		}
		sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nla valeur totale qu'on peut la porter:"+calucluLoadValue(sac.getListe(),solution));
		
	}
}*/
import java.util.ArrayList;
public class Tabou extends AlgorithmeTrajectoir{

	public Tabou(Sacados my_sac,int nbrItiration)
	{
		super(my_sac, nbrItiration);
		
	}
	public static ArrayList<Integer> tabou(ArrayList<Integer> slolutionInit)
	{
		ArrayList<ArrayList<Integer>> listeTabou=new ArrayList<ArrayList<Integer>>();
		int nbr=nbrItiration;
		ArrayList<Integer> solution=slolutionInit;
		ArrayList<Integer> neighbor=new ArrayList<Integer>(solution.size());
		while(nbr!=0)
		{
			neighbor=HammingNeighbor(sac.getListe(),solution,sac.getCapacite());
			if(!listeTabou.contains(neighbor))
			{
				listeTabou.add(neighbor);
				if(calucluLoadValue(liste,solution)<calucluLoadValue(liste,neighbor) &&
						calculeLoadWeight(liste,neighbor)<=sac.getCapacite())
					{
						
					solution=neighbor;
					}
				
			}
			nbr--;
		}
		return solution;
	}

}