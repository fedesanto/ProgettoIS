package progettoIS.gruppo01.Calculator.Management;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;

public class InsertionManagementTest {

    private final int MAX_CAPACITY = 50;
    private ComplexStack stack;
    private InsertionManagement instance;

    /*
     Test of execute method, of class InsertionManagement.
     */
    
    //test di execute nel caso di input tipico
    @Test
    public void testExecute1() throws FullStackException, EmptyStackException {
        System.out.println("InsertionManagement execute test typical");

        stack = new ComplexStack(MAX_CAPACITY);
        instance = new InsertionManagement(stack);
        
        String input = "2.2 + 3.5j";
        instance.execute(input);

        assertEquals(stack.top(), ComplexNum.parseComplex(input));
    }

    //test di execute nel caso di input invalido
    @Test
    public void testExecute2() throws FullStackException {
        System.out.println("InsertionManagement execute test full stack");
        
        stack = new ComplexStack(0);
        instance = new InsertionManagement(stack);
        
        stack = new ComplexStack(2);
        stack.insert(new ComplexNum(5.25 ,-36.5));
        stack.insert(new ComplexNum(-25 ,-39.4));

        String input = "-7.0 + 3.57j";

        assertThrows(FullStackException.class, () -> {
            instance.execute(input);
        });
    }

}
