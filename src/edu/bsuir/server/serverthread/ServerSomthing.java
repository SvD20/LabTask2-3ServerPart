package edu.bsuir.server.serverthread;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class ServerSomthing extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {

        try {

            while (!socket.isClosed()) {
                String resultword = sort(in.readLine());
                send(resultword);
                System.out.println("Новая нить закончила свою работу,сокет общения закрыт, присоединитесь снова");
                socket.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }

    private String sort (String data){
        char[] charArray = data.toCharArray();
        Arrays.sort(charArray);
        String sortedString = new String(charArray);
        return sortedString;
    }

}

