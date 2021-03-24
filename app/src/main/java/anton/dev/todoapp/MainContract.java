package anton.dev.todoapp;

import java.util.List;

public interface MainContract {

    interface View {
        void showTodoList(List<String> todoList);
    }

    interface Presenter {
        void clickNewTaskButton();
        void clickDeleteTask();
    }

    interface Model {
        void addTask();
        void loadTask();
        void deleteTask();
    }
}
