package org.example.LoggerUtil;

public class Logger implements Logging {
    private static LogLevel logLevelDefault = LogLevel.INFO;

    private LogLevel logLevel;

    private LogBuffer logBuffer;
    private LogCosumerRegistry logCosumerRegistry;

    private Thread dispatcher;

    public Logger(){
        logLevel = logLevelDefault;
        logBuffer = new EventLogBuffer();
        logCosumerRegistry = new LogCosumerRegistry();

        dispatcher = new LogDispatcher(logCosumerRegistry, logBuffer);
        dispatcher.start();
    }


    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public void setModuleHandler(String module, LogMessageConsumer logMessageConsumer){
        this.logCosumerRegistry.subscribe(module, logMessageConsumer);
    }

    public void info(String module, String body){
        LogMessage message = new LogMessage(LogLevel.INFO, module, body);
        try{
            logBuffer.buffer(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void debug(String module, String body){
        // loglevel should be persisted in a config file for dynamic change
        if(logLevel != LogLevel.DEBUG){
            // do nothing
            return;
        }
        LogMessage message = new LogMessage(LogLevel.DEBUG, module, body);
        try{
            logBuffer.buffer(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void warn(String module, String body){
        LogMessage message = new LogMessage(LogLevel.WARN, module, body);
        try{
            logBuffer.buffer(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void error(String module, String body){
        LogMessage message = new LogMessage(LogLevel.ERROR, module, body);
        try{
            logBuffer.buffer(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void joinThread(){
        while(!logBuffer.bufferEmpty()){
            System.out.println("Waiting for LogBuffer to be empty");
        }
        ((LogDispatcher) dispatcher).stopDispatcher();
    }
}
