package sun.util.logging;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LoggingSupport {
    private static final String DEFAULT_FORMAT = "%1$tb %1$td, %1$tY %1$tl:%1$tM:%1$tS %1$Tp %2$s%n%4$s: %5$s%6$s%n";
    private static final String FORMAT_PROP_KEY = "java.util.logging.SimpleFormatter.format";
    private static final LoggingProxy proxy = (LoggingProxy) AccessController.doPrivileged(new PrivilegedAction<LoggingProxy>() { // from class: sun.util.logging.LoggingSupport.1
        @Override // java.security.PrivilegedAction
        public LoggingProxy run() {
            try {
                Class<?> c4 = Class.forName("java.util.logging.LoggingProxyImpl", true, null);
                Field f10 = c4.getDeclaredField("INSTANCE");
                f10.setAccessible(true);
                return (LoggingProxy) f10.get(null);
            } catch (ClassNotFoundException e2) {
                return null;
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (NoSuchFieldException e11) {
                throw new AssertionError(e11);
            }
        }
    });

    private LoggingSupport() {
    }

    public static boolean isAvailable() {
        return proxy != null;
    }

    private static void ensureAvailable() {
        if (proxy == null) {
            throw new AssertionError((Object) "Should not here");
        }
    }

    public static List<String> getLoggerNames() {
        ensureAvailable();
        return proxy.getLoggerNames();
    }

    public static String getLoggerLevel(String loggerName) {
        ensureAvailable();
        return proxy.getLoggerLevel(loggerName);
    }

    public static void setLoggerLevel(String loggerName, String levelName) {
        ensureAvailable();
        proxy.setLoggerLevel(loggerName, levelName);
    }

    public static String getParentLoggerName(String loggerName) {
        ensureAvailable();
        return proxy.getParentLoggerName(loggerName);
    }

    public static Object getLogger(String name) {
        ensureAvailable();
        return proxy.getLogger(name);
    }

    public static Object getLevel(Object logger) {
        ensureAvailable();
        return proxy.getLevel(logger);
    }

    public static void setLevel(Object logger, Object newLevel) {
        ensureAvailable();
        proxy.setLevel(logger, newLevel);
    }

    public static boolean isLoggable(Object logger, Object level) {
        ensureAvailable();
        return proxy.isLoggable(logger, level);
    }

    public static void log(Object logger, Object level, String msg) {
        ensureAvailable();
        proxy.log(logger, level, msg);
    }

    public static void log(Object logger, Object level, String msg, Throwable t2) {
        ensureAvailable();
        proxy.log(logger, level, msg, t2);
    }

    public static void log(Object logger, Object level, String msg, Object... params) {
        ensureAvailable();
        proxy.log(logger, level, msg, params);
    }

    public static Object parseLevel(String levelName) {
        ensureAvailable();
        return proxy.parseLevel(levelName);
    }

    public static String getLevelName(Object level) {
        ensureAvailable();
        return proxy.getLevelName(level);
    }

    public static int getLevelValue(Object level) {
        ensureAvailable();
        return proxy.getLevelValue(level);
    }

    public static String getSimpleFormat() {
        return getSimpleFormat(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getSimpleFormat(boolean useProxy) {
        LoggingProxy loggingProxy;
        String format = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.util.logging.LoggingSupport.2
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty(LoggingSupport.FORMAT_PROP_KEY);
            }
        });
        if (useProxy && (loggingProxy = proxy) != null && format == null) {
            format = loggingProxy.getProperty(FORMAT_PROP_KEY);
        }
        if (format != null) {
            try {
                String.format(format, new Date(), "", "", "", "", "");
                return format;
            } catch (IllegalArgumentException e2) {
                return DEFAULT_FORMAT;
            }
        }
        return DEFAULT_FORMAT;
    }
}
