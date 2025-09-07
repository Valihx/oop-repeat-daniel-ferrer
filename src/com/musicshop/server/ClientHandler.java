package com.musicshop.server;

import java.net.Socket;

public class ClientHandler implements Runnable {
    //private socket to handle a client
    private Socket clientSocket;

    //constructor for new clients
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("client connected");
    }
}