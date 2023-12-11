package progettoIS.gruppo01.Calculator;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Complex.MathOperations;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.InsufficientNumbersException;
import progettoIS.gruppo01.Exceptions.MathException;
import progettoIS.gruppo01.Exceptions.SyntaxException;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;

public class ComplexCalculatorTest {

    private final int MAX_CAPACITY = 50;
    private ComplexCalculator instance;

    @BeforeEach
    public void setUp() {
        instance = new ComplexCalculator();
    }

    /**
     * Test of parseInput method, of class ComplexCalculator.
     */
    
    /*
    test di parseInput nel caso di inserimento di un numero complesso con 
    parte reale e immaginaria, con stack non pieno
     */
    @Test
    public void testParseInput1() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test number typical");

        String input = "+5.23 - 9.23j";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(new ComplexNum(5.23, -9.23), num);
    }

    /*
    test di parseInput nel caso di inserimento di un numero complesso con 
    solo la parte reale, con stack non pieno
     */
    @Test
    public void testParseInput2() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test number typical");

        String input = "+5.23";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(new ComplexNum(5.23, 0), num);
    }

    /*
    test di parseInput nel caso di inserimento di un numero complesso con 
    solo la parte immaginaria, con stack non pieno
     */
    @Test
    public void testParseInput3() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test number typical");

        String input = "-9.23j";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(new ComplexNum(0, -9.23), num);
    }

    //test di parseInput nel caso di inserimento di un numero complesso, con stack pieno
    @Test
    public void testParseInput4() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test number full stack");

        String input = "26.21 + 31.3j";

        for (int i = 0; i < MAX_CAPACITY; i++) {
            instance.parseInput(input);
        }

        assertThrows(FullStackException.class, () -> {
            instance.parseInput(input);
        });
    }

    //test di parseInput nel caso di salvataggio su variabile, con stack vuoto
    @Test
    public void testParseInput5() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test saveVar empty stack");

        assertThrows(EmptyStackException.class, () -> {
            instance.parseInput(">t");
        });
    }

    //test di parseInput nel caso di inserimento da variabile, con variabile inizializzata e stack non pieno
    @Test
    public void testParseInput6() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test insVar typical");

        instance.parseInput("-3 + 4.25j");

        String input = ">x";
        instance.parseInput(input);

        input = "<x";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(new ComplexNum(-3, 4.25), num);
    }

    //test di parseInput nel caso di inserimento da variabile,con variabile inizializzata e stack pieno
    @Test
    public void testParseInput7() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test insVar fullstack");

        String input = "-53.2 - 4.7j";

        for (int i = 0; i < MAX_CAPACITY; i++) {
            instance.parseInput(input);
        }

        input = ">a";
        instance.parseInput(input);

        input = "-53.2 - 4.7j";
        instance.parseInput(input);

        assertThrows(FullStackException.class, () -> {
            instance.parseInput("<a");
        });
    }

    //test di parseInput nel caso di inserimento da variabile,con variabile non inizializzata
    @Test
    public void testParseInput8() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test insVar uninitialized variable");

        assertThrows(UninitializedVariableException.class, () -> {
            instance.parseInput("<n");
        });
    }

    //test di parseInput nel caso di somma su variabile, con variabile inizializzata e stack non vuoto
    @Test
    public void testParseInput9() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test addVar typical");

        String input = "-2 + 9.0j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "5 + 34.6j";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        input = ">c";
        instance.parseInput(input);

        input = "+c";
        instance.parseInput(input);

        input = "<c";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.somma(num1, num2), num);
    }

    //test di parseInput nel caso di somma su variabile, con stack vuoto
    @Test
    public void testParseInput10() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test addVar empty stack");

        assertThrows(EmptyStackException.class, () -> {
            instance.parseInput("+l");
        });
    }

    //test di parseInput nel caso di somma su variabile, con variabile non inizializzata e stack non vuoto
    @Test
    public void testParseInput11() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test addVar uninitialized variable");

        String input = "-2 + 9.0j";
        instance.parseInput(input);

        assertThrows(UninitializedVariableException.class, () -> {
            instance.parseInput("+s");
        });
    }

    //test di parseInput nel caso di sottrazione su variabile, con variabile inizializzata e stack non vuoto
    @Test
    public void testParseInput12() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test subVar typical");

        String input = "+45.6 - 12.12j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "-29.20 - 97.39j";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        input = ">c";
        instance.parseInput(input);

        input = "-c";
        instance.parseInput(input);

        input = "<c";
        instance.parseInput(input);

        ComplexNum num = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.sottrazione(num2, num1), num);
    }

    //test di parseInput nel caso di sottrazzione su variabile, con stack vuoto
    @Test
    public void testParseInput13() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test subVar empty stack");

        assertThrows(EmptyStackException.class, () -> {
            instance.parseInput("-o");
        });
    }

    //test di parseInput nel caso di sottrazione su variabile, con variabile non inizializzata e stack non vuoto
    @Test
    public void testParseInput14() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test subVar uninitialized variable");

        String input = "5.4 - 2.234j";
        instance.parseInput(input);

        assertThrows(UninitializedVariableException.class, () -> {
            instance.parseInput("-d");
        });
    }
    
    
    //test performance di parseInput nel caso di inserimento di un numero complesso
    @Test
    public void testParseInputPerformance1() {
        System.out.println("ComplexCalculator parseInput test performance number");
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.parseInput("+167.5 - 23.6j");
        });
    }
    
    //test performance di parseInput nel caso di salvataggio su variabile
    @Test
    public void testParseInputPerformance2() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator parseInput test performance saveVar");
        
        instance.parseInput("45.89j");
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.parseInput(">w");
        });
    }
    
    //test performance di parseInput nel caso di inserimento da variabile
    @Test
    public void testParseInputPerformance3() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator parseInput test performance insVar");
        
        instance.parseInput("-17.94 - 3.0j");
        instance.parseInput(">v"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.parseInput("<v");
        });
    }
    
    //test performance di parseInput nel caso di addizione su variabile
    @Test
    public void testParseInputPerformance4() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator parseInput test performance addVar");
        
        instance.parseInput("-93.12");
        instance.parseInput(">k"); 
        instance.parseInput("-22.48 + 10.23j");
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.parseInput("+k");
        });
    }
    
    //test performance di parseInput nel caso di sottrazione su variabile
    @Test
    public void testParseInputPerformance5() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator parseInput test performance subVar");
        
        instance.parseInput("567.69 + 58.55j");
        instance.parseInput(">j"); 
        instance.parseInput("-99.0j");
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.parseInput("-j");
        });
    }

    /**
     * Test of add method, of class ComplexCalculator.
     */
    //test di add nel caso in cui lo stack presenti almeno due elementi 
    @Test
    public void testAdd1() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator add test typical");

        String input = "-32.6 + 5.78j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "76.09 - 66.6j";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        instance.add();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.somma(num1, num2), ris);
    }

    //test di add nel caso in cui lo stack presenti un solo elemento
    @Test
    public void testAdd2() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator add test insufficientnumbers(1)");

        String input = "-32.6 + 5.78j";
        instance.parseInput(input);

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.add();
        });
    }

    //test di add nel caso in cui lo stack sia vuoto
    @Test
    public void testAdd3() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator add test insufficientnumbers(0)");

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.add();
        });
    }
    
    //test performance di add
    @Test
    public void testAddPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance add");
        
        instance.parseInput("0");
        instance.parseInput("335.98 - 330.54j"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.add();
        });
    }

    /**
     * Test of sub method, of class ComplexCalculator.
     */
    //test di sub nel caso in cui lo stack presenti almeno due elementi 
    @Test
    public void testSub1() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator sub test typical");

        String input = "45.12 - 88.38j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "-26.001 - 11.6j";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        instance.sub();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.sottrazione(num1, num2), ris);
    }

    //test di sub nel caso in cui lo stack presenti un solo elemento
    @Test
    public void testSub2() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator sub test insufficientnumbers(1)");

        String input = "16 + 7j";
        instance.parseInput(input);

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.sub();
        });
    }

    //test di sub nel caso in cui lo stack sia vuoto
    @Test
    public void testSub3() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator sub test insufficientnumbers(0)");

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.sub();
        });
    }
    
    //test performance di sub
    @Test
    public void testSubPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance sub");
        
        instance.parseInput("-98.98 - 102.43j");
        instance.parseInput("298.1 - 109.4j"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.sub();
        });
    }

    /**
     * Test of div method, of class ComplexCalculator.
     */
    //test di div nel caso in cui lo stack presenti almeno due elementi, e quello in cima non sia zero
    @Test
    public void testDiv1() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException, MathException {
        System.out.println("ComplexCalculator div test typical");

        String input = "23 + 110.20j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "21.45";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        instance.div();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.divisione(num1, num2), ris);
    }

    //test di div nel caso in cui lo stack presenti un solo elemento
    @Test
    public void testDiv2() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator div test insufficientnumbers(1)");

        String input = "-16j";
        instance.parseInput(input);

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.div();
        });
    }

    //test di div nel caso in cui lo stack sia vuoto
    @Test
    public void testDiv3() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator div test insufficientnumbers(0)");

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.div();
        });
    }

    //test di div nel caso in cui lo stack presenti almeno due elementi, e quello in cima sia zero
    @Test
    public void testDiv4() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException, MathException {
        System.out.println("ComplexCalculator div test math error");

        String input = "-15.34 + 10j";
        instance.parseInput(input);

        input = "0";
        instance.parseInput(input);

        assertThrows(MathException.class, () -> {
            instance.div();
        });
    }
    
    //test performance di div
    @Test
    public void testDivPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance div");
        
        instance.parseInput("21.50 - 27.34j");
        instance.parseInput("104.28 - 20.32j"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.div();
        });
    }

    /**
     * Test of mul method, of class ComplexCalculator.
     */
    //test di mul nel caso in cui lo stack presenti almeno due elementi 
    @Test
    public void testMul1() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator mul test typical");

        String input = "-134.45j";
        instance.parseInput(input);
        ComplexNum num1 = ComplexNum.parseComplex(input);

        input = "+122.93 + 58.65j";
        instance.parseInput(input);
        ComplexNum num2 = ComplexNum.parseComplex(input);

        instance.mul();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.moltiplicazione(num1, num2), ris);
    }

    //test di mul nel caso in cui lo stack presenti un solo elemento
    @Test
    public void testMul2() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator mul test insufficientnumbers(1)");

        String input = "2.09j";
        instance.parseInput(input);

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.mul();
        });
    }

    //test di mul nel caso in cui lo stack sia vuoto
    @Test
    public void testMul3() throws InsufficientNumbersException, FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator mul test insufficientnumbers(0)");

        assertThrows(InsufficientNumbersException.class, () -> {
            instance.mul();
        });
    }
    
    //test performance di mul
    @Test
    public void testMulPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance mul");
        
        instance.parseInput("-3.23j"); 
        instance.parseInput("59.56"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.mul();
        });
    }

    /**
     * Test of signInv method, of class ComplexCalculator.
     */
    @Test
    //test di singInv nel caso in cui lo stack non sia vuoto
    public void testSignInv1() throws EmptyStackException, FullStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator signInv test typical");

        String input = "42.45 - 67.34j";
        ComplexNum numInv = ComplexNum.parseComplex(input);

        instance.parseInput(input);

        instance.signInv();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.invSegno(numInv), ris);
    }

    @Test
    //test di singInv nel caso in cui lo stack sia vuoto
    public void testSignInv2() throws EmptyStackException, FullStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator signInv test empty stack");

        assertThrows(EmptyStackException.class, () -> {
            instance.signInv();
        });
    }

    //test performance di signInv
    @Test
    public void testSignInvPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance signInv");
        
        instance.parseInput("230.67 + 46.11j"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.signInv();
        });
    }
    
    /**
     * Test of sqrt method, of class ComplexCalculator.
     */
    @Test
    //test di sqrt nel caso in cui lo stack non sia vuoto
    public void testSqrt1() throws EmptyStackException, FullStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator sqrt test typical");

        String input = "-64.4";
        ComplexNum numInv = ComplexNum.parseComplex(input);

        instance.parseInput(input);

        instance.sqrt();

        ComplexNum ris = ComplexNum.parseComplex(instance.getLastNumbers()[0]);
        assertEquals(MathOperations.sqrt(numInv), ris);
    }

    @Test
    //test di sqrt nel caso in cui lo stack sia vuoto
    public void testSqrt2() throws EmptyStackException, FullStackException, UninitializedVariableException, SyntaxException {
        System.out.println("ComplexCalculator sqrt test empty stack");

        assertThrows(EmptyStackException.class, () -> {
            instance.sqrt();
        });
    }
    
    //test performance di sqrt
    @Test
    public void testSqrtPerformance() throws FullStackException, EmptyStackException, UninitializedVariableException, SyntaxException{
        System.out.println("ComplexCalculator test performance sqrt");
        
        instance.parseInput("-64.4 + 990.6j"); 
        
        assertTimeout(Duration.ofMillis(100), () -> {
            instance.sqrt();
        });
    }

    /**
     * Test of clear method, of class ComplexCalculator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        ComplexCalculator instance = new ComplexCalculator();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class ComplexCalculator.
     */
    @Test
    public void testDrop() throws Exception {
        System.out.println("drop");
        ComplexCalculator instance = new ComplexCalculator();
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class ComplexCalculator.
     */
    @Test
    public void testDup() throws Exception {
        System.out.println("dup");
        ComplexCalculator instance = new ComplexCalculator();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class ComplexCalculator.
     */
    @Test
    public void testSwap() throws Exception {
        System.out.println("swap");
        ComplexCalculator instance = new ComplexCalculator();
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of over method, of class ComplexCalculator.
     */
    @Test
    public void testOver() throws Exception {
        System.out.println("over");
        ComplexCalculator instance = new ComplexCalculator();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastNumbers method, of class ComplexCalculator.
     */
    @Test
    public void testGetLastNumbers() {
        System.out.println("getLastNumbers");
        ComplexCalculator instance = new ComplexCalculator();
        String[] expResult = null;
        String[] result = instance.getLastNumbers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
