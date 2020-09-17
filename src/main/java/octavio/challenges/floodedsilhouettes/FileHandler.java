package octavio.challenges.floodedsilhouettes;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {
    List<String> fileContent = new ArrayList<>();


    public FileHandler(String fileName) {
        try {
            readFileInList(fileName);
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
    }

    private void readFileInList(String fileName) throws URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        try (Stream<String> stream = Files.lines(path)) {

            fileContent = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFileContent(){
        return fileContent;
    }

}

