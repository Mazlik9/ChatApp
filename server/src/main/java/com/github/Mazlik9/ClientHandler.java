package com.github.Mazlik9;

import com.github.Mazlik9.command.CommandHandler;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable{

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private CommandHandler commandHandler = new CommandHandler();

    // constructors
    public ClientHandler(Socket socket){
        this.socket = socket;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e){
            System.out.println("Error creating streams: " + e.getMessage());
            closeConnections();
        }
    }

    @Override
    public void run() {
        try{
            String message;
            while ((message = in.readLine()) != null){
                System.out.println("Received: " + message);
                commandHandler.handle(message, this);
            }
        } catch (IOException e){
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            closeConnections();
        }

    }

    public void closeConnections(){
        try{
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing connections: " + e.getMessage());
        }
    }
}
