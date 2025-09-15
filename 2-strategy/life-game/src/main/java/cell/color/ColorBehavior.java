package cell.color;

import static org.fusesource.jansi.Ansi.*;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

public abstract class ColorBehavior {
    public Color color;
    private Ansi ansi;

    public ColorBehavior (Color color){
        this.color = color;
        this.ansi = ansi().fg(color);
    }

    public void write(String s){
        System.out.print(ansi.a(s).reset());
    }
}
