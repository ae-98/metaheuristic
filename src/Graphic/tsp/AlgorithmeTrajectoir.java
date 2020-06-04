package Graphic.tsp;



import java.util.ArrayList;
import java.util.Random;

public class AlgorithmeTrajectoir {
	protected TSP tour;
	public AlgorithmeTrajectoir(TSP tour)
	{
		this.tour=tour;
	}
	public  double calculeTour(double tour[][],ArrayList<String> villesList,ArrayList<String>TourList)
	{
		int i,start=TourList.indexOf(TourList.get(0)); 
		double distance=0.0;
		for(i=0;i<TourList.size()-1;i++)
		{
			distance+=tour[villesList.indexOf(TourList.get(i))][villesList.indexOf(TourList.get(i+1))];
		}
		if(tour[villesList.indexOf(TourList.get(i))][start]!=0.0)
		{
			distance+=tour[villesList.indexOf(TourList.get(i))][start];
			return distance;
		}	
		else return 0.0;
	}
	public ArrayList<String> Neighbor2opt(ArrayList<String> villesList,ArrayList<String>TourList)
	{
		String tmp;
		Random rand=new Random();
		
		int n=villesList.size(),i=rand.nextInt(n),j=rand.nextInt(n);
		ArrayList<String> cpy=new ArrayList<String>(villesList);
		while(i==j)
		{
			i=rand.nextInt(n);
			j=rand.nextInt(n);
		}   
		tmp=cpy.get(i);
		cpy.set(i, cpy.get(j));
		cpy.set(j, tmp);
		
		return cpy;
	}
	public ArrayList<String> Neighbor3opt(ArrayList<String> villesList,ArrayList<String>TourList)
	{
		String tmp;
		Random rand=new Random();
		int n=villesList.size(),i=rand.nextInt(n),j=rand.nextInt(n),
				compte;
		ArrayList<String> cpy=new ArrayList<String>(villesList);
		while(!( i!=j && i<j ) )
		{
			i=rand.nextInt(n);
			j=rand.nextInt(n);
		}  
		for(compte=i;compte<=j;compte++)
		{
			 if(compte!=j)
			  {
			   cpy.set(compte+1,TourList.get(compte));
			  }
			  else
			  {
			   cpy.set(i,TourList.get(j));
			   }
		}
		return cpy;
	}
	public ArrayList<String> Neighbor4opt(ArrayList<String> villesList,ArrayList<String>TourList)
	{
		String tmp;
		Random rand=new Random();
		int n=villesList.size(),i=rand.nextInt(n),j=rand.nextInt(n),
				compte=0,l,k,nbrElements;
		ArrayList<String> cpy=new ArrayList<String>(villesList);
		while(!( i!=j && i<j ) )
		{
			i=rand.nextInt(n);
			j=rand.nextInt(n);
		}  
		l=i;
		k=j;
		nbrElements=(int)((i+j)/2);
		while(l!=k && compte<=nbrElements)
		{
			tmp=cpy.get(l);
			cpy.set(l, cpy.get(k));
			cpy.set(k, tmp);
			l++;
			k--;
		}
		
		return cpy;
	}
	
	public ArrayList<String> returnNeighbor(ArrayList<String> villesList,ArrayList<String>TourList,int k)
	{
		
		if(k==2) return Neighbor2opt( villesList,TourList );
		else if(k==3) return Neighbor3opt( villesList,TourList );
		return Neighbor4opt( villesList,TourList );
	}
	
}
