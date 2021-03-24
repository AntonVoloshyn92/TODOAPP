package anton.dev.todoapp.ui.mainActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import anton.dev.todoapp.R;
import anton.dev.todoapp.model.entity.Task;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Task> todoList;
    private RecyclerViewAdapter.OnItemClickListener listener;

    public RecyclerViewAdapter(List<Task> todoList , OnItemClickListener listener) {
        this.todoList = todoList;
        this.listener = listener;
    }

    public void setTodoList(List<Task> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("RecyclerViewAdapter", "onBindViewHolder + position " + String.valueOf(position));
        holder.tv_task.setText(todoList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tv_task;
        private OnItemClickListener iListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.iListener = listener;
            tv_task = itemView.findViewById(R.id.tv_task);

        }

        @Override
        public void onClick(View v) {
            iListener.onClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}
