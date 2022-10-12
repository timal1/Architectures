package ru.timlad.httpserver;

import ru.timlad.config.Config;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;
import ru.timlad.requesthandler.RequestHandler;
import ru.timlad.requesthandler.RequestParserFactory;
import ru.timlad.service.socket.SocketServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Connection {

    private static final Logger logger = ConsoleLogger.createConsoleLogger();
    public void getConnection(ServerSocket serverSocket, Config config) throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("New client connected!");

            new Thread(RequestHandler.createRequestHandler(
                    SocketServiceFactory.createSocketService(socket),
                    RequestParserFactory.createRequestParser(),
                    config)).start();
        }
    }
}
