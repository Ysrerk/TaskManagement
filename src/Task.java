import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {


    static List<Object>addedtasklist;

    public enum Status{
        ADDED,
        ASSIGNED,
        SCHEDULED,
        SCHEDULEDASSIGNED
    }
    private int id;
    private String name;
    private LocalDateTime dueDate;



    static void addtask(int id,String name,LocalDateTime dueDate){

        addedtasklist=new ArrayList<>();

        addedtasklist.add(id);
        addedtasklist.add(name);
        addedtasklist.add(dueDate);
        addedtasklist.add(Status.ADDED);
        Database.listofaddedtasklist.add(addedtasklist);

    }




}
