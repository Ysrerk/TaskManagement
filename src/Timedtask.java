import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Timedtask extends  Task{
    static List<Object> timedTasklist;

    private static LocalDateTime startDate;
    private  static LocalDateTime endDate;


    static void addtimedtasklist(ArrayList<Object> list,LocalDateTime startDate,LocalDateTime endDate){
        timedTasklist=new ArrayList<>();

        timedTasklist=list;
        timedTasklist.add(startDate);
        timedTasklist.add(endDate);
        timedTasklist.set(timedTasklist.indexOf(Status.ADDED),Status.SCHEDULED);
        Main.listofaddedtimedtasklist.add(timedTasklist);



    }














}
