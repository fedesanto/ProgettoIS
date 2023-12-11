package progettoIS.gruppo01.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.SyntaxException;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;



public class ComplexCalculatorTest {
    
    private ComplexCalculator instance;      
    
    @BeforeEach
    public void setUp() {
        instance = new ComplexCalculator();
    }
    
 
    /**
     * Test of parseInput method, of class ComplexCalculator.
     */
    //test di parseInput nel caso di inserimento di un numero, con stack non pieno
    @Test
    public void testParseInput1() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test number");
        
        String input = "+5.23 - 9.23j";
        instance.parseInput(input);
        
        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(new ComplexNum(5.23,-9.23),num);
    }
    
    //test di parseInput nel caso di inserimento di salvataggio su variabile, con stack non vuoto
    @Test
    public void testParseInput3() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test save variable");
        
        instance.parseInput("-3 + 4.25j");
        
        String input = ">x";
        instance.parseInput(input);
        
        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(,);
    }

    /**
     * Test of add method, of class ComplexCalculator.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        ComplexCalculator instance = new ComplexCalculator();
        instance.add();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class ComplexCalculator.
     */
    @Test
    public void testSub() throws Exception {
        System.out.println("sub");
        ComplexCalculator instance = new ComplexCalculator();
        instance.sub();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class ComplexCalculator.
     */
    @Test
    public void testDiv() throws Exception {
        System.out.println("div");
        ComplexCalculator instance = new ComplexCalculator();
        instance.div();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class ComplexCalculator.
     */
    @Test
    public void testMul() throws Exception {
        System.out.println("mul");
        ComplexCalculator instance = new ComplexCalculator();
        instance.mul();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signInv method, of class ComplexCalculator.
     */
    @Test
    public void testSignInv() throws Exception {
        System.out.println("signInv");
        ComplexCalculator instance = new ComplexCalculator();
        instance.signInv();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class ComplexCalculator.
     */
    @Test
    public void testSqrt() throws Exception {
        System.out.println("sqrt");
        ComplexCalculator instance = new ComplexCalculator();
        instance.sqrt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class ComplexCalculator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ComplexCalculator instance = new ComplexCalculator();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class ComplexCalculator.
     */
    @Test
    public void testDrop() throws Exception {
        System.out.println("drop");
        ComplexCalculator instance = new ComplexCalculator();
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class ComplexCalculator.
     */
    @Test
    public void testDup() throws Exception {
        System.out.println("dup");
        ComplexCalculator instance = new ComplexCalculator();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class ComplexCalculator.
     */
    @Test
    public void testSwap() throws Exception {
        System.out.println("swap");
        ComplexCalculator instance = new ComplexCalculator();
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of over method, of class ComplexCalculator.
     */
    @Test
    public void testOver() throws Exception {
        System.out.println("over");
        ComplexCalculator instance = new ComplexCalculator();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastNumbers method, of class ComplexCalculator.
     */
    @Test
    public void testGetLastNumbers() {
        System.out.println("getLastNumbers");
        ComplexCalculator instance = new ComplexCalculator();
        String[] expResult = null;
        String[] result = instance.getLastNumbers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
