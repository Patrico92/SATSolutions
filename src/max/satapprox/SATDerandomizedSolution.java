/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

import java.util.ArrayList;

/**
 *
 * @author Patryk Kozieł
 */
public class SATDerandomizedSolution {
    
    private SAT sat;

    public SATDerandomizedSolution(SAT sat) {
        this.sat = sat;
    }
    
    public void computeSolution(){
        
        SAT outputSAT = new SAT(sat);
        System.out.println(sat.toString());
        ArrayList<Variable> variables = sat.getVariables();

        for (Variable variable : variables) {
            double exp1 = sat.getExpectedValueWhenVariableSet(variable, true);
            double exp2 = sat.getExpectedValueWhenVariableSet(variable, false);
            
            if (exp1 >= exp2) variable.setValue(true); 
            else variable.setValue(false);

            sat.removeVariableFromClauses(variable);
            System.out.println("Exp1 = " + exp1 + " Exp2 = " + exp2 + "\n" + sat.toString());
        }
        
        System.out.println(outputSAT.toStringWithVals() + "Satisfied clauses: " + outputSAT.numOfSatisfiedClauses());
        
    }
}
