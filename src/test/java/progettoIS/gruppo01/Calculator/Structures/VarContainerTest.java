package progettoIS.gruppo01.Calculator.Structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;

/**
 *
 * @author Federico Santonicola
 */
public class VarContainerTest {
    private VarContainer varC;
    
    @BeforeEach
    public void setUp() {
        varC = new VarContainer();
    }

    /**
     * Test of setValue method, of class VarContainer.
     */
    @Test
    public void testSetValue() {
        
    }

    /**
     * Test of getValue method, of class VarContainer.
     */
    @Test
    public void testGetValue1() throws Exception {
        System.out.println("Test getValue: caso ordinario");
        varC.setValue('x', new ComplexNum(23, 23));
        assertEquals(varC.getValue('x'), new ComplexNum(23, 23));
    }   
}