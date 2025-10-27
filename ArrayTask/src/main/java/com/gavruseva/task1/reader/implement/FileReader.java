package com.gavruseva.task1.reader.implement;

import com.gavruseva.task1.exception.FileException;
import com.gavruseva.task1.reader.intefaces.FileReaderInterface;
import com.gavruseva.task1.validator.implement.FileNameValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader implements FileReaderInterface {
    private final static Logger logger = LogManager.getLogger();
    private final FileNameValidator fileNameValidator = new FileNameValidator();

    @Override
    public List<String> readLinesFromFile(String path) throws FileException {

        if (!fileNameValidator.isFileNameValid(path)) {
            logger.error("Reading from the file impossible");
            throw new FileException("Reading from the file impossible");
        }

        List<String> list = new ArrayList<>();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            logger.error("Reading from the file impossible");
            throw new FileException(e);
        }
        logger.info("The file has read successfully and you have a new string array list");
        return list;
    }
}
