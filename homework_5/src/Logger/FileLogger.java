package Logger;
import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class FileLogger implements Logger{
    private java.util.logging.Logger logger;
    private FileLogger(String name) {
        this.logger = java.util.logging.Logger.getLogger(name);
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
            }
        }
    }
    public static FileLogger init(String name){
        return new FileLogger(name);
    }

    @Override
    public void warning(String msg) {
        logger.log(Level.WARNING, msg);
    }

    @Override
    public void info(String msg) {
        logger.log(Level.INFO, msg);
    }
}
