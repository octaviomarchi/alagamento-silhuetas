package octavio.challenges.floodedsilhouettes;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    private Path getPathFromFileName(String fileName){
        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return path;
    }

    @Test
    void workingSample() {
        Path filePath = getPathFromFileName("valid5cases.txt");
        FileHandler fileHandler = new FileHandler(filePath);

        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(Arrays.asList(1));
        expectedResults.add(Arrays.asList(5, 2));
        expectedResults.add(Arrays.asList(1, 1, 1));
        expectedResults.add(Arrays.asList(1, 2, 3, 4));
        expectedResults.add(Arrays.asList(5, 4, 3, 4, 5));

        assertEquals(5, fileHandler.getTotalCases());
        assertIterableEquals(expectedResults, fileHandler.getTestCases());
    }
}