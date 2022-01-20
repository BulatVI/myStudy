package com.dubakovNetworkProgramming.TCP.example;

/* Программа для реализации простого клиентского сервера */

import java.io.*;
import java.net.*;

public class Server extends Thread {
    ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(1001);
            System.out.println(serverSocket);
        } catch (IOException e) {
            fail(e, "Could not start server.");
        }
        System.out.println("Server is running . . .");
        this.start();
    }

    public static void fail(Exception e, String str) {
        System.out.println(str + "." + e);
    }

    @Override
    public void run() {
        try {
            while (true) {
                /* Принимаются запросы от клиентов */
                Socket client = serverSocket.accept();
                //Создается объект соединение, чтобы управлять взаимодействием клиента с сервером
                new Connection(client);
            }
        } catch (IOException e) {
            fail(e, "Not listening");
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}

class Connection extends Thread {
    /* Declare the variables */
    protected Socket netClient;
    protected BufferedReader fromClient;
    protected PrintStream toClient;

    public Connection(Socket client) {
        netClient = client;
        try {
/* Создается входной поток, чтобы принимать данные от клиента */
            fromClient = new BufferedReader(new InputStreamReader(netClient.getInputStream()));
/* Создается выходной поток, чтобы посылать данные клиенту */
            toClient = new PrintStream(netClient.getOutputStream());
        } catch (IOException e) {
            try {
                netClient.close();
            } catch (IOException e1) {
                System.err.println("Unable to set up streams" + e1);
                return;
            }
        }
        this.start();
    }

    @Override
    public void run() {
        String login, password;
        try {
            while (true) {
                toClient.println("Login: ");
                /* Принимается login как ввод от клиента */
                login = fromClient.readLine();
                // Завершить соединение, когда Bye вводится как login
                if (login == null || login.equals("Bye")) {
                    System.out.println("Exit");
                    return;
                } else
                    System.out.println(login + " logged in");
                // Посылается подтверждение клиенту
                toClient.println("Password: ");
                /* Принимается пароль то клиента */
                password = fromClient.readLine();
            }
        } catch (IOException ignore) {
        } finally {
            try {
                netClient.close();
            } catch (IOException ignored) {
            }
        }
    }
}

