package modules.Tasks.Timeless;

import modules.Tasks.Task;

import java.util.logging.Logger;

public class TimelessTask extends Task{

    public static final Logger LOGGER = Logger.getLogger(TimelessTask.class.getName());

    public TimelessTask(){
        super();
    }

    public TimelessTask(Integer statusID, String name, String description){
        super(statusID, name, description);
    }


}
