/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import max.satapprox.BruteForceSol;
import max.satapprox.Clause;
import max.satapprox.SAT;
import max.satapprox.SATGenerator;
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
public class BruteForceTest {
    
    public BruteForceTest() {
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
    
    //@Test
    public void testPrint(){
        
        Variable x1 = new Variable(true,1);
        Variable x2 = new Variable(false,2);
        Variable x3 = new Variable(false,3);
        Variable x4 = new Variable(true,4);
        Variable x5 = new Variable(true,5);
        
        Clause c1 = new Clause(Variable.makeListOfVaraibles(x1,x2),null);
        Clause c2 = new Clause(Variable.makeListOfVaraibles(x3), Variable.makeListOfVaraibles(x1) );
        Clause c3 = new Clause(Variable.makeListOfVaraibles(x2), Variable.makeListOfVaraibles(x3));
        Clause c4 = new Clause(Variable.makeListOfVaraibles(x4,x5), Variable.makeListOfVaraibles(x4));
        
        SAT sat = new SAT(Clause.makeListOfClauses(c1,c2,c3,c4));
        System.out.println(sat.toString());
        BruteForceSol bFS = new BruteForceSol(sat);
        
        bFS.computeSolution();
        
    }
    
    @Test
    public void testRandomSAT(){
        SAT sat = SATGenerator.generateRandomSat(5, 5);
        System.out.println(sat);
        BruteForceSol bFS = new BruteForceSol(sat);
        
        bFS.computeSolution();
    }
    
}