package com.gavruseva.task1.warehouse;

import com.gavruseva.task1.data.ArrayData;

import java.util.Map;

public interface StorageWarehouse {
    ArrayData getData(int id);
    Map<Integer, ArrayData> getMap();
}
