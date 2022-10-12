package ru.timlad.responsehandler.serializer;

public class ResponseSerializerFactory {

    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
}
