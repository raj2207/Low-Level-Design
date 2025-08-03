package org.example.LoggerUtil;

public class LogMessage {
    Long date;
    LogLevel logLevel;
    String module;
    String body;

    LogMessage(LogLevel logLevel, String module,String body){
        this.date = System.currentTimeMillis();
        this.logLevel = logLevel;
        this.module = module;
        this.body = body;
    }
}
