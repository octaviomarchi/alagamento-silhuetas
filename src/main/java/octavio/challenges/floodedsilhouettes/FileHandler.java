package octavio.challenges.floodedsilhouettes;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FileHandler {

    final int MAX_INPUTS = 100;
    final int MIN_INPUTS = 1;

    private List<String> fileContent;
    private List<List<Integer>> testCases;
    private Integer totalCases;

    public FileHandler(Path filePath) {
        try {
            readFileInList(filePath);
            if (isFileValid()){
                setTestCases(fileContent);
            }
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
    }

    private void readFileInList(Path filePath) throws URISyntaxException {
        try (Stream<String> stream = Files.lines(filePath)) {
            fileContent = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isFileValid(){
        boolean isValid = true;
        totalCases = Integer.valueOf(fileContent.get(0));
        // check if we have between 1 and 100 cases to test
        if (totalCases.intValue() < MIN_INPUTS || totalCases.intValue() > MAX_INPUTS){
            log.debug("File has more cases than the max allowed");
            isValid = false;
        }
        if (totalCases.intValue() != (fileContent.size() -1)/2 ){
            log.debug("There are more cases than informed in the file");
            isValid = false;
        }
        for(int i = 1; i < fileContent.size(); i += 2){
            int columnsExpected = Integer.valueOf(fileContent.get(i));
            int contentLength = fileContent.get(i+1).trim().split("\\s").length;
            if(columnsExpected != contentLength){
                log.debug("Case " + (i-1)/2 + "does not have the same number of silhouettes");
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private void setTestCases(List<String> fileContent){
        testCases = new ArrayList<>();
        for(int i = 2; i < fileContent.size(); i += 2){
            List<String> stringList = Arrays.asList(fileContent.get(i).trim().split("\\s"));
            List<Integer> listInteger = stringList.stream().map(Integer::valueOf).collect(Collectors.toList());
            testCases.add(listInteger);
        }
    }

    public List<List<Integer>> getTestCases() {
        return testCases;
    }

    public Integer getTotalCases() {
        return totalCases;
    }
}

