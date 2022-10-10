package ru.timlad.httpserver;

import ru.timlad.config.Config;
import ru.timlad.logger.ConsoleLogger;
import ru.timlad.logger.Logger;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpServer {

    private static final Logger logger = ConsoleLogger.createConsoleLogger();

    private HttpServer(){
    }

    public static HttpServer createHttpServer() {
        return new HttpServer();
    }
    public void startServer(Config config) {
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            logger.info(String.format("Server started at port %d!%n", config.getPort()));

            Connection.createConnection().getConnection(serverSocket, config);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
