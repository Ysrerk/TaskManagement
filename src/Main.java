import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {
     static List<List<Object>> listofaddedtasklist =new ArrayList<>();
     static List<List<Object>> listofaddedtimedtasklist =new ArrayList<>();
     static List<List<Object>> listofassignedtasklist=new ArrayList<>();
    public static void main(String[] args) {
        interactionwithuser();
       //Task.addtask(1,"write a code", LocalDateTime.now());
       //Task.addtask(2,"complete code", LocalDateTime.now());

        System.out.println(listofaddedtasklist);

    }

    //  in this method  will handle   user interactions
    public static void interactionwithuser(){

        while (true){
            Scanner read=new Scanner(System.in);
            System.out.println("please chooese  from menu which  type process do you want " +
                    "0-exit"+
                    "1-Add new Task"+
                    "2-Add a task to Timed Task List"+
                    "3-To list Tasks"+
                    "4-To list Timed Tasks"+
                    "5-To Assign task"+
                    "6-To list  assigned task");
            int processid= read.nextInt();
            if (processid==0){

                break;
            }
            else if(processid==1){
                System.out.println("please enter task id");
                int id= read.nextInt();
                System.out.println("please add task name");
                String name= read.next();

                System.out.println("please add task due date like this format  (yyyy-MM-dd)");
                String duedate=read.next();
                duedate+="T12:00:00";

                //LocalDateTime aLD = LocalDateTime.parse(duedate);
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dueDate = LocalDateTime.parse(duedate);
                Task.addtask(id,name,dueDate);


            } else if (processid == 2) {
                System.out.println("which task do you want to timed task  please enter id");
                int timedtaskid= read.nextInt();

                System.out.println("please add task startdate like this format  (yyyy-MM-dd)");
                String startdate=read.next();
                startdate+="T12:00:00";

                LocalDateTime starDate = LocalDateTime.parse(startdate);
                System.out.println("please add task finishdate like this format  (yyyy-MM-dd)");
                String finishdate=read.next();
                finishdate+="T12:00:00";

                LocalDateTime endDate = LocalDateTime.parse(finishdate);
                // id that is  was got from user  is  searching  in the list of task
                for (List<Object> timedtask:listofaddedtasklist){
                    ArrayList<Object>timedtaskc=(ArrayList<Object>) timedtask;

                    if(timedtaskc.contains(timedtaskid)){
                        int ind=listofaddedtasklist.indexOf(timedtaskc);
                        Timedtask.addtimedtasklist(timedtaskc,starDate,endDate);

                        //************************Buna bir bakmam lazim **********************************************
                        //listofaddedtasklist.remove(ind);


                    }
                }
            }
            else if (processid==3){

                for(List<Object> tlist:listofaddedtasklist){


                    System.out.println("Task id:"+tlist.get(0)+"Task  details:"+tlist.get(1)+"Task Due Date:"
                            +tlist.get(2)+"Task Status:"+tlist.get(3));
                }

            }


            else if(processid==4){
                //ttlist is meaning timed task
                for(List<Object>ttlist:listofaddedtimedtasklist){

                    System.out.println("Task id:"+ttlist.get(0)+"Task  details:"+ttlist.get(1)+"Task Due Date:"
                            +ttlist.get(2)+"Task Status:"+ttlist.get(3)+"Task start date:"+ttlist.get(4)+"Task end date:"
                            +ttlist.get(5));

                }
            }
            else if(processid==5){

                System.out.println("which task do you want to assigned to task  please enter id");

                int assignedid=read.nextInt();

                System.out.println("Who do you want to assign?");
                String assignto=read.next();

                for(List<Object>astask:listofaddedtasklist){

                   if(astask.contains(assignedid)){

                       Assignedtask.assignedtotask(astask,assignto);
                   }
                }

            }

            else if (processid==6){

                for (List<Object> aslist:listofassignedtasklist){

                    System.out.println(" ASSIGNED TASK LIST "+"TASK ID:"+aslist.get(0)+"  TASK DETAILS:"+aslist.get(1)+"  TASK DUE DATE:"+aslist.get(2)+"TASK STATUS:"+ aslist.get(3)+"   TASK ASSIGNED TO:"+aslist.get(4));
                }
            }


        }


    }



}
