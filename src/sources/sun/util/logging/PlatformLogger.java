package sun.util.logging;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PlatformLogger {
    private static final int ALL = Integer.MIN_VALUE;
    private static final int CONFIG = 700;
    private static final int FINE = 500;
    private static final int FINER = 400;
    private static final int FINEST = 300;
    private static final int INFO = 800;
    private static final int OFF = Integer.MAX_VALUE;
    private static final int SEVERE = 1000;
    private static final int WARNING = 900;
    private volatile JavaLoggerProxy javaLoggerProxy;
    private volatile LoggerProxy loggerProxy;
    private static final Level DEFAULT_LEVEL = Level.INFO;
    private static boolean loggingEnabled = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: sun.util.logging.PlatformLogger.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public Boolean run() {
            String cname = System.getProperty("java.util.logging.config.class");
            String fname = System.getProperty("java.util.logging.config.file");
            return Boolean.valueOf((cname == null && fname == null) ? false : true);
        }
    })).booleanValue();
    private static Map<String, WeakReference<PlatformLogger>> loggers = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum Level {
        ALL,
        FINEST,
        FINER,
        FINE,
        CONFIG,
        INFO,
        WARNING,
        SEVERE,
        OFF;

        private static final int[] LEVEL_VALUES = {Integer.MIN_VALUE, 300, 400, 500, 700, 800, 900, 1000, Integer.MAX_VALUE};
        Object javaLevel;

        public int intValue() {
            return LEVEL_VALUES[ordinal()];
        }

        static Level valueOf(int level) {
            switch (level) {
                case Integer.MIN_VALUE:
                    return ALL;
                case 300:
                    return FINEST;
                case 400:
                    return FINER;
                case 500:
                    return FINE;
                case 700:
                    return CONFIG;
                case 800:
                    return INFO;
                case 900:
                    return WARNING;
                case 1000:
                    return SEVERE;
                case Integer.MAX_VALUE:
                    return OFF;
                default:
                    int i10 = Arrays.binarySearch(LEVEL_VALUES, 0, r0.length - 2, level);
                    return values()[i10 >= 0 ? i10 : (-i10) - 1];
            }
        }
    }

    public static synchronized PlatformLogger getLogger(String name) {
        PlatformLogger log;
        synchronized (PlatformLogger.class) {
            log = null;
            WeakReference<PlatformLogger> ref = loggers.get(name);
            if (ref != null) {
                log = ref.get();
            }
            if (log == null) {
                log = new PlatformLogger(name);
                loggers.put(name, new WeakReference<>(log));
            }
        }
        return log;
    }

    public static synchronized void redirectPlatformLoggers() {
        synchronized (PlatformLogger.class) {
            if (!loggingEnabled && LoggingSupport.isAvailable()) {
                loggingEnabled = true;
                for (Map.Entry<String, WeakReference<PlatformLogger>> entry : loggers.entrySet()) {
                    WeakReference<PlatformLogger> ref = entry.getValue();
                    PlatformLogger plog = ref.get();
                    if (plog != null) {
                        plog.redirectToJavaLoggerProxy();
                    }
                }
            }
        }
    }

    private void redirectToJavaLoggerProxy() {
        DefaultLoggerProxy lp = (DefaultLoggerProxy) DefaultLoggerProxy.class.cast(this.loggerProxy);
        JavaLoggerProxy jlp = new JavaLoggerProxy(lp.name, lp.level);
        this.javaLoggerProxy = jlp;
        this.loggerProxy = jlp;
    }

    private PlatformLogger(String name) {
        if (loggingEnabled) {
            JavaLoggerProxy javaLoggerProxy = new JavaLoggerProxy(name);
            this.javaLoggerProxy = javaLoggerProxy;
            this.loggerProxy = javaLoggerProxy;
            return;
        }
        this.loggerProxy = new DefaultLoggerProxy(name);
    }

    public boolean isEnabled() {
        return this.loggerProxy.isEnabled();
    }

    public String getName() {
        return this.loggerProxy.name;
    }

    public boolean isLoggable(Level level) {
        if (level == null) {
            throw new NullPointerException();
        }
        JavaLoggerProxy jlp = this.javaLoggerProxy;
        return jlp != null ? jlp.isLoggable(level) : this.loggerProxy.isLoggable(level);
    }

    public Level level() {
        return this.loggerProxy.getLevel();
    }

    public void setLevel(Level newLevel) {
        this.loggerProxy.setLevel(newLevel);
    }

    public void severe(String msg) {
        this.loggerProxy.doLog(Level.SEVERE, msg);
    }

    public void severe(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.SEVERE, msg, t2);
    }

    public void severe(String msg, Object... params) {
        this.loggerProxy.doLog(Level.SEVERE, msg, params);
    }

    public void warning(String msg) {
        this.loggerProxy.doLog(Level.WARNING, msg);
    }

    public void warning(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.WARNING, msg, t2);
    }

    public void warning(String msg, Object... params) {
        this.loggerProxy.doLog(Level.WARNING, msg, params);
    }

    public void info(String msg) {
        this.loggerProxy.doLog(Level.INFO, msg);
    }

    public void info(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.INFO, msg, t2);
    }

    public void info(String msg, Object... params) {
        this.loggerProxy.doLog(Level.INFO, msg, params);
    }

    public void config(String msg) {
        this.loggerProxy.doLog(Level.CONFIG, msg);
    }

    public void config(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.CONFIG, msg, t2);
    }

    public void config(String msg, Object... params) {
        this.loggerProxy.doLog(Level.CONFIG, msg, params);
    }

    public void fine(String msg) {
        this.loggerProxy.doLog(Level.FINE, msg);
    }

    public void fine(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.FINE, msg, t2);
    }

    public void fine(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINE, msg, params);
    }

    public void finer(String msg) {
        this.loggerProxy.doLog(Level.FINER, msg);
    }

    public void finer(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.FINER, msg, t2);
    }

    public void finer(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINER, msg, params);
    }

    public void finest(String msg) {
        this.loggerProxy.doLog(Level.FINEST, msg);
    }

    public void finest(String msg, Throwable t2) {
        this.loggerProxy.doLog(Level.FINEST, msg, t2);
    }

    public void finest(String msg, Object... params) {
        this.loggerProxy.doLog(Level.FINEST, msg, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class LoggerProxy {
        final String name;

        abstract void doLog(Level level, String str);

        abstract void doLog(Level level, String str, Throwable th);

        abstract void doLog(Level level, String str, Object... objArr);

        abstract Level getLevel();

        abstract boolean isEnabled();

        abstract boolean isLoggable(Level level);

        abstract void setLevel(Level level);

        protected LoggerProxy(String name) {
            this.name = name;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DefaultLoggerProxy extends LoggerProxy {
        private static final String formatString = LoggingSupport.getSimpleFormat(false);
        private Date date;
        volatile Level effectiveLevel;
        volatile Level level;

        private static PrintStream outputStream() {
            return System.err;
        }

        DefaultLoggerProxy(String name) {
            super(name);
            this.date = new Date();
            this.effectiveLevel = deriveEffectiveLevel(null);
            this.level = null;
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        boolean isEnabled() {
            return this.effectiveLevel != Level.OFF;
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        Level getLevel() {
            return this.level;
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void setLevel(Level newLevel) {
            Level oldLevel = this.level;
            if (oldLevel != newLevel) {
                this.level = newLevel;
                this.effectiveLevel = deriveEffectiveLevel(newLevel);
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg) {
            if (isLoggable(level)) {
                outputStream().print(format(level, msg, null));
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg, Throwable thrown) {
            if (isLoggable(level)) {
                outputStream().print(format(level, msg, thrown));
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg, Object... params) {
            if (isLoggable(level)) {
                String newMsg = formatMessage(msg, params);
                outputStream().print(format(level, newMsg, null));
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        boolean isLoggable(Level level) {
            Level effectiveLevel = this.effectiveLevel;
            return level.intValue() >= effectiveLevel.intValue() && effectiveLevel != Level.OFF;
        }

        private Level deriveEffectiveLevel(Level level) {
            return level == null ? PlatformLogger.DEFAULT_LEVEL : level;
        }

        private String formatMessage(String format, Object... parameters) {
            if (parameters != null) {
                try {
                    if (parameters.length != 0) {
                        if (format.indexOf("{0") < 0 && format.indexOf("{1") < 0 && format.indexOf("{2") < 0 && format.indexOf("{3") < 0) {
                            return format;
                        }
                        return MessageFormat.format(format, parameters);
                    }
                } catch (Exception e2) {
                    return format;
                }
            }
            return format;
        }

        private synchronized String format(Level level, String msg, Throwable thrown) {
            String throwable;
            this.date.setTime(System.currentTimeMillis());
            throwable = "";
            if (thrown != null) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                pw.println();
                thrown.printStackTrace(pw);
                pw.close();
                throwable = sw.toString();
            }
            return String.format(formatString, this.date, getCallerInfo(), this.name, level.name(), msg, throwable);
        }

        private String getCallerInfo() {
            String sourceClassName = null;
            String sourceMethodName = null;
            Throwable throwable = new Throwable();
            boolean lookingForLogger = true;
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            int length = stackTrace.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                StackTraceElement frame = stackTrace[i10];
                String cname = frame.getClassName();
                if (lookingForLogger) {
                    if (cname.equals("sun.util.logging.PlatformLogger")) {
                        lookingForLogger = false;
                    }
                } else if (!cname.equals("sun.util.logging.PlatformLogger")) {
                    sourceClassName = cname;
                    sourceMethodName = frame.getMethodName();
                    break;
                }
                i10++;
            }
            if (sourceClassName != null) {
                return sourceClassName + " " + sourceMethodName;
            }
            return this.name;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class JavaLoggerProxy extends LoggerProxy {
        private final Object javaLogger;

        static {
            for (Level level : Level.values()) {
                level.javaLevel = LoggingSupport.parseLevel(level.name());
            }
        }

        JavaLoggerProxy(String name) {
            this(name, null);
        }

        JavaLoggerProxy(String name, Level level) {
            super(name);
            Object logger = LoggingSupport.getLogger(name);
            this.javaLogger = logger;
            if (level != null) {
                LoggingSupport.setLevel(logger, level.javaLevel);
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg) {
            LoggingSupport.log(this.javaLogger, level.javaLevel, msg);
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg, Throwable t2) {
            LoggingSupport.log(this.javaLogger, level.javaLevel, msg, t2);
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void doLog(Level level, String msg, Object... params) {
            if (!isLoggable(level)) {
                return;
            }
            int len = params != null ? params.length : 0;
            Object[] sparams = new String[len];
            for (int i10 = 0; i10 < len; i10++) {
                sparams[i10] = String.valueOf(params[i10]);
            }
            LoggingSupport.log(this.javaLogger, level.javaLevel, msg, sparams);
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        boolean isEnabled() {
            return LoggingSupport.isLoggable(this.javaLogger, Level.OFF.javaLevel);
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        Level getLevel() {
            Object javaLevel = LoggingSupport.getLevel(this.javaLogger);
            if (javaLevel == null) {
                return null;
            }
            try {
                return Level.valueOf(LoggingSupport.getLevelName(javaLevel));
            } catch (IllegalArgumentException e2) {
                return Level.valueOf(LoggingSupport.getLevelValue(javaLevel));
            }
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        void setLevel(Level level) {
            LoggingSupport.setLevel(this.javaLogger, level == null ? null : level.javaLevel);
        }

        @Override // sun.util.logging.PlatformLogger.LoggerProxy
        boolean isLoggable(Level level) {
            return LoggingSupport.isLoggable(this.javaLogger, level.javaLevel);
        }
    }
}
