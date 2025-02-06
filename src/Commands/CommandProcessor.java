package Commands;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commands;

    public CommandProcessor() {
        commands = new HashMap<>();
        commands.put("help", new Help_Command());
    }
}
