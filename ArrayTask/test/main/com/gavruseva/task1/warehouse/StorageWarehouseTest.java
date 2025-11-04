package main.com.gavruseva.task1.warehouse;

import main.com.gavruseva.task1.data.ArrayData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StorageWarehouseTest {
    private final StorageWarehouse storageWarehouse = StorageWarehouse.getInstance();;

    @Test
    public void testGetData(){
        ArrayData data = new ArrayData(1,2, 3, 4);
        storageWarehouse.getMap().put(0, data);
        double[] expectedData = {1, 2, 3, 4};
        ArrayData receivedData = storageWarehouse.getData(0);
        double[] actualData = {receivedData.getSum(), receivedData.getAvg(), receivedData.getMax(), receivedData.getMin()};
        assertArrayEquals(expectedData, actualData, 0.001);
    }
}