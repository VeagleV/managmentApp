package modules;
import java.util.ArrayList;
public class User {

    private String login;
    private String password;
    private final Integer id;

    private ArrayList<Task> listOfTasks = new ArrayList<>();

    User(String login, String password, Integer id, ArrayList<Task> listOfTasks){
        this.login = login;
        this.password = password;
        this.id = id;
        this.listOfTasks = listOfTasks;
    }

    User(String login, String password, Integer id){
        this.login = login;
        this.password = password;
        this.id = id;
    }

    User(String login, String password){
        this.login = login;
        this.password = password;
        this.id = 0;
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

    public Task getTask(String name){

        Integer currentID = getTaskId(name);

        return Mediator.getTask(currentID, listOfTasks);
    }

    public Integer getTaskId(String name){
        return Mediator.getTaskId(name, listOfTasks);
    }


    public void updateTask(Task task){
        Mediator.updateTask(task, listOfTasks);
    }







}
