package fr.lernejo.logger;

public class LoggerFactory {
    public static ContextualLogger getLogger(String name){
        return new ContextualLogger(name,new ConsoleLogger());
    }
    public static FileLogger getLogger2(String name){
        String pathAsString = "C:/Users/ManyimMa/Documents/GitHub/decouplig_java_training/Jeulog.txt";
        return new FileLogger(pathAsString, name,new ConsoleLogger());
    }
}
