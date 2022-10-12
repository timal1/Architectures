package ru.timlad.service.socket;

import java.net.Socket;

public class SocketServiceFactory {

    public static SocketService createSocketService(Socket socket) {
        return new SocketServiceIml(socket);
    }
}
