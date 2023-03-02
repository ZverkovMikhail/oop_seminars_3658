package Calculator;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class FileLogger {
    String name;
    private FileLogger(Object o) {
        name = o.getClass().getName();
    }
    public static FileLogger init(Object o){
        return new FileLogger(o);
    }

    public Logger getLogger(){
        Logger logger = Logger.getLogger(name);
        FileHandler fh;

        {
            try {
                fh = new FileHandler(name + ".log", true);
                Formatter formatter = new SimpleFormatter() {
                    private static final String format = "%1$tF %1$tT (%2$-7s) >>> %3$s %n";

                    @Override
                    public synchronized String format(LogRecord lr) {
                        return String.format(format,
                                new Date(lr.getMillis()),
                                lr.getLevel().getLocalizedName(),
                                lr.getMessage()
                        );
                    }
                };

                fh.setFormatter(formatter);
                logger.addHandler(fh);
                logger.setUseParentHandlers(false);
            } catch (IOException e) {
                return null;
            }
        }
        return logger;
    }
}
