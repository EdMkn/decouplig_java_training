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
    final private ContextualLogger delegateLogger;
    final private FileLogger fileLogger;

    public CompositeLogger(String callerClass){
        delegateLogger = new ContextualLogger(callerClass,new ConsoleLogger());
        fileLogger = new FileLogger(callerClass,new ConsoleLogger());
    }


    @Override
    public void log(String message) {
        delegateLogger.log(message);
        fileLogger.log(message);
    }
}
