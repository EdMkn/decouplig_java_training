package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    private static String pathAsString = "Jeulog.txt";

    public static Logger getLogger(String name){
        return new ContextualLogger(name,new ConsoleLogger());
    }
    public static Logger getLogger2(String name){
        return new ContextualLogger(name,new FileLogger(pathAsString));
    }
    public static Logger getLogger3(String name){
        return new CompositeLogger(getLogger(name),getLogger2(name));
    }
    public static Logger getLogger4(String name){
        Predicate<String> condition = message -> message.contains("simulation");
        return new CompositeLogger(getLogger(name),
            new ContextualLogger(name,new FilteredLogger(new FileLogger(pathAsString),condition)));
    }
}
