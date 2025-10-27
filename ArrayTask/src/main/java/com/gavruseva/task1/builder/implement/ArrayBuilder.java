package com.gavruseva.task1.builder.implement;

import com.gavruseva.task1.builder.interfaces.ArrayBuilderInterface;
import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayBuilder implements ArrayBuilderInterface {
    private final static Logger logger = LogManager.getLogger();
    private int[] array;
    @Override
    public ArrayBuilderInterface setIntegerArray(int... array){
        if (array == null || array.length == 0){
            logger.warn("Trying to create a null or empty array");
            throw new ArrayException("Can't create an array out of empty array");
        }
        this.array = array;
        return this;
    }
    @Override
    public CustomArray build(){
        CustomArray customArray = new CustomArray(array);
        return customArray;
    }
}
