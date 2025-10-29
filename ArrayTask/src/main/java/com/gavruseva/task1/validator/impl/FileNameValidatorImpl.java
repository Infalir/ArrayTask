package com.gavruseva.task1.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileNameValidatorImpl implements com.gavruseva.task1.validator.FileNameValidator {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean isFileNameValid(String path) {
        if (path == null) {
            logger.warn("The path equal to null");
            return false;
        }
        if (path.isBlank()) {
            logger.warn("The name of the path is empty");
            return false;
        }
        File file = new File(path);
        return file.exists() && file.length() > 0;
    }
}
