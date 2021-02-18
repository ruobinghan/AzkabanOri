package yaml.unit;

public class Command {
    private String command;
//    private Map map;

    public Command(String command) {
        this.command = command;
//        map=new LinkedHashMap();
//        map.put("command",command);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
