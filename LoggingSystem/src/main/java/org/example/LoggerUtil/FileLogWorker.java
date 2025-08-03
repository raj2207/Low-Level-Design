package org.example.LoggerUtil;

public class FileLogWorker implements LogMessageConsumer {

    private static final String LOG_FILE_DEFAULT = "/log/servce.txt";

    private String logFile;

    FileLogWorker(){
        logFile = LOG_FILE_DEFAULT;
    }

    FileLogWorker(String fileName){
        logFile = fileName;
    }

    @Override
    public void consume(LogMessage logMessage){
        // append to a file

    }
}
