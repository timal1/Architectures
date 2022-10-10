package ru.timlad.logger;

public class ConsoleLogger implements Logger {

    private ConsoleLogger() {
    }

    public static ConsoleLogger createConsoleLogger() {
        return new ConsoleLogger();
    }
    @Override
    public void info(String msg) {
        System.out.println(msg);
    }
}
