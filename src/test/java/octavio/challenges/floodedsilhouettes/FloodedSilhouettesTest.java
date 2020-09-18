package octavio.challenges.floodedsilhouettes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FloodedSilhouettesTest {

    @Test
    void testLeveledSilhouettes(){
        FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(Arrays.asList(5, 5, 5, 5, 5));
        assertEquals(0, floodedSilhouettes.getFloodedAmount());
    }

    @Test
    void testUphillSilhouettes(){
        FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7));
        assertEquals(0, floodedSilhouettes.getFloodedAmount());
    }

    @Test
    void testDownhillSilhouette(){
        FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
        assertEquals(0, floodedSilhouettes.getFloodedAmount());
    }

    @Test
    void testEmailCase(){
        FloodedSilhouettes floodedSilhouettes = new FloodedSilhouettes(Arrays.asList(7, 10, 2, 5, 13, 3, 4, 1, 5, 9));
        assertEquals(36, floodedSilhouettes.getFloodedAmount());
    }

}