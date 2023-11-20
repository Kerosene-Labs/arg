# Espresso Argument Parser (EAP)
The **Espresso Argument Parser** is a library built for the [Espresso](https://github.com/hlafaille/espresso) build tool
to provide a clean and efficient way of handling command line arguments. See the `doc/` directory for more in depth 
information.

# Usage
```java
/**
 * Main.java
 */

public class Main() {
    public static void main(String[] args) {
        EspressoArgumentParser espressoArgumentParser = new EspressoArgumentParser("Docker", "Containers, yo!");

        // build our command
        Command command = new Command("ps", "List all images on this system") {
            @Override
            public void execute(List<CommandModifier> commandModifiers) {
                System.out.println("Do your business logic here!");
            }
        };

        // wrap your commands in a command container
        CommandContainer commandContainer = new CommandContainer("images", "Show all top level images");
        commandContainer.addCommand(command);
        
        // enter the parser
        espressoArgumentParser.addCommandContainer(commandContainer);
    }
}
```
Compile and execute your file (`java Main.class images ps`) and you will witness the business logic execute.

# Features
* Almost exact Docker-like CLI structure
* Command Modifiers
  * `--tail 30`, `--verbose`, `--search "term"`
* Subcommands
  * Navigational, container like objects that don't provide any functionality
* ~~Automatic help text generation and printing~~
* ~~Call other commands internally~~
* ~~Exception handlers~~

# Reasoning
I strongly disliked how other libraries like Apache Commons CLI work, especially since they seem to enforce a GNU style
on the developer. **EAP** enforces a resource-style (similar to Docker CLI) structure, with support for modifiers on any
particular command.