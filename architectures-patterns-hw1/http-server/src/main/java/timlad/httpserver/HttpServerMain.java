package timlad.httpserver;


import timlad.httpserver.server.HttpServer;

public class HttpServerMain {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.startServer();
    }
}
