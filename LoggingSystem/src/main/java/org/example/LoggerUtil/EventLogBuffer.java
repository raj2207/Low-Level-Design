package org.example.LoggerUtil;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class EventLogBuffer implements LogBuffer {


    BlockingQueue<LogMessage> logBuffer;

    public EventLogBuffer(){
        logBuffer = new LinkedBlockingQueue<>();
    }

    @Override
    public void buffer(LogMessage logMessage){
        try {
            logBuffer.put(logMessage);
        } catch (Exception e){
            System.out.println("Error buffering Log message: "+ logMessage);
        }
    }

    @Override
    public boolean bufferEmpty(){
        return logBuffer.size() == 0;
    }

    public LogMessage take(){
        try {
            return logBuffer.take();
        } catch (Exception e){
            System.out.println("Exception occured while consume message");
        }
        return null;
    }
}
