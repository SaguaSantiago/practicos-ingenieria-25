import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void test01 () {
        StringCalculator sc = new StringCalculator();
        String[] cases = {"", "1", "1,2"};
        int[] exp = {0, 1, 3};
        for(int i=0; i<cases.length; i++){
            int res = sc.Add(cases[i]);
            assertEquals(exp[i],res);
        }
    }
    
    @Test
    public void test02 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("1,2,3,4,5,6");
        int exp = 21;
        assertEquals(exp, res);
    }

    @Test
    public void test03 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("1,2\n3\n4,5,6");
        int exp = 21;
        assertEquals(exp, res);
    }

    @Test
    public void test04 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("//;\n1;2");
        int exp = 3;
        assertEquals(exp, res);
    }

    @Test
    public void test05 () {
        StringCalculator sc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, ()-> sc.Add("1,2\n-3\n4,5,6"));
    }

    @Test
    public void test06 () {
        StringCalculator sc = new StringCalculator();
        String string = "1,2\n-3\n4,-5,-6";
        assertThrows(IllegalArgumentException.class, ()-> sc.Add(string));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> sc.Add(string));
        String exp = "negatives not allowed: -3,-5,-6";
        assertEquals(exp, exception.getMessage());
    }

    @Test
    public void test07 () {
        StringCalculator sc = new StringCalculator();
        int exp = 0;
        int res = sc.getCalledCount();
        assertEquals(exp, res);
        sc.Add("");
        sc.Add("1,2");
        sc.Add("3");
        exp = 3;
        res = sc.getCalledCount();
        assertEquals(exp, res);
    }

    @Test
    public void test08 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("1,2\n3\n4,5,6,1001,2000");
        int exp = 21;
        assertEquals(exp, res);
    }

    @Test
    public void test09 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("//[''']\n1'''2'''3");
        int exp = 6;
        assertEquals(exp, res);
    }

    @Test
    public void test10 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("//[-][%]\n1-2%3");
        int exp = 6;
        assertEquals(exp, res);
    }

    @Test
    public void test11 () {
        StringCalculator sc = new StringCalculator();
        int res = sc.Add("//[--][%%]\n1--2%%3");
        int exp = 6;
        assertEquals(exp, res);
    }
}
