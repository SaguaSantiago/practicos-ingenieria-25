import java.util.Scanner;

import interfaces.InputStrategy;

public class ConsoleInput implements InputStrategy {
    @Override
    public int getN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese n:");
        int n = sc.nextInt();
        sc.close();
        return n;
    }
}
