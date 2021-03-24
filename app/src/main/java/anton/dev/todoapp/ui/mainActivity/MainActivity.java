package anton.dev.todoapp.ui.mainActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

import anton.dev.todoapp.contract.MainContract;
import anton.dev.todoapp.R;
import anton.dev.todoapp.model.entity.Task;

public class MainActivity extends AppCompatActivity implements MainContract.View, RecyclerViewAdapter.OnItemClickListener {

    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;
    private final String LOG_TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Click button");
                presenter.clickNewTaskButton();
            }
        });
    }

    private void init() {
        Log.d(LOG_TAG, "init");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new MainActivityPresenter(this);
        presenter.initListRecyclerView();
    }

    @Override
    public void showTodoList(List<Task> todoList) {
        Log.d(LOG_TAG, "showTodoList");
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(todoList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showDialogTask() {
        Log.d(LOG_TAG, "showDialogTask");
        showDialog();
    }

    private void showDialog() {
        Log.d(LOG_TAG, "show Dialog");
        final EditText editText = new EditText(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER;
        lp.setMargins(16, 16, 16, 16);
        editText.setLayoutParams(lp);

        new AlertDialog.Builder(this)
                .setTitle("Write task")
                .setView(editText)
                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = editText.getText().toString();
                        if (!TextUtils.isEmpty(text)) {
                            presenter.clickAddNewTask(new Task(text));
                        }
                    }
                })
                .create()
                .show();
    }

    @Override
    public void onClick(int position) {
        presenter.getTaskFromPosition(position);
    }
}

//todo build MVP
//build controller and local DB and Remute DB
//todo set firebase
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();