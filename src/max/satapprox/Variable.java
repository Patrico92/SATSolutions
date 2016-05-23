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
public class Variable implements Comparable<Variable>{
    
    private boolean value;
    private boolean set = false;
    private int number;

    public Variable(boolean value, int number) {
        this.value = value;
        this.number = number;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void setSet(boolean set) {
        this.set = set;
    }

    public boolean isSet() {
        return set;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString(){
        return "x"+getNumber();
    }
    
    public String toStringWithVal(){
        return "x"+getNumber() + " = " + (getValue() ? "1" : "0");
    }
    
    public static ArrayList<Variable> makeListOfVaraibles(Variable... vars){
        
        ArrayList<Variable> res = new ArrayList<>();
        res.addAll(Arrays.asList(vars));
        return res;
    }



    @Override
    public int compareTo(Variable o) {
        if(this.number < o.getNumber()) return -1;
        else return 1;
    }


}
