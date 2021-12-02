package fr.lernejo.logger;

public class LoggerFactory {

    public static ContextualLogger getLogger(String name){
        return new ContextualLogger(name,new ConsoleLogger());
    }

}
