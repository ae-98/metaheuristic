package Graphic.tsp;



import java.util.ArrayList;

public class tabouTSP extends AlgorithmeTrajectoir{
	protected int nbriterations;
	public tabouTSP(TSP tour,int nbriterations) {
		super(tour);
		// TODO Auto-generated constructor stub
		this.nbriterations=nbriterations;
	}
	public ArrayList<String> tabou(ArrayList<String> solutionInit)
	{
		ArrayList<ArrayList<String>> listeTabou=new ArrayList<ArrayList<String>>();
		ArrayList<String>solution=solutionInit;
		ArrayList<String> neighbor=new ArrayList<String>(solution.size());
		int nbr=nbriterations;
		double disSol=0.0,disNei=0.0;
		while(nbr!=0)
		{
			neighbor=Neighbor2opt(this.tour.getVillesList(),solution);
			if(!listeTabou.contains(neighbor))
			{
				listeTabou.add(neighbor);
				disSol=calculeTour(this.tour.getViles(),this.tour.getVillesList(),solution);
				disNei=calculeTour(this.tour.getViles(),this.tour.getVillesList(), neighbor);
				
				if(disNei!=0.0 && disSol>disNei)
				{
					solution=neighbor;
				
				}
				
			}
			nbr--;
		}
		return solution;

	}
	public static void main(String[] args) {
		TSP tour=new TSP(5);
		tabouTSP newTour=new tabouTSP(tour, 1000);
     	ArrayList<String> solution=newTour.tabou(tour.setTour());
		//tour.villeMatrixe();
		System.out.print("\nle meilleur chemain est:");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nle voyageur va passer "+newTour.calculeTour(tour.getViles(),tour.getVillesList(), solution));
		
	}

}
