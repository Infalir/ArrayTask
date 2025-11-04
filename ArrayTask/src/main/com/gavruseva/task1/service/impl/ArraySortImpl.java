package main.com.gavruseva.task1.service.impl;

import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.service.ArraySort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortImpl implements ArraySort {
    private final static Logger logger = LogManager.getLogger();
    @Override
    public void bubbleSort(CustomArray array) throws ArrayException {
        logger.info("Method for bubble sorting is called");
        int[] tempArray = array.getArray();
        for (int i = 0; i < tempArray.length - 1; i++) {
            for (int j = 0; j < tempArray.length - i - 1; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }
        array.setArray(tempArray);
    }
    @Override
    public void insertionSort(CustomArray array) throws ArrayException{
        logger.info("Method for insertion sorting is called");
        int[] tempArray = array.getArray();
        for (int i = 1; i < tempArray.length; i++){
            for (int j = i; j > 0 && tempArray[j-1] > tempArray[j]; j--){
                int temp = tempArray[j];
                tempArray[j] = tempArray[j-1];
                tempArray[j-1] = temp;
            }
        }
        array.setArray(tempArray);
    }
    @Override
    public void selectionSort(CustomArray array)throws ArrayException{
        logger.info("Method for selection sorting is called");
        int[] tempArray = array.getArray();
        for (int i = 0; i < tempArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[j] < tempArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = tempArray[minIndex];
            tempArray[minIndex] = tempArray[i];
            tempArray[i] = temp;
        }
        array.setArray(tempArray);
    }
}
