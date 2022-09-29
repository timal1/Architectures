package timlad.httpserver.responsehandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateResponse {

    private String WWW = "C:/GeekBrains/My_jobs/webinar_Architectures_and_patterns_Java/architectures-patterns-hw1/www";

    public void createResponse(String partPath, PrintWriter output) throws IOException {
        Path path = Paths.get(WWW, partPath);

        if (!Files.exists(path)) {
            BadResponse badResponse = new BadResponse();
            badResponse.badResponse(output);
            return;
        }
        OkResponse okResponse = new OkResponse();
        okResponse.okResponse(path, output);
    }
}
