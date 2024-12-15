package modules.Tasks.Timed;

import modules.Tasks.Task;

public class TimedTask extends Task {



    public TimedTask(){
        super();
    }

    public TimedTask(Integer statusID, String name, String description){
        super(statusID, name, description);
    }
}
