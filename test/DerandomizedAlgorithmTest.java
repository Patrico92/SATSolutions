/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import max.satapprox.BruteForceSol;
import max.satapprox.SAT;
import max.satapprox.SATDerandomizedSolution;
import max.satapprox.SATGenerator;
import max.satapprox.SATSimpleApprox;
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
public class DerandomizedAlgorithmTest {
    
    public DerandomizedAlgorithmTest() {
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
    public void firstTest(){
        SAT sat = SATGenerator.generateRandomSat(7, 10);
        SATDerandomizedSolution satDS = new SATDerandomizedSolution(sat);
        satDS.computeSolution();
    }
    
    @Test
    public void compareSolutions(){
        SAT sat = SATGenerator.generateRandomSat(7, 10);

        SATSimpleApprox ssa = new SATSimpleApprox(sat);
        ssa.getApproxSolution();
        
        BruteForceSol bFS = new BruteForceSol(sat);
        System.out.println(bFS.computeSolution().getSolution());
        
        SATDerandomizedSolution satDS = new SATDerandomizedSolution(sat);
        satDS.computeSolution();
    }
}
