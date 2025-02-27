package com.github.Mazlik9.command;

import com.github.Mazlik9.ClientHandler;

import java.util.*;

public class CommandHandler {

    private final Map<String, Command> commands = new HashMap<>();

    // constructors
    public CommandHandler(){
        commands.put("kick", new KickCommand());
        commands.put("stop", new StopCommand());
    }

    public void handle(String input, ClientHandler clientHandler){
        String[] parts = input.split(" ");
        String commandName = parts[0].toLowerCase();
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, parts.length - 1);

        Command command = commands.get(commandName);
        if(command != null){
            command.execute(clientHandler, args);
        } else{
            System.out.println("Unknown command: " + commandName);
        }
    }
}
