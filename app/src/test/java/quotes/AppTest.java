/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testGsonFile() throws IOException {
        Path quotePath = Paths.get("recentquotes.json");
        assertDoesNotThrow(() -> Files.exists(quotePath));
    }
}



// Test reader
//refactor json to take in a reader, parse author, array.