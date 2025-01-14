package java.util.logging;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StreamHandler extends Handler {
    private boolean doneHeader;
    private OutputStream output;
    private volatile Writer writer;

    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();
        setLevel(manager.getLevelProperty(cname + ".level", Level.INFO));
        setFilter(manager.getFilterProperty(cname + ".filter", null));
        setFormatter(manager.getFormatterProperty(cname + ".formatter", new SimpleFormatter()));
        try {
            setEncoding(manager.getStringProperty(cname + ".encoding", null));
        } catch (Exception e2) {
            try {
                setEncoding(null);
            } catch (Exception e10) {
            }
        }
    }

    public StreamHandler() {
        this.sealed = false;
        configure();
        this.sealed = true;
    }

    public StreamHandler(OutputStream out, Formatter formatter) {
        this.sealed = false;
        configure();
        setFormatter(formatter);
        setOutputStream(out);
        this.sealed = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void setOutputStream(OutputStream out) throws SecurityException {
        try {
            if (out == null) {
                throw new NullPointerException();
            }
            flushAndClose();
            this.output = out;
            this.doneHeader = false;
            String encoding = getEncoding();
            if (encoding == null) {
                this.writer = new OutputStreamWriter(this.output);
            } else {
                try {
                    this.writer = new OutputStreamWriter(this.output, encoding);
                } catch (UnsupportedEncodingException ex) {
                    throw new Error("Unexpected exception " + ((Object) ex));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized void setEncoding(String encoding) throws SecurityException, UnsupportedEncodingException {
        super.setEncoding(encoding);
        if (this.output == null) {
            return;
        }
        flush();
        if (encoding == null) {
            this.writer = new OutputStreamWriter(this.output);
        } else {
            this.writer = new OutputStreamWriter(this.output, encoding);
        }
    }

    @Override // java.util.logging.Handler
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            try {
                String msg = getFormatter().format(record);
                try {
                    if (!this.doneHeader) {
                        this.writer.write(getFormatter().getHead(this));
                        this.doneHeader = true;
                    }
                    this.writer.write(msg);
                } catch (Exception ex) {
                    reportError(null, ex, 1);
                }
            } catch (Exception ex2) {
                reportError(null, ex2, 5);
            }
        }
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord record) {
        if (this.writer == null || record == null) {
            return false;
        }
        return super.isLoggable(record);
    }

    @Override // java.util.logging.Handler
    public synchronized void flush() {
        if (this.writer != null) {
            try {
                this.writer.flush();
            } catch (Exception ex) {
                reportError(null, ex, 2);
            }
        }
    }

    private synchronized void flushAndClose() throws SecurityException {
        checkPermission();
        if (this.writer != null) {
            try {
                if (!this.doneHeader) {
                    this.writer.write(getFormatter().getHead(this));
                    this.doneHeader = true;
                }
                this.writer.write(getFormatter().getTail(this));
                this.writer.flush();
                this.writer.close();
            } catch (Exception ex) {
                reportError(null, ex, 3);
            }
            this.writer = null;
            this.output = null;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized void close() throws SecurityException {
        flushAndClose();
    }
}
