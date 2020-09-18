package octavio.challenges.floodedsilhouettes;

import java.util.Collections;
import java.util.List;

public class FloodedSilhouettes {
    private Integer floodedAmount = 0;

    public FloodedSilhouettes(List<Integer> columns){
        if (columns.size() >= 3) {
            calculate(columns);
        }
    }

    private void calculate(List<Integer> columns){

        Integer minValue = Collections.min(columns);
        Integer maxFloodableHeight = Collections.max(columns);

        for (int currentHeight = minValue + 1; currentHeight < maxFloodableHeight; currentHeight++) {
            boolean isInsideWall = false;
            int countAmount = 0;
            for(Integer column : columns){
                if (isInsideWall){
                    if (column < currentHeight){
                        countAmount++;
                    } else {
                        this.floodedAmount += countAmount;
                        countAmount = 0;
                    }
                } else if(column >= currentHeight){
                    isInsideWall = true;
                }

            }
        }


    }

    public Integer getFloodedAmount() {
        return floodedAmount;
    }
}
