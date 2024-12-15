package modules.LogCreator;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogCreator {

    public static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("src/modules/LogCreator/log.config")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(LogCreator.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void createLog(Level level, String message){
        LOGGER.log(level, message);
    }

}
