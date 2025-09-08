package com.musicshop.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int request;

        do {
            System.out.println("\n     Menu ");
            System.out.println("1. Display All Instruments");
            System.out.println("2. Exit");
            System.out.print("Enter your request: ");

            request = scanner.nextInt();

            if (request == 1) {
                System.out.println("\nRequesting all instruments from server...");
                try {
                    Socket socket = new Socket("localhost", 8888);

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    out.println("GetAllInstruments");
                    String response = in.readLine();
                    //json array to prove connection works
                    System.out.println("\nServer Response:"+response);

                    socket.close();

                } catch (IOException e) {
                    System.out.println("Client Error: could not connect to server");
                }
            } else if (request != 2) {
                System.out.println("Invalid request, please try again.");
            }

        } while (request != 2);

        System.out.println("Exiting application.");
    }
}