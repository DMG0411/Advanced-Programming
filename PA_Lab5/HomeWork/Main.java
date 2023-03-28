package HomeWork;

import HomeWork.commands.*;

public class Main {
    private static final Catalog catalog = new Catalog();

    public static void main(String[] args) {
        try {
            Command command = parseCommand(args);
            command.execute();
        } catch (InvalidDataException e) {
            System.err.println("Invalid data: " + e.getMessage());
        } catch (InvalidCommandException e) {
            System.err.println("Invalid command: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Command parseCommand(String[] args) throws InvalidCommandException {
        if (args.length == 0) {
            throw new InvalidCommandException("No command specified");
        }
        String commandName = args[0];
            switch (commandName) {
                case "add" -> {
                    if (args.length != 4) {
                        throw new InvalidCommandException("Invalid add command syntax");
                    }
                    int id = Integer.parseInt(args[1]);
                    String name = args[2];
                    String path = args[3];
                    return new AddCommand(catalog, id, name, path);
                }
                case "list" -> {
                    if (args.length != 1) {
                        throw new InvalidCommandException("Invalid list command syntax");
                    }
                    return new ListCommand(catalog);
                }
                case "view" -> {
                    if (args.length != 2) {
                        throw new InvalidCommandException("Invalid view command syntax");
                    }
                    int viewId = Integer.parseInt(args[1]);
                    return new ViewCommand(catalog, viewId);
                }
                case "report" -> {
                    if (args.length != 2) {
                        throw new InvalidCommandException("Invalid report command syntax");
                    }
                    String outputPath = args[1];
                    return new ReportCommand(catalog, outputPath);
                }
                default -> throw new InvalidCommandException("Unknown command: " + commandName);
            }
    }
}
