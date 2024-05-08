package sun.nio.fs;

import com.sun.nio.file.SensitivityWatchEventModifier;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PollingWatchService extends AbstractWatchService {
    private final Map<Object, PollingWatchKey> map = new HashMap();
    private final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: sun.nio.fs.PollingWatchService.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Thread t2 = new Thread(r10);
            t2.setDaemon(true);
            return t2;
        }
    });

    PollingWatchService() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.AbstractWatchService
    public WatchKey register(final Path path, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        final Set<WatchEvent.Kind<?>> eventSet = new HashSet<>(events.length);
        for (WatchEvent.Kind<?> event : events) {
            if (event == StandardWatchEventKinds.ENTRY_CREATE || event == StandardWatchEventKinds.ENTRY_MODIFY || event == StandardWatchEventKinds.ENTRY_DELETE) {
                eventSet.add(event);
            } else if (event != StandardWatchEventKinds.OVERFLOW) {
                if (event == null) {
                    throw new NullPointerException("An element in event set is 'null'");
                }
                throw new UnsupportedOperationException(event.name());
            }
        }
        if (eventSet.isEmpty()) {
            throw new IllegalArgumentException("No events to register");
        }
        SensitivityWatchEventModifier sensivity = SensitivityWatchEventModifier.MEDIUM;
        if (modifiers.length > 0) {
            for (WatchEvent.Modifier modifier : modifiers) {
                if (modifier == null) {
                    throw new NullPointerException();
                }
                if (modifier instanceof SensitivityWatchEventModifier) {
                    sensivity = (SensitivityWatchEventModifier) modifier;
                } else {
                    throw new UnsupportedOperationException("Modifier not supported");
                }
            }
        }
        if (!isOpen()) {
            throw new ClosedWatchServiceException();
        }
        final SensitivityWatchEventModifier s2 = sensivity;
        try {
            return (WatchKey) AccessController.doPrivileged(new PrivilegedExceptionAction<PollingWatchKey>() { // from class: sun.nio.fs.PollingWatchService.2
                @Override // java.security.PrivilegedExceptionAction
                public PollingWatchKey run() throws IOException {
                    return PollingWatchService.this.doPrivilegedRegister(path, eventSet, s2);
                }
            });
        } catch (PrivilegedActionException pae) {
            Throwable cause = pae.getCause();
            if (cause != null && (cause instanceof IOException)) {
                throw ((IOException) cause);
            }
            throw new AssertionError(pae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PollingWatchKey doPrivilegedRegister(Path path, Set<? extends WatchEvent.Kind<?>> events, SensitivityWatchEventModifier sensivity) throws IOException {
        PollingWatchKey watchKey;
        BasicFileAttributes attrs = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, new LinkOption[0]);
        if (!attrs.isDirectory()) {
            throw new NotDirectoryException(path.toString());
        }
        Object fileKey = attrs.fileKey();
        if (fileKey == null) {
            throw new AssertionError((Object) "File keys must be supported");
        }
        synchronized (closeLock()) {
            if (!isOpen()) {
                throw new ClosedWatchServiceException();
            }
            synchronized (this.map) {
                watchKey = this.map.get(fileKey);
                if (watchKey == null) {
                    watchKey = new PollingWatchKey(path, this, fileKey);
                    this.map.put(fileKey, watchKey);
                } else {
                    watchKey.disable();
                }
            }
            watchKey.enable(events, sensivity.sensitivityValueInSeconds());
        }
        return watchKey;
    }

    @Override // sun.nio.fs.AbstractWatchService
    void implClose() throws IOException {
        synchronized (this.map) {
            for (Map.Entry<Object, PollingWatchKey> entry : this.map.entrySet()) {
                PollingWatchKey watchKey = entry.getValue();
                watchKey.disable();
                watchKey.invalidate();
            }
            this.map.clear();
        }
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: sun.nio.fs.PollingWatchService.3
            @Override // java.security.PrivilegedAction
            public Void run() {
                PollingWatchService.this.scheduledExecutor.shutdown();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CacheEntry {
        private long lastModified;
        private int lastTickCount;

        CacheEntry(long lastModified, int lastTickCount) {
            this.lastModified = lastModified;
            this.lastTickCount = lastTickCount;
        }

        int lastTickCount() {
            return this.lastTickCount;
        }

        long lastModified() {
            return this.lastModified;
        }

        void update(long lastModified, int tickCount) {
            this.lastModified = lastModified;
            this.lastTickCount = tickCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class PollingWatchKey extends AbstractWatchKey {
        private Map<Path, CacheEntry> entries;
        private Set<? extends WatchEvent.Kind<?>> events;
        private final Object fileKey;
        private ScheduledFuture<?> poller;
        private int tickCount;
        private volatile boolean valid;

        PollingWatchKey(Path dir, PollingWatchService watcher, Object fileKey) throws IOException {
            super(dir, watcher);
            this.fileKey = fileKey;
            this.valid = true;
            this.tickCount = 0;
            this.entries = new HashMap();
            try {
                DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
                try {
                    for (Path entry : stream) {
                        long lastModified = Files.getLastModifiedTime(entry, LinkOption.NOFOLLOW_LINKS).toMillis();
                        this.entries.put(entry.getFileName(), new CacheEntry(lastModified, this.tickCount));
                    }
                    if (stream != null) {
                        stream.close();
                    }
                } finally {
                }
            } catch (DirectoryIteratorException e2) {
                throw e2.getCause();
            }
        }

        Object fileKey() {
            return this.fileKey;
        }

        @Override // java.nio.file.WatchKey
        public boolean isValid() {
            return this.valid;
        }

        void invalidate() {
            this.valid = false;
        }

        void enable(Set<? extends WatchEvent.Kind<?>> events, long period) {
            synchronized (this) {
                this.events = events;
                Runnable thunk = new Runnable() { // from class: sun.nio.fs.PollingWatchService.PollingWatchKey.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PollingWatchKey.this.poll();
                    }
                };
                this.poller = PollingWatchService.this.scheduledExecutor.scheduleAtFixedRate(thunk, period, period, TimeUnit.SECONDS);
            }
        }

        void disable() {
            synchronized (this) {
                ScheduledFuture<?> scheduledFuture = this.poller;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
        }

        @Override // java.nio.file.WatchKey
        public void cancel() {
            this.valid = false;
            synchronized (PollingWatchService.this.map) {
                PollingWatchService.this.map.remove(fileKey());
            }
            disable();
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[Catch: all -> 0x0104, TryCatch #1 {, blocks: (B:3:0x0001, B:8:0x0007, B:11:0x000e, B:80:0x00aa, B:55:0x00bc, B:56:0x00c6, B:58:0x00cc, B:61:0x00e0, B:64:0x00f3, B:75:0x00af, B:76:0x00b4, B:53:0x00b6, B:87:0x00fc), top: B:2:0x0001, inners: #8 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        synchronized void poll() {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.nio.fs.PollingWatchService.PollingWatchKey.poll():void");
        }
    }
}
