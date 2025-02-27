package com.github.Mazlik9;

import com.github.Mazlik9.command.CommandHandler;
import com.github.Mazlik9.model.Client;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int PORT = 55556;
    private static List<ClientHandler> clients = new ArrayList<>();
    private static CommandHandler commandHandler = new CommandHandler();

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server listening on port: " + PORT);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e){
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void removeClient(ClientHandler clientHandler){
        clients.remove(clientHandler);
        clientHandler.closeConnections();
    }

    public static void stop(){
        for(ClientHandler clientHandler : clients){
            clientHandler.closeConnections();
        }
        clients.clear();
        System.out.println("Server stopped");
        System.exit(0);
    }
}
