package com.musicshop.client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    public void start(){

        System.out.println("trying to connect to server");
        try {
            // create a socket and connects to the server.
            Socket socket = new Socket("localhost", 8888);
            //it works
            System.out.println("client connection successful");
            //code code code
            socket.close();
            //done with client
            System.out.println("client connection closed");

        } catch (IOException e) {
            //error connecting
            System.out.println("couldnt connect client");
        }
    }
}

