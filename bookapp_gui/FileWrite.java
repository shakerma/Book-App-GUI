package bookapp_gui;

/**
 *
 * @authors Joshua & Maryan
 */

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class FileWrite {

    public void write(String filepath, String content) {

        File file = new File(filepath);

        try (FileWriter writer = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
