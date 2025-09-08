package com.musicshop.server;

import com.musicshop.dao.InstrumentDaoImplementation;
import com.musicshop.dao.InstrumentDaoInterface;
import com.musicshop.exception.DaoException;

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

            if (request != null && request.equals("GetAllInstruments")) {
                InstrumentDaoInterface dao = new InstrumentDaoImplementation();
                out.println(dao.getAllInstrumentsAsJson());
            }

            clientSocket.close();

        } catch (IOException | DaoException e) { // This handles both network and database errors
            System.out.println("ClientHandlere rror: " + e.getMessage());
        }
    }
}