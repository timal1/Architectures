package timlad.httpserver.server;

import timlad.httpserver.requesthandler.HandlerRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    public void getConnection(ServerSocket serverSocket) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            HandlerSocket handlerSocket = new HandlerSocket();

            new Thread(() -> handlerSocket.handlerSocket(socket)).start();
        }
    }
}
