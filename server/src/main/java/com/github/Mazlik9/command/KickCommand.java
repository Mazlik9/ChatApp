package com.github.Mazlik9.command;

import com.github.Mazlik9.ClientHandler;
import com.github.Mazlik9.Server;

public class KickCommand implements Command{
    @Override
    public void execute(ClientHandler clientHandler, String[] args) {
        Server.removeClient(clientHandler);
    }
}
