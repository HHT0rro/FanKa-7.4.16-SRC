package java.nio.file;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import sun.nio.fs.BasicFileAttributesHolder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class FileTreeWalker implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean closed;
    private final boolean followLinks;
    private final LinkOption[] linkOptions;
    private final int maxDepth;
    private final ArrayDeque<DirectoryNode> stack = new ArrayDeque<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum EventType {
        START_DIRECTORY,
        END_DIRECTORY,
        ENTRY
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DirectoryNode {
        private final Path dir;
        private final Iterator<Path> iterator;
        private final Object key;
        private boolean skipped;
        private final DirectoryStream<Path> stream;

        DirectoryNode(Path dir, Object key, DirectoryStream<Path> stream) {
            this.dir = dir;
            this.key = key;
            this.stream = stream;
            this.iterator = stream.iterator2();
        }

        Path directory() {
            return this.dir;
        }

        Object key() {
            return this.key;
        }

        DirectoryStream<Path> stream() {
            return this.stream;
        }

        Iterator<Path> iterator() {
            return this.iterator;
        }

        void skip() {
            this.skipped = true;
        }

        boolean skipped() {
            return this.skipped;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Event {
        private final BasicFileAttributes attrs;
        private final Path file;
        private final IOException ioe;
        private final EventType type;

        private Event(EventType type, Path file, BasicFileAttributes attrs, IOException ioe) {
            this.type = type;
            this.file = file;
            this.attrs = attrs;
            this.ioe = ioe;
        }

        Event(EventType type, Path file, BasicFileAttributes attrs) {
            this(type, file, attrs, null);
        }

        Event(EventType type, Path file, IOException ioe) {
            this(type, file, null, ioe);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EventType type() {
            return this.type;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path file() {
            return this.file;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public BasicFileAttributes attributes() {
            return this.attrs;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IOException ioeException() {
            return this.ioe;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileTreeWalker(Collection<FileVisitOption> options, int maxDepth) {
        boolean fl = false;
        for (FileVisitOption option : options) {
            switch (AnonymousClass1.$SwitchMap$java$nio$file$FileVisitOption[option.ordinal()]) {
                case 1:
                    fl = true;
                default:
                    throw new AssertionError((Object) "Should not get here");
            }
        }
        if (maxDepth < 0) {
            throw new IllegalArgumentException("'maxDepth' is negative");
        }
        this.followLinks = fl;
        this.linkOptions = fl ? new LinkOption[0] : new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        this.maxDepth = maxDepth;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.nio.file.FileTreeWalker$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$nio$file$FileVisitOption;

        static {
            int[] iArr = new int[FileVisitOption.values().length];
            $SwitchMap$java$nio$file$FileVisitOption = iArr;
            try {
                iArr[FileVisitOption.FOLLOW_LINKS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private BasicFileAttributes getAttributes(Path file, boolean canUseCached) throws IOException {
        BasicFileAttributes cached;
        if (canUseCached && (file instanceof BasicFileAttributesHolder) && System.getSecurityManager() == null && (cached = ((BasicFileAttributesHolder) file).get()) != null && (!this.followLinks || !cached.isSymbolicLink())) {
            return cached;
        }
        try {
            BasicFileAttributes attrs = Files.readAttributes(file, (Class<BasicFileAttributes>) BasicFileAttributes.class, this.linkOptions);
            return attrs;
        } catch (IOException ioe) {
            if (!this.followLinks) {
                throw ioe;
            }
            BasicFileAttributes attrs2 = Files.readAttributes(file, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            return attrs2;
        }
    }

    private boolean wouldLoop(Path dir, Object key) {
        Iterator<DirectoryNode> iterator2 = this.stack.iterator2();
        while (iterator2.hasNext()) {
            DirectoryNode ancestor = iterator2.next();
            Object ancestorKey = ancestor.key();
            if (key != null && ancestorKey != null) {
                if (key.equals(ancestorKey)) {
                    return true;
                }
            } else {
                try {
                    if (Files.isSameFile(dir, ancestor.directory())) {
                        return true;
                    }
                } catch (IOException | SecurityException e2) {
                }
            }
        }
        return false;
    }

    private Event visit(Path entry, boolean ignoreSecurityException, boolean canUseCached) {
        try {
            BasicFileAttributes attrs = getAttributes(entry, canUseCached);
            int depth = this.stack.size();
            if (depth >= this.maxDepth || !attrs.isDirectory()) {
                return new Event(EventType.ENTRY, entry, attrs);
            }
            if (this.followLinks && wouldLoop(entry, attrs.fileKey())) {
                return new Event(EventType.ENTRY, entry, new FileSystemLoopException(entry.toString()));
            }
            try {
                DirectoryStream<Path> stream = Files.newDirectoryStream(entry);
                this.stack.push(new DirectoryNode(entry, attrs.fileKey(), stream));
                return new Event(EventType.START_DIRECTORY, entry, attrs);
            } catch (IOException ioe) {
                return new Event(EventType.ENTRY, entry, ioe);
            } catch (SecurityException se) {
                if (ignoreSecurityException) {
                    return null;
                }
                throw se;
            }
        } catch (IOException ioe2) {
            return new Event(EventType.ENTRY, entry, ioe2);
        } catch (SecurityException se2) {
            if (ignoreSecurityException) {
                return null;
            }
            throw se2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event walk(Path file) {
        if (this.closed) {
            throw new IllegalStateException("Closed");
        }
        Event ev = visit(file, false, false);
        return ev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event next() {
        Event ev;
        DirectoryNode top = this.stack.peek();
        if (top == null) {
            return null;
        }
        do {
            Path entry = null;
            IOException ioe = null;
            if (!top.skipped()) {
                Iterator<Path> iterator = top.iterator();
                try {
                    if (iterator.hasNext()) {
                        entry = iterator.next();
                    }
                } catch (DirectoryIteratorException x10) {
                    ioe = x10.getCause();
                }
            }
            if (entry == null) {
                try {
                    top.stream().close();
                } catch (IOException e2) {
                    if (ioe == null) {
                        ioe = e2;
                    } else {
                        ioe.addSuppressed(e2);
                    }
                }
                this.stack.pop();
                return new Event(EventType.END_DIRECTORY, top.directory(), ioe);
            }
            ev = visit(entry, true, true);
        } while (ev == null);
        return ev;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pop() {
        if (!this.stack.isEmpty()) {
            DirectoryNode node = this.stack.pop();
            try {
                node.stream().close();
            } catch (IOException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void skipRemainingSiblings() {
        if (!this.stack.isEmpty()) {
            this.stack.peek().skip();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            while (!this.stack.isEmpty()) {
                pop();
            }
            this.closed = true;
        }
    }
}
