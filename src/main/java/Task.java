
public class Task {
    public static final String EXIT_COMMAND = "bye";

    public static final String LIST_COMMAND = "list";
    public static final String EXIT_MESSAGE = "Bye. Hope to see you again soon!\n";

    private String task;
    private boolean isDone = false;

    enum ValidTasks {
        todo, deadline, event
    }
    Task(String task) {
        this.task = task;
    }

    public boolean isExit() {
        return this.task.equals(Task.EXIT_COMMAND);
    }

    public String get() {
        return this.task;
    }

    public boolean isList() {
        return this.task.equals(Task.LIST_COMMAND);
    }

    public void toggleDone() {
        this.isDone = !this.isDone;
    }

    public String getStatusIcon() {
        return this.isDone ? "X" : "";
    }

    public boolean isMark() {
        return this.task.contains("mark");
    }

    public boolean isUnmark() {
        return this.task.contains("unmark");
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String eventCode() {
        return "";
    }

    public boolean isValidTask() throws InvalidTask {
        if (!this.task.contains(" ")) {
            throw new InvalidTask();
        }

        int i = this.task.indexOf(' ');
        String command = this.task.substring(0, i);

        for (ValidTasks v : ValidTasks.values()) {
            if (v.toString().equals(command)) {
                return true;
            }
        }

        throw new InvalidTask();
    }

    //returns the event string without the prefix word
    public String eventDescription() {
        int i = this.get().indexOf(' ');
        return this.get().substring(i + 1);
    }

}
