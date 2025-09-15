import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestBowling {
    
    @Test
    public void test01 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(0);
        int expected = 0;
        int res = bg.score();
        assertEquals(expected, res);    
    }

    @Test
    public void test02 () {
        BowlingGame bg = new BowlingGame();
        assertThrows(IllegalArgumentException.class, ()-> bg.roll(-1));    
        assertThrows(IllegalArgumentException.class, ()-> bg.roll(11));    
    }

    @Test
    public void test03 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(10);
        int res = bg.bonus;
        int expected = 2;
        assertEquals(expected, res);
    }

    @Test
    public void test04 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(10);
        bg.roll(5);
        bg.roll(3);
        int res = bg.score();
        int expected = 26;
        assertEquals(expected, res);
    }

    @Test
    public void test05 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(10);
        bg.roll(8);
        bg.roll(1);
        int res = bg.score();
        int expected = 28;
        assertEquals(expected, res);
    }

    @Test
    public void test06 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(8);
        bg.roll(2);
        int res = bg.bonus;
        int expected = 1;
        assertEquals(expected, res);
    }

    @Test
    public void test07 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(8);
        bg.roll(2);
        bg.roll(5);

        int res = bg.score();
        int expected = 20;
        assertEquals(expected, res);
    }

    @Test
    public void test08 () {
        BowlingGame bg = new BowlingGame();
        bg.roll(10);
        int res = bg.getRollNumber();
        int expected = 3;
        assertEquals(expected, res);
        bg.roll(10);
        res = bg.getRollNumber();
        expected = 5;
        assertEquals(expected, res);
    }
}
