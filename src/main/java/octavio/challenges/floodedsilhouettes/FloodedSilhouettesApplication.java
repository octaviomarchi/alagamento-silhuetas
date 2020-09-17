package octavio.challenges.floodedsilhouettes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloodedSilhouettesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FloodedSilhouettesApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        FileHandler fileHandler = new FileHandler("caso1.txt");
    }
}
