package Graphic.tsp;

import java.util.ArrayList;


public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		////*******************Gloton************/////////
		/* TSP tour = new TSP(5);
	        //tour.villeMatrixe();
	       // tour.setTour();*/
		 TSP tour = new TSP(5);
	        double[][] v= tour.getViles();
	       // tour.villeMatrixe();
	        ArrayList<String> l=tour.setTour();
	        System.out.println("\nle meilleur chemain est:"+l);
	        double c=tour.calculeTour(v, l);
	        //tour.setTour();
	        System.out.println("\nle voyageur va passer "+c);
	        
	    ////*******************VNS************///////// 
		/*TSP tour=new TSP(5);
		VNS newTour=new VNS(tour, 1000);
		ArrayList<String> solution=newTour.vns(tour.setTour());
		tour.villeMatrixe();
		System.out.print("\nle meilleur chemain est:");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nle voyageur va passer "+newTour.calculeTour(tour.getViles(),tour.getVillesList(), solution));
		*/
	////*******************Tabou************///////// 
		/*TSP tour=new TSP(5);
		tabouTSP newTour=new tabouTSP(tour, 1000);
     	ArrayList<String> solution=newTour.tabou(tour.setTour());
		tour.villeMatrixe();
		System.out.print("\nle meilleur chemain est:");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nle voyageur va passer "+newTour.calculeTour(tour.getViles(),tour.getVillesList(), solution));
		*/
	////*******************RECUITsSIMPLE************///////// 
		/*TSP tour=new TSP(5);
		int T=10000;
		RecuitSimuleTSP rec=new RecuitSimuleTSP();
		ArrayList<String> solution=rec.recuitSimple(tour,T);
		tour.villeMatrixe();
		System.out.print("\nle meilleur chemain est:");
		solution.stream().forEach(v->System.out.print(v+" "));
		System.out.println("\nle voyageur va passer "+rec.calculeTour(tour.getViles(),tour.getVillesList(), solution));*/
///	////*******************decent************///////// 
		/*TSP tour=new TSP(5);
		int T=100;
		DicendeMethodeTSP tspDM=new DicendeMethodeTSP(tour,T);
		ArrayList<String> initSol=tour.getInitSoul();
		
		ArrayList<String> solution=tspDM.dicende(initSol);
	System.out.print("\nle meilleur chemain est:");
     solution.stream().forEach(v->System.out.print(v+" "));
	System.out.println("\nle voyageur va passer "+tspDM.calculeTour(tour.getViles(),tour.getVillesList(), solution));*/
	}

}
