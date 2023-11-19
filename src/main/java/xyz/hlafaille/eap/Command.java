package xyz.hlafaille.eap;

import lombok.Getter;

import java.util.List;

/**
 * <h2>Espresso Argument Parser Command</h2>
 */
public abstract class Command {
    private String shortName;
    private String name;
    private String helpText;

    @Getter
    private List<CommandModifier> commandModifierList;

}
