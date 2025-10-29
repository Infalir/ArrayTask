package com.gavruseva.task1.warehouse;

import com.gavruseva.task1.data.CalculatedData;
import com.gavruseva.task1.entity.CustomArray;

public interface StorageWarehouse {
    void updateData(CustomArray array);
    CalculatedData getData(int id);
}
