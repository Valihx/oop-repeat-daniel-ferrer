package com.musicshop.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        try {
            ServerSocket sSocket = new ServerSocket(8888);
            System.out.println("waiting for connection");

            //loop listening for a connection
            while (true) {

                Socket clientSocket = sSocket.accept();
                System.out.println("new client connected");

                //handle the client in a new thread to not clash with others
                ClientHandler cHandler = new ClientHandler(clientSocket);
                new Thread(cHandler).start();
            }
        } catch (IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
        }
    }
}