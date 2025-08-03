package org.example.LoggerUtil;

public interface Logging {

    public void info(String module, String body);

    public void debug(String module, String body);

    public void warn(String module, String body);

    public void error(String module, String body);
}
