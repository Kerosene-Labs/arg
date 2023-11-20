package xyz.hlafaille.eap;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h2>Espresso Argument Parser Command Modifier</h2>
 * A command modifier can modify the input/output of a command, but shouldn't be considered an "input". For example,
 * with the following Docker command:
 * <p/>
 * docker logs container_name <b>--tail 30</b>
 * <p/>
 * The <b>--tail 30</b> component is what's known as a command modifier in EAP.
 */
@Getter
@AllArgsConstructor
public abstract class CommandModifier {
    private String name;
    private String description;
    // private Class expectedType; todo finish
    private String value;
}
