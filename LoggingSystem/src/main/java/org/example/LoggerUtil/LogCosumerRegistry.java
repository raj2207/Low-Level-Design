package org.example.LoggerUtil;

import java.util.concurrent.ConcurrentHashMap;

public class LogCosumerRegistry {
    // Ideally each module can be subscriber by multiple consumers,
    // In that case, we can maintain a List , Keeping single consumer
    // for a service as of now.
    ConcurrentHashMap<String, LogMessageConsumer> logMessageConsumers;

    public LogCosumerRegistry(){
        logMessageConsumers = new ConcurrentHashMap<>();
    }

    public void subscribe(String module, LogMessageConsumer logMessageConsumer){
        logMessageConsumers.put(module, logMessageConsumer);
    }

    public LogMessageConsumer getLogMessageConsumer(String module){
        return logMessageConsumers.get(module);
    }



}
