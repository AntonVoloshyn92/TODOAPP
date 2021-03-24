package anton.dev.todoapp.ui.mainActivity;

import android.util.Log;

import java.util.List;

import anton.dev.todoapp.contract.MainContract;
import anton.dev.todoapp.model.db.Model;
import anton.dev.todoapp.model.entity.Task;

public class MainActivityPresenter implements MainContract.Presenter {

    private final String LOG_TAG = this.getClass().getSimpleName();
    private MainContract.View view;
    private MainContract.Model model;

    public MainActivityPresenter(MainContract.View view) {
        this.view = view;
        model = new Model();
    }

    @Override
    public void initListRecyclerView() {
        view.showTodoList(model.loadTask());
    }

    @Override
    public void clickNewTaskButton() {
        view.showDialogTask();
    }

    @Override
    public void clickDeleteTask() {

    }

    @Override
    public void getTaskFromPosition(int position) {
        Task task = model.loadTask().get(position);
        Log.d("WTF", "selected task is " + task.getDescription());

    }


    @Override
    public void clickAddNewTask(Task task) {
        if (task != null) {
            //todo
        }
    }

}
