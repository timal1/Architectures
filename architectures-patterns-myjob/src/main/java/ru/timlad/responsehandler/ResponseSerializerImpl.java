package ru.timlad.responsehandler;

import ru.timlad.domain.HttpResponse;


public class ResponseSerializerImpl implements ResponseSerializer{

    public static ResponseSerializerImpl createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
    @Override
    public String serialize(HttpResponse httpResponse) {

        return httpResponse.getHttpVersion() + " " + httpResponse.getStatusCode() + " " + httpResponse.getHttpStatus() + "\n" +
                 httpResponse.getContentType() + " " + httpResponse.getCharset() + "\n\n";
    }
}
