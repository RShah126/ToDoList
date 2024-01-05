package Shah.SERVLETS;

import Shah.TASKS.Task;
import Shah.DB.DBSupport;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ToDoList")
public class TaskGenerator extends HttpServlet {

    private final List<Task> taskList = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            out.println(taskList.toString());     
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String taskTitle = request.getParameter("taskTitle");
    String priority = request.getParameter("priority");  
    Task newTask = new Task(taskTitle, false, priority);  
    taskList.add(newTask);

    try {
        newTask.newTaskSQL();                
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    String jsonResponse = newTask.toString();

    response.setContentType("application/json");
    try (PrintWriter out = response.getWriter()) {
        out.println(jsonResponse);
        }
    }


    @Override
    public String getServletInfo() {
        return "TaskGenerator Servlet";
    } 


}

