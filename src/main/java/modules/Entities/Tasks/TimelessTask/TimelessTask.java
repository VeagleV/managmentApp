package modules.Entities.Tasks.TimelessTask;

import modules.Entities.Tasks.Task.Task;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.util.logging.Logger;

@Entity
@DiscriminatorValue("TimelessTask")
public class TimelessTask extends Task{

    public static final Logger LOGGER = Logger.getLogger(TimelessTask.class.getName());


    //----------------------CONSTRUCTORS----------------------
    public TimelessTask(){
        super();
    }

    public TimelessTask(Integer statusID, String name, String description){
        super(statusID, name, description);
    }
    //----------------------CONSTRUCTORS----------------------

}
