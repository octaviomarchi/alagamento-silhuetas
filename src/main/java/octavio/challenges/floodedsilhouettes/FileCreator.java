package octavio.challenges.floodedsilhouettes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileCreator {

    public FileCreator(String fileName, List<Integer> integerList) throws IOException {
        Path filePath = getPathToFile(fileName);
        writeIntoFile(filePath, integerList);
    }

    private Path getPathToFile(String fileName) throws IOException {
        File file = new File("src\\main\\resources\\" + fileName +".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return Paths.get(file.toURI());

    }

    private void writeIntoFile(Path filePath, List<Integer> integerList) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8);
        for (Integer integer : integerList){
            writer.write(String.valueOf(integer.intValue()));
            writer.newLine();
        }
        writer.close();
        System.out.println("File created in " + filePath.toString());
    }
}
