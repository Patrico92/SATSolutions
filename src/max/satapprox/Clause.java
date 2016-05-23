/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.satapprox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Patryk Kozieł
 */
public class Clause {
    
    private ArrayList<Variable> variables;
    private ArrayList<Variable> negVariables;

    public Clause(ArrayList<Variable> variables, ArrayList<Variable> negVariables) {
        this.variables = variables;
        this.negVariables = negVariables;
        examine();
    }
    
    public boolean isSatisfied(){
        
        for(int i = 0; i < variables.size(); i++){
            if(variables.get(i).getValue() == true) return true;
        }
        
        for(int i = 0; i < negVariables.size(); i++){
            if(negVariables.get(i).getValue() == false) return true;
        }
        
        return variables.isEmpty() && negVariables.isEmpty();
    }
    
    @Override
    public String toString(){
        String res = "(";
        
        for(int i = 0; i < variables.size(); i++){
            res = res + variables.get(i).toString();
            if(i < variables.size() - 1 || negVariables.size() > 0) res = res + " or ";
        }
        
        for(int i = 0; i < negVariables.size(); i++){
            res = res + "~" + negVariables.get(i).toString();
            if(i < negVariables.size() - 1) res = res + " or ";
        }
        
        res += ")";
        
        return res;
    }
    
    public static ArrayList<Clause> makeListOfClauses(Clause... clauses){
        
        ArrayList<Clause> res = new ArrayList<>();
        res.addAll(Arrays.asList(clauses));
        return res;
    }

    private void examine() {
        if(variables == null){
            variables = new ArrayList<>();
        }
        
        if(negVariables == null){
            negVariables = new ArrayList<>();
        }
    }

    ArrayList<Variable> getVariables() {
        ArrayList<Variable> res = new ArrayList();
        
        for (Variable var : variables){
            res.add(var);
        }
        
        res.removeAll(negVariables);
        
        for (Variable var : negVariables){
            res.add(var);
        }
        
        return res;
    }

    Clause getCopy() {
        Clause clause = new Clause((ArrayList<Variable>)variables.clone(), (ArrayList<Variable>)negVariables.clone());
        return clause;
    }

    boolean existsVariableInPositiveLiteral(Variable var) {
        return variables.contains(var);
    }

    boolean existsVariableInNegativeLiteral(Variable var) {
        return negVariables.contains(var);
    }
    
   public int getSize(){
       return variables.size() + negVariables.size();
   }
   
   public double getExpectedValueWithVariableSet(Variable var){
       
       double exp;
       
       if(variables.contains(var)){
           if (var.getValue() == true){
               exp = 1.0;
           } else {
               exp = 1.0 - Math.pow(0.5, this.getSize()-1 );
           }
       } else if (negVariables.contains(var)){
           if (var.getValue() == false){
               exp = 1.0;
           } else {
               exp = 1.0 - Math.pow(0.5, this.getSize()-1 );
           }
       } else {
           exp = 1.0 - Math.pow(0.5, this.getSize());
       }
       
       return exp;
   }

    void removeVariableWithConditions(Variable var) {
        if(variables.contains(var)) {
            if (var.getValue() == true){
                this.clear();       
            } else {
                variables.remove(var);
            }
        } else if (negVariables.contains(var)){
            if (var.getValue() == false){
                    this.clear();   
            } else {
                negVariables.remove(var);
            }
        }
    }

    private void clear() {
        variables.clear();
        negVariables.clear();  
    }
    
}
