package ru.timlad;

import ru.timlad.config.Config;
import ru.timlad.config.ConfigFactory;
import ru.timlad.httpserver.HttpServer;

public class WebServer {

    public static void main(String[] args) {

        Config config = ConfigFactory.create(args);
        HttpServer.createHttpServer().startServer(config);
    }
}
