package modules;
import modules.Tasks.Task;
import modules.Tasks.Timed.TimedTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class User {

    private String login;
    private String password;
    private final Integer id;
    private static Integer counter = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private ScheduledExecutorService scheduler;

    public static final Logger LOGGER = Logger.getLogger(User.class.getName());

    User(){
        this.id = counter++;
        startCheckingTasks();
    }


    //Запускает проверку на то, что задача просрочена, раз в секунду
    private void startCheckingTasks() {
        scheduler.scheduleAtFixedRate(()->{

            for(int i = 0; i < tasks.size(); i++){

                Task currentTask = (Task) Arrays.asList(tasks.values()).get(i);

                if(currentTask instanceof TimedTask currentTimedTask){

                    currentTimedTask.updatePlannedTime();

                }
            }
        },0,1,TimeUnit.SECONDS);
    }

    public void stopCheckingTasks(){

    }

    User(String login, String password){
        this();
        this.login = login;
        this.password = password;
    }


    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public Integer getId(){
        return id;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void assignTask(Task task) {

        if( tasks.containsKey(task.getId())) {

            throw new RuntimeException("This task is already assigned to this User");

        }

        this.tasks.put(task.getId(), task);
    }

    public void depriveTask(Task task){
        if(!tasks.containsKey(task.getId())){

            throw new RuntimeException("There is no such assigned task to this User");

        }

        tasks.remove(task.getId());

    }




}
