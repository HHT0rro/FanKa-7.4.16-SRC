package sun.nio.fs;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.internal.logging.nano.MetricsProto;
import com.sun.nio.file.SensitivityWatchEventModifier;
import dalvik.annotation.optimization.ReachabilitySensitive;
import dalvik.system.CloseGuard;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinuxWatchService extends AbstractWatchService {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private final Poller poller;

    /* renamed from: -$$Nest$smeventOffsets, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m3823$$Nest$smeventOffsets() {
        return eventOffsets();
    }

    /* renamed from: -$$Nest$smeventSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3824$$Nest$smeventSize() {
        return eventSize();
    }

    private static native void configureBlocking(int i10, boolean z10) throws UnixException;

    private static native int[] eventOffsets();

    private static native int eventSize();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int inotifyAddWatch(int i10, long j10, int i11) throws UnixException;

    private static native int inotifyInit() throws UnixException;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void inotifyRmWatch(int i10, int i11) throws UnixException;

    /* JADX INFO: Access modifiers changed from: private */
    public static native int poll(int i10, int i11) throws UnixException;

    private static native void socketpair(int[] iArr) throws UnixException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinuxWatchService(UnixFileSystem fs) throws IOException {
        String msg;
        try {
            int ifd = inotifyInit();
            int[] sp = new int[2];
            try {
                configureBlocking(ifd, false);
                socketpair(sp);
                configureBlocking(sp[0], false);
                Poller poller = new Poller(fs, this, ifd, sp);
                this.poller = poller;
                poller.start();
            } catch (UnixException x10) {
                UnixNativeDispatcher.close(ifd);
                throw new IOException(x10.errorString());
            }
        } catch (UnixException x11) {
            if (x11.errno() == UnixConstants.EMFILE) {
                msg = "User limit of inotify instances reached or too many open files";
            } else {
                msg = x11.errorString();
            }
            throw new IOException(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // sun.nio.fs.AbstractWatchService
    public WatchKey register(Path dir, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        return this.poller.register(dir, events, modifiers);
    }

    @Override // sun.nio.fs.AbstractWatchService
    void implClose() throws IOException {
        this.poller.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LinuxWatchKey extends AbstractWatchKey {
        private final int ifd;

        /* renamed from: wd, reason: collision with root package name */
        private volatile int f53739wd;

        LinuxWatchKey(UnixPath dir, LinuxWatchService watcher, int ifd, int wd2) {
            super(dir, watcher);
            this.ifd = ifd;
            this.f53739wd = wd2;
        }

        int descriptor() {
            return this.f53739wd;
        }

        void invalidate(boolean remove) {
            if (remove) {
                try {
                    LinuxWatchService.inotifyRmWatch(this.ifd, this.f53739wd);
                } catch (UnixException e2) {
                }
            }
            this.f53739wd = -1;
        }

        @Override // java.nio.file.WatchKey
        public boolean isValid() {
            return this.f53739wd != -1;
        }

        @Override // java.nio.file.WatchKey
        public void cancel() {
            if (isValid()) {
                ((LinuxWatchService) watcher()).poller.cancel(this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class Poller extends AbstractPoller {
        private static final int BUFFER_SIZE = 8192;
        private static final int IN_ATTRIB = 4;
        private static final int IN_CREATE = 256;
        private static final int IN_DELETE = 512;
        private static final int IN_IGNORED = 32768;
        private static final int IN_MODIFY = 2;
        private static final int IN_MOVED_FROM = 64;
        private static final int IN_MOVED_TO = 128;
        private static final int IN_Q_OVERFLOW = 16384;
        private static final int IN_UNMOUNT = 8192;
        private static final int OFFSETOF_LEN;
        private static final int OFFSETOF_MASK;
        private static final int OFFSETOF_NAME;
        private static final int OFFSETOF_WD;
        private static final int SIZEOF_INOTIFY_EVENT = LinuxWatchService.m3824$$Nest$smeventSize();
        private static final int[] offsets;
        private final long address;
        private final UnixFileSystem fs;

        @ReachabilitySensitive
        private final CloseGuard guard;
        private final int ifd;
        private final int[] socketpair;
        private final LinuxWatchService watcher;
        private final Map<Integer, LinuxWatchKey> wdToKey;

        static {
            int[] m3823$$Nest$smeventOffsets = LinuxWatchService.m3823$$Nest$smeventOffsets();
            offsets = m3823$$Nest$smeventOffsets;
            OFFSETOF_WD = m3823$$Nest$smeventOffsets[0];
            OFFSETOF_MASK = m3823$$Nest$smeventOffsets[1];
            OFFSETOF_LEN = m3823$$Nest$smeventOffsets[3];
            OFFSETOF_NAME = m3823$$Nest$smeventOffsets[4];
        }

        Poller(UnixFileSystem fs, LinuxWatchService watcher, int ifd, int[] sp) {
            CloseGuard closeGuard = CloseGuard.get();
            this.guard = closeGuard;
            this.fs = fs;
            this.watcher = watcher;
            this.ifd = ifd;
            this.socketpair = sp;
            this.wdToKey = new HashMap();
            this.address = LinuxWatchService.unsafe.allocateMemory(PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            closeGuard.open("close");
        }

        @Override // sun.nio.fs.AbstractPoller
        void wakeup() throws IOException {
            try {
                UnixNativeDispatcher.write(this.socketpair[1], this.address, 1);
            } catch (UnixException x10) {
                throw new IOException(x10.errorString());
            }
        }

        @Override // sun.nio.fs.AbstractPoller
        Object implRegister(Path obj, Set<? extends WatchEvent.Kind<?>> events, WatchEvent.Modifier... modifiers) {
            UnixPath dir = (UnixPath) obj;
            int mask = 0;
            for (WatchEvent.Kind<?> event : events) {
                if (event == StandardWatchEventKinds.ENTRY_CREATE) {
                    mask |= 384;
                } else if (event == StandardWatchEventKinds.ENTRY_DELETE) {
                    mask |= MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT;
                } else if (event == StandardWatchEventKinds.ENTRY_MODIFY) {
                    mask |= 6;
                }
            }
            if (modifiers.length > 0) {
                for (WatchEvent.Modifier modifier : modifiers) {
                    if (modifier == null) {
                        return new NullPointerException();
                    }
                    if (!(modifier instanceof SensitivityWatchEventModifier)) {
                        return new UnsupportedOperationException("Modifier not supported");
                    }
                }
            }
            try {
                UnixFileAttributes attrs = UnixFileAttributes.get(dir, true);
                if (!attrs.isDirectory()) {
                    return new NotDirectoryException(dir.getPathForExceptionMessage());
                }
                try {
                    NativeBuffer buffer = NativeBuffers.asNativeBuffer(dir.getByteArrayForSysCalls());
                    try {
                        int wd2 = LinuxWatchService.inotifyAddWatch(this.ifd, buffer.address(), mask);
                        LinuxWatchKey key = this.wdToKey.get(Integer.valueOf(wd2));
                        if (key == null) {
                            LinuxWatchKey key2 = new LinuxWatchKey(dir, this.watcher, this.ifd, wd2);
                            this.wdToKey.put(Integer.valueOf(wd2), key2);
                            return key2;
                        }
                        return key;
                    } finally {
                        buffer.release();
                    }
                } catch (UnixException x10) {
                    if (x10.errno() == UnixConstants.ENOSPC) {
                        return new IOException("User limit of inotify watches reached");
                    }
                    return x10.asIOException(dir);
                }
            } catch (UnixException x11) {
                return x11.asIOException(dir);
            }
        }

        @Override // sun.nio.fs.AbstractPoller
        void implCancelKey(WatchKey obj) {
            LinuxWatchKey key = (LinuxWatchKey) obj;
            if (key.isValid()) {
                this.wdToKey.remove(Integer.valueOf(key.descriptor()));
                key.invalidate(true);
            }
        }

        @Override // sun.nio.fs.AbstractPoller
        void implCloseAll() {
            this.guard.close();
            for (Map.Entry<Integer, LinuxWatchKey> entry : this.wdToKey.entrySet()) {
                entry.getValue().invalidate(true);
            }
            this.wdToKey.clear();
            LinuxWatchService.unsafe.freeMemory(this.address);
            UnixNativeDispatcher.close(this.socketpair[0]);
            UnixNativeDispatcher.close(this.socketpair[1]);
            UnixNativeDispatcher.close(this.ifd);
        }

        protected void finalize() throws Throwable {
            try {
                CloseGuard closeGuard = this.guard;
                if (closeGuard != null) {
                    closeGuard.warnIfOpen();
                }
                close();
            } finally {
                super.finalize();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int bytesRead;
            int nReady;
            while (true) {
                try {
                    int nReady2 = LinuxWatchService.poll(this.ifd, this.socketpair[0]);
                    try {
                        int bytesRead2 = UnixNativeDispatcher.read(this.ifd, this.address, 8192);
                        bytesRead = bytesRead2;
                    } catch (UnixException x10) {
                        if (x10.errno() != UnixConstants.EAGAIN) {
                            throw x10;
                        }
                        bytesRead = 0;
                    }
                    if (nReady2 > 1 || (nReady2 == 1 && bytesRead == 0)) {
                        try {
                            UnixNativeDispatcher.read(this.socketpair[0], this.address, 8192);
                            boolean shutdown = processRequests();
                            if (shutdown) {
                                return;
                            }
                        } catch (UnixException x11) {
                            if (x11.errno() != UnixConstants.EAGAIN) {
                                throw x11;
                            }
                        }
                    }
                    int offset = 0;
                    while (offset < bytesRead) {
                        long event = this.address + offset;
                        int wd2 = LinuxWatchService.unsafe.getInt(OFFSETOF_WD + event);
                        int mask = LinuxWatchService.unsafe.getInt(OFFSETOF_MASK + event);
                        int len = LinuxWatchService.unsafe.getInt(OFFSETOF_LEN + event);
                        UnixPath name = null;
                        if (len <= 0) {
                            nReady = nReady2;
                        } else {
                            int actual = len;
                            while (actual > 0) {
                                long last = ((OFFSETOF_NAME + event) + actual) - 1;
                                if (LinuxWatchService.unsafe.getByte(last) != 0) {
                                    break;
                                } else {
                                    actual--;
                                }
                            }
                            if (actual <= 0) {
                                nReady = nReady2;
                            } else {
                                byte[] buf = new byte[actual];
                                int i10 = 0;
                                while (i10 < actual) {
                                    buf[i10] = LinuxWatchService.unsafe.getByte(OFFSETOF_NAME + event + i10);
                                    i10++;
                                    nReady2 = nReady2;
                                    event = event;
                                }
                                nReady = nReady2;
                                name = new UnixPath(this.fs, buf);
                            }
                        }
                        processEvent(wd2, mask, name);
                        offset += SIZEOF_INOTIFY_EVENT + len;
                        nReady2 = nReady;
                    }
                } catch (UnixException x12) {
                    x12.printStackTrace();
                    return;
                }
            }
        }

        private WatchEvent.Kind<?> maskToEventKind(int mask) {
            if ((mask & 2) > 0) {
                return StandardWatchEventKinds.ENTRY_MODIFY;
            }
            if ((mask & 4) > 0) {
                return StandardWatchEventKinds.ENTRY_MODIFY;
            }
            if ((mask & 256) > 0) {
                return StandardWatchEventKinds.ENTRY_CREATE;
            }
            if ((mask & 128) > 0) {
                return StandardWatchEventKinds.ENTRY_CREATE;
            }
            if ((mask & 512) > 0) {
                return StandardWatchEventKinds.ENTRY_DELETE;
            }
            if ((mask & 64) > 0) {
                return StandardWatchEventKinds.ENTRY_DELETE;
            }
            return null;
        }

        private void processEvent(int wd2, int mask, UnixPath name) {
            WatchEvent.Kind<?> kind;
            if ((mask & 16384) > 0) {
                for (Map.Entry<Integer, LinuxWatchKey> entry : this.wdToKey.entrySet()) {
                    entry.getValue().signalEvent(StandardWatchEventKinds.OVERFLOW, null);
                }
                return;
            }
            LinuxWatchKey key = this.wdToKey.get(Integer.valueOf(wd2));
            if (key == null) {
                return;
            }
            if ((32768 & mask) > 0) {
                this.wdToKey.remove(Integer.valueOf(wd2));
                key.invalidate(false);
                key.signal();
            } else if (name != null && (kind = maskToEventKind(mask)) != null) {
                key.signalEvent(kind, name);
            }
        }
    }
}
