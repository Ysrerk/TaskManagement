
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Jsonread {

    static void readjson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("tasks2.json"));
        for (Object o : a)
        {
            JSONObject task = (JSONObject) o;
            JSONObject task2 = (JSONObject) task.get("task");
            String Status =(String) (task2.get("Status"));
            System.out.println("*****************************");
            System.out.println("Task Status :"+Status);

            String id = (String) task2.get("id");
            System.out.println("Task id :"+id);

            String DueDate = (String) task2.get("DueDate");
            System.out.println("Task DueDate :"+DueDate);

            String task_details = (String) task2.get("task_details");
            System.out.println("Task Details :"+task_details);
            System.out.println("*****************************");

           // JSONArray task_details = (JSONArray) task2.get("task_details");
            //System.out.println(task_details);

        }


    }

}
