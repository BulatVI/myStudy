package com.dubakovNetworkProgramming.UDP.task;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPClient {
    private static InetAddress address;
    private static MulticastSocket socket;

    public static void main(String[] args) throws IOException {
        System.out.println("Ожидание сообщения от сервера");
        try {
            // Создание объекта MulticastSocket для получения
            // данных от группы, используя номер порта 1502
            socket = new MulticastSocket(1502);
            address = InetAddress.getByName("233.0.0.1");
            // Регистрация клиента в группе
            socket.joinGroup(address);
            while (true) {
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // Получение данных от сервера
                socket.receive(packet);
                String str = new String(packet.getData());
                System.out.println("Получено сообщение: " + str.trim());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Удаление клиента из группы
                socket.leaveGroup(address);
                // Закрытие сокета
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

