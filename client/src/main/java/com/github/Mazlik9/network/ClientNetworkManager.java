package com.github.Mazlik9.network;

import java.io.*;
import java.net.Socket;

public class ClientNetworkManager {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public void connectToServer(String address, int port) throws IOException {
        socket = new Socket(address, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Connected to the Server");
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public void closeConnections() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing connections: " + e.getMessage());
        }
    }
}
