package org.example.LoggerUtil;

public class ConsoleLogWorker implements LogMessageConsumer {

    @Override
    public void consume(LogMessage message){
        System.out.println(message.date + " " + message.logLevel + " " + message.module + " " + message.body);
    }
}
