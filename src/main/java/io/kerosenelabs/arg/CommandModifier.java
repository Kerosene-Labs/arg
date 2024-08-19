package io.kerosenelabs.arg;

import lombok.Getter;

/**
 * <h2>Argument Parser Command Modifier</h2>
 * A command modifier can modify the input/output of a command, but shouldn't be considered an "input". For example,
 * with the following Docker command:
 * <p/>
 * docker logs container_name <b>--tail 30</b>
 * <p/>
 * The <b>--tail 30</b> component is what's known as a command modifier in EAP.
 */
public class CommandModifier {
    @Getter
    private String name;

    @Getter
    private String description;

    // private Class expectedType; todo finish
    private String value;

    public CommandModifier(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
