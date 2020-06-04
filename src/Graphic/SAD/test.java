package Graphic.SAD;

import java.util.ArrayList;


public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sacados sac = new Sacados(5,20);
		int nbrItir=100;
		/////////////// ************ VNS ************///////////////////
		/*VNS v1=new VNS(sac, nbrItir);
		ArrayList<Integer> l=v1.VNS(sac,nbrItir);
		sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		l.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nla valeur totale qu'on peut la porter:"+v1.calucluLoadValue(sac.getListe(),l));
        */
/////////////// ************ Methode Desende ************///////////////////
		DesendeMethode d=new DesendeMethode(sac,nbrItir);
		ArrayList<Integer> solution=d.decent(sac,nbrItir);
		sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nla valeur totale qu'on peut la porter:"+d.calucluLoadValue(sac.getListe(),solution));
		
/////////////// ************ RecuitSimple ************///////////////////
		/*SacRecuitSimple s=new SacRecuitSimple(sac,nbrItir);
		
		
		ArrayList<Integer> solution;
		solution=s.RecuitSimple(sac,nbrItir);
		sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		solution.stream().forEach(v->System.out.print(v+" "));
		
		System.out.println("\nla valeur totale qu'on peut la porter:"+s.calucleLoadValue(sac.getListe(),solution));
		*/
/////////////// ************ glouton ************///////////////////		
		/*Sacados s=new Sacados(5,15);
		Solution mySol=s.glouton();
		s.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		mySol.getInstance().stream().forEach(v->System.out.print(v+" "));
		System.out.println("\nla valeur totale qu'on peut la porter:"+mySol.getValeur());
*//////////////// ************ Genitic ************///////////////////	
		//Sacados sac=new Sacados(4, 20);
		/*sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		System.out.print("\n");
		GeneticSacADos pop=new GeneticSacADos(500, nbrItir, sac.getListe(), 20);
		ArrayList<Integer> solution= pop.algoGenetique();
		solution.forEach(v->System.out.print(v+" "));
		System.out.println("\nla valeur totale qu'on peut la porter:"+pop.calucluLoadValue(sac.getListe(),solution));
		//System.out.println( pop.algoGenetique() );*/
/////////////// ************ Tabou ************///////////////////		
	
		/*ArrayList<Integer>soln=sac.glouton().getInstance();
		Tabou T=new Tabou(sac, nbrItir);
		System.out.print("\n");
		sac.getListe().stream().forEach(v->System.out.print(String.format("(%d,%d)", v.getValeur(),v.getPoids())));
		
		ArrayList<Integer> solution=T.tabou(soln);
		System.out.print("\n");
		solution.forEach(v->System.out.print(v+" "));
		System.out.println("\nla valeur totale qu'on peut la porter:"+T.calucluLoadValue(sac.getListe(),solution));
		*/
	

	}

}
