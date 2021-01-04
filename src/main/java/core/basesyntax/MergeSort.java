package core.basesyntax;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class MergeSort {
    /**
     * Реализуйте метод void mergeSort(int[] array), который отсортирует массив целых чисел
     * с помощью сортировки слиянием.
     */
    public void mergeSort(int[] array) {
    }

    public static OffsetDateTime offsetDateTime(LocalDateTime localTime) {
        ZoneOffset offset = ZonedDateTime.now().getOffset();
        return OffsetDateTime.of(localTime, offset);
    }
}
