package timlad.httpserver.requesthandler;

import java.io.BufferedReader;
import java.io.IOException;

public class HandlerRequest {

    public String handlerRequest(BufferedReader input) throws IOException {
        WaitingRequest waitingRequest = new WaitingRequest();
        waitingRequest.waitingRequest(input);
        ParsingRequest parsingRequest = new ParsingRequest();
        return parsingRequest.parsingRequest(input);
    }
}
