package ca.ubc.cpsc210.todo.model;

/**
 * Created by HardingLiu on 2015-07-22.
 */
public class UnscheduledTodoItem extends TodoItem {
    boolean highPriority;

    public UnscheduledTodoItem(String title, String description, boolean highPriority) {
        super(title, description);
        this.highPriority = highPriority;
    }


    @Override
    public boolean isHighPriority() {
        return highPriority;
    }


    public void setHighPriority(boolean highPriority) {
        this.highPriority = highPriority;
    }

}
