package sun.net;

import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ProgressSource {
    private boolean connected;
    private String contentType;
    private long expected;
    private long lastProgress;
    private String method;
    private long progress;
    private ProgressMonitor progressMonitor;
    private State state;
    private int threshold;
    private URL url;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum State {
        NEW,
        CONNECTED,
        UPDATE,
        DELETE
    }

    public ProgressSource(URL url, String method) {
        this(url, method, -1L);
    }

    public ProgressSource(URL url, String method, long expected) {
        this.progress = 0L;
        this.lastProgress = 0L;
        this.expected = -1L;
        this.connected = false;
        this.threshold = 8192;
        this.url = url;
        this.method = method;
        this.contentType = "content/unknown";
        this.progress = 0L;
        this.lastProgress = 0L;
        this.expected = expected;
        this.state = State.NEW;
        ProgressMonitor progressMonitor = ProgressMonitor.getDefault();
        this.progressMonitor = progressMonitor;
        this.threshold = progressMonitor.getProgressUpdateThreshold();
    }

    public boolean connected() {
        if (this.connected) {
            return true;
        }
        this.connected = true;
        this.state = State.CONNECTED;
        return false;
    }

    public void close() {
        this.state = State.DELETE;
    }

    public URL getURL() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String ct) {
        this.contentType = ct;
    }

    public long getProgress() {
        return this.progress;
    }

    public long getExpected() {
        return this.expected;
    }

    public State getState() {
        return this.state;
    }

    public void beginTracking() {
        this.progressMonitor.registerSource(this);
    }

    public void finishTracking() {
        this.progressMonitor.unregisterSource(this);
    }

    public void updateProgress(long latestProgress, long expectedProgress) {
        this.lastProgress = this.progress;
        this.progress = latestProgress;
        this.expected = expectedProgress;
        if (!connected()) {
            this.state = State.CONNECTED;
        } else {
            this.state = State.UPDATE;
        }
        long j10 = this.lastProgress;
        int i10 = this.threshold;
        if (j10 / i10 != this.progress / i10) {
            this.progressMonitor.updateProgress(this);
        }
        long j11 = this.expected;
        if (j11 != -1) {
            long j12 = this.progress;
            if (j12 >= j11 && j12 != 0) {
                close();
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return getClass().getName() + "[url=" + ((Object) this.url) + ", method=" + this.method + ", state=" + ((Object) this.state) + ", content-type=" + this.contentType + ", progress=" + this.progress + ", expected=" + this.expected + "]";
    }
}
