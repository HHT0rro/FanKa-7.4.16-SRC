package java.util.logging;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Logging implements LoggingMXBean {
    private static LogManager logManager = LogManager.getLogManager();
    private static String EMPTY_STRING = "";

    @Override // java.util.logging.LoggingMXBean
    public List<String> getLoggerNames() {
        Enumeration<String> loggers = logManager.getLoggerNames();
        ArrayList<String> array = new ArrayList<>();
        while (loggers.hasMoreElements()) {
            array.add(loggers.nextElement());
        }
        return array;
    }

    @Override // java.util.logging.LoggingMXBean
    public String getLoggerLevel(String loggerName) {
        Logger l10 = logManager.getLogger(loggerName);
        if (l10 == null) {
            return null;
        }
        Level level = l10.getLevel();
        if (level == null) {
            return EMPTY_STRING;
        }
        return level.getLevelName();
    }

    @Override // java.util.logging.LoggingMXBean
    public void setLoggerLevel(String loggerName, String levelName) {
        if (loggerName == null) {
            throw new NullPointerException("loggerName is null");
        }
        Logger logger = logManager.getLogger(loggerName);
        if (logger == null) {
            throw new IllegalArgumentException("Logger " + loggerName + "does not exist");
        }
        Level level = null;
        if (levelName != null && (level = Level.findLevel(levelName)) == null) {
            throw new IllegalArgumentException("Unknown level \"" + levelName + "\"");
        }
        logger.setLevel(level);
    }

    @Override // java.util.logging.LoggingMXBean
    public String getParentLoggerName(String loggerName) {
        Logger l10 = logManager.getLogger(loggerName);
        if (l10 == null) {
            return null;
        }
        Logger p10 = l10.getParent();
        if (p10 == null) {
            return EMPTY_STRING;
        }
        return p10.getName();
    }
}
