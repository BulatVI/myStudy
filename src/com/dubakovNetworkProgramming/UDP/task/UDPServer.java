package com.dubakovNetworkProgramming.UDP.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/*
Постановка задачи
Необходимо разработать клиент/серверное приложение, в котором сервер может распространять сообщения всем клиентам,
зарегистрированным в группе 233.0.0.1, порт 1502. Пользователь сервера должен иметь возможность ввода и отправки
текстовых сообщений, а пользователь-клиент просматривает полученные сообщения.
*/
public class UDPServer {

    private void call() {
        System.out.println("Отправка сообщений всем:");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             DatagramSocket socket = new DatagramSocket()
        ) {
            InetAddress inetAddress = InetAddress.getByName("233.0.0.1");
            DatagramPacket packet;
            while (true) {
                String s = br.readLine();
                packet = new DatagramPacket(s.getBytes(StandardCharsets.UTF_8), s.length(), inetAddress, 1502);
                socket.send(packet);
                System.out.println("Отправлено сообщение: "+ s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SocketException {
        new UDPServer().call();
    }
}
