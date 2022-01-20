package com.dubakovNetworkProgramming.TCP.task;

import java.net.Socket;

import java.io.ObjectInputStream;

public class ClientTCP {
    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket("localhost", 1500);
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
        ) {
            // Извлекаем объект из входного потока
            DateMessage dateMessage = (DateMessage) in.readObject();
            // Выводим полученные данные на консоль
            System.out.println("----------");
            System.out.println(dateMessage.getMessage());
            System.out.println(dateMessage.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
