/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

/**
 *
 * @author Patryk Kozieł
 */
public class SATSolution {
    
    private String solution;

    public SATSolution(SAT sat) {
        solution = "Satisfied clauses: " + sat.numOfSatisfiedClauses() + "\n" + sat.toStringValues();
    }

    public String getSolution() {
        return solution;
    }

}
