package sun.nio.fs;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class AbstractWatchService implements WatchService {
    private volatile boolean closed;
    private final LinkedBlockingDeque<WatchKey> pendingKeys = new LinkedBlockingDeque<>();
    private final WatchKey CLOSE_KEY = new AbstractWatchKey(null, 0 == true ? 1 : 0) { // from class: sun.nio.fs.AbstractWatchService.1
        @Override // java.nio.file.WatchKey
        public boolean isValid() {
            return true;
        }

        @Override // java.nio.file.WatchKey
        public void cancel() {
        }
    };
    private final Object closeLock = new Object();

    abstract void implClose() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract WatchKey register(Path path, WatchEvent.Kind<?>[] kindArr, WatchEvent.Modifier... modifierArr) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void enqueueKey(WatchKey key) {
        this.pendingKeys.offer(key);
    }

    private void checkOpen() {
        if (this.closed) {
            throw new ClosedWatchServiceException();
        }
    }

    private void checkKey(WatchKey key) {
        if (key == this.CLOSE_KEY) {
            enqueueKey(key);
        }
        checkOpen();
    }

    @Override // java.nio.file.WatchService
    public final WatchKey poll() {
        checkOpen();
        WatchKey key = this.pendingKeys.poll();
        checkKey(key);
        return key;
    }

    @Override // java.nio.file.WatchService
    public final WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException {
        checkOpen();
        WatchKey key = this.pendingKeys.poll(timeout, unit);
        checkKey(key);
        return key;
    }

    @Override // java.nio.file.WatchService
    public final WatchKey take() throws InterruptedException {
        checkOpen();
        WatchKey key = this.pendingKeys.take();
        checkKey(key);
        return key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isOpen() {
        return !this.closed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object closeLock() {
        return this.closeLock;
    }

    @Override // java.nio.file.WatchService, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.closeLock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            implClose();
            this.pendingKeys.clear();
            this.pendingKeys.offer(this.CLOSE_KEY);
        }
    }
}
