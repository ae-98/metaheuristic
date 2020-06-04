package Graphic.SAD;

import java.util.ArrayList;


public class VNS extends AlgorithmeTrajectoir{

	public VNS(Sacados sac,int nbrItir) {
		// TODO Auto-generated constructor stub
		super(sac, nbrItir);
	}
	public static ArrayList<Integer> decent(Sacados sac,ArrayList<Integer> slolutionInit,int nbriter){
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
	public static ArrayList<Integer> VNS(Sacados sac,int nbrItiration)
	{
		ArrayList<Integer> solutionInit=sac.glouton().getInstance(),neighbor=new ArrayList<Integer>();
		ArrayList<Integer> neighbor1=new ArrayList<Integer>(solutionInit.size());
		ArrayList<Integer> solution=new ArrayList<Integer>(solutionInit.size());
	    neighbor1=solutionInit;
		int nbr=nbrItiration;
		while(nbr!=0)
		{
		solution=decent(sac,neighbor1,nbr);
		if(calucluLoadValue(sac.getListe(),solutionInit)>calucluLoadValue(sac.getListe(),solution) &&
				calculeLoadWeight(sac.getListe(), solutionInit)<=sac.getCapacite()){
			break;
		}nbr--;}
		
		return solution;
		
		
			
			
		}

	

}
