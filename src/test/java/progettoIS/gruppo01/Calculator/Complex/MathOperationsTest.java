
package progettoIS.gruppo01.Calculator.Complex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Federico Santonicola
 */
public class MathOperationsTest {

    /**
     * Test of somma method, of class MathOperations.
     */
    @Test
    public void testSomma() {
        System.out.println("somma");
        ComplexNum num1 = new ComplexNum(23, 53);
        ComplexNum num2 = new ComplexNum(534, 23);
        ComplexNum expResult = new ComplexNum(23+534, 53+23);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of sottrazione method, of class MathOperations.
     */
    @Test
    public void testSottrazione() {
        System.out.println("sottrazione");
        ComplexNum num1 = null;
        ComplexNum num2 = null;
        ComplexNum expResult = null;
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divisione method, of class MathOperations.
     */
    @Test
    public void testDivisione() {
        System.out.println("divisione");
        ComplexNum num1 = null;
        ComplexNum num2 = null;
        ComplexNum expResult = null;
        ComplexNum result = MathOperations.divisione(num1, num2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moltiplicazione method, of class MathOperations.
     */
    @Test
    public void testMoltiplicazione() {
        System.out.println("moltiplicazione");
        ComplexNum num1 = null;
        ComplexNum num2 = null;
        ComplexNum expResult = null;
        ComplexNum result = MathOperations.moltiplicazione(num1, num2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class MathOperations.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNum num = null;
        ComplexNum expResult = null;
        ComplexNum result = MathOperations.sqrt(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invSegno method, of class MathOperations.
     */
    @Test
    public void testInvSegno() {
        System.out.println("invSegno");
        ComplexNum num = null;
        ComplexNum expResult = null;
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
