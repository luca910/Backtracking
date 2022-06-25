package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverBacktracking {
	public static int guteLösungGEW=0;
	public static int guteLösungWER=0;

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

	static int gesamtWert(int[] gewicht, int[] werte, int[] res,int maxGewicht) {
		int result = 0;
		if(gesamtGewicht(gewicht,werte,res,maxGewicht) == -1) {
			return -1;
		}
		for(int i = 0; i < res.length;i++) {
			if(res[i] >0) {
				result += werte[i];
			}
		}
		return result;
	}


        // Bei Bedarf können Sie hierhin andere
        // satisfies() / satisfiable() - Methoden
        // aus LogicSolverGreedy kopieren.


	static int solveBacktracking(int[]gewicht, int[] werte, int maxWeight) {
		int[] res = new int[gewicht.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = 0;
		}//create result array
		return solveBacktracking(gewicht, werte, maxWeight,res);

	}

	static int solveBacktracking(int[]gewicht, int[] werte, int maxWeight, int[] res) {

		for (int i = 0; i < res.length; i++) {

			int[] guteLösung = res;

			if (res[res.length-1-i] == 0) {
				res[res.length-1-i] = 1;
				if (gesamtGewicht(gewicht, werte, res, maxWeight) != -1) {


					if (guteLösungWER < gesamtWert(gewicht, werte, res, maxWeight)) {
						//System.out.println("guteLösungWER: " + guteLösungWER);
						//System.out.println("gesamtWert: " + gesamtWert(gewicht, werte, res, maxWeight));
						guteLösung = res;
						guteLösungWER = gesamtWert(gewicht, werte, res, maxWeight);
					}
					solveBacktracking(gewicht, werte, maxWeight, guteLösung);
				}
				res[res.length-1-i] = 0;

			}

		}
		return guteLösungWER;

	}

	public static void main(String[] args) {
		int nobjs = 4;
		int[] gewichte= {10,5,7,11};
		int[] werte={7,6,2,1};
		int[] ausgewaehlt = {1,1,1,1};

		int gewicht2[]={10,5,7,11,13,1,7,11,13,19,19,9,8,2,7};
		int werte2[]={7,6,1,1,1,4,11,20,3,7,8,9,16,19,100};
		int[] ausgewaehlt2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		System.out.println(solveBacktracking(gewichte, werte, 30));
		//System.out.println(gesamtGewicht(gewichte, werte, ausgewaehlt, 30));
		System.out.println(solveBacktracking(gewicht2, werte2, 30,ausgewaehlt2));

	}

}
