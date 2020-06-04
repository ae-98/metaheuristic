package Graphic.tsp;



import java.util.ArrayList;



public class VNSt extends AlgorithmeTrajectoir{

	protected int nbriterations;
	
	public VNSt(TSP tour,int nbriterations) {
		super(tour);
		this.nbriterations=nbriterations;
		// TODO Auto-generated constructor stub
	}
	public ArrayList<String> vns(ArrayList<String> solutioniInit)
	{
		//solution initial  
		ArrayList<String> solution=solutioniInit;
		ArrayList<String> neighbor=new ArrayList<String>(solution.size());
		DicendeMethodeTSP des=new DicendeMethodeTSP(tour, nbriterations);
		int nbr=nbriterations,k;
		double disSol=0.0,disNei=0.0;
		while(nbr!=0)
		{
			k=2;
			neighbor=des.desende(solution, k);
			disSol=calculeTour(this.tour.getViles(),this.tour.getVillesList(),solution);
			disNei=calculeTour(this.tour.getViles(),this.tour.getVillesList(), neighbor);
			while(k<=4)
			{
			/*desente*/
				
				if(disNei!=0.0 && disSol>disNei)
				{
					k=2;
				}
				k++;
			}
			nbr--;
		}
		
		return solution;
	}
	

}
