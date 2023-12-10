package progettoIS.gruppo01.Calculator.Management;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import progettoIS.gruppo01.Calculator.Complex.ComplexNum;
import progettoIS.gruppo01.Calculator.Complex.MathOperations;
import progettoIS.gruppo01.Calculator.Structures.ComplexStack;
import progettoIS.gruppo01.Calculator.Structures.VarContainer;
import progettoIS.gruppo01.Exceptions.EmptyStackException;
import progettoIS.gruppo01.Exceptions.FullStackException;
import progettoIS.gruppo01.Exceptions.UninitializedVariableException;

public class VarManagementTest {

    private final int MAX_CAPACITY = 50;
    private VarManagement instance;
    private ComplexStack stack;
    private VarContainer var;

    @BeforeEach
    public void setUp() {
        stack = new ComplexStack(MAX_CAPACITY);
        var = new VarContainer();
        instance = new VarManagement(stack, var);
    }

    /**
     * Test of execute method, of class VarManagement.
     */
    //test di execute nel caso di ">x". con stack non vuoto
    @Test
    public void testExecuteSave1() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test saveVar typical");

        ComplexNum top = new ComplexNum(34.7, -45.6);
        stack.insert(top);

        String input = ">a";
        instance.execute(input);

        assertEquals(top, var.getValue('a'));
    }

    //test di execute nel caso di ">x", con stack vuoto
    @Test
    public void testExecuteSave2() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test saveVar empty stack");

        String input = ">c";

        assertThrows(EmptyStackException.class, () -> {
            instance.execute(input);
        });
    }

    //test di execute nel caso di "<x", con variabile inizializzata e stack non pieno
    @Test
    public void testExecuteIns1() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test insVar typical");

        ComplexNum top = new ComplexNum(-2, -4.67);

        var.setValue('d', top);

        String input = "<d";
        instance.execute(input);

        assertEquals(top, stack.top());
    }

    //test di execute nel caso di "<x", con variabile inizializzata e stack  pieno
    @Test
    public void testExecuteIns2() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test insVar full stack");

        ComplexStack semiStack = new ComplexStack(2);
        semiStack.insert(new ComplexNum(-2.5, 3.2));
        semiStack.insert(new ComplexNum(-32.4, -12.8));

        instance = new VarManagement(semiStack, var);

        var.setValue('f', new ComplexNum(28.12, 34.67));

        String input = "<f";

        assertThrows(FullStackException.class, () -> {
            instance.execute(input);
        });
    }

    //test di execute nel caso di "<x", con variabile non inizializzata
    @Test
    public void testExecuteIns3() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test insVar uninitialized variable");

        String input = "<m";

        assertThrows(UninitializedVariableException.class, () -> {
            instance.execute(input);
        });
    }

    //test di execute nel caso di "+x", con variabile inizializzata e stack non vuoto
    @Test
    public void testExecuteAdd1() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test addVar typical");

        ComplexNum top = new ComplexNum(34.7, -45.6);
        stack.insert(top);

        ComplexNum varValue = new ComplexNum(-12.67, 78.9);
        var.setValue('g', varValue);

        String input = "+g";
        instance.execute(input);

        assertEquals(MathOperations.somma(top, varValue), var.getValue('g'));
    }

    //test di execute nel caso di "+x", con stack vuoto
    @Test
    public void testExecuteAdd2() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test addVar empty stack");

        String input = "+t";

        assertThrows(EmptyStackException.class, () -> {
            instance.execute(input);
        });
    }
    
    //test di execute nel caso di "+x", con variabile non inizializzata e stack non vuoto
    @Test
    public void testExecuteAdd3() throws FullStackException, EmptyStackException, UninitializedVariableException {
        System.out.println("VarManagement execute test addVar empty stack");

        stack.insert(new ComplexNum(-78.5, -98.4));
        
        String input = "+t";

        assertThrows(UninitializedVariableException.class, () -> {
            instance.execute(input);
        });
    }
}
