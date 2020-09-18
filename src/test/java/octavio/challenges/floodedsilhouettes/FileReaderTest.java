package octavio.challenges.floodedsilhouettes;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class FileReaderTest {
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
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            log.error("Problem reading the file", e);
        }

        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(Arrays.asList(1));
        expectedResults.add(Arrays.asList(5, 2));
        expectedResults.add(Arrays.asList(1, 1, 1));
        expectedResults.add(Arrays.asList(1, 2, 3, 4));
        expectedResults.add(Arrays.asList(5, 4, 3, 4, 5));

        assertEquals(5, fileReader.getTotalCases());
        assertIterableEquals(expectedResults, fileReader.getTestCases());
    }
}