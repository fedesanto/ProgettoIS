package progettoIS.gruppo01.Calculator.ButtonOp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;

public class StackCommanderTest {
    
    private ComplexStack stackNumeri;
    private final int MAX_CAPACITY = 50;
    private StackCommander instance;
    
    @BeforeEach
    public void setUp() {
        
        stackNumeri = new ComplexStack(MAX_CAPACITY);
        instance = new StackCommander(stackNumeri);
        
    }

    /**
     * Test of stackClear method, of class StackCommander.
     */
    
    //Test stackClear quando lo stack ha elementi all'interno.
    
    @Test
    public void testStackClear1() throws FullStackException {
        
        System.out.println("Test stackClear: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(13.1 , -7.2);
        ComplexNum num2 = new ComplexNum(30.2 , 55);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackClear();
        
        assertEquals(0,stackNumeri.getSize());
        
    }
    
    //Test stackClear quando lo stack è vuoto.
    
    @Test
    public void testStackClear2() {
        
        System.out.println("Test stackClear: stack vuoto");
        
        assertEquals(0,stackNumeri.getSize());
        
    }

    
    /**
     * Test of stackDrop method, of class StackCommander.
     */
    
    //Test StackDrop quando lo stack ha elementi all'interno.
    
    @Test
    public void testStackDrop1() throws FullStackException, EmptyStackException {
        
        System.out.println("Test stackDrop: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(4.9 , 26.9);
        ComplexNum num2 = new ComplexNum(37.6 , -9.9);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackDrop();
        
        assertEquals(num1,stackNumeri.top());
        
    }
    
    //Test stackDrop quando lo stack è vuoto.
    
    @Test
    public void testStackDrop2() {
        
        System.out.println("Test stackDrop: stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            instance.stackDrop();
        });

    }

    /**
     * Test of stackDup method, of class StackCommander.
     */
   
    //Test stackDup quando lo stack ha elementi all'interno.
    
    @Test
    public void testStackDup1() throws FullStackException, EmptyStackException {
        
        System.out.println("Test stackDup: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(88.8 , -43);
        
        stackNumeri.insert(num1);
        
        instance.stackDup();
        
        assertEquals(num1,stackNumeri.top());
          
    }
    
    
    //Test stackDup quando lo stack è vuoto.
    
    @Test
    public void testStackDup2() {
        
        System.out.println("Test stackDup: stack vuoto");
        
        assertThrows(EmptyStackException.class,() -> {
            instance.stackDup(); //stackClear non tira EmptyStackException
        });
        
    }
    
    //Test stackDup quando lo stack è pieno. 
    
    @Test
    public void testStackDup3() throws Exception {
        
        System.out.println("Test stackDup: stack pieno");
        
        ComplexNum num1 = new ComplexNum(32.21 , -11);
        
        for(int i=0; i<MAX_CAPACITY; i++){
            
            stackNumeri.insert(num1);
            
        }
        
        assertThrows(FullStackException.class,() -> {
            instance.stackDup();
        });
          
    }

    /**
     * Test of stackSwap method, of class StackCommander.
     */
    
    //Test stackSwap quando lo stack ha elementi all'interno.
    
    @Test
    public void testStackSwap1() throws FullStackException, InsufficientNumbersException, EmptyStackException {
        
        System.out.println("Test stackSwap: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(64 , -232.234);
        ComplexNum num2 = new ComplexNum(-32.1 , -12);

        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackSwap();
        
        assertEquals(num1,stackNumeri.top());
         
    }
    
    //Test stackSwap quando lo stack è vuoto.
    
    @Test
    public void testStackSwap2() {
        
        System.out.println("Test stackSwap: stack vuoto");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackSwap(); 
        });
         
    }
    
    //Test stackSwap quando è presente un solo numero.
    
    @Test
    public void testStackSwap3() throws FullStackException {
        
        System.out.println("Test stackSwap: stack con un solo elemento all'interno");
        
        ComplexNum num1 = new ComplexNum(8 , -24);
        
        stackNumeri.insert(num1);
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackSwap(); 
        });
         
    }

    /**
     * Test of stackOver method, of class StackCommander.
     */

    //Test stackOver quando lo stack non è vuoto.
    
    @Test
    public void testStackOver1() throws FullStackException, InsufficientNumbersException, EmptyStackException {
        
        System.out.println("Test stackOver: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(56 , 21.2);
        ComplexNum num2 = new ComplexNum(99.0 , 10);

        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        instance.stackOver();
        
        assertEquals(num1,stackNumeri.top());
        
    }
       
    //Test stackOver quando lo stack è vuoto.
    
    @Test
    public void testStackOver2() {
        
        System.out.println("Test stackOver: stack è vuoto");
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackOver(); 
        });
        
    }
    
    //Test stackOver quando lo stack è pieno.
    
    @Test
    public void testStackOver3() throws FullStackException, InsufficientNumbersException, EmptyStackException {
        
        System.out.println("Test stackOver: stack non vuoto");
        
        ComplexNum num1 = new ComplexNum(11 , 12.23);
        
        for(int i = 0; i < MAX_CAPACITY; i++){
        
            stackNumeri.insert(num1);
        
        }
        
        assertThrows(FullStackException.class,() -> {
            instance.stackOver();
        });
        
    }
    
    //Test stackOver quando è presente un solo numero nello stack.
    
    @Test
    public void testStackOver4() throws FullStackException, InsufficientNumbersException, EmptyStackException {
        
        System.out.println("Test stackOver: stack con un solo elemento all'interno");
        
        ComplexNum num1 = new ComplexNum(-123 , 54.3);
            
        stackNumeri.insert(num1);
        
        assertThrows(InsufficientNumbersException.class,() -> {
            instance.stackOver();
        });
        
    }
    

    /**
     * Test of getContent method, of class StackCommander.
     */

    //Test getContent quando nello stack sono presenti lo stesso numero degli elementi richiesti.
    
    @Test
    public void testGetContent1() throws FullStackException {
        
        System.out.println("Test getContent: stack con stesso numero di elemtni quanto sono quelli richiesti");
        
        ComplexNum num1 = new ComplexNum(5 , -13.9);
        ComplexNum num2 = new ComplexNum(48 , 8.2);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        int num = 2;
        String[] expResult = {"5 - 13.9j","48 + 8.2j"};
        
        assertArrayEquals(expResult, instance.getContent(num));
        
    }
    
    //Test getContent quando nello stack sono presenti meno numeri di quelli richiesti.
    
    @Test
    public void testGetContent2() throws FullStackException {
        
        System.out.println("Test getContent: stack con meno elementi di quelli richiesti");
        
        ComplexNum num1 = new ComplexNum(-45.9 , -52.3);
        ComplexNum num2 = new ComplexNum(11.8 , 113);
        
        stackNumeri.insert(num1);
        stackNumeri.insert(num2);
        
        int num = 3;
        String[] expResult = {"-45.9 - 52.3j","11.8 + 113j"};

        assertArrayEquals(expResult, instance.getContent(num));

    }
    
    //Test getContent quando lo stack è vuoto.

    @Test
    public void testGetContent3() {
        
        System.out.println("Test getContent: stack vuoto");
        
        int num = 10;

        assertNull(instance.getContent(num));
        
    }

}
