import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Jsonmake {

        void jsonmake(List<List<Object>> task){


        JSONArray taskList = new JSONArray();
        for (List<Object>stask:task){
            JSONObject taskDetails = new JSONObject();
            JSONObject taskObject = new JSONObject();

            taskDetails.put("id",String.valueOf(stask.get(0)));
            taskDetails.put("task_details",String.valueOf(stask.get(1)));
            taskDetails.put("DueDate", String.valueOf(stask.get(2)));
            taskDetails.put("Status", String.valueOf(stask.get(3)));
            taskObject.put("task", taskDetails);
            taskList.add(taskObject);



        }

        try (FileWriter file = new FileWriter("tasks2.json")) {

            file.write(taskList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }







    }
}
