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

        FileHandler fileHandler = new FileHandler(filePath);
        testCases = fileHandler.getTestCases();
    }
}
