import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.YLab.Main;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void eqalsSearchTest() {
        Main.main(new String[]{"-f", "src/test/resources/test-files.xml", "-s", "file-22222222.txt"});
        String result = "/dir-88971375/dir-219753795/file-22222222.txt"+System.lineSeparator();
        assertEquals(result, outContent.toString());
    }

    @Test
    public void maskSearchTest() {

        Main.main(new String[]{"-f", "src/test/resources/test-files.xml", "-s", "*.txt"});
        String result = "/dir-88971375/file-1272239243.txt"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-22222222.txt"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file.txt"+System.lineSeparator();
        assertEquals(result, outContent.toString());
    }

    @Test
    public void regularSearchTest() {

        Main.main(new String[]{"-f", "src/test/resources/test-files.xml", "-S", ".*?[a-z]{4}-\\d+\\.[a-z]+"});
        String result = "/file-77194797.xmml"+System.lineSeparator()
                + "dir-88971375/file-9738721998.java"+System.lineSeparator()
                + "dir-88971375/file-1272239243.txt"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-9748472197.xhtml"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-11111111.java"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-22222222.txt"+System.lineSeparator();

        assertEquals(result, outContent.toString());
    }

    @Test
    public void fullSearchTest() {

        Main.main(new String[]{"-f", "src/test/resources/test-files.xml"});
        String result = "/file-77194797.xmml"+System.lineSeparator()
                + "dir-88971375/file-9738721998.java"+System.lineSeparator()
                + "dir-88971375/file-1272239243.txt"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-9748472197.xhtml"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-11111111.java"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file-22222222.txt"+System.lineSeparator()
                + "dir-88971375/dir-219753795/file.txt"+System.lineSeparator();

        assertEquals(result, outContent.toString());
    }
}