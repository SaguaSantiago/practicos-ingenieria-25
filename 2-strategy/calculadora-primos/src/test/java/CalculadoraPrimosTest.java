import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import interfaces.CalculateStrategy;
import interfaces.InputStrategy;
import interfaces.OutputStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CalculadoraPrimosTest {
    @ParameterizedTest
    @ArgumentsSource(StrategiesProvider.class)
    public void Test01(CalculateStrategy cb){
        CalculadoraPrimos cp = new Calculator(cb, null, null);
        List<Integer> res = cp.performCalculate(1);
        List<Integer> exp = new ArrayList<>();
        assertEquals(exp,res);
    }

    @ParameterizedTest
    @ArgumentsSource(StrategiesProvider.class)
    public void Test02(CalculateStrategy cb){
        CalculadoraPrimos cp = new Calculator(cb, null, null);
        List<Integer> res = cp.performCalculate(3);
        List<Integer> exp = new ArrayList<>();
        exp.add(2);
        exp.add(3);

        assertEquals(exp,res);

        res = cp.performCalculate(5);
        exp.add(5);

        assertEquals(exp,res);

    }

    @Test
    public void OutputTest () {
        OutputMock os = new OutputMock();
        InputStrategy is = new ConsoleInput();
        CalculateStrategy cs = new LSOptimized();

        CalculadoraPrimos cp = new Calculator(cs, os, is);

        cp.exec();

        assertTrue(os.isInvoked());
        // assertEquals();
    }

    private static class StrategiesProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
            Arguments.of(new LSOptimized(), new ConsoleOutput(), new ConsoleInput()),
            Arguments.of(new LSOptimized(), new FileOutput(),  new ConsoleInput())
        );
        }
    }
}
