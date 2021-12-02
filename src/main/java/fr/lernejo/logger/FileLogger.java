package fr.lernejo.logger;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private final Path path;
    final private Logger delegateLogger;
    final private String callerClass;
    String pathAsString = "C:/Users/ManyimMa/Documents/GitHub/decouplig_java_training/Jeulog.txt";

    public FileLogger(String callerClass, Logger loggr) {
        path = Paths.get(pathAsString).toAbsolutePath();
        this.callerClass = callerClass;
        delegateLogger = loggr;
    }

    public void log(String message) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            Files.write(path, (LocalDateTime.now().format(formatter) + " " + callerClass + " " + message
                + "\n").getBytes(), APPEND, CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write log message to file [" + path + "]", e);
        }
    }
}
