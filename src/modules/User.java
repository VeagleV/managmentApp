package modules;
import modules.Tasks.Task;
import java.util.HashMap;


public class User {

    private String login;
    private String password;
    private final Integer id;
    private static Integer counter = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();

    User(){
        this.id = counter++;
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
