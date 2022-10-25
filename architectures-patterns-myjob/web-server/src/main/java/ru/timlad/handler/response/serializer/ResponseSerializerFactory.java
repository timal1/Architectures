package ru.timlad.handler.response.serializer;

public class ResponseSerializerFactory {

    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
}
