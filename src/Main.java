import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        interactionwithuser();
       //Task.addtask(1,"write a code", LocalDateTime.now());
       //Task.addtask(2,"complete code", LocalDateTime.now());

        System.out.println(Database.listofaddedtasklist);

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
                    "6-To list  assigned task"+
                    "7-Assigned timed task"+
                    "8- To list assigned timed task"+
                    "9-Sort Task according to Name"+
                    "10-Sort Task according to Date"+
                    "11-Delete Task");
            int processid= read.nextInt();
            if (processid==0){

                break;
            }
            else if(processid==1){
                read.nextLine();
                System.out.println("please enter task id");
                int id=Integer.valueOf(read.nextLine());
                System.out.println("please add task name");
                String name= read.nextLine();

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
                for (List<Object> timedtask:Database.listofaddedtasklist){
                    ArrayList<Object>timedtaskc=(ArrayList<Object>) timedtask;

                    if(timedtaskc.contains(timedtaskid)){
                        int ind=Database.listofaddedtasklist.indexOf(timedtaskc);
                        Timedtask.addtimedtasklist(timedtaskc,starDate,endDate);

                        //************************Buna bir bakmam lazim **********************************************
                        //listofaddedtasklist.remove(ind);


                    }
                }
            }
            else if (processid==3){

                for(List<Object> tlist:Database.listofaddedtasklist){


                    System.out.println("Task id:"+tlist.get(0)+"Task  details:"+tlist.get(1)+"Task Due Date:"
                            +tlist.get(2)+"Task Status:"+tlist.get(3));
                }

            }


            else if(processid==4){
                //ttlist is meaning timed task
                for(List<Object>ttlist:Database.listofaddedtimedtasklist){

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

                for(List<Object>astask:Database.listofaddedtasklist){

                   if(astask.contains(assignedid)){

                       Assignedtask.assignedtotask(astask,assignto);
                   }
                }

            }

            else if (processid==6){

                for (List<Object> aslist:Database.listofassignedtasklist){

                    System.out.println(" ASSIGNED TASK LIST "+"TASK ID:"+aslist.get(0)+"  TASK DETAILS:"+aslist.get(1)+
                            "  TASK DUE DATE:"+aslist.get(2)+"TASK STATUS:"+
                            aslist.get(3)+"   TASK ASSIGNED TO:"+aslist.get(4));
                }
            }

            else if(processid==7){

                System.out.println("which task do you want to  bugget task");
                int id=read.nextInt();
                System.out.println("please add task startdate like this format  (yyyy-MM-dd)");
                String startdate=read.next();
                startdate+="T12:00:00";

                LocalDateTime starDate = LocalDateTime.parse(startdate);
                System.out.println("please add task finishdate like this format  (yyyy-MM-dd)");
                String finishdate=read.next();
                finishdate+="T12:00:00";

                LocalDateTime endDate = LocalDateTime.parse(finishdate);

                System.out.println("what isthe budget of  project");
                int budget= read.nextInt();

                for(List<Object> blist:Database.listofassignedtasklist){
                    if (blist.contains(id)){
                        AssignedTimedTask.tobudgetthetask(blist,starDate,endDate,budget);
                    }

                }
            }
            else if (processid==8){

                for (List<Object> bdlist:Database.listofbudgettasklist){

                    System.out.println(bdlist);

                   System.out.println("Budget list"+"task id"+ bdlist.get(0)+"task details:"+bdlist.get(1)+
                           "task due date"+bdlist.get(2)+"task status"+bdlist.get(3)+"task assigned to"+bdlist.get(4)+
                           "start date"+bdlist.get(5)+"end date"+bdlist.get(6)+"budget"+bdlist.get(7));
                }

            }

            else if(processid==9){

                List<Object> result = Database.listofaddedtasklist.stream().sorted((o1, o2)->o1.get(1).toString().compareTo(o2.get(1).toString())).collect(Collectors.toList());
                System.out.println("Tasks sorted  according to name :");

                for (Object task:result){
                    System.out.println(task);
                }

            }

            else if(processid==10){

                System.out.println("Tasks sorted according to date");

                List<Object> result = Database.listofaddedtasklist.stream().sorted((o1, o2)->o1.get(2).toString().compareTo(o2.get(2).toString())).collect(Collectors.toList());

                System.out.println(result);
            }
            else if(processid==11){
                System.out.println("which task do you want to delete ");
                int id=read.nextInt();


                for(List<Object> task:Database.listofaddedtasklist){

                    if(task.contains(id)){

                        Database.listofaddedtasklist.remove(task);
                    }
                }


            }




        }


    }



}
