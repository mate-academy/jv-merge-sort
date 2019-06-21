package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    private static final int[][] testArrays = {
            {1, 3, 5, 7, 9, 3, 6, 8, 0, 2},
            {-5, -3, -2, -6, 4, -14, 32, 11, -16, 6},
            {9, 6, 4, 3, 2, 6, 1, 12, 3, 2},
            {-10, 10, -9, 9, -8, 8, -4, 4, -1, 1},
            {4, 2, -9, 6, -3, 0, 12, 34, 25, 11},
    };

    @Test
    public void mergeSort() {
        MergeSort sort = new MergeSort();
        for (int i = 0; i < 5; i++) {
            int[] actualResult = sort.mergeSort(testArrays[i]);
            int[] expectedResult = Arrays.stream(testArrays[i]).sorted().toArray();
            Assert.assertArrayEquals(
                    "Test failed with array " + Arrays.toString(testArrays[i]),
                    expectedResult,
                    actualResult);
        }
    }
}
