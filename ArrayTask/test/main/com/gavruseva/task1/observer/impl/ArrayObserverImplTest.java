package main.com.gavruseva.task1.observer.impl;

import main.com.gavruseva.task1.data.ArrayData;
import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.repository.ArrayRepository;
import main.com.gavruseva.task1.warehouse.StorageWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayObserverImplTest {
    private ArrayObserverImpl observer;
    private StorageWarehouse warehouse;
    private CustomArray array;
    private ArrayRepository repository;

    @BeforeEach
    public void setUp() throws ArrayException {
        observer = new ArrayObserverImpl();
        warehouse = StorageWarehouse.getInstance();
        repository = ArrayRepository.getInstance();
        int[] temp = {8, 3, 2, 1};
        array = new CustomArray(temp, 1);
        array.attach(observer);
        repository.addArray(array);
    }

    @Test
    public void testUpdate() throws ArrayException {
        int[] temp1 = {1, 2, 3, 4};
        array.setArray(temp1);
        double[] expected = {10, 2.5, 4, 1};
        ArrayData actualData = warehouse.getData(array.getId());
        double[] actual = {actualData.getSum(), actualData.getAvg(), actualData.getMax(), actualData.getMin()};
        assertArrayEquals(expected, actual, 0.001);
    }
}