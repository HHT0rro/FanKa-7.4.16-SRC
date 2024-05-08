package java.util.logging;

import dalvik.system.VMStack;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LogRecord implements Serializable {
    private static final int MIN_SEQUENTIAL_THREAD_ID = 1073741823;
    private static final long serialVersionUID = 5372048053134512534L;
    private Level level;
    private String loggerName;
    private String message;
    private long millis;
    private transient boolean needToInferCaller;
    private transient Object[] parameters;
    private transient ResourceBundle resourceBundle;
    private String resourceBundleName;
    private long sequenceNumber;
    private String sourceClassName;
    private String sourceMethodName;
    private int threadID;
    private Throwable thrown;
    private static final AtomicLong globalSequenceNumber = new AtomicLong(0);
    private static final AtomicInteger nextThreadId = new AtomicInteger(1073741823);
    private static final ThreadLocal<Integer> threadIds = new ThreadLocal<>();

    private int defaultThreadID() {
        long tid = Thread.currentThread().getId();
        if (tid < 1073741823) {
            return (int) tid;
        }
        ThreadLocal<Integer> threadLocal = threadIds;
        Integer id2 = threadLocal.get();
        if (id2 == null) {
            id2 = Integer.valueOf(nextThreadId.getAndIncrement());
            threadLocal.set(id2);
        }
        return id2.intValue();
    }

    public LogRecord(Level level, String msg) {
        level.getClass();
        this.level = level;
        this.message = msg;
        this.sequenceNumber = globalSequenceNumber.getAndIncrement();
        this.threadID = defaultThreadID();
        this.millis = System.currentTimeMillis();
        this.needToInferCaller = true;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public void setLoggerName(String name) {
        this.loggerName = name;
    }

    public ResourceBundle getResourceBundle() {
        return this.resourceBundle;
    }

    public void setResourceBundle(ResourceBundle bundle) {
        this.resourceBundle = bundle;
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public void setResourceBundleName(String name) {
        this.resourceBundleName = name;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException();
        }
        this.level = level;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public void setSequenceNumber(long seq) {
        this.sequenceNumber = seq;
    }

    public String getSourceClassName() {
        if (this.needToInferCaller) {
            inferCaller();
        }
        return this.sourceClassName;
    }

    public void setSourceClassName(String sourceClassName) {
        this.sourceClassName = sourceClassName;
        this.needToInferCaller = false;
    }

    public String getSourceMethodName() {
        if (this.needToInferCaller) {
            inferCaller();
        }
        return this.sourceMethodName;
    }

    public void setSourceMethodName(String sourceMethodName) {
        this.sourceMethodName = sourceMethodName;
        this.needToInferCaller = false;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParameters() {
        return this.parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public int getThreadID() {
        return this.threadID;
    }

    public void setThreadID(int threadID) {
        this.threadID = threadID;
    }

    public long getMillis() {
        return this.millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public Throwable getThrown() {
        return this.thrown;
    }

    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeByte(1);
        out.writeByte(0);
        Object[] objArr = this.parameters;
        if (objArr == null) {
            out.writeInt(-1);
            return;
        }
        out.writeInt(objArr.length);
        int i10 = 0;
        while (true) {
            Object[] objArr2 = this.parameters;
            if (i10 < objArr2.length) {
                Object obj = objArr2[i10];
                if (obj == null) {
                    out.writeObject(null);
                } else {
                    out.writeObject(obj.toString());
                }
                i10++;
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        byte major = in.readByte();
        byte minor = in.readByte();
        if (major != 1) {
            throw new IOException("LogRecord: bad version: " + ((int) major) + "." + ((int) minor));
        }
        int len = in.readInt();
        if (len >= -1) {
            if (len == -1) {
                this.parameters = null;
            } else if (len < 255) {
                this.parameters = new Object[len];
                int i10 = 0;
                while (true) {
                    Object[] objArr = this.parameters;
                    if (i10 >= objArr.length) {
                        break;
                    }
                    objArr[i10] = in.readObject();
                    i10++;
                }
            } else {
                List<Object> params = new ArrayList<>(Math.min(len, 1024));
                for (int i11 = 0; i11 < len; i11++) {
                    params.add(in.readObject());
                }
                int i12 = params.size();
                this.parameters = params.toArray(new Object[i12]);
            }
            String str = this.resourceBundleName;
            if (str != null) {
                try {
                    ResourceBundle bundle = ResourceBundle.getBundle(str, Locale.getDefault(), ClassLoader.getSystemClassLoader());
                    this.resourceBundle = bundle;
                } catch (MissingResourceException e2) {
                    try {
                        this.resourceBundle = ResourceBundle.getBundle(this.resourceBundleName, Locale.getDefault(), Thread.currentThread().getContextClassLoader());
                    } catch (MissingResourceException e10) {
                        this.resourceBundle = null;
                    }
                }
            }
            this.needToInferCaller = false;
            return;
        }
        throw new NegativeArraySizeException();
    }

    private void inferCaller() {
        this.needToInferCaller = false;
        StackTraceElement[] stack = VMStack.getThreadStackTrace(Thread.currentThread());
        boolean lookingForLogger = true;
        for (StackTraceElement frame : stack) {
            String cname = frame.getClassName();
            boolean isLoggerImpl = isLoggerImplFrame(cname);
            if (lookingForLogger) {
                if (isLoggerImpl) {
                    lookingForLogger = false;
                }
            } else if (!isLoggerImpl && !cname.startsWith("java.lang.reflect.") && !cname.startsWith("sun.reflect.")) {
                setSourceClassName(cname);
                setSourceMethodName(frame.getMethodName());
                return;
            }
        }
    }

    private boolean isLoggerImplFrame(String cname) {
        return cname.equals("java.util.logging.Logger") || cname.startsWith("java.util.logging.LoggingProxyImpl") || cname.startsWith("sun.util.logging.");
    }
}
