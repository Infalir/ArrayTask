package main.com.gavruseva.task1.builder.impl;

import main.com.gavruseva.task1.builder.ArrayBuilder;
import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayBuilderImpl implements ArrayBuilder {
    private final static Logger logger = LogManager.getLogger();
    private int[] array;
    private int id;
    @Override
    public ArrayBuilder setIntegerArray(int... array) throws ArrayException {
        if (array == null || array.length == 0){
            logger.error("Trying to create a null or empty array");
            throw new ArrayException("Can't create an array out of empty array");
        }
        this.array = array;
        return this;
    }
    @Override
    public ArrayBuilder setIndex(int id) throws ArrayException {
        if(id < 0 || id > array.length){
            logger.error("Trying to create an index out of bounds");
            throw new ArrayException("Can't create an index out of bounds");
        }
        this.id = id;
        return this;
    }
    @Override
    public CustomArray build() throws  ArrayException{
        CustomArray customArray = new CustomArray(array, id);
        return customArray;
    }
}
