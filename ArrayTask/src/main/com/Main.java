package main.com;

import main.com.gavruseva.task1.builder.impl.ArrayBuilderImpl;
import main.com.gavruseva.task1.entity.CustomArray;
import main.com.gavruseva.task1.exception.ArrayException;
import main.com.gavruseva.task1.exception.FileException;
import main.com.gavruseva.task1.observer.ArrayObserver;
import main.com.gavruseva.task1.observer.impl.ArrayObserverImpl;
import main.com.gavruseva.task1.parser.impl.StringParserImpl;
import main.com.gavruseva.task1.reader.impl.FileArrayReaderImpl;
import main.com.gavruseva.task1.repository.ArrayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        FileArrayReaderImpl fileReader = new FileArrayReaderImpl();
        StringParserImpl stringParserImpl = new StringParserImpl();
        ArrayBuilderImpl createFactory = new ArrayBuilderImpl();
        ArrayObserver observer = new ArrayObserverImpl();
        ArrayRepository arrayRepository = ArrayRepository.getInstance();
            try {
                CustomArray array = createFactory.setIntegerArray(stringParserImpl
                                .parseString(fileReader.readLinesFromFile("resources/file/data.txt")))
                        .build();
                array.attach(observer);
                arrayRepository.addArray(array);
            }
            catch(FileException e){
                logger.error("Can't access file data.txt");
                e.printStackTrace();
            }
            catch(ArrayException e){
                logger.error("Can't create the array");
                e.printStackTrace();
            }

    }
}