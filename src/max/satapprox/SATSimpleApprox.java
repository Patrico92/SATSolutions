/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Patryk Kozieł
 */
public class SATSimpleApprox {
    
    private SAT sat;
    
    public SATSimpleApprox(SAT sat){
        this.sat = sat;
    }
    
    public ArrayList<Variable> getApproxSolution(){
        
        Random generator = new Random();
        ArrayList<Variable> variables = sat.getVariables();
        
        for (Variable var : variables){
            var.setValue(generator.nextBoolean());
        }
        
        System.out.println("satisfied clauses: " + sat.numOfSatisfiedClauses());
        System.out.println(sat.toStringWithVals());
        return variables;
        
    }
    
}
