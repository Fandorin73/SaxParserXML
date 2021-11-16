import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.*;
import ru.YLab.Main;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestIntegration {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void eqalsSearchTest() {
        Main.main(new String[]{"-f", "test-files.xml", "-s", "file-22222222.txt"});
        String result = "/dir-88971375/dir-219753795/file-22222222.txt\r\n";
        assertEquals(result, outContent.toString());
    }

    @Test
    public void maskSearchTest() {

        Main.main(new String[]{"-f", "test-files.xml", "-s", "*.txt"});
        String result = "/dir-88971375/file-1272239243.txt\r\n"
                + "dir-88971375/dir-219753795/file-22222222.txt\r\n"
                + "dir-88971375/dir-219753795/file.txt\r\n";
        assertEquals(result, outContent.toString());
    }

    @Test
    public void regularSearchTest() {

        Main.main(new String[]{"-f", "test-files.xml", "-S", ".*?[a-z]{4}-\\d+.[a-z]+"});
        String result = "/file-77194797.xmml\r\n"
                + "dir-88971375/file-9738721998.java\r\n"
                + "dir-88971375/file-1272239243.txt\r\n"
                + "dir-88971375/dir-219753795/file-9748472197.xhtml\r\n"
                + "dir-88971375/dir-219753795/file-11111111.java\r\n"
                + "dir-88971375/dir-219753795/file-22222222.txt\r\n";

        assertEquals(result, outContent.toString());
    }

    @Test
    public void fullSearchTest() {

        Main.main(new String[]{"-f", "test-files.xml"});
        String result = "/file-77194797.xmml\r\n"
                + "dir-88971375/file-9738721998.java\r\n"
                + "dir-88971375/file-1272239243.txt\r\n"
                + "dir-88971375/dir-219753795/file-9748472197.xhtml\r\n"
                + "dir-88971375/dir-219753795/file-11111111.java\r\n"
                + "dir-88971375/dir-219753795/file-22222222.txt\r\n"
                + "dir-88971375/dir-219753795/file.txt\r\n";

        assertEquals(result, outContent.toString());
    }
}