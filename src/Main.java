import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import modules.LogCreator.LogCreator;
import modules.Tasks.Task;
import modules.Tasks.TaskFactory;
import modules.Tasks.TaskType;
import modules.Tasks.Timed.TimedTask;

import static java.lang.Thread.sleep;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());



    public static void main(String[] args) {


    //TODO: Сохранение бд в файл(два файла csv, один для юзера, второй для тасков(1 значение - айди юзера)(stos)
    //TODO: Консольный интерфейс

       //Заглушка для проверки функционала
        LogCreator log = new LogCreator(); // Данная строка **обязательна** для конфигурации логгера

        TaskFactory taskFactory = new TaskFactory();

        Task newTimedTask = taskFactory.createTask(TaskType.TIMED_TASK);

        Task newTimelessTask = taskFactory.createTask(TaskType.TIMELESS_TASK, 2,"Clean up", "clean the room");

        LocalDateTime date = LocalDateTime.now();
        date = date.plusSeconds(7);
        TimedTask newnewTimedTask = Task.assignTimeToTimelessTask(newTimelessTask,date);

        System.out.println(newnewTimedTask.getCreationTime());

        for(int i = 0; i < 10; i++) {
            try {
                sleep(1000);
                System.out.println(newnewTimedTask.isExpired());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }




    }
}