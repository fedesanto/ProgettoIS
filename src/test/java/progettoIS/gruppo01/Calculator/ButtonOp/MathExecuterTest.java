package progettoIS.gruppo01.Calculator.ButtonOp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Complex.MathOperations;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;
import progettoIS.gruppo01.Exceptions.MathException;

public class MathExecuterTest {
    
    private ComplexStack stackNumeri;
    private final int MAX_CAPACITY = 10;
    private MathExecuter instance;
    
    @BeforeEach
    public void setUp() {
        
        stackNumeri = new ComplexStack(MAX_CAPACITY);
        instance = new MathExecuter(stackNumeri);
        
    }

    /**
     * Test of stackAdd method, of class MathExecuter.
     */
    
    
    //Test di stackAdd con stack non vuoto e entrambi inumeri hanno parte reale e immaginaria non nulle.
    
    @Test
    public void testStackAdd1() throws FullStackException, InsufficientNumbersException, EmptyStackException {
        
        System.out.println("Test stackAdd : caso ordinario");
        
        ComplexNum num1 = new ComplexNum(2.0 , -37.2);
        ComplexNum num2 = new ComplexNum(-9.8 , 5);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackAdd();
        
        assertEquals(MathOperations.somma(num1,num2),stackNumeri.top());
        
    }

    //Test di stackAdd con stack vuoto.
    
    @Test
    public void testStackAdd2() {
        
        System.out.println("Test stackAdd : numeri insufficienti nello stack");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackAdd();
        });
        
    }
    
    

    /**
     * Test of stackSub method, of class MathExecuter.
     */
    
    //Test di stackSub con stack non vuoto e entrambi inumeri hanno parte reale e immaginaria non nulle.
    
    @Test
    public void testStackSub1() throws InsufficientNumbersException, EmptyStackException, FullStackException {
        
        System.out.println("Test stackSub : caso ordinario");
        
        ComplexNum num1 = new ComplexNum(-5.9 , 46);
        ComplexNum num2 = new ComplexNum(36.0 , 23.2);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackSub();
        
        assertEquals(MathOperations.sottrazione(num1,num2),stackNumeri.top()); //invertendo l'ordine il test fallisce
        
    }
    
    //Test di stackSub con stack vuoto.
    
    @Test
    public void testStackSub2() {
        
        System.out.println("Test stackSub : numeri insufficienti nello stack");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackSub();
        });
        
    }

    /**
     * Test of stackDiv method, of class MathExecuter.
     */
   
    //Test di stackDiv con stack non vuoto e entrambi inumeri hanno parte reale e immaginaria non nulle.
    
    @Test
    public void testStackDiv1() throws InsufficientNumbersException, MathException, EmptyStackException, FullStackException {
        
        System.out.println("Test stackDiv: caso ordinario");
        
        ComplexNum num1 = new ComplexNum(17.5 , -15.0);
        ComplexNum num2 = new ComplexNum(23 , 9.17);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackDiv();
        
        assertEquals(MathOperations.divisione(num1,num2),stackNumeri.top()); //invertendo l'ordine il test fallisce
        
    }
    
    //Test di stackDiv con stack vuoto.
    
    @Test
    public void testStackDiv2() {
        
        System.out.println("Test stackDiv: numeri insufficenti nello stack");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackDiv();
        });
        
    }
    
    //Test di stackDiv nel caso in cui il dividendo sia 0.
    
    @Test
    public void testStackDiv3() throws FullStackException, InsufficientNumbersException, MathException {
        
        System.out.println("Test stackDiv: divisione per zero");
        
        ComplexNum num1 = new ComplexNum(57.2 , -34.8);
        ComplexNum num2 = new ComplexNum(0 , 0);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        assertThrows(MathException.class,() -> {
            instance.stackDiv();
        });
        
    }

    /**
     * Test of stackMul method, of class MathExecuter.
     */
  
    //Test di stackMul con stack non vuoto e entrambi inumeri hanno parte reale e immaginaria non nulle.
    
    @Test
    public void testStackMul1() throws InsufficientNumbersException, EmptyStackException, FullStackException {
       
        System.out.println("Test stackMul: caso ordinario");
        
        ComplexNum num1 = new ComplexNum(-45.1, 22.2);
        ComplexNum num2 = new ComplexNum(21 , 10.9);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackMul();
        
        assertEquals(MathOperations.moltiplicazione(num2,num1),stackNumeri.top());

        
    }
    
    //Test di stackMul con stack vuoto.
    
    @Test
    public void testStackMul2() {
       
        System.out.println("Test stackMul: nueri insufficienti nello stack");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackMul();
        });
        
    }

    /**
     * Test of stackSignInv method, of class MathExecuter.
     */
 
    //Test di stackSignInv con stack non vuoto e e il numero ha parte reale e immaginaria non nulle.
    
    @Test
    public void testStackSignInv1() throws EmptyStackException, FullStackException {
        
        System.out.println("Test stackSignInv: caso ordinario"); 
        
        ComplexNum num1 = new ComplexNum(-11.7, 33);
        
        stackNumeri.insert(num1);
        
        instance.stackSignInv();
        
        assertEquals(MathOperations.invSegno(num1),stackNumeri.top());
        
    }
    
    //Test di stackSignInv con stack vuoto.
    
    @Test
    public void testStackSignInv2() {
        
        System.out.println("Test stackSignInv: numeri insufficienti nello stack");
        
        assertThrows(EmptyStackException.class,() -> {
            instance.stackSignInv();
        });
        
    }

    /**
     * Test of stackSqrt method, of class MathExecuter.
     */
 
    //Test di stackSqrt con stack non vuoto e il numero ha parte reale e immaginaria non nulle.
    
    @Test
    public void testStackSqrt1() throws EmptyStackException, FullStackException {
        
        System.out.println("Test stackSqrt: caso ordinario");
        
        ComplexNum num1 = new ComplexNum(7.77, -32.5);
        
        stackNumeri.insert(num1);
        
        instance.stackSqrt();
        
        assertEquals(MathOperations.sqrt(num1),stackNumeri.top());
       
    }
    
    //Test di stackSqrt con stack vuoto.
    
    @Test
    public void testStackSqrt2() {
        
        System.out.println("Test stackSqrt: numeri insufficinenti nello stack");
        
        assertThrows(EmptyStackException.class,() -> {
            instance.stackSqrt();
        });
        
    }

}
