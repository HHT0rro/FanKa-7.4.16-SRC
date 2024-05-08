package java.util.logging;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Handler {
    private static final int offValue = Level.OFF.intValue();
    private volatile String encoding;
    private volatile Filter filter;
    private volatile Formatter formatter;
    private final LogManager manager = LogManager.getLogManager();
    private volatile Level logLevel = Level.ALL;
    private volatile ErrorManager errorManager = new ErrorManager();
    boolean sealed = true;

    public abstract void close() throws SecurityException;

    public abstract void flush();

    public abstract void publish(LogRecord logRecord);

    public synchronized void setFormatter(Formatter newFormatter) throws SecurityException {
        checkPermission();
        newFormatter.getClass();
        this.formatter = newFormatter;
    }

    public Formatter getFormatter() {
        return this.formatter;
    }

    public synchronized void setEncoding(String encoding) throws SecurityException, UnsupportedEncodingException {
        checkPermission();
        if (encoding != null) {
            try {
                if (!Charset.isSupported(encoding)) {
                    throw new UnsupportedEncodingException(encoding);
                }
            } catch (IllegalCharsetNameException e2) {
                throw new UnsupportedEncodingException(encoding);
            }
        }
        this.encoding = encoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public synchronized void setFilter(Filter newFilter) throws SecurityException {
        checkPermission();
        this.filter = newFilter;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public synchronized void setErrorManager(ErrorManager em) {
        checkPermission();
        if (em == null) {
            throw new NullPointerException();
        }
        this.errorManager = em;
    }

    public ErrorManager getErrorManager() {
        checkPermission();
        return this.errorManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportError(String msg, Exception ex, int code) {
        try {
            this.errorManager.error(msg, ex, code);
        } catch (Exception ex2) {
            System.err.println("Handler.reportError caught:");
            ex2.printStackTrace();
        }
    }

    public synchronized void setLevel(Level newLevel) throws SecurityException {
        if (newLevel == null) {
            throw new NullPointerException();
        }
        checkPermission();
        this.logLevel = newLevel;
    }

    public Level getLevel() {
        return this.logLevel;
    }

    public boolean isLoggable(LogRecord record) {
        int levelValue = getLevel().intValue();
        if (record.getLevel().intValue() < levelValue || levelValue == offValue) {
            return false;
        }
        Filter filter = getFilter();
        if (filter == null) {
            return true;
        }
        return filter.isLoggable(record);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkPermission() throws SecurityException {
        if (this.sealed) {
            this.manager.checkPermission();
        }
    }
}
