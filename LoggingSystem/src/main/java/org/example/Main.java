package org.example;
import org.example.*;
import org.example.LoggerUtil.*;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        LogMessageConsumer consoleLogWorker = new ConsoleLogWorker();
        logger.setModuleHandler("API", consoleLogWorker);
        for(int i=0;i<30;i++){
            System.out.println("Main thread : Count:" + i);
            logger.info("API", "Log Sequence "+ i);
            logger.debug("API", "Debug Log Sequence" + i);
            if(i==10) {
                logger.setLogLevel(LogLevel.DEBUG);
            }
        }
        try{
            System.out.println("Waiting for logs to be processed");
            sleep(1000);
        }catch (Exception e){
            System.out.println("Exception occured while in sleep mode: " +  e.toString());
        }
        //logger.joinThread();

    }
}