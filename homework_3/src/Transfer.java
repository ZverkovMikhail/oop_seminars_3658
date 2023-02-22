import java.io.Reader;
import java.io.Writer;

interface Transfer {
    void write(String text);
    String read();
}
