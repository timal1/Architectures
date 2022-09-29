package timlad.httpserver.requesthandler;

import java.io.BufferedReader;
import java.io.IOException;

public class WaitingRequest {
    public void waitingRequest(BufferedReader input) throws IOException {
        while (!input.ready()) ;
    }
}
