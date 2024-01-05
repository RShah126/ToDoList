package Shah.TASKS;

/**
 *
 * @author ryans
 */
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<Task> tasks = new ArrayList<>();

    public static void AddTask(Task task) {
        tasks.add(task);
    }
    
    public static void RemoveTask(Task task) {
        tasks.remove(task);
    }


    public static List<Task> getTasks() {
        return tasks;
    }

 
}
