package sun.nio.fs;

import dalvik.system.CloseGuard;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class UnixDirectoryStream implements DirectoryStream<Path> {
    private final UnixPath dir;
    private final long dp;
    private final DirectoryStream.Filter<? super Path> filter;
    private final CloseGuard guard;
    private volatile boolean isClosed;
    private Iterator<Path> iterator;
    private final ReentrantReadWriteLock streamLock = new ReentrantReadWriteLock(true);

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnixDirectoryStream(UnixPath dir, long dp, DirectoryStream.Filter<? super Path> filter) {
        CloseGuard closeGuard = CloseGuard.get();
        this.guard = closeGuard;
        this.dir = dir;
        this.dp = dp;
        this.filter = filter;
        closeGuard.open("close");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UnixPath directory() {
        return this.dir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Lock readLock() {
        return this.streamLock.readLock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Lock writeLock() {
        return this.streamLock.writeLock();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isOpen() {
        return !this.isClosed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean closeImpl() throws IOException {
        if (!this.isClosed) {
            this.isClosed = true;
            try {
                UnixNativeDispatcher.closedir(this.dp);
                this.guard.close();
                return true;
            } catch (UnixException x10) {
                throw new IOException(x10.errorString());
            }
        }
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        writeLock().lock();
        try {
            closeImpl();
        } finally {
            writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Iterator<Path> iterator(DirectoryStream<Path> ds) {
        UnixDirectoryIterator unixDirectoryIterator;
        if (this.isClosed) {
            throw new IllegalStateException("Directory stream is closed");
        }
        synchronized (this) {
            if (this.iterator != null) {
                throw new IllegalStateException("Iterator already obtained");
            }
            unixDirectoryIterator = new UnixDirectoryIterator(ds);
            this.iterator = unixDirectoryIterator;
        }
        return unixDirectoryIterator;
    }

    @Override // java.nio.file.DirectoryStream, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Path> iterator2() {
        return iterator(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class UnixDirectoryIterator implements Iterator<Path> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean atEof = false;
        private Path nextEntry;
        private final DirectoryStream<Path> stream;

        UnixDirectoryIterator(DirectoryStream<Path> stream) {
            this.stream = stream;
        }

        private boolean isSelfOrParent(byte[] nameAsBytes) {
            return nameAsBytes[0] == 46 && (nameAsBytes.length == 1 || (nameAsBytes.length == 2 && nameAsBytes[1] == 46));
        }

        private Path readNextEntry() {
            UnixPath resolve;
            while (true) {
                byte[] nameAsBytes = null;
                UnixDirectoryStream.this.readLock().lock();
                try {
                    try {
                        if (UnixDirectoryStream.this.isOpen()) {
                            nameAsBytes = UnixNativeDispatcher.readdir(UnixDirectoryStream.this.dp);
                        }
                        if (nameAsBytes == null) {
                            this.atEof = true;
                            return null;
                        }
                        if (!isSelfOrParent(nameAsBytes)) {
                            resolve = UnixDirectoryStream.this.dir.resolve(nameAsBytes);
                            try {
                                if (UnixDirectoryStream.this.filter == null || UnixDirectoryStream.this.filter.accept(resolve)) {
                                    break;
                                }
                            } catch (IOException ioe) {
                                throw new DirectoryIteratorException(ioe);
                            }
                        }
                    } finally {
                        UnixDirectoryStream.this.readLock().unlock();
                    }
                } catch (UnixException x10) {
                    IOException ioe2 = x10.asIOException(UnixDirectoryStream.this.dir);
                    throw new DirectoryIteratorException(ioe2);
                }
            }
            return resolve;
        }

        @Override // java.util.Iterator
        public synchronized boolean hasNext() {
            if (this.nextEntry == null && !this.atEof) {
                this.nextEntry = readNextEntry();
            }
            return this.nextEntry != null;
        }

        @Override // java.util.Iterator
        public synchronized Path next() {
            Path result;
            result = this.nextEntry;
            if (result == null && !this.atEof) {
                result = readNextEntry();
            } else {
                this.nextEntry = null;
            }
            if (result == null) {
                throw new NoSuchElementException();
            }
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected void finalize() throws IOException {
        CloseGuard closeGuard = this.guard;
        if (closeGuard != null) {
            closeGuard.warnIfOpen();
        }
        close();
    }
}
