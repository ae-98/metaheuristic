package Graphic.SAD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.Random;
public class Sacados {

	protected ArrayList<Objet> liste;
	
	protected int capacite; 
	public Sacados(int n,int capacite)
	{
		this.capacite=capacite;
		int i,poids,valuer;
		this.liste=new ArrayList<Objet>();
		Random rand = new Random();
		for(i=0;i<n;i++)
		{
			valuer=rand.ints(1, capacite)
				      .findFirst()
				      .getAsInt();
			poids=rand.ints(2, capacite)
				      .findFirst()
				      .getAsInt();
			Objet Object=new Objet(valuer,poids);
			this.liste.add(Object);
		}
	}
	public ArrayList<Objet> getListe()
	{
		return liste;
	}
	public int getCapacite()
	{
		return capacite;
	}
	public static double maxElement(List<Double> profite)
	{
		
		double maxE=profite.get(0);
		for(int i=1;i<profite.size();i++)
		{
			if(maxE<profite.get(i)) maxE=profite.get(i);
		}
		return maxE;
	}
	public Solution glouton()
	{
		List<Double> profite=(List<Double>) liste.stream()
				.map( m-> (  ( (double)m.getValeur()/ (double)m.getPoids() ) ) )
				.collect(Collectors.toList());
		List<Double>Cpyprofite=new ArrayList<Double>(profite);
		ArrayList<Objet> listeClone= new ArrayList<Objet>(liste);
	double  maxProfite=maxElement(profite);
	Solution solu=new Solution(profite.size());
	//Cpyprofite.stream().forEach(v->System.out.print(v+" "));
//	listeClone.stream().forEach(v->System.out.print(v.get+" "));
	int index,poids=0,valeur,index2;
	Objet condidat;
	
	while(listeClone.size()!=0)
	{
		if(listeClone.size()!=0){
			maxProfite=maxElement(Cpyprofite);
			index=profite.indexOf( maxProfite );
			condidat=liste.get(  index  );
			index2=Cpyprofite.indexOf( maxProfite );
			
			listeClone.remove(index2);
			Cpyprofite.remove(index2);
			if(poids+condidat.getPoids() <= capacite) 
				{
				valeur=condidat.getValeur();
				poids+=condidat.getPoids();
				solu.setValeur(valeur+solu.getValeur());
				solu.takeSolution(index);
				}
		}
	}
	return solu;
	}
	public Solution gloutonInit()
	{
		List<Double> profite=(List<Double>) liste.stream()
				.map( m-> (  ( (double)m.getValeur()/ (double)m.getPoids() ) ) )
				.collect(Collectors.toList());
		List<Double>Cpyprofite=new ArrayList<Double>(profite);
		ArrayList<Objet> listeClone= new ArrayList<Objet>(liste);
	double  maxProfite=maxElement(profite);
	Solution solu=new Solution(profite.size());
	//Cpyprofite.stream().forEach(v->System.out.print(v+" "));
//	listeClone.stream().forEach(v->System.out.print(v.get+" "))
	int index,poids=0,valeur,index2;
	Objet condidat;
	
	while(listeClone.size()!=0)
	{
		
			maxProfite=maxElement(Cpyprofite);
			index=profite.indexOf( maxProfite );
			condidat=liste.get(  index  );
			index2=Cpyprofite.indexOf( maxProfite );
			
			listeClone.remove(index2);
			Cpyprofite.remove(index2);
			if(poids+condidat.getPoids() <= capacite) 
				{
				valeur=condidat.getValeur();
				poids+=condidat.getPoids();
				solu.setValeur(valeur+solu.getValeur());
				solu.takeSolution(index);
				break;
				}
		
	}
	
	return solu;
	}
	public static void main(String argv[])
	{
	
			Sacados s=new Sacados(5,15);
			Solution mySol=s.glouton();
			s.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
			System.out.print("\n");
			mySol.getInstance().stream().forEach(v->System.out.print(v+" "));
			System.out.println("\nla valeur totale qu'on peut la porter:"+mySol.getValeur());
		
		

	}

}