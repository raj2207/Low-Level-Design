package org.example.LoggerUtil;

public class LogDispatcher extends Thread{
    LogCosumerRegistry logCosumerRegistry;
    LogBuffer logBuffer;
    boolean shouldRun;

    public LogDispatcher(LogCosumerRegistry logCosumerRegistry, LogBuffer eventLogBuffer){
        this.logCosumerRegistry = logCosumerRegistry;
        this.logBuffer = eventLogBuffer;
    }

    public void stopDispatcher(){
        shouldRun = false;
    }

    @Override
    public void run(){
        try{
            while(shouldRun){
                System.out.println("Dispatching......");
                LogMessage logMessage = ((EventLogBuffer)logBuffer).take();
                LogMessageConsumer handler = logCosumerRegistry.getLogMessageConsumer(logMessage.module);

                if(handler!=null){
                    handler.consume(logMessage);
                }
            }
        } catch (Exception e) {
            System.out.println("Error dispatching log message. Excpetion:"+ e.toString());
        }
    }
}
