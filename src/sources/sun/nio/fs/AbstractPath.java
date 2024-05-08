package sun.nio.fs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPath implements Path {
    @Override // java.nio.file.Path
    public final boolean startsWith(String other) {
        return startsWith(getFileSystem().getPath(other, new String[0]));
    }

    @Override // java.nio.file.Path
    public final boolean endsWith(String other) {
        return endsWith(getFileSystem().getPath(other, new String[0]));
    }

    @Override // java.nio.file.Path
    public final Path resolve(String other) {
        return resolve(getFileSystem().getPath(other, new String[0]));
    }

    @Override // java.nio.file.Path
    public final Path resolveSibling(Path other) {
        if (other == null) {
            throw new NullPointerException();
        }
        Path parent = getParent();
        return parent == null ? other : parent.resolve(other);
    }

    @Override // java.nio.file.Path
    public final Path resolveSibling(String other) {
        return resolveSibling(getFileSystem().getPath(other, new String[0]));
    }

    @Override // java.nio.file.Path, java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<Path> iterator2() {
        return new Iterator<Path>() { // from class: sun.nio.fs.AbstractPath.1

            /* renamed from: i, reason: collision with root package name */
            private int f53738i = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f53738i < AbstractPath.this.getNameCount();
            }

            @Override // java.util.Iterator
            public Path next() {
                if (this.f53738i < AbstractPath.this.getNameCount()) {
                    Path result = AbstractPath.this.getName(this.f53738i);
                    this.f53738i++;
                    return result;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.nio.file.Path
    public final File toFile() {
        return new File(toString());
    }

    @Override // java.nio.file.Path, java.nio.file.Watchable
    public final WatchKey register(WatchService watcher, WatchEvent.Kind<?>... events) throws IOException {
        return register(watcher, events, new WatchEvent.Modifier[0]);
    }
}
