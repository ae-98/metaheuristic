package Graphic.tsp;



import java.util.ArrayList;

public class DicendeMethodeTSP extends AlgorithmeTrajectoir{
	protected int nbriterations;
	
	public DicendeMethodeTSP(TSP tour,int nbriterations) {
		super(tour);
		this.nbriterations=nbriterations;
		// TODO Auto-generated constructor stub
	}

	

	public ArrayList<String> dicende(ArrayList<String> initSol)
	{
		//solution initiale
		ArrayList<String> solution=initSol,neibhor=new ArrayList<String>(solution.size());;
		double disSol=0.0,disNei=0.0;
		int nbr=nbriterations;
		while(nbr!=0)
		{
			neibhor=Neighbor2opt(this.tour.getVillesList(),solution);
			disSol=calculeTour(this.tour.getViles(),this.tour.getVillesList(),solution);
			disNei=calculeTour(this.tour.getViles(),this.tour.getVillesList(), neibhor);
			if(disNei!=0.0 && disSol>disNei)
			{
				solution=neibhor;
				return solution;
			}
			
			nbr--;
		}
		return solution;
	}
	public ArrayList<String> desende(ArrayList<String> initSol,int k)
	{
		
		ArrayList<String> solution=initSol,neibhor=new ArrayList<String>(solution.size());;
		double disSol=0.0,disNei=0.0;
		int nbr=nbriterations;
		while(nbr!=0)
		{
			neibhor=returnNeighbor(this.tour.getVillesList(),solution, k);
			disSol=calculeTour(this.tour.getViles(),this.tour.getVillesList(),solution);
			disNei=calculeTour(this.tour.getViles(),this.tour.getVillesList(), neibhor);
			if(disNei!=0.0 && disSol>disNei)
			{
				solution=neibhor;
				return solution;
			}
			
			nbr--;
		}
		return solution;
	}
	public static void main (String argv[])
	{
		TSP tour=new TSP(5);
		int T=100;
		DicendeMethodeTSP tspDM=new DicendeMethodeTSP(tour,T);
		ArrayList<String> initSol=tour.getInitSoul();
		
		ArrayList<String> solution=tspDM.dicende(initSol);
	System.out.print("\nle meilleur chemain est:");
     solution.stream().forEach(v->System.out.print(v+" "));
	System.out.println("\nle voyageur va passer "+tspDM.calculeTour(tour.getViles(),tour.getVillesList(), solution));
	}
}
