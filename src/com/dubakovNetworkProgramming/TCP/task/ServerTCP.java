package com.dubakovNetworkProgramming.TCP.task;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/*
Постановка задачи
Необходимо разработать клиент/серверное приложение, в котором сервер слушает запросы клиентов на порт 1500 и отправляет
объект-сообщение, содержащий текущую дату/время сервера и строку сообщения. Пользователь-клиент должен иметь
возможность просмотра полученного сообщения.
*/
public class ServerTCP extends Thread {
    ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        new ServerTCP().start();
    }

    public ServerTCP() throws IOException {
        serverSocket = new ServerSocket(1500);
        System.out.println("Starting the server ");
    }

    @Override
    public void run() {
        while (true) {
            try (
                    Socket clientSocket = serverSocket.accept();
                    // Получение выходного потока, связанного с объектом Socket
                    ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())
            ) {
                System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostAddress());
                // Создание объекта для передачи клиентам
                DateMessage dateMessage = new DateMessage(Calendar.getInstance().getTime(),
                        "Текущая дата/время на сервере");
                // Запись объекта в выходной поток
                out.writeObject(dateMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
