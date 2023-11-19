package xyz.hlafaille.eap;

import lombok.Getter;

import java.util.List;

/**
 * <h2>Espresso Argument Parser Command</h2>
 */
public abstract class Command {
    @Getter
    private String name;

    @Getter
    private String helpText;

    @Getter
    private List<CommandModifier> commandModifierList;

    public Command(String name, String helpText) {
        this.name = name;
        this.helpText = helpText;
    }

    abstract void execute();

}
