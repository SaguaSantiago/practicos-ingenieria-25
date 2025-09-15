import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import interfaces.OutputStrategy;

public class FileOutput implements OutputStrategy {
    @Override
    public void export(List<Integer> primos){
        java.io.File dir = new java.io.File("./static");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try (FileWriter writer = new FileWriter("./static/output.txt")) {
            writer.write("Resultado:\n");
            for(Integer p : primos){
                writer.write("*: "+p+"\n");
                System.out.println("Se escribió el texto en el archivo.");
            }
            writer.write("-----------------------\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
