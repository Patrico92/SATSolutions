/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Patryk Kozieł
 */
public class BruteForceSol {
    
    private SAT sat;
    private SAT sol;
    private ArrayList<Variable> variables;

    public BruteForceSol(SAT sat) {
        this.sat = sat;
    }
    
    public SATSolution computeSolution(){
        
        SATSolution solution = null;
        variables = sat.getVariables();
        clearList();
        int numOfIteration = getNumberOfIterations();
        int i = 0;
        int maxSatClauses = sat.getNumOfClauses();
        int satClauses = 0;
        
        do{
            if (sat.numOfSatisfiedClauses() > satClauses){
                
                satClauses = sat.numOfSatisfiedClauses(); 
                solution = new SATSolution(sat);
                if(satClauses == maxSatClauses) break;
            }
            
            setIteration(i);
            
            i++;
            
        } while (i < numOfIteration);
        
        return solution;
       
    }

    private void clearList() {
        for(Variable var : variables){
            var.setValue(false);
        }
    }

    private int getNumberOfIterations() {
        return (int) Math.pow(2,(double)variables.size());
    }

    private void setIteration(int i) {
        for (Variable var : variables){
            var.setValue((i % 2 != 0));
            i /=2;
        }
    }

    private void printSolution() {
        System.out.println("Satisfied clauses: " + sol.numOfSatisfiedClauses());
        String res = "";
        ArrayList<Variable> vars = sol.getVariables();
        
        Collections.sort(vars);
        for(Variable var : vars){
            res += var.toStringWithVal() + "\n";
        }        
        System.out.println(res);
    } 
    
}
