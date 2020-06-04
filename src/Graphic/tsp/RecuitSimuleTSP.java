package Graphic.tsp;



import java.util.ArrayList;
import java.util.Random;

public class RecuitSimuleTSP {
	public static  double calculeTour(double villes[][],ArrayList<String> villesList,ArrayList<String>TourList)
	{
		int i,start=TourList.indexOf(TourList.get(0)); 
		double distance=0.0;
		for(i=0;i<TourList.size()-1;i++)
		{
			distance+=villes[villesList.indexOf(TourList.get(i))][villesList.indexOf(TourList.get(i+1))];
		}
		if(villes[villesList.indexOf(TourList.get(i))][start]!=0.0)
		{
			distance+=villes[villesList.indexOf(TourList.get(i))][start];
			return distance;
		}	
		else return 0.0;
	}
	public static ArrayList<String> Neighbor(double villes[][],ArrayList<String> villesList,ArrayList<String>TourList)
	{
		String tmp;
		int i,j,n=villesList.size();
		double minDist=0.0;
		ArrayList<String> cpy,solution=new ArrayList<String>();
		for(i=0;i<n;i++)
		{
			cpy=new ArrayList<String>(villesList);
			for(j=i+1;j<n-1;j++)
			{
				tmp=cpy.get(i);
				cpy.set(i, cpy.get(j));
				cpy.set(j, tmp);
			}
			if(minDist==0.0 && calculeTour(villes,villesList,cpy)!=0)
			{
				minDist=calculeTour(villes,villesList,cpy);
				solution=cpy;
			}
			else if(calculeTour(villes,villesList,cpy)!=0 &&calculeTour(villes,villesList,cpy)<minDist)
			{
				minDist=calculeTour(villes,villesList,cpy);
				solution=cpy;
			}
		}
		return solution;
	}
	public static double P(double tour,double tour1,int T)
	{
		return Math.exp((tour1-tour)/T); 
	}
	public static ArrayList<String> recuitSimple(TSP tour,int T){
		ArrayList<String> solution=tour.getInitSoul(),neibhor=new ArrayList<String>(solution.size());
		Random rand=new Random();
		double disSol=0.0,disNei=0.0,r=rand.nextDouble();
		while(T!=0)
		{
			neibhor=Neighbor(tour.getViles(),tour.getVillesList(),solution);
			disSol=calculeTour(tour.getViles(),tour.getVillesList(),solution);
			disNei=calculeTour(tour.getViles(),tour.getVillesList(), neibhor);
			if(r<P(disSol, disSol, T))
			{
				solution=neibhor;
				break;
			}
			T-=100;
		}
		return solution;
		
	}
	public static void main(String[] args) {
		
		TSP tour=new TSP(5);
		int T=10000;
		RecuitSimuleTSP rec=new RecuitSimuleTSP();
		/*//solution intial
		ArrayList<String> solution=tour.getInitSoul(),neibhor=new ArrayList<String>(solution.size());
		Random rand=new Random();
		double disSol=0.0,disNei=0.0,r=rand.nextDouble();
		while(T!=0)
		{
			neibhor=rec.Neighbor(tour.getViles(),tour.getVillesList(),solution);
			disSol=rec.calculeTour(tour.getViles(),tour.getVillesList(),solution);
			disNei=rec.calculeTour(tour.getViles(),tour.getVillesList(), neibhor);
			if(r<rec.P(disSol, disSol, T))
			{
				solution=neibhor;
				break;
			}
			T-=100;
		}*/
		ArrayList<String> solution=rec.recuitSimple(tour,T);
		tour.villeMatrixe();
		System.out.print("\nle meilleur chemain est:");
		solution.stream().forEach(v->System.out.print(v+" "));
		System.out.println("\nle voyageur va passer "+rec.calculeTour(tour.getViles(),tour.getVillesList(), solution));

	}

}
