package ru.timlad.httpserver;

import ru.timlad.config.Config;
import ru.timlad.config.ConfigFactory;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;
import ru.timlad.requesthandler.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    private Connection(){
    }

    public static Connection createConnection() {
        return new Connection();
    }

    private static final Logger logger = ConsoleLogger.createConsoleLogger();
    public void getConnection(ServerSocket serverSocket, Config config) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("New client connected!");

            new Thread(RequestHandler.createRequestHandler(SocketService.createSocketService(socket), config)).start();
        }
    }
}
