package octavio.challenges.floodedsilhouettes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class FloodedSilhouettesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FloodedSilhouettesApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        final String fileName = "caso1.txt";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        List<List<Integer>> testCases;

        FileReader fileReader = new FileReader(filePath);
        testCases = fileReader.getTestCases();

        for(List<Integer> testCase : testCases){
            FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(testCase);
            System.out.println(floodedSilhouettes.getFloodedAmount());
        }
    }
}
