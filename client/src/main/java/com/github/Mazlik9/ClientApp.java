package com.github.Mazlik9;

import com.github.Mazlik9.network.ClientNetworkManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.util.Scanner;

public class ClientApp {

    private static final int PORT = 55556;

    public static void main(String[] args) {


        ClientNetworkManager networkManager = new ClientNetworkManager();

        try{
            networkManager.connectToServer("localhost", PORT);
            System.out.println("Connected to the server. Type message to send");

            Scanner scanner = new Scanner(System.in);
            String userInput;

            while(true){
                userInput = scanner.nextLine();

                networkManager.sendMessage(userInput);
                String response = networkManager.receiveMessage();
                System.out.println("Received from server: " + response);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
