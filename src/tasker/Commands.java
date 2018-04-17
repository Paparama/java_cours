package tasker;

public enum Commands {
    SHOW_COMMANDS("show commands"),
    EXIT("exit"),
    CLOSE("close"),
    SHOW_ALL_TASKS("show all tasks"),
    SHOW_DONE("show done"),
    TAKE_TASK("take task"),
    MARK_AS_DONE("mark as done");

    private String description;

    private Commands(String description) {
        this.description = description;
    }

    public String getDescription() {return description;}
}
