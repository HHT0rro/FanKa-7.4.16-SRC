package sun.nio.fs;

import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
abstract class AbstractPoller implements Runnable {
    private final LinkedList<Request> requestList = new LinkedList<>();
    private boolean shutdown = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum RequestType {
        REGISTER,
        CANCEL,
        CLOSE
    }

    abstract void implCancelKey(WatchKey watchKey);

    abstract void implCloseAll();

    abstract Object implRegister(Path path, Set<? extends WatchEvent.Kind<?>> set, WatchEvent.Modifier... modifierArr);

    abstract void wakeup() throws IOException;

    public void start() {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: sun.nio.fs.AbstractPoller.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                Thread thr = new Thread(this);
                thr.setDaemon(true);
                thr.start();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WatchKey register(Path dir, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) throws IOException {
        if (dir == null) {
            throw new NullPointerException();
        }
        Set<WatchEvent.Kind<?>> eventSet = new HashSet<>(events.length);
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
        return (WatchKey) invoke(RequestType.REGISTER, dir, eventSet, modifiers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cancel(WatchKey key) {
        try {
            invoke(RequestType.CANCEL, key);
        } catch (IOException x10) {
            throw new AssertionError((Object) x10.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void close() throws IOException {
        invoke(RequestType.CLOSE, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Request {
        private final Object[] params;
        private final RequestType type;
        private boolean completed = false;
        private Object result = null;

        Request(RequestType type, Object... params) {
            this.type = type;
            this.params = params;
        }

        RequestType type() {
            return this.type;
        }

        Object[] parameters() {
            return this.params;
        }

        void release(Object result) {
            synchronized (this) {
                this.completed = true;
                this.result = result;
                notifyAll();
            }
        }

        Object awaitResult() {
            Object obj;
            boolean interrupted = false;
            synchronized (this) {
                while (!this.completed) {
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        interrupted = true;
                    }
                }
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                obj = this.result;
            }
            return obj;
        }
    }

    private Object invoke(RequestType type, Object... params) throws IOException {
        Request req = new Request(type, params);
        synchronized (this.requestList) {
            if (this.shutdown) {
                throw new ClosedWatchServiceException();
            }
            this.requestList.add(req);
        }
        wakeup();
        Object result = req.awaitResult();
        if (result instanceof RuntimeException) {
            throw ((RuntimeException) result);
        }
        if (result instanceof IOException) {
            throw ((IOException) result);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean processRequests() {
        synchronized (this.requestList) {
            while (true) {
                Request req = this.requestList.poll();
                if (req != null) {
                    if (this.shutdown) {
                        req.release(new ClosedWatchServiceException());
                    }
                    switch (AnonymousClass2.$SwitchMap$sun$nio$fs$AbstractPoller$RequestType[req.type().ordinal()]) {
                        case 1:
                            Object[] params = req.parameters();
                            Path path = (Path) params[0];
                            Set<? extends WatchEvent.Kind<?>> events = (Set) params[1];
                            WatchEvent.Modifier[] modifiers = (WatchEvent.Modifier[]) params[2];
                            req.release(implRegister(path, events, modifiers));
                            break;
                        case 2:
                            WatchKey key = (WatchKey) req.parameters()[0];
                            implCancelKey(key);
                            req.release(null);
                            break;
                        case 3:
                            implCloseAll();
                            req.release(null);
                            this.shutdown = true;
                            break;
                        default:
                            req.release(new IOException("request not recognized"));
                            break;
                    }
                }
            }
        }
        return this.shutdown;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: sun.nio.fs.AbstractPoller$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$sun$nio$fs$AbstractPoller$RequestType;

        static {
            int[] iArr = new int[RequestType.values().length];
            $SwitchMap$sun$nio$fs$AbstractPoller$RequestType = iArr;
            try {
                iArr[RequestType.REGISTER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$sun$nio$fs$AbstractPoller$RequestType[RequestType.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$sun$nio$fs$AbstractPoller$RequestType[RequestType.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }
}
