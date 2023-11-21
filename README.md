# Espresso Argument Parser (EAP)
The **Espresso Argument Parser** is a library built for the [Espresso](https://github.com/hlafaille/espresso) build tool
to provide a clean and efficient way of handling command line arguments. See the `doc/` directory for more in depth 
information.

# Features
* Mimics the Docker CLI `resource -> action on resource` style
* Command Modifiers
  * Optionally take in a value of a generic type (ex: Integer, String, Boolean)
  * Enforce that type with builtin exception handlers
  * Automatically wired in to your command's `execute()` method, allowing you to modify the output of that command 
    depending on the modifiers specified
* Command Containers (Subcommands)
  * Navigational, container like objects that don't provide any business logic
  * Designed to represent a particular resource, like images in Docker's case
* Exception handlers
  * Built in exception handlers to deal with scenarios such as:
    * Command/Command Container/Command Modifier not found
    * Command/Command Container not specified
    * Incorrect command modifier input data type
* ~~Automatic help text generation and printing~~
* ~~Exit code propagation~~
  * ~~Define your exit code in an exception handler~~

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
        
        // add that container to your parser
        espressoArgumentParser.addCommandContainer(commandContainer);
        
        // enter the parser
        espressoArgumentParser.parse(args);
    }
}
```
...now run your `.jar` file with the `images ps` arguments, you should see the text `Do your business logic here!` print
to the console!

# Reason
I strongly disliked how other libraries like Apache Commons CLI work, especially since they seem to enforce a GNU style
on the developer. **EAP** enforces a resource-style (similar to Docker CLI) structure, with support for modifiers on any
particular command.