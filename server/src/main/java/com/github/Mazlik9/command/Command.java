package com.github.Mazlik9.command;

import com.github.Mazlik9.ClientHandler;

public interface Command {
    void execute(ClientHandler clientHandler, String[] args);
}
