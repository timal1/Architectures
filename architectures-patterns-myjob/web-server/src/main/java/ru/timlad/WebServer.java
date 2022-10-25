package ru.timlad;

import ru.timlad.config.ConfigFactory;
import ru.timlad.httpserver.ConnectionFactory;
import ru.timlad.httpserver.HttpServer;

public class WebServer {

    public static void main(String[] args) {

        HttpServer.createHttpServer().startServer(
                ConfigFactory.create(args),
                ConnectionFactory.createConnection());
    }
}
