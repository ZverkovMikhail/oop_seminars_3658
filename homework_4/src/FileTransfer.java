import java.io.*;
import java.util.Scanner;

public class FileTransfer implements Transfer {
    private String fileName;

    public FileTransfer(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void write(String text) {
        try {
            Writer writer = new FileWriter(this.fileName);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public String read() {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
