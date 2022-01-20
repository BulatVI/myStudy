package com.dubakovNetworkProgramming.TCP.example;

/* Программа для реализации простого клиентского сокета */

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        try (
                // Создается объект сокет, чтобы соединиться с сервером
                Socket clientSocket = new Socket("127.0.0.1", 1001);

                // Создается выходной поток, чтобы посылать данные на сервер
                PrintStream out = new PrintStream(clientSocket.getOutputStream());

                // Создается входной поток, чтобы принимать данные с сервера
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Создается входной поток, чтобы читать данные из окна консоли
                BufferedReader stdin = new BufferedReader(new InputStreamReader((System.in)))
        ) {
            /* Чтение из сокета */
            String login = in.readLine();
            System.out.println(login);
            /* Прием login */
            String logName = stdin.readLine();
            out.println(logName);
            /* Чтение из сокета */
            String password = in.readLine();
            System.out.println(password);
            /* Прием password */
            String pass = stdin.readLine();
            out.println(pass);
            String str = in.readLine();
            System.out.println(str);
            while ((str = stdin.readLine()) != null) {
                out.println(str);
                if (str.equals("Bye"))
                    break;
            }
        } catch (UnknownHostException e) {
            System.err.println("Unidentified hostname ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O ");
            System.exit(1);
        }
    }
}
