package ru.timlad.handler.method;

import org.reflections.Reflections;
import ru.timlad.config.Config;
import ru.timlad.handler.Handler;
import ru.timlad.handler.response.creator.ResponseCreator;
import ru.timlad.handler.response.serializer.ResponseSerializer;
import ru.timlad.service.socket.SocketService;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;


public class MethodHandlerFactory {

    private static  List<MethodHandler> methodHandlers;

    public static List<MethodHandler> getMethodHandlers() {
        return methodHandlers;
    }

    public static MethodHandler create(SocketService socketService, ResponseCreator responseCreator, ResponseSerializer responseSerializer, Config config) {


        Reflections reflections = new Reflections("ru.timlad.handler.method");

        Set<Class<?>> handles = reflections.getTypesAnnotatedWith(Handler.class);

        handles.stream().sorted(Comparator.comparingInt(c -> c.getAnnotation(Handler.class).order()));


                methodHandlers =  handles.stream().map(h -> {
                    MethodHandler methodHandler;
                    try {
                        methodHandler = (MethodHandler) h.getDeclaredConstructor(SocketService.class, ResponseCreator.class, ResponseSerializer.class, Config.class).newInstance(socketService, responseCreator, responseSerializer, config);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    return methodHandler;

                }).collect(Collectors.toList());
                return methodHandlers.get(0);
    }

}
