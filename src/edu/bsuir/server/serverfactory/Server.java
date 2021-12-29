package edu.bsuir.server.serverfactory;

import edu.bsuir.server.serverthread.ServerSomthing;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);

        try {
            while (true) {

                System.out.println("Сервер ждет запрос на соединение");
                Socket socket = server.accept();

                System.out.println("Новая нить обработки запроса создана");
                try {
                    serverList.add(new ServerSomthing(socket));

                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
            System.out.println("Сервер прекратил работу");
        }
    }
}
