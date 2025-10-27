package com.gavruseva.task1.creator.implement;

import com.gavruseva.task1.builder.implement.ArrayBuilder;
import com.gavruseva.task1.creator.interfaces.ArrayCreatorInterface;
import com.gavruseva.task1.entity.CustomArray;
import com.gavruseva.task1.exception.FileException;
import com.gavruseva.task1.parser.implement.StringParser;
import com.gavruseva.task1.reader.implement.FileReader;

public class ArrayCreator implements ArrayCreatorInterface {
    private final FileReader fileReader = new FileReader();
    private final StringParser stringParser = new StringParser();
    private final ArrayBuilder createFactory = new ArrayBuilder();

    @Override
    public CustomArray createCustomArray(String path) throws FileException {
        CustomArray array = createFactory.setIntegerArray(stringParser
                    .parseString(fileReader.readLinesFromFile(path)))
                    .build();
        return array;
    }
}
