package fr.lernejo.logger;

public class LoggerFactory {
    public static ContextualLogger getLogger(String name){
        return new ContextualLogger(name,new ConsoleLogger());
    }
    public static FileLogger getLogger2(String name){
        return new FileLogger(name,new ConsoleLogger());
    }
    public static CompositeLogger getLogger3(String name){
        return new CompositeLogger(name);
    }
}
