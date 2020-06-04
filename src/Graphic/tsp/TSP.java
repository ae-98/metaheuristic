package Graphic.tsp;



import java.util.*;

public class TSP
{
    protected double[][] viles;
    ArrayList<String> villesList;
    int nbrVille;
    
    public TSP(int nbrVille) {
        this.villesList = new ArrayList<String>();
        this.viles = new double[nbrVille][nbrVille];
         Random rand = new Random();
        for (int i = 0; i < nbrVille; ++i) {
            this.villesList.add(Integer.toString(i));
        }
        for (int i = 0; i < nbrVille; ++i) {
            for (int j = 0; j < nbrVille; ++j) {
                if (i != j /*&& this.viles[i][j] == 0.0*/) {
                    this.viles[i][j] = Math.ceil(10.0 * rand.nextDouble());
                   this.viles[j][i] = this.viles[i][j];
                }
            }
        }
    }
    
    public double[][] getViles() {
        return this.viles;
    }
    
    public ArrayList<String> getVillesList() {
        return this.villesList;
    }
  
    public void setViles(final double[][] viles) {
        this.viles = viles;
    }
   
    
    public void villeMatrixe() {
        for (int i = 0; i < this.viles.length; ++i) {
            for (int j = 0; j < this.viles[i].length; ++j) {
                System.out.print(String.valueOf(this.viles[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
    public void villeMatrixe(final double[][] vile) {
        for (int i = 0; i < this.viles.length; ++i) {
            for (int j = 0; j < this.viles[i].length; ++j) {
                System.out.print(String.valueOf(this.viles[i][j]) + " ");
            }
            System.out.println();
        }
    }
    
    public static double[][] cloneArray(double[][] old, final double[][] current) {
        final int length = current.length;
        old = new double[length][length];
        for (int i = 0; i < old.length; ++i) {
            for (int j = 0; j < old[i].length; ++j) {
                old[i][j] = current[i][j];
            }
        }
        return old;
    }
    
    public boolean estExiste(final ArrayList<String> tmp, final String ville) {
        for (int i = 0; i < tmp.size(); ++i) {
            if (tmp.get(i).equals(ville)) {
                return true;
            }
        }
        return false;
    }
    
    public void cut(final double[][] array, final int i) {
        int j;
        for (j = 0, j = 0; j < array.length; ++j) {
            array[j][i] = 0.0;
        }
        for (j = 0; j < array.length; ++j) {
            array[i][j] = 0.0;
        }
    }
    
    public static int getPosMin(final double[] array) {
        int i = 0;
        int pos = 0;
        double min = array[0];
        for (i = 1; i < array.length; ++i) {
            if (min == 0.0 && array[i] != 0.0) {
                min = array[i];
                pos = i;
            }
            if (min > array[i] && array[i] != 0.0) {
                min = array[i];
                pos = i;
            }
        }
        return pos;
    }
    
    public double getMin(final double[] array) {
        int i = 0;
        int pos = 0;
        double min = array[0];
        for (i = 1; i < array.length; ++i) {
            if (min == 0.0 && array[i] != 0.0) {
                min = array[i];
                pos = i;
            }
            if (min > array[i] && array[i] != 0.0) {
                min = array[i];
                pos = i;
            }
        }
        return min;
    }
    
    public  double calculeTour(final double[][] villes, final ArrayList<String> TourList) {
        final int start = TourList.indexOf(this.villesList.get(0));
        double distance = 0.0;
        int i;
        for (i = 0; i < TourList.size() - 1; ++i) {
            distance += villes[this.villesList.indexOf(TourList.get(i))][this.villesList.indexOf(TourList.get(i + 1))];
        }
        if (villes[this.villesList.indexOf(TourList.get(i))][start] != 0.0) {
            distance += villes[this.villesList.indexOf(TourList.get(i))][start];
            return distance;
        }
        return 0.0;
    }
    
    public ArrayList<String> setTour() {
        final int n = this.viles[0].length;
        int preview = 0;
        double minDistance = 0.0;
        ArrayList<String> tourList = new ArrayList<String>();
        ArrayList<String> tmp = new ArrayList<String>();
        double[][] cloneMatrix = new double[0][0];
        for (int i = 0; i < n; ++i) {
            tmp = new ArrayList<String>();
            cloneMatrix = cloneArray(cloneMatrix, this.viles);
            preview = i;
            tmp.add(this.villesList.get(preview));
            int minPos = getPosMin(cloneMatrix[preview]);
            double min = this.getMin(cloneMatrix[preview]);
            this.cut(cloneMatrix, i);
            while (min != 0.0) {
                preview = minPos;
                if (!this.estExiste(tmp, this.villesList.get(preview))) {
                    tmp.add(this.villesList.get(preview));
                }
                minPos = getPosMin(cloneMatrix[preview]);
                min = this.getMin(cloneMatrix[preview]);
                this.cut(cloneMatrix, preview);
            }
            if (minDistance == 0.0) {
                tourList = tmp;
                minDistance = this.calculeTour(this.viles, tmp);
            }
            else if (minDistance != 0.0 && minDistance > this.calculeTour(this.viles, tmp)) {
                tourList = tmp;
                minDistance = this.calculeTour(this.viles, tmp);
               // System.out.println("min2:" + minDistance);
            }
            
        }
       // System.out.println("\nle voyageur va passer "+minDistance);
       // System.out.println(tourList);
        return tourList;
    }
    
    public ArrayList<String> getInitSoul() {
        final Random rand = new Random();
        final int n = this.viles[0].length;
        int preview = 0;
        final int i = rand.nextInt(n);
        double minDistance = 0.0;
        ArrayList<String> tourList = new ArrayList<String>();
        ArrayList<String> tmp = new ArrayList<String>();
        double[][] cloneMatrix = new double[0][0];
        tmp = new ArrayList<String>();
        cloneMatrix = cloneArray(cloneMatrix, this.viles);
        preview = i;
        tmp.add(this.villesList.get(preview));
        int minPos = getPosMin(cloneMatrix[preview]);
        double min = this.getMin(cloneMatrix[preview]);
        this.cut(cloneMatrix, i);
        while (min != 0.0) {
            preview = minPos;
            if (!this.estExiste(tmp, this.villesList.get(preview))) {
                tmp.add(this.villesList.get(preview));
            }
            minPos = getPosMin(cloneMatrix[preview]);
            min = this.getMin(cloneMatrix[preview]);
            this.cut(cloneMatrix, preview);
        }
        System.out.println(minDistance);
        if (minDistance == 0.0) {
            tourList = tmp;
            minDistance = this.calculeTour(this.viles, tmp);
        }
        else if (minDistance != 0.0 && minDistance > this.calculeTour(this.viles, tmp)) {
            tourList = tmp;
            minDistance = this.calculeTour(this.viles, tmp);
        }
        return tourList;
    }
    
    public static void main(final String[] argv) {
        TSP tour = new TSP(100);
        double[][]v= tour.getViles();
        tour.villeMatrixe();
        ArrayList<String> l=tour.setTour();
        System.out.println("\nle meilleur chemain est:"+l);
        double c=tour.calculeTour(v, l);
        //tour.setTour();
        System.out.println("\nle voyageur va passer "+c);
    }
}
