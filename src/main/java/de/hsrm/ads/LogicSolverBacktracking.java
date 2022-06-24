package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverBacktracking {

	static boolean satisfies(int[] assignment, int[] clause) {
		for (int i=0; i<clause.length; ++i)
			if(assignment[i]*clause[i]==1)
				return true;
		return false;
	}
	static boolean satisfies(int[] assignment, int[][] formula) {

		for(int i = 0;i<formula.length;i++){
			if(!satisfies(assignment,formula[i])){
				return false;
			}
		}
		return true;
		//DONE
	}

	static int gesamtGewicht(int[] ausgewaehlt,int[] gewicht, int maxGewicht) {
		int result = 0;
		for(int i = 0; i < ausgewaehlt.length;i++) {
			result += gewicht[ausgewaehlt[i]];
		}
		if(result > maxGewicht) {
			return 0;
		}


		return result;
	}

	static int gesamtGewicht(int[] gewicht,int[] werte, int[] res, int maxGewicht) {
		int result = 0;
		for(int i = 0; i < res.length;i++) {
			if(res[i] >0) {
				result += gewicht[i];
			}
		}
		if(result > maxGewicht) {
			return -1;
		}

		return result;
	}


        // Bei Bedarf können Sie hierhin andere
        // satisfies() / satisfiable() - Methoden
        // aus LogicSolverGreedy kopieren.


	static int[] solveBacktracking(int[]gewicht, int[] werte, int maxWeight) {
		int[] res = new int[gewicht.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}//create result array
		return solveBacktracking(gewicht, werte, maxWeight,res);

	}

	static int[] solveBacktracking(int[]gewicht, int[] werte, int maxWeight, int[] res) {
		if (gesamtGewicht(gewicht, werte, res, maxWeight) != -1) {
			return res;
		}

		for (int i = 0; i < res.length; i++) {
			int guteLösungINT=gesamtGewicht(gewicht, werte, res, maxWeight);
			if (res[res.length-1-i] == -1) {
				res[res.length-1-i] = 1;
				if (gesamtGewicht(gewicht, werte, res, maxWeight) != -1) {
					return res;
				}
				if(guteLösungINT>gesamtGewicht(gewicht, werte, res, maxWeight)) {
					guteLösung=gesamtGewicht(gewicht, werte, res, maxWeight);
				}
				solveBacktracking(gewicht, werte, maxWeight, guteLösung);
				res[res.length-1-i] = -1;

			}

		}
		return new int[res.length];

	}

	static int rucksack(int[] ausgewaehlt,int[] gewicht, int wert, int restKapa, int objIndex) {
		
		return 0;
	}

	static int rucksack(int[] ausgewaehlt,int[] gewicht, int wert, int maxGewicht, int restKapa, int objIndex) {

		return 0;
				}


	public static void main(String[] args) {
		int nobjs = 4;
		int[] gewichte= {10,5,7,11};
		int[] werte={7,6,2,1};
		int[] ausgewaehlt = {1,1,1,-1};
		System.out.println(gesamtGewicht(gewichte, werte, ausgewaehlt, 20));


	}

}
