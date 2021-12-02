package fr.lernejo.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class CompositeLogger implements Logger{
    final private Logger delegateLogger;
    final private Logger fileLogger;

    public CompositeLogger(Logger delegateLogger, Logger fileLogger){
        this.delegateLogger = delegateLogger;
        this.fileLogger = fileLogger;
    }


    @Override
    public void log(String message) {
        delegateLogger.log(message);
        fileLogger.log(message);
    }
}
