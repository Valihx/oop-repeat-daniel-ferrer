package com.musicshop.server;

import java.net.Socket;
import java.io.*;


public class ClientHandler implements Runnable {
    //private socket to handle a client
    private Socket clientSocket;
    private int clientID;

    //constructor for new clients
    public ClientHandler(Socket socket, int clientID) {
        this.clientSocket = socket;
        this.clientID = clientID;
    }

    @Override
    public void run() {
        System.out.println("clienthandler started for:" + clientID);

        try {
            // translation for the socket
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //listen for a request
            String request =  in.readLine();
            System.out.println("clienthandler received request: " + request);

            if(request != null && request.equals("GetAllInstruments")){
                //json code
            }


        } catch (IOException e) {
            System.out.println("Error in Client Handler: " + e.getMessage());
        }
    }
}