/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author Patryk Kozieł
 */
public class SAT {
    
    private ArrayList<Clause> clauses;

    public SAT(ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }
    
    public int numOfSatisfiedClauses(){
        
        int res = 0;
        for (int i = 0; i < clauses.size(); i++){
            res += clauses.get(i).isSatisfied() ? 1 : 0;
        }
        
        return res;
    }
    
    @Override
    public String toString(){
        String res = "";
        
        for (int i = 0; i < clauses.size(); i++){
            res += clauses.get(i).toString();
            if(i!= clauses.size() - 1) res += " and ";
        }
        
        return res;
    }
    
    public String toStringWithVals(){
        String res = toString() + "\n";
        ArrayList<Variable> vars = getVariables();
        
        Collections.sort(vars);
        for(Variable var : vars){
            res += var.toStringWithVal() + "\n";
        }
        
        return res;
    }

    public SAT(SAT sat) {
        this(sat.getCopiedClauses());
    }

    public ArrayList<Clause> getClauses() {
        return clauses;
    }

    public ArrayList<Variable> getVariables() {
        
        ArrayList<Variable> res = new ArrayList<>();
        HashSet<Variable> set = new HashSet<>();
        
        clauses.stream().forEach((clause) -> {
            clause.getVariables().stream().forEach((variable) -> {
                set.add(variable);
            });
        });
        
       res.addAll(set);
       Collections.sort(res);
       return res;
    }

    int getNumOfClauses() {
        return clauses.size();
    }

    String toStringValues() {
        String res = "";
        for (Variable var : getVariables()){
            res += var.toStringWithVal() + "\n";
        }
        return res;
    }
    
    public ArrayList<Clause> getCopiedClauses(){
        
        ArrayList<Clause> clauses = new ArrayList<>();
        
        for (Clause clause : getClauses()){
            clauses.add(clause.getCopy());
        }
        
        return clauses;
    }
    
    public void removeVariableFromClauses(Variable var){
        ArrayList<Clause> clausesToRemove = new ArrayList<>();
        for (Clause clause : clauses){
            clause.removeVariableWithConditions(var);   
            if (clause.getSize() == 0) clausesToRemove.add(clause);
        }
        clauses.removeAll(clausesToRemove);
    }

    double getExpectedValueWhenVariableSet(Variable variable, boolean b) {
        double ex = 0.0;
        variable.setValue(b);
        
        for (Clause clause : clauses){
            ex += clause.getExpectedValueWithVariableSet(variable);
        }
        
        return ex;
    }
    
    
}
