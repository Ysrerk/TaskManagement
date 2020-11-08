import java.util.ArrayList;
import java.util.List;

public class Assignedtask  extends Task{


    private static String assignedto;

    static void assignedtotask(List<Object> list,String assignedto){

        List<Object> assignedtasklist=new ArrayList<>();
        assignedtasklist=list;
        assignedtasklist.add(assignedto);
        assignedtasklist.set(list.indexOf(Status.ADDED),Status.ASSIGNED);
        Database.listofassignedtasklist.add(assignedtasklist);

    }



}
