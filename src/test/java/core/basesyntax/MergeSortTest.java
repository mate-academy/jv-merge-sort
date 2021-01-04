package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        for (int i = 0; i < testArrays.length; i++) {
            Map<Integer, Integer> expectedMap = countEntries(testArrays[i]);
            sort.mergeSort(testArrays[i]);
            Map<Integer, Integer> actualMap = countEntries(testArrays[i]);
            for (int j = 0; j < testArrays[i].length - 1; j++) {
                Assert.assertTrue(
                        "Test failed. Array isn't sorted: " + Arrays.toString(testArrays[i]),
                        testArrays[i][j] <= testArrays[i][j + 1]);
            }

            Assert.assertEquals(
                    "Test failed with elements: " + Arrays.toString(testArrays[i]),
                    expectedMap,
                    actualMap);
        }
    }

    private Map<Integer, Integer> countEntries(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : array) {
            if (map.keySet().contains(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }
        return map;
    }

    @Test
    public void offsetUkraine() {
        LocalDateTime localDateTime =
                LocalDateTime.of(2019, Month.SEPTEMBER, 06, 13, 17);
        OffsetDateTime expected = OffsetDateTime.of(localDateTime, ZoneOffset.of("+02:00"));
        OffsetDateTime result = MergeSort.offsetDateTime(localDateTime);
        Assert.assertEquals(expected, result);
    }
}
