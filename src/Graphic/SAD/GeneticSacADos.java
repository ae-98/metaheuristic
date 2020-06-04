package Graphic.SAD;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
public class GeneticSacADos {
	private int iterations;
	private int nombreIndividus;

	private ArrayList<Objet> sac;
	private int capacity;
	private int Solution=0;
	private ArrayList<ArrayList<Integer>> individus;
	private int croismment;
	//initialiser l'object
	public GeneticSacADos(int iterations,int nombreIndividus, ArrayList<Objet> sac,int capacity)
	{
		this.nombreIndividus=nombreIndividus;
		this.iterations=iterations;
		this.sac=sac;
		this.capacity=capacity;
		Random rand=new Random();
		//determine aléatoirment le point de croissment entre 1 et sac.size()-1
		this.croismment=rand.nextInt(((sac.size()-1) - 1) + 1) + 1;
	}
	//g�n�rer al�atoirment un individu
	public ArrayList<Integer> generateIndividu()
	{
		int i;
		Random rand=new Random();
		ArrayList<Integer> individu=new ArrayList<Integer>(sac.size());
		for(i=0;i<sac.size();i++)
		{
			if(rand.nextDouble()>0.5) individu.add(1);
			else individu.add(0);
		}
		return individu;
	}
	//g�n�rer la premiere generation
	public ArrayList<ArrayList<Integer>> generateFirstGeneration()
	{
		ArrayList<ArrayList<Integer>> initGeneration=new ArrayList<ArrayList<Integer>>();
		int i=0,cmp=0;
		ArrayList<Integer>individu=new ArrayList<Integer>();
		while(cmp!=nombreIndividus)
		{
			individu=generateIndividu();
			if(calculFitness(individu)>0) {
			initGeneration.add(individu);
			cmp++;
			}
		}
		return initGeneration;
	}
	//calculer la fitness d' unindividu 
	public int calculFitness(ArrayList<Integer> individu)
	{
		int i,valeur=0,poids=0;
		for(i=0;i<individu.size();i++)
		{
			
			
			valeur+=individu.get(i)*sac.get(i).getValeur();
			poids+=individu.get(i)*sac.get(i).getPoids();
		}
		if(poids>capacity)
			return 0;
		return valeur;
	}
	public int maxElement(ArrayList<Integer> list) 
	{
		int i,max=list.get(0),pos=0;
		for(i=1;i<list.size();i++)
		{
			if(list.get(i)>max)
				{
				max=list.get(i);
				pos=i;
				}
		}
		return pos;
	}
	public ArrayList<ArrayList<Integer>> SelectCroisement(ArrayList<ArrayList<Integer>> listIndividu)
	{
		Random rand=new Random();
		ArrayList<ArrayList<Integer>> bestFittestindivius=new ArrayList<ArrayList<Integer>>();
		int fitnessTotal=0,i;
		for(i=0;i<listIndividu.size();i++)
		{
			fitnessTotal+=calculFitness(listIndividu.get(i));
		}
		int persentChoise,count=0;
		for(i=0;i<listIndividu.size();i++)
		{
				persentChoise= calculFitness(listIndividu.get(i))/fitnessTotal;
				if(rand.nextDouble()>persentChoise && calculFitness(listIndividu.get(i))>0)
				{
					bestFittestindivius.add(listIndividu.get(i));
					 count++;
					if(count==2)
					{
						return bestFittestindivius;
					}
			}
		}
		return bestFittestindivius;
	}
	public ArrayList<Integer> SelectMutation(ArrayList<ArrayList<Integer>> listIndividu)
	{
		Random rand=new Random();
		int i,persentChoise, fitnessTotal=0;
		for(i=0;i<listIndividu.size();i++)
		{
			fitnessTotal+=calculFitness(listIndividu.get(i));
		}
		for(i=0;i<listIndividu.size();i++)
		{
			persentChoise= calculFitness(listIndividu.get(i))/fitnessTotal;
			if(rand.nextDouble()<persentChoise && calculFitness(listIndividu.get(i))>0)
			{
				return listIndividu.get(i);
			}
		}
		return listIndividu.get(i-1);
	}
	//g�n�rer un noveau fils 
	
	public ArrayList<ArrayList<Integer> > GenereteCroisement(ArrayList<Integer> parent1,ArrayList<Integer> parent2)
	{
		ArrayList<Integer> fils=new ArrayList<Integer>(),fils1=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> croisment=new ArrayList<ArrayList<Integer>>();
		
		
		int i;
		
			for(i=0;i<sac.size();i++)
			{
				if(i<this.croismment)
				fils.add(parent1.get(i));
				else 
				fils.add(parent2.get(i));
			}
			croisment.add(fils);
		for(i=0;i<sac.size();i++)
		{
			if(i<this.croismment)
			fils1.add(parent2.get(i));
			else
			fils1.add(parent1.get(i));
		}
		croisment.add(fils1);
		return croisment;
	}
	
	//faire la mutation a un individu aleotiore
	public ArrayList<Integer> GenereteMutation(ArrayList<Integer> individu)
	{
		Random rand=new Random();
		int i;
		for(i=0;i<individu.size();i++)
		{
			if(rand.nextDouble()>0.6)
				if(individu.get(i)==0)
				{
					individu.set(i, 1);
				}
				else
				{
					individu.set(i, 0);
				}
		}
		return individu;
	}
	public ArrayList<ArrayList<Integer>>survivors()
	{
		ArrayList<Integer>individusFitness=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>>individusTrieParFitness=new ArrayList<ArrayList<Integer>>(),
		cpy=new ArrayList<ArrayList<Integer>>(this.individus);
		int i,index;
		for(i=0;i<cpy.size();i++)
		{
			individusFitness.add(calculFitness(cpy.get(i)));
		}
		while(cpy.size()!=0)
		{
			
			index=maxElement(individusFitness);
			individusTrieParFitness.add(cpy.get(index));
			cpy.remove(index);
			individusFitness.remove(index);
		}
		index=individusTrieParFitness.size()-1;
		for(i=index;i!=nombreIndividus;i--)
		{
			individusTrieParFitness.remove(i);
		}
		return individusTrieParFitness;
	}
	public ArrayList<Integer> algoGenetique()
	{
		/*Generation de la population initial*/
		this.individus=generateFirstGeneration();
		ArrayList<ArrayList<Integer>>croismment=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> mutation=new ArrayList<Integer>();
		int i=0,j;
		while(i!=this.iterations)
		{
			for(j=0;j<nombreIndividus;j++)
			{
				/*Selection de la population pour le croissment*/
				croismment=SelectCroisement(this.individus);
				/*Generation des enfants par croissment*/
				croismment=GenereteCroisement(croismment.get(0),croismment.get(1));
				this.individus.add(croismment.get(0));
				
				this.individus.add(croismment.get(1));
				/*Selection de la population pour la mutation*/
				mutation=SelectMutation(this.individus);
//				/*Generation des enfants par croissment*/
				this.individus.add(GenereteMutation(mutation));
			
			}
			this.individus=survivors();
			i++;
		}
		
		return this.individus.get(0);
	}
	public static int calucluLoadValue(ArrayList<Objet> liste,ArrayList<Integer> instance)
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
	
}
