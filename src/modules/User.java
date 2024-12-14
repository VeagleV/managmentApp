package modules;
import java.util.ArrayList;
public class User {

    private String login;
    private String password;
    private final Integer id;
    private static Integer counter = 0;
    private ArrayList<Task> listOfTasks = new ArrayList<>();

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




}
