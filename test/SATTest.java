/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import max.satapprox.Clause;
import max.satapprox.SAT;
import max.satapprox.Variable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patryk Kozieł
 */
public class SATTest {
    
    public SATTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    public void test1(){
        
        Variable x1 = new Variable(true,1);
        Variable x2 = new Variable(false,2);
        Variable x3 = new Variable(false,3);
        
        Clause c1 = new Clause(Variable.makeListOfVaraibles(x1,x2),null);
        Clause c2 = new Clause(Variable.makeListOfVaraibles(x3), Variable.makeListOfVaraibles(x1) );
        Clause c3 = new Clause(Variable.makeListOfVaraibles(x2), Variable.makeListOfVaraibles(x3));
        
        SAT sat = new SAT(Clause.makeListOfClauses(c1,c2,c3));
        System.out.println(sat.toString());
        assertEquals(2,sat.numOfSatisfiedClauses());
        x1.setValue(false);
        assertEquals(2,sat.numOfSatisfiedClauses());

    }
    @Test
    public void numOfVariables(){
        
        Variable x1 = new Variable(true,1);
        Variable x2 = new Variable(false,2);
        Variable x3 = new Variable(false,3);
        Variable x4 = new Variable(true,4);
        
        Clause c1 = new Clause(Variable.makeListOfVaraibles(x1,x2),null);
        Clause c2 = new Clause(Variable.makeListOfVaraibles(x3), Variable.makeListOfVaraibles(x1) );
        Clause c3 = new Clause(Variable.makeListOfVaraibles(x2), Variable.makeListOfVaraibles(x3));
        Clause c4 = new Clause(Variable.makeListOfVaraibles(x4), Variable.makeListOfVaraibles(x4));
        
        SAT sat = new SAT(Clause.makeListOfClauses(c1,c2,c3,c4));
        System.out.println(sat.toString());
        
        ArrayList<Variable> vars = sat.getVariables();
        for(int i = 0; i < vars.size(); i++){
            System.out.println(vars.get(i).toString());
        }
        
        assertEquals(4, sat.getVariables().size());
    }
}
