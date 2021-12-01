package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Logger l = new Logger() {
            @Override
            public void log(String message) {

            }
        };
        return l;
    }
}
