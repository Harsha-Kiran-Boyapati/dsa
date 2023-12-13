package syntax.io;

import lld.fileSystem.v1.models.File;
import org.junit.jupiter.api.Test;

import java.io.*;

public class FileTest {
    @Test
    void writerTest() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.text"));
            writer.write("writting to a file");
            writer.write("\n second line");
            writer.close();
        } catch (IOException e) {
            System.out.println("io exectpion thrown");
        }
        ;
    }

    @Test
    void readerTest() {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.text"));){
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("io exception");
        }
    }
}
