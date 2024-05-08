package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DirectoryWalker<T> {
    private final int depthLimit;
    private final FileFilter filter;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CancelException extends IOException {
        private static final long serialVersionUID = 1347339620135041008L;
        private final int depth;
        private final File file;

        public CancelException(File file, int i10) {
            this("Operation Cancelled", file, i10);
        }

        public int getDepth() {
            return this.depth;
        }

        public File getFile() {
            return this.file;
        }

        public CancelException(String str, File file, int i10) {
            super(str);
            this.file = file;
            this.depth = i10;
        }
    }

    public DirectoryWalker() {
        this(null, -1);
    }

    public final void checkIfCancelled(File file, int i10, Collection<T> collection) throws IOException {
        if (handleIsCancelled(file, i10, collection)) {
            throw new CancelException(file, i10);
        }
    }

    public File[] filterDirectoryContents(File file, int i10, File[] fileArr) throws IOException {
        return fileArr;
    }

    public void handleCancelled(File file, Collection<T> collection, CancelException cancelException) throws IOException {
        throw cancelException;
    }

    public boolean handleDirectory(File file, int i10, Collection<T> collection) throws IOException {
        return true;
    }

    public void handleDirectoryEnd(File file, int i10, Collection<T> collection) throws IOException {
    }

    public void handleDirectoryStart(File file, int i10, Collection<T> collection) throws IOException {
    }

    public void handleEnd(Collection<T> collection) throws IOException {
    }

    public void handleFile(File file, int i10, Collection<T> collection) throws IOException {
    }

    public boolean handleIsCancelled(File file, int i10, Collection<T> collection) throws IOException {
        return false;
    }

    public void handleRestricted(File file, int i10, Collection<T> collection) throws IOException {
    }

    public void handleStart(File file, Collection<T> collection) throws IOException {
    }

    public final void walk(File file, Collection<T> collection) throws IOException {
        Objects.requireNonNull(file, "Start Directory is null");
        try {
            handleStart(file, collection);
            walk(file, 0, collection);
            handleEnd(collection);
        } catch (CancelException e2) {
            handleCancelled(file, collection, e2);
        }
    }

    public DirectoryWalker(FileFilter fileFilter, int i10) {
        this.filter = fileFilter;
        this.depthLimit = i10;
    }

    public DirectoryWalker(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2, int i10) {
        if (iOFileFilter == null && iOFileFilter2 == null) {
            this.filter = null;
        } else {
            this.filter = FileFilterUtils.or(FileFilterUtils.makeDirectoryOnly(iOFileFilter == null ? TrueFileFilter.TRUE : iOFileFilter), FileFilterUtils.makeFileOnly(iOFileFilter2 == null ? TrueFileFilter.TRUE : iOFileFilter2));
        }
        this.depthLimit = i10;
    }

    private void walk(File file, int i10, Collection<T> collection) throws IOException {
        checkIfCancelled(file, i10, collection);
        if (handleDirectory(file, i10, collection)) {
            handleDirectoryStart(file, i10, collection);
            int i11 = i10 + 1;
            int i12 = this.depthLimit;
            if (i12 < 0 || i11 <= i12) {
                checkIfCancelled(file, i10, collection);
                FileFilter fileFilter = this.filter;
                File[] filterDirectoryContents = filterDirectoryContents(file, i10, fileFilter == null ? file.listFiles() : file.listFiles(fileFilter));
                if (filterDirectoryContents == null) {
                    handleRestricted(file, i11, collection);
                } else {
                    for (File file2 : filterDirectoryContents) {
                        if (file2.isDirectory()) {
                            walk(file2, i11, collection);
                        } else {
                            checkIfCancelled(file2, i11, collection);
                            handleFile(file2, i11, collection);
                            checkIfCancelled(file2, i11, collection);
                        }
                    }
                }
            }
            handleDirectoryEnd(file, i10, collection);
        }
        checkIfCancelled(file, i10, collection);
    }
}
