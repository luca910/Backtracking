package de.hsrm.ads;

import java.util.Arrays;

public class LogicSolverGreedy {

  static boolean satisfies(short[] assignment, short[] clause) {
	  for (int i=0; i<clause.length; ++i)
		  if(assignment[i]*clause[i]==1)
			  return true;
	  return false;
  }
	
  static boolean satisfies(short[] assignment, short[][] formula) {

      for(int i = 0;i<formula.length;i++){
              if(!satisfies(assignment,formula[i])){
                  return false;
          }
      }
        return true;
      //DONE
  }

  static boolean satisfiable(short[] assignment, short[] clause) {
      if(satisfies(assignment, clause)) return true;
      for(int i =0; i<assignment.length;i++){
          if(assignment[i]==0 && clause[i]==1 || assignment[i]==0 && clause[i]==-1)
          {
              return true;}
      }
      return false;
      //DONE
  }
	
  static boolean satisfiable(short[] assignment, short[][] formula) {

      for(int i = 0;i<formula.length;i++){
          if(!satisfiable(assignment,formula[i])){
              return false;
          }
      }
      return true;
      //DONE
  }
    static short[] solveGreedy(short[] clause, short[] res) {
        for(int i = 0; i < clause.length; i++) {
            if(clause[i] == 0) {
                continue;//skip zustand
            }
            if(res[i] == 0 && clause[i] != 0) {//res nocht nicht gesetzt & zustand vorhanden
                res[i] = clause[i];
                break;
            }
        }
      return res;
    }
	
  static short[] solveGreedy(short[][] formula) {
      short[] res = new short[formula[0].length];
      for(int i=0;i< res.length;i++){
          res[i]=0;
      }//create result array

      for(int i=0;i< formula.length;i++) {

          if(!satisfiable(res, formula)) {
              return new short[res.length];//no result
          }

          if(!satisfies(res,formula[i])) {//skip wenn vorherige lösung auch passt ->2
              res= solveGreedy(formula[i], res); //löse clause
          }
      }
      return res;
  }

}
