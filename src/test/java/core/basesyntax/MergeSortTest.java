package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSortTest {
    private static final int[][] defaultArrays = {
            {1, 3, 5, 7, 9, 3, 6, 8, 0, 2},
            {-5, -3, -2, -6, 4, -14, 32, 11, -16, 6},
            {9, 6, 4, 3, 2, 6, 1, 12, 3, 2},
            {-10, 10, -9, 9, -8, 8, -4, 4, -1, 1},
            {4, 2, -9, 6, -3, 0, 12, 34, 25, 11},
    };

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
            sort.mergeSort(testArrays[i]);
            for (int j = 0; j < testArrays[i].length; j++) {
                Map<Integer, Integer> expectedMap = new HashMap();
                for (Integer number : defaultArrays[i]) {
                    if (expectedMap.keySet().contains(number)) {
                        expectedMap.put(number, expectedMap.get(number) + 1);
                    } else {
                        expectedMap.put(number, 1);
                    }
                }
                Map<Integer, Integer> actualMap = new HashMap();
                for (Integer number : testArrays[i]) {
                    if (actualMap.keySet().contains(number)) {
                        actualMap.put(number, actualMap.get(number) + 1);
                    } else {
                        actualMap.put(number, 1);
                    }
                }
                for (int l = 0; l < testArrays[i].length - 1; l++) {
                    Assert.assertTrue(
                            "Test failed. Array isn't sorted: " + Arrays.toString(testArrays[i]),
                            testArrays[i][l] <= testArrays[i][l + 1]);
                }

                Assert.assertEquals(
                        "Test failed with elements: " + Arrays.toString(testArrays[i]),
                        expectedMap,
                        actualMap);
            }
        }
    }
}
