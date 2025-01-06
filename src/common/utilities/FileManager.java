package common.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public static void exportToCSV(String fileName, List<?> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Object obj : data) {
                writer.write(obj.toString());
                writer.newLine();
            }
        }
    }

    public static void exportToJSON(String fileName, List<?> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("[");
            writer.newLine();
            for (int i = 0; i < data.size(); i++) {
                writer.write("  " + data.get(i).toString());
                if (i < data.size() - 1) writer.write(",");
                writer.newLine();
            }
            writer.write("]");
        }
    }
}
