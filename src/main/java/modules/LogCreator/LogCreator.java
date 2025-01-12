package modules.LogCreator;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

//данный класс предназначен для инициализация логгера, и его конфигурирования через log.config
public class LogCreator {

    public static Logger LOGGER;

    static {
        //относительный путь до файла с конфигами
        try(FileInputStream ins = new FileInputStream("src/main/java/modules/LogCreator/log.config"))
        {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(LogCreator.class.getName());
        }
        catch (Exception ignore)
        {
            ignore.printStackTrace();
        }
    }

    public static void createLog(Level level, String message){
        LOGGER.log(level, message);
    }
}
