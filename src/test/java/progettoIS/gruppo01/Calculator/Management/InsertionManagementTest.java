package progettoIS.gruppo01.Calculator.Management;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;

/**
 *
 * @author attil
 */
public class InsertionManagementTest {
    
    private final int MAX_CAPACITY = 50;
    private ComplexStack stack;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new ComplexStack(MAX_CAPACITY);
    }
    

    /**
     * Test of execute method, of class InsertionManagement.
     */
    @Test 
    public void testExecute1() throws FullStackException, EmptyStackException{
        System.out.println("execute");
        String input = "2 + 3j";
        InsertionManagement instance = new InsertionManagement(stack);
        
        instance.execute(input);
        
        assertEquals(stack.top(),ComplexNum.parseComplex(input));
    }
    
    @Test 
    public void testExecute2() throws FullStackException, EmptyStackException {
        System.out.println("execute");
        String input = "-3 + 4j";
        InsertionManagement instance = new InsertionManagement(stack);
        
        instance.execute(input);
        
        assertEquals(stack.top(),ComplexNum.parseComplex(input));
    }
    
    @Test 
    public void testExecute3() throws FullStackException, EmptyStackException {
        stack.insert(new ComplexNum(3,2));
        System.out.println("execute");
        String input = "-5.0 + 7.23j";
        InsertionManagement instance = new InsertionManagement(stack);
        
        instance.execute(input);
        
        assertEquals(stack.top(),ComplexNum.parseComplex(input));
    }
    
    @Test 
    public void testExecute4() throws FullStackException {
        stack= new ComplexStack(0);
        
        System.out.println("execute");
        String input = "-7 + 3.57j";
        
        InsertionManagement instance = new InsertionManagement(stack);
                
        assertThrows(FullStackException.class, () -> {
            instance.execute(input);
        });
    }
    
}
