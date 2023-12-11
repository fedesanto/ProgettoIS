
package progettoIS.gruppo01.Calculator.Complex;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComplexNumTest {

    /**
     * Test of getRealPart method, of class ComplexNum.
     */
    @Test
    public void testGetRealPart() {
        System.out.println("Test getRealPart");
        ComplexNum num = new ComplexNum(23.5542, 53);
        
        double expResult = 23.5542;
        double result = num.getRealPart();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getImgPart method, of class ComplexNum.
     */
    @Test
    public void testGetImgPart() {
        System.out.println("Test getImgPart");
        ComplexNum num = new ComplexNum(23.5542, 0);
        
        double expResult = 0;
        double result = num.getImgPart();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexNum.
     */
    @Test
    public void testToString1() {
        System.out.println("Test toString: parte reale e parte immaginaria interi > 0");
        ComplexNum num = new ComplexNum(532, 12);
        
        String expResult = "532 + 12j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testToString2() {
        System.out.println("Test toString: parte reale e parte immaginaria interi < 0");
        ComplexNum num = new ComplexNum(-32, -1);
        
        String expResult = "-32 - 1j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testToString3() {
        System.out.println("Test toString: parte reale e parte immaginaria decimali > 0");
        ComplexNum num = new ComplexNum(432.124, 5.9);
        
        String expResult = "432.124 + 5.9j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testToString4() {
        System.out.println("Test toString: parte reale e parte immaginaria decimali < 0");
        ComplexNum num = new ComplexNum(-42.54, -12.2174);
        
        String expResult = "-42.54 - 12.2174j";
        String result = num.toString();
        
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testToString5() {
        System.out.println("Test toString: parte reale nulla e parte immaginaria < 0");
        ComplexNum num = new ComplexNum(0, -12.634);
        
        String expResult = "-12.634j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testToString6() {
        System.out.println("Test toString: parte reale nulla e parte immaginaria > 0");
        ComplexNum num = new ComplexNum(0, 234);
        
        String expResult = "234j";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testToString7() {
        System.out.println("Test toString: parte immaginaria nulla e parte reale < 0");
        ComplexNum num = new ComplexNum(-312.5, 0);
        
        String expResult = "-312.5";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testToString8() {
        System.out.println("Test toString: parte immaginaria nulla e parte reale > 0");
        ComplexNum num = new ComplexNum(75, 0);
        
        String expResult = "75";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testToString9() {
        System.out.println("Test toString: parte reale ed immaginaria entrambi nulli");
        ComplexNum num = new ComplexNum(0, 0);
        
        String expResult = "0";
        String result = num.toString();
        
        assertEquals(expResult, result); 
    }

    /**
     * Test of parseComplex method, of class ComplexNum.
     */
    @Test
    public void testParseComplex1() {
        System.out.println("Test parseComplex: stringa non valida #1");
        String num = "5+4";
        
        ComplexNum expResult = null;
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex2() {
        System.out.println("Test parseComplex: stringa non valida #2");
        String num = "5 - -4j";
        
        ComplexNum expResult = null;
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex3() {
        System.out.println("Test parseComplex: stringa non valida #3");
        String num = ".4";
        
        ComplexNum expResult = null;
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex4() {
        System.out.println("Test parseComplex: stringa non valida #4");
        String num = "54,5j";
        
        ComplexNum expResult = null;
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex5() {
        System.out.println("Test parseComplex: parte reale ed immaginaria > 0");
        String num = "+23 + 12.6j";
        
        ComplexNum expResult = new ComplexNum(23, 12.6);
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex6() {
        System.out.println("Test parseComplex: parte reale ed immaginaria < 0");
        String num = "-23.21 - 5j";
        
        ComplexNum expResult = new ComplexNum(-23.21, -5);
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex7() {
        System.out.println("Test parseComplex: parte reale nulla");
        String num = "+25.6j";
        
        ComplexNum expResult = new ComplexNum(0, 25.6);
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }
    
    @Test
    public void testParseComplex8() {
        System.out.println("Test parseComplex: parte immaginaria nulla");
        String num = "-25.43256";
        
        ComplexNum expResult = new ComplexNum(-25.43256, 0);
        ComplexNum result = ComplexNum.parseComplex(num);
        
        assertEquals(expResult, result); 
    }

    /**
     * Test of equals method, of class ComplexNum.
     */
    @Test
    public void testEquals1() {
        System.out.println("Test equals: caso ordinario #1");
        ComplexNum num1 = new ComplexNum(23, -3.54);
        ComplexNum num2 = new ComplexNum(23, -3.54);
        
        assertTrue(num1.equals(num2));
    }
    
    @Test
    public void testEquals2() {
        System.out.println("Test equals: caso ordinario #2");
        ComplexNum num1 = new ComplexNum(23.52345, 0);
        ComplexNum num2 = new ComplexNum(23.52345, 0);
        
        assertTrue(num1.equals(num2));
    }
    
    @Test
    public void testEquals3() {
        System.out.println("Test equals: caso eccezionale #1");
        ComplexNum num1 = new ComplexNum(-543, 65.3);
        Object num2 = new Object();
        
        assertFalse(num1.equals(num2));
    }
    
    @Test
    public void testEquals4() {
        System.out.println("Test equals: caso eccezionale #2");
        ComplexNum num1 = new ComplexNum(-543, 65.3);
        ComplexNum num2 = num1;
        
        assertTrue(num1.equals(num2));
    }
    
    @Test
    public void testEquals5() {
        System.out.println("Test equals: caso eccezionale #3");
        ComplexNum num1 = new ComplexNum(-543, 65.3);
        ComplexNum num2 = null;
        
        assertFalse(num1.equals(num2));
    }
    
}
