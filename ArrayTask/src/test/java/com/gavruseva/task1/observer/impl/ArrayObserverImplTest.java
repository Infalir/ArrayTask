package com.gavruseva.task1.observer.impl;

import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.repository.impl.ArrayRepositoryImpl;
import com.gavruseva.task1.warehouse.impl.StorageWarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayObserverImplTest {
    private ArrayObserverImpl observer;
    private StorageWarehouseImpl warehouse;
    private CustomArray array;
    private ArrayRepositoryImpl repository;

    @BeforeEach
    public void setUp() throws ArrayException {
        observer = new ArrayObserverImpl();
        warehouse = StorageWarehouseImpl.getInstance();
        repository = ArrayRepositoryImpl.getInstance();
        int[] temp = {8, 3, 2, 1};
        array = new CustomArray(temp, 1);
        array.attach(observer);
        repository.addArray(array);
    }
    @Test
    public void testUpdate(){

    }
}