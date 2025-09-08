package com.musicshop.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args){
        new Server().start();
    }

    public void start(){
        try{
            //making a socket for all connections to be listened
            ServerSocket sSocket = new ServerSocket(8888);
            System.out.println("waiting for connection");
            int clientCount = 0;

            //loop listening for connections forever
            while(true) {

                Socket clientSocket = sSocket.accept();
                clientCount++;
                System.out.println("new client connected:"+clientCount);

                //handle the client in a new thread to not clash with others
                ClientHandler cHandler = new ClientHandler(clientSocket, clientCount);
                new Thread(cHandler).start();
            }
        } catch(IOException e) {
            System.out.println("Server Exception: " + e.getMessage());
        }
    }
}