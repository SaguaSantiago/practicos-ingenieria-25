import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RomanNumbersTest {
    @Test
    public void test01 (){
        RomanNumbers rm = new RomanNumbers();
        String res = rm.getRomans(1);
        String exp = "I";
        assertEquals(exp, res);
        res = rm.getRomans(5);
        exp = "V";
        assertEquals(exp, res);
        res = rm.getRomans(10);
        exp = "X";
        assertEquals(exp, res);
        res = rm.getRomans(50);
        exp = "L";
        assertEquals(exp, res);
        res = rm.getRomans(100);
        exp = "C";
        assertEquals(exp, res);
        res = rm.getRomans(500);
        exp = "D";
        assertEquals(exp, res);
        res = rm.getRomans(1000);
        exp = "M";
        assertEquals(exp, res);
    }

    @Test
    public void test02 () {
        RomanNumbers rm = new RomanNumbers();
        String res = rm.getRomans(3);
        String exp = "III";
        assertEquals(exp, res);
        res = rm.getRomans(6);
        exp = "VI";
        assertEquals(exp, res);
        res = rm.getRomans(16);
        exp = "XVI";
        assertEquals(exp, res);
        res = rm.getRomans(20);
        exp = "XX";
        assertEquals(exp, res);
        res = rm.getRomans(66);
        exp = "LXVI";
        assertEquals(exp, res);
        res = rm.getRomans(166);
        exp = "CLXVI";
        assertEquals(exp, res);
        res = rm.getRomans(666);
        exp = "DCLXVI";
        assertEquals(exp, res);
        res = rm.getRomans(1666);
        exp = "MDCLXVI";
        assertEquals(exp, res);
    }

    @Test
    public void test03 () {
        RomanNumbers rm = new RomanNumbers();
        String res = rm.getRomans(4);
        String exp = "IV";
        assertEquals(exp, res);
        res = rm.getRomans(40);
        exp = "XL";
        assertEquals(exp, res);
        res = rm.getRomans(400);
        exp = "CD";
        assertEquals(exp, res);
        res = rm.getRomans(900);
        exp = "CM";
        assertEquals(exp, res);
        res = rm.getRomans(90);
        exp = "XC";
        assertEquals(exp, res);
        res = rm.getRomans(9);
        exp = "IX";
        assertEquals(exp, res);
    }
}
