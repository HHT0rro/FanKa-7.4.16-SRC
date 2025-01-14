package java.nio.file;

import java.nio.file.WatchEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class StandardWatchEventKinds {
    public static final WatchEvent.Kind<Object> OVERFLOW = new StdWatchEventKind("OVERFLOW", Object.class);
    public static final WatchEvent.Kind<Path> ENTRY_CREATE = new StdWatchEventKind("ENTRY_CREATE", Path.class);
    public static final WatchEvent.Kind<Path> ENTRY_DELETE = new StdWatchEventKind("ENTRY_DELETE", Path.class);
    public static final WatchEvent.Kind<Path> ENTRY_MODIFY = new StdWatchEventKind("ENTRY_MODIFY", Path.class);

    private StandardWatchEventKinds() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class StdWatchEventKind<T> implements WatchEvent.Kind<T> {
        private final String name;
        private final Class<T> type;

        StdWatchEventKind(String name, Class<T> type) {
            this.name = name;
            this.type = type;
        }

        @Override // java.nio.file.WatchEvent.Kind
        public String name() {
            return this.name;
        }

        @Override // java.nio.file.WatchEvent.Kind
        public Class<T> type() {
            return this.type;
        }

        public String toString() {
            return this.name;
        }
    }
}
