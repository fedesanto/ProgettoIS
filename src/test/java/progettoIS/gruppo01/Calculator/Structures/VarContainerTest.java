package progettoIS.gruppo01.Calculator.Structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;

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
     * Test of getValue method, of class VarContainer.
     */
    @Test
    public void testGetValueAndSetValue1() throws Exception {
        System.out.println("Test setValue e getValue: caso ordinario");
        ComplexNum num=new ComplexNum(23, 23);
        varC.setValue('x', num);
        assertEquals(num, varC.getValue('x'));
    }   
   
    @Test
     public void testGetValueAndSetValue2() throws Exception {
        System.out.println("Test setValue e getValue: caso numero complesso uguale a 0");
        ComplexNum num=new ComplexNum(0, 0);
        varC.setValue('x', num);
        assertEquals(num, varC.getValue('x'));
    }
    
    @Test
    public void testGetValueAndSetValue3() throws Exception {
        System.out.println("Test setValue e getValue: caso di doppio setValue su variabili diverse ");
        ComplexNum num1=new ComplexNum(26,54);
        varC.setValue('x', num1);
        varC.setValue('y', num1);
        assertEquals(num1, varC.getValue('x'));
        assertEquals(num1, varC.getValue('x'));
    }
    @Test
    public void testGetValueAndSetValue4() throws Exception {
        System.out.println("Test setValue e getValue: caso di doppio setValue sulla stessa variabile");
        ComplexNum num1=new ComplexNum(26,54);
        ComplexNum num2=new ComplexNum(45,78);
        varC.setValue('x', num1);
        varC.setValue('x', num2);
        assertEquals(num2, varC.getValue('x'));
    }
    @Test
    public void testGetValueAndSetValue5() throws Exception {
        System.out.println("Test setValue e getValue: caso di doppia getValue su variabili diverse");
        ComplexNum num=new ComplexNum(26,54);
        varC.setValue('x', num);
        varC.setValue('y', num);
        assertEquals(num, varC.getValue('x'));
        assertEquals(num, varC.getValue('y'));
    }
    @Test
    public void testGetValueAndSetValue6() throws Exception {
        System.out.println("Test setValue e getValue: caso di doppia getValue sulla stessa variabile");
        ComplexNum num=new ComplexNum(26,54);
        varC.setValue('x', num);
        assertEquals(num, varC.getValue('x'));
        assertEquals(num, varC.getValue('x'));
    }
    @Test
    public void testGetValue() throws Exception {
        System.out.println("Test getValue: caso in cui si verifica una UninitializedVariableException ");
        assertThrows(UninitializedVariableException.class,()->{
            varC.getValue('y');
        });
       
    }
         
}