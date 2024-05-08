package java.nio.file;

import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileTreeWalker;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FileTreeIterator implements Iterator<FileTreeWalker.Event>, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private FileTreeWalker.Event next;
    private final FileTreeWalker walker;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileTreeIterator(Path start, int maxDepth, FileVisitOption... options) throws IOException {
        FileTreeWalker fileTreeWalker = new FileTreeWalker(Arrays.asList(options), maxDepth);
        this.walker = fileTreeWalker;
        FileTreeWalker.Event walk = fileTreeWalker.walk(start);
        this.next = walk;
        IOException ioe = walk.ioeException();
        if (ioe != null) {
            throw ioe;
        }
    }

    private void fetchNextIfNeeded() {
        if (this.next == null) {
            FileTreeWalker.Event ev = this.walker.next();
            while (ev != null) {
                IOException ioe = ev.ioeException();
                if (ioe != null) {
                    throw new UncheckedIOException(ioe);
                }
                if (ev.type() != FileTreeWalker.EventType.END_DIRECTORY) {
                    this.next = ev;
                    return;
                }
                ev = this.walker.next();
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!this.walker.isOpen()) {
            throw new IllegalStateException();
        }
        fetchNextIfNeeded();
        return this.next != null;
    }

    @Override // java.util.Iterator
    public FileTreeWalker.Event next() {
        if (!this.walker.isOpen()) {
            throw new IllegalStateException();
        }
        fetchNextIfNeeded();
        if (this.next == null) {
            throw new NoSuchElementException();
        }
        FileTreeWalker.Event result = this.next;
        this.next = null;
        return result;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.walker.close();
    }
}
