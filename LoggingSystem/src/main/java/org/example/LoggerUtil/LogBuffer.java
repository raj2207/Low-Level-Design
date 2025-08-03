package org.example.LoggerUtil;

public interface LogBuffer {
    void buffer(LogMessage message);
    boolean bufferEmpty();
}
