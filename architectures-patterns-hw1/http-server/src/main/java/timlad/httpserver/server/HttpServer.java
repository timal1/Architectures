package timlad.httpserver.server;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpServer {
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Server started!");

            Connection connection = new Connection();
            connection.getConnection(serverSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
