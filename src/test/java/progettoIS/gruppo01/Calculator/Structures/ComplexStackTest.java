package progettoIS.gruppo01.Calculator.Structures;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;


public class ComplexStackTest {
    
   private ComplexStack compS;

    /**
     * Test of insert method, of class ComplexStack.
     */
    @BeforeEach
    public void setUp() {
       compS = new ComplexStack(10);
    }
    
    
    @Test
    public void testInsertAndTop1() throws Exception {
        System.out.println("Test inser e top :caso ordinario");
        ComplexNum num = new ComplexNum(23,23);
        compS.insert(num);
        assertEquals(num,compS.top());
    }
   
    @Test
     public void testInsertAndTop2() throws Exception {
        System.out.println("Test insert e top: caso numero complesso uguale a 0");
       ComplexNum num = new ComplexNum(0,0);
        compS.insert(num);
        assertEquals(num,compS.top());
    }   
      
    @Test
    public void testInsertAndRemove1() throws Exception {
        System.out.println("Test insert e remove:  due insert e due remove consecutivi ");
        ComplexNum num1 = new ComplexNum(0,-23);
        ComplexNum num2 = new ComplexNum(84,-23);
        compS.insert(num1);
        compS.insert(num2);
        assertEquals(num2,compS.remove());
        assertEquals(num1,compS.remove());
    }
    @Test
    public void testInsert1() throws Exception {
        System.out.println("Test insert: caso in cui si verifica una FullStackException ");
        compS = new ComplexStack(0);
        assertThrows(FullStackException.class,()->{
            compS.insert(new ComplexNum(23,23));
        });
         }
    /**
     * Test of remove method, of class ComplexStack.
     */
    
    @Test
    public void testRemove1() throws Exception {
        System.out.println("Test remove:caso ordinario");
        ComplexNum num = new ComplexNum(23,23);
        compS.insert(num);
        assertEquals(num,compS.remove());
    }
   
    @Test
     public void testRemove2() throws Exception {
        System.out.println("Test remove: caso numero complesso uguale a 0");
       ComplexNum num = new ComplexNum(0,0);
        compS.insert(num);
        assertEquals(num,compS.remove());
    }
     
    @Test
    public void testRemove3() throws Exception {
        System.out.println("Test remove: caso in cui si verifica una EmptyStackException ");
        assertThrows(EmptyStackException.class,()->{
            compS.remove();
        });
         }

    /**
     * Test of top method, of class ComplexStack.
     */
    
    @Test
    public void testTop1() throws Exception {
        System.out.println("Test top: caso di due top consecutivi");
        ComplexNum num = new ComplexNum(23,23);
        compS.insert(num);
        assertEquals(num,compS.top());
        assertEquals(num,compS.top());
    }
    @Test
    public void testTop2() throws Exception {
        System.out.println("Test top: caso in cui si verifica una EmptyStackException ");
        assertThrows(EmptyStackException.class,()->{
            compS.top();
        });
         }

    /**
     * Test of getSize method, of class ComplexStack.
     */
    @Test
    public void testGetSize1() throws FullStackException {
        System.out.println("Test getSize:caso ordinario");
        compS=new ComplexStack(2);
        compS.insert(new ComplexNum(43,90));
        assertEquals(1, compS.getSize());
    }
    @Test
    public void testGetSize2() {
        System.out.println("Test getSize:caso stack vuoto");
        assertEquals(0, compS.getSize());
    }
     @Test
    public void testGetSize3() throws FullStackException {
        compS=new ComplexStack(1);
        System.out.println("Test getSize:caso stack pieno");
        compS.insert(new ComplexNum(43,90));
        assertEquals(1, compS.getSize());
    }
    
}
