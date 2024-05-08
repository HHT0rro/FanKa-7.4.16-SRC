package java.util.logging;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MemoryHandler extends Handler {
    private static final int DEFAULT_SIZE = 1000;
    private LogRecord[] buffer;
    int count;
    private volatile Level pushLevel;
    private int size;
    int start;
    private Handler target;

    private void configure() {
        LogManager manager = LogManager.getLogManager();
        String cname = getClass().getName();
        this.pushLevel = manager.getLevelProperty(cname + ".push", Level.SEVERE);
        int intProperty = manager.getIntProperty(cname + ".size", 1000);
        this.size = intProperty;
        if (intProperty <= 0) {
            this.size = 1000;
        }
        setLevel(manager.getLevelProperty(cname + ".level", Level.ALL));
        setFilter(manager.getFilterProperty(cname + ".filter", null));
        setFormatter(manager.getFormatterProperty(cname + ".formatter", new SimpleFormatter()));
    }

    public MemoryHandler() {
        this.sealed = false;
        configure();
        this.sealed = true;
        LogManager manager = LogManager.getLogManager();
        String handlerName = getClass().getName();
        String targetName = manager.getProperty(handlerName + ".target");
        if (targetName == null) {
            throw new RuntimeException("The handler " + handlerName + " does not specify a target");
        }
        try {
            Class<?> clz = ClassLoader.getSystemClassLoader().loadClass(targetName);
            this.target = (Handler) clz.newInstance();
        } catch (Exception e2) {
            try {
                Class<?> clz2 = Thread.currentThread().getContextClassLoader().loadClass(targetName);
                this.target = (Handler) clz2.newInstance();
            } catch (Exception innerE) {
                throw new RuntimeException("MemoryHandler can't load handler target \"" + targetName + "\"", innerE);
            }
        }
        init();
    }

    private void init() {
        this.buffer = new LogRecord[this.size];
        this.start = 0;
        this.count = 0;
    }

    public MemoryHandler(Handler target, int size, Level pushLevel) {
        if (target == null || pushLevel == null) {
            throw new NullPointerException();
        }
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.sealed = false;
        configure();
        this.sealed = true;
        this.target = target;
        this.pushLevel = pushLevel;
        this.size = size;
        init();
    }

    @Override // java.util.logging.Handler
    public synchronized void publish(LogRecord record) {
        if (isLoggable(record)) {
            int i10 = this.start;
            int i11 = this.count;
            LogRecord[] logRecordArr = this.buffer;
            int ix = (i10 + i11) % logRecordArr.length;
            logRecordArr[ix] = record;
            if (i11 < logRecordArr.length) {
                this.count = i11 + 1;
            } else {
                int i12 = i10 + 1;
                this.start = i12;
                this.start = i12 % logRecordArr.length;
            }
            if (record.getLevel().intValue() >= this.pushLevel.intValue()) {
                push();
            }
        }
    }

    public synchronized void push() {
        for (int i10 = 0; i10 < this.count; i10++) {
            int i11 = this.start + i10;
            LogRecord[] logRecordArr = this.buffer;
            int ix = i11 % logRecordArr.length;
            LogRecord record = logRecordArr[ix];
            this.target.publish(record);
        }
        this.start = 0;
        this.count = 0;
    }

    @Override // java.util.logging.Handler
    public void flush() {
        this.target.flush();
    }

    @Override // java.util.logging.Handler
    public void close() throws SecurityException {
        this.target.close();
        setLevel(Level.OFF);
    }

    public synchronized void setPushLevel(Level newLevel) throws SecurityException {
        if (newLevel == null) {
            throw new NullPointerException();
        }
        checkPermission();
        this.pushLevel = newLevel;
    }

    public Level getPushLevel() {
        return this.pushLevel;
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord record) {
        return super.isLoggable(record);
    }
}
