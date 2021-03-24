package anton.dev.todoapp.model.db;

import java.util.ArrayList;
import java.util.List;

import anton.dev.todoapp.contract.MainContract;
import anton.dev.todoapp.model.entity.Task;

public class Model implements MainContract.Model {

    @Override
    public void addTask(Task task) {

    }

    @Override
    public List<Task> loadTask() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Поспать"));
        taskList.add(new Task("Покушать"));
        taskList.add(new Task("Погулять"));
        taskList.add(new Task("Выпить кофе"));
        taskList.add(new Task("Поваляться"));
        taskList.add(new Task("Поужинать"));
        taskList.add(new Task("Поужинать1"));
        taskList.add(new Task("Поужинать2"));
        taskList.add(new Task("Поужинать3"));
        taskList.add(new Task("Поужинать4"));
        taskList.add(new Task("Поужинать5"));
        taskList.add(new Task("Поужинать6"));
        taskList.add(new Task("Поужинать7"));
        taskList.add(new Task("Поужинать8"));
        taskList.add(new Task("Поужинать9"));
        taskList.add(new Task("Поужинать10"));
        taskList.add(new Task("Поужинать11"));
        taskList.add(new Task("Поужинать12"));
        taskList.add(new Task("Поужинать13"));
        taskList.add(new Task("Поужинать14"));
        taskList.add(new Task("Поужинать15"));
        taskList.add(new Task("Поужинать16"));
        taskList.add(new Task("Поужинать17"));
        taskList.add(new Task("Поужинать18"));
        return taskList;
    }
}
