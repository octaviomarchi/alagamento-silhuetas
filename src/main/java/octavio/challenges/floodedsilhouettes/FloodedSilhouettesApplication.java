package octavio.challenges.floodedsilhouettes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class FloodedSilhouettesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FloodedSilhouettesApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {

        final String FILE_NAME = "caso2";

        Path readFilePath = Paths.get(getClass().getClassLoader().getResource(FILE_NAME + ".txt").toURI());
        List<List<Integer>> testCases;
        List<Integer> results = new ArrayList<>();

        // Getting data from file
        FileReader fileReader = new FileReader(readFilePath);
        testCases = fileReader.getTestCases();

        // Calculating the results
        for(List<Integer> testCase : testCases){
            FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(testCase);
            log.debug(String.valueOf(floodedSilhouettes.getFloodedAmount()));
            results.add(floodedSilhouettes.getFloodedAmount());
        }

        // Writing results to file
        FileCreator fileCreator = new FileCreator(FILE_NAME + "-results", results);
    }
}
