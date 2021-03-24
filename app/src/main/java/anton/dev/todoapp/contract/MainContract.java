package anton.dev.todoapp.contract;

import java.util.List;

import anton.dev.todoapp.model.entity.Task;

public interface MainContract {

    interface View {
        void showTodoList(List<Task> todoList);

        void showDialogTask();

    }

    interface Presenter {

        void initListRecyclerView();

        void clickNewTaskButton();

        void clickDeleteTask();

        void getTaskFromPosition(int position);

        void clickAddNewTask(Task task);
    }

    interface Model {
        void addTask(Task task);

       // void deleteTask(int id); todo

        List<Task> loadTask();

//        void deleteTask();
    }
}
