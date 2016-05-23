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
public class SATGenerator {
    
    public static SAT generateRandomSat(int numOfVar, int numOfClauses){
        
        Random generator = new Random();
        ArrayList<Variable> variables = new ArrayList<>();
        for (int i = 1; i <= numOfVar; i++){
            variables.add(new Variable(generator.nextBoolean(),i));
        }
        
        ArrayList<Clause> clauses = new ArrayList<>();
        
        for (int i =0; i < numOfClauses; i++){
            ArrayList<Variable> var = new ArrayList<>();
            ArrayList<Variable> negVar = new ArrayList<>();
            for(int j = 0; j < numOfVar; j++){
                if (generator.nextBoolean()){
                    if(generator.nextBoolean()) var.add(variables.get(j));
                    else negVar.add(variables.get(j));
                }
            } 
            if(var.size() > 0 || negVar.size() > 0) clauses.add(new Clause(var,negVar));   
        }
        
        SAT sat = new SAT(clauses);
        
        return sat;
        
    }
    
}
