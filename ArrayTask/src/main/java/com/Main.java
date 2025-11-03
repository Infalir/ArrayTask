package com;

import com.gavruseva.task1.builder.impl.ArrayBuilderImpl;
import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.ArrayException;
import com.gavruseva.task1.exception.FileException;
import com.gavruseva.task1.observer.ArrayObserver;
import com.gavruseva.task1.observer.impl.ArrayObserverImpl;
import com.gavruseva.task1.parser.impl.StringParserImpl;
import com.gavruseva.task1.reader.impl.FileArrayReaderImpl;
import com.gavruseva.task1.repository.impl.ArrayRepositoryImpl;
import com.gavruseva.task1.warehouse.impl.StorageWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        FileArrayReaderImpl fileReader = new FileArrayReaderImpl();
        StringParserImpl stringParserImpl = new StringParserImpl();
        ArrayBuilderImpl createFactory = new ArrayBuilderImpl();
        ArrayObserver observer = new ArrayObserverImpl();
        ArrayRepositoryImpl arrayRepository = ArrayRepositoryImpl.getInstance();
            try {
                CustomArray array = createFactory.setIntegerArray(stringParserImpl
                                .parseString(fileReader.readLinesFromFile("src/resources/data.txt")))
                        .build();
                array.attach(observer);
                arrayRepository.addArray(array);
            }
            catch(FileException e){
                logger.error("Can't access file");
                e.printStackTrace();
            }
            catch(ArrayException e){
                logger.error("Can't create the array");
                e.printStackTrace();
            }

    }
}