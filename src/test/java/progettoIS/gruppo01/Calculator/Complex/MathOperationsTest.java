package progettoIS.gruppo01.Calculator.Complex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MathOperationsTest {

    /**
     * Test of somma method, of class MathOperations.
     */
    @Test
    public void testSomma1() {
        System.out.println("Test sommma: parte reale ed immaginaria entrambi positivi");
        ComplexNum num1 = new ComplexNum(23.5, 53);
        ComplexNum num2 = new ComplexNum(534.2, 23.98);
        ComplexNum expResult = new ComplexNum(23.5+534.2, 53+23.98);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSomma2() {
        System.out.println("Test sommma: parte reale ed immaginaria entrambi negativi");
        ComplexNum num1 = new ComplexNum(-235, -123);
        ComplexNum num2 = new ComplexNum(-7.10, -1237.9);
        ComplexNum expResult = new ComplexNum(-235-7.10, -123-1237.9);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSomma3() {
        System.out.println("Test sommma: parte immaginaria nulla");
        ComplexNum num1 = new ComplexNum(8, 0);
        ComplexNum num2 = new ComplexNum(29, 0);
        ComplexNum expResult = new ComplexNum(8+29, 0);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSomma4() {
        System.out.println("Test sommma: parte reale nulla");
        ComplexNum num1 = new ComplexNum(0, 235);
        ComplexNum num2 = new ComplexNum(0, -12.643);
        ComplexNum expResult = new ComplexNum(0, 235-12.643);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSomma5() {
        System.out.println("Test sommma: misto");
        ComplexNum num1 = new ComplexNum(0, -235);
        ComplexNum num2 = new ComplexNum(12.6, 43.1);
        ComplexNum expResult = new ComplexNum(0+12.6, -235+43.1);
        
        ComplexNum result = MathOperations.somma(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of sottrazione method, of class MathOperations.
     */
    @Test
    public void testSottrazione1() {
        System.out.println("Test sottrazione: parte reale ed immaginaria entrambi positivi");
        ComplexNum num1 = new ComplexNum(23.5, 53);
        ComplexNum num2 = new ComplexNum(534.2, 23.98);
        ComplexNum expResult = new ComplexNum(23.5-534.2, 53-23.98);
        
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSottrazione2() {
        System.out.println("Test sottrazione: parte reale ed immaginaria entrambi negativi");
        ComplexNum num1 = new ComplexNum(-235, -123);
        ComplexNum num2 = new ComplexNum(-7.10, -1237.9);
        ComplexNum expResult = new ComplexNum(-235+7.10, -123+1237.9);
        
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSottrazione3() {
        System.out.println("Test sottrazione: parte immaginaria nulla");
        ComplexNum num1 = new ComplexNum(8, 0);
        ComplexNum num2 = new ComplexNum(29, 0);
        ComplexNum expResult = new ComplexNum(8-29, 0);
        
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSottrazione4() {
        System.out.println("Test sottrazione: parte reale nulla");
        ComplexNum num1 = new ComplexNum(0, 235);
        ComplexNum num2 = new ComplexNum(0, -12.643);
        ComplexNum expResult = new ComplexNum(0, 235+12.643);
        
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSottrazione5() {
        System.out.println("Test sottrazione: misto");
        ComplexNum num1 = new ComplexNum(0, -235);
        ComplexNum num2 = new ComplexNum(12.6, 43.1);
        ComplexNum expResult = new ComplexNum(0-12.6, -235-43.1);
        
        ComplexNum result = MathOperations.sottrazione(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of divisione method, of class MathOperations.
     */
    @Test
    public void testDivisione1() {
        System.out.println("Test divisione: parte reale intera e parte immaginaria decimale");
        double a, b, c, d;
        a = -643;
        b = 53;
        c = -12.432;
        d = 0.12;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round(((a*c + b*d)/(c*c + d*d))*1000.0)/1000.0;
        double imgPart = Math.round(((b*c - a*d)/(c*c + d*d))*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.divisione(num1, num2);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testDivisione2() {
        System.out.println("Test divisione: parte reale decimale e parte immaginaria intera");
        double a, b, c, d;
        a = -3.12443;
        b = 53.65;
        c = 12;
        d = -5421;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round(((a*c + b*d)/(c*c + d*d))*1000.0)/1000.0;
        double imgPart = Math.round(((b*c - a*d)/(c*c + d*d))*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.divisione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDivisione3() {
        System.out.println("Test divisione: parte reale nulla");
        double a, b, c, d;
        a = 0;
        b = -124;
        c = 0;
        d = 0.12;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round(((a*c + b*d)/(c*c + d*d))*1000.0)/1000.0;
        double imgPart = Math.round(((b*c - a*d)/(c*c + d*d))*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.divisione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDivisione4() {
        System.out.println("Test divisione: divisione per 0");
        double a, b, c, d;
        a = 413.34;
        b = -12.6;
        c = 0;
        d = 0;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);

        assertNull(MathOperations.divisione(num1, num2));
    }

    /**
     * Test of moltiplicazione method, of class MathOperations.
     */
    @Test
    public void testMoltiplicazione1() {
        System.out.println("Test moltiplicazione: parte reale intera e parte immaginaria decimale");
        double a, b, c, d;
        a = -643;
        b = 53;
        c = -12.432;
        d = 0.12;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round((a*c - b*d)*1000.0)/1000.0;
        double imgPart = Math.round((a*d + b*c)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.moltiplicazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testMoltiplicazione2() {
        System.out.println("Test moltiplicazione: parte reale decimale e parte immaginaria intera");
        double a, b, c, d;
        a = -3.12443;
        b = 53.65;
        c = 12;
        d = -5421;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round((a*c - b*d)*1000.0)/1000.0;
        double imgPart = Math.round((a*d + b*c)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.moltiplicazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMoltiplicazione3() {
        System.out.println("Test moltiplicazione: parte reale nulla");
        double a, b, c, d;
        a = 0;
        b = -124;
        c = 0;
        d = 0.12;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round((a*c - b*d)*1000.0)/1000.0;
        double imgPart = Math.round((a*d + b*c)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.moltiplicazione(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMoltiplicazione4() {
        System.out.println("Test moltiplicazione: moltiplicazione per 0");
        double a, b, c, d;
        a = 413.34;
        b = -12.6;
        c = 0;
        d = 0;
        ComplexNum num1 = new ComplexNum(a, b);
        ComplexNum num2 = new ComplexNum(c, d);
        
        double realPart = Math.round((a*c - b*d)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(0, 0);

        ComplexNum result = MathOperations.moltiplicazione(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of sqrt method, of class MathOperations.
     */
    @Test
    public void testSqrt1() {
        System.out.println("Test radice quadrata: parte reale ed immaginaria positivi");
        double a, b, modulo, argomento;
        a = 32.53;
        b = 321.76;
        ComplexNum num = new ComplexNum(a, b);
        
        modulo = Math.sqrt(a*a + b*b);
        argomento =  Math.atan2(b,a);
        double realPart = Math.round(Math.sqrt(modulo)*Math.cos(argomento/2.0)*1000.0)/1000.0;
        double imgPart = Math.round(Math.sqrt(modulo)*Math.sin(argomento/2.0)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.sqrt(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSqrt2() {
        System.out.println("Test radice quadrata: parte reale ed immaginaria negativi");
        double a, b, modulo, argomento;
        a = -234.10;
        b = -5432.4254;
        ComplexNum num = new ComplexNum(a, b);
        
        modulo = Math.sqrt(a*a + b*b);
        argomento =  Math.atan2(b,a);
        double realPart = Math.round(Math.sqrt(modulo)*Math.cos(argomento/2.0)*1000.0)/1000.0;
        double imgPart = Math.round(Math.sqrt(modulo)*Math.sin(argomento/2.0)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.sqrt(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSqrt3() {
        System.out.println("Test radice quadrata: parte immaginaria nulla");
        double a, b, modulo, argomento;
        a = -64;
        b = 0;
        ComplexNum num = new ComplexNum(a, b);
        
        modulo = Math.sqrt(a*a + b*b);
        argomento = Math.atan2(b,a);
        double realPart = Math.round(Math.sqrt(modulo)*Math.cos(argomento/2.0)*1000.0)/1000.0;
        double imgPart = Math.round(Math.sqrt(modulo)*Math.sin(argomento/2.0)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.sqrt(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSqrt4() {
        System.out.println("Test radice quadrata: parte reale nulla");
        double a, b, modulo, argomento;
        a = 0;
        b = 128;
        ComplexNum num = new ComplexNum(a, b);
        
        modulo = Math.sqrt(a*a + b*b);
        argomento =  Math.atan2(b,a);
        double realPart = Math.round(Math.sqrt(modulo)*Math.cos(argomento/2.0)*1000.0)/1000.0;
        double imgPart = Math.round(Math.sqrt(modulo)*Math.sin(argomento/2.0)*1000.0)/1000.0;
        ComplexNum expResult = new ComplexNum(realPart, imgPart);
        
        ComplexNum result = MathOperations.sqrt(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of invSegno method, of class MathOperations.
     */
    @Test
    public void testInvSegno1() {
        System.out.println("Test inversione segno: parte reale ed immaginaria entrambi positivi");
        ComplexNum num = new ComplexNum(23.5, 53);
        ComplexNum expResult = new ComplexNum(-23.5, -53);
        
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvSegno2() {
        System.out.println("Test inversione segno: parte reale ed immaginaria entrambi negativi");
        ComplexNum num = new ComplexNum(-421.5, -653.1);
        ComplexNum expResult = new ComplexNum(421.5, 653.1);
        
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvSegno3() {
        System.out.println("Test inversione segno: parte reale positiva e parte immaginaria negativa");
        ComplexNum num = new ComplexNum(86, -12.4);
        ComplexNum expResult = new ComplexNum(-86, 12.4);
        
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvSegno4() {
        System.out.println("Test inversione segno: parte reale negativa ed parte reale positiva");
        ComplexNum num = new ComplexNum(-64.75, 12);
        ComplexNum expResult = new ComplexNum(64.75, -12);
        
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvSegno5() {
        System.out.println("Test inversione segno: parte reale ed immaginaria entrambi nulli");
        ComplexNum num = new ComplexNum(0, 0);
        ComplexNum expResult = new ComplexNum(0, 0);
        
        ComplexNum result = MathOperations.invSegno(num);
        assertEquals(expResult, result);
    }
}
