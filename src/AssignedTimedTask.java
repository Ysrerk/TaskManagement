import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AssignedTimedTask  extends Task{
    private int budget;


    public  static void tobudgetthetask(List<Object> list, LocalDateTime startdate, LocalDateTime enddate, int budget){

        List<Object>budgettasklist=new ArrayList<>();
        budgettasklist=list;
        budgettasklist.add(startdate);
        budgettasklist.add(enddate);
        budgettasklist.add(budget);
        budgettasklist.set(budgettasklist.indexOf(Status.ASSIGNED),Status.SCHEDULEDASSIGNED);

        Database.listofbudgettasklist.add(budgettasklist);


    }


}
