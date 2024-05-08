package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.channels.Channel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: FileLockTable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SharedFileLockTable extends FileLockTable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ConcurrentHashMap<FileKey, List<FileLockReference>> lockMap = new ConcurrentHashMap<>();
    private static ReferenceQueue<FileLock> queue = new ReferenceQueue<>();
    private final Channel channel;
    private final FileKey fileKey;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* compiled from: FileLockTable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FileLockReference extends WeakReference<FileLock> {
        private FileKey fileKey;

        FileLockReference(FileLock referent, ReferenceQueue<FileLock> queue, FileKey key) {
            super(referent, queue);
            this.fileKey = key;
        }

        FileKey fileKey() {
            return this.fileKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedFileLockTable(Channel channel, FileDescriptor fd2) throws IOException {
        this.channel = channel;
        this.fileKey = FileKey.create(fd2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r1.add(new sun.nio.ch.SharedFileLockTable.FileLockReference(r10, sun.nio.ch.SharedFileLockTable.queue, r9.fileKey));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        checkList(r0, r10.position(), r10.size());
        r0.add(new sun.nio.ch.SharedFileLockTable.FileLockReference(r10, sun.nio.ch.SharedFileLockTable.queue, r9.fileKey));
     */
    @Override // sun.nio.ch.FileLockTable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void add(java.nio.channels.FileLock r10) throws java.nio.channels.OverlappingFileLockException {
        /*
            r9 = this;
            java.util.concurrent.ConcurrentHashMap<sun.nio.ch.FileKey, java.util.List<sun.nio.ch.SharedFileLockTable$FileLockReference>> r0 = sun.nio.ch.SharedFileLockTable.lockMap
            sun.nio.ch.FileKey r1 = r9.fileKey
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
        La:
            if (r0 != 0) goto L33
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 2
            r1.<init>(r2)
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<sun.nio.ch.FileKey, java.util.List<sun.nio.ch.SharedFileLockTable$FileLockReference>> r0 = sun.nio.ch.SharedFileLockTable.lockMap     // Catch: java.lang.Throwable -> L30
            sun.nio.ch.FileKey r2 = r9.fileKey     // Catch: java.lang.Throwable -> L30
            java.lang.Object r0 = r0.putIfAbsent(r2, r1)     // Catch: java.lang.Throwable -> L30
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L2d
            sun.nio.ch.SharedFileLockTable$FileLockReference r2 = new sun.nio.ch.SharedFileLockTable$FileLockReference     // Catch: java.lang.Throwable -> L30
            java.lang.ref.ReferenceQueue<java.nio.channels.FileLock> r3 = sun.nio.ch.SharedFileLockTable.queue     // Catch: java.lang.Throwable -> L30
            sun.nio.ch.FileKey r4 = r9.fileKey     // Catch: java.lang.Throwable -> L30
            r2.<init>(r10, r3, r4)     // Catch: java.lang.Throwable -> L30
            r1.add(r2)     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            goto L5b
        L2d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            r1 = r0
            goto L33
        L30:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r0
        L33:
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<sun.nio.ch.FileKey, java.util.List<sun.nio.ch.SharedFileLockTable$FileLockReference>> r1 = sun.nio.ch.SharedFileLockTable.lockMap     // Catch: java.lang.Throwable -> L6b
            sun.nio.ch.FileKey r2 = r9.fileKey     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L6b
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L6b
            if (r0 != r1) goto L62
            long r4 = r10.position()     // Catch: java.lang.Throwable -> L5f
            long r6 = r10.size()     // Catch: java.lang.Throwable -> L5f
            r2 = r9
            r3 = r0
            r2.checkList(r3, r4, r6)     // Catch: java.lang.Throwable -> L5f
            sun.nio.ch.SharedFileLockTable$FileLockReference r2 = new sun.nio.ch.SharedFileLockTable$FileLockReference     // Catch: java.lang.Throwable -> L5f
            java.lang.ref.ReferenceQueue<java.nio.channels.FileLock> r3 = sun.nio.ch.SharedFileLockTable.queue     // Catch: java.lang.Throwable -> L5f
            sun.nio.ch.FileKey r4 = r9.fileKey     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r10, r3, r4)     // Catch: java.lang.Throwable -> L5f
            r0.add(r2)     // Catch: java.lang.Throwable -> L5f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5f
            r1 = r0
        L5b:
            r9.removeStaleEntries()
            return
        L5f:
            r1 = move-exception
            r2 = r0
            goto L6d
        L62:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L66
            r0 = r1
            goto La
        L66:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L6d
        L6b:
            r1 = move-exception
            r2 = r0
        L6d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6f
            throw r1
        L6f:
            r1 = move-exception
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.nio.ch.SharedFileLockTable.add(java.nio.channels.FileLock):void");
    }

    private void removeKeyIfEmpty(FileKey fk, List<FileLockReference> list) {
        if (list.isEmpty()) {
            lockMap.remove(fk);
        }
    }

    @Override // sun.nio.ch.FileLockTable
    public void remove(FileLock fl) {
        List<FileLockReference> list = lockMap.get(this.fileKey);
        if (list == null) {
            return;
        }
        synchronized (list) {
            int index = 0;
            while (true) {
                if (index >= list.size()) {
                    break;
                }
                FileLockReference ref = list.get(index);
                FileLock lock = ref.get();
                if (lock == fl) {
                    ref.clear();
                    list.remove(index);
                    break;
                }
                index++;
            }
        }
    }

    @Override // sun.nio.ch.FileLockTable
    public List<FileLock> removeAll() {
        List<FileLock> result = new ArrayList<>();
        List<FileLockReference> list = lockMap.get(this.fileKey);
        if (list != null) {
            synchronized (list) {
                int index = 0;
                while (index < list.size()) {
                    FileLockReference ref = list.get(index);
                    FileLock lock = ref.get();
                    if (lock != null && lock.acquiredBy() == this.channel) {
                        ref.clear();
                        list.remove(index);
                        result.add(lock);
                    } else {
                        index++;
                    }
                }
                removeKeyIfEmpty(this.fileKey, list);
            }
        }
        return result;
    }

    @Override // sun.nio.ch.FileLockTable
    public void replace(FileLock fromLock, FileLock toLock) {
        List<FileLockReference> list = lockMap.get(this.fileKey);
        synchronized (list) {
            int index = 0;
            while (true) {
                if (index >= list.size()) {
                    break;
                }
                FileLockReference ref = list.get(index);
                FileLock lock = ref.get();
                if (lock != fromLock) {
                    index++;
                } else {
                    ref.clear();
                    list.set(index, new FileLockReference(toLock, queue, this.fileKey));
                    break;
                }
            }
        }
    }

    private void checkList(List<FileLockReference> list, long position, long size) throws OverlappingFileLockException {
        for (FileLockReference ref : list) {
            FileLock fl = ref.get();
            if (fl != null && fl.overlaps(position, size)) {
                throw new OverlappingFileLockException();
            }
        }
    }

    private void removeStaleEntries() {
        while (true) {
            FileLockReference ref = (FileLockReference) queue.poll();
            if (ref != null) {
                FileKey fk = ref.fileKey();
                List<FileLockReference> list = lockMap.get(fk);
                if (list != null) {
                    synchronized (list) {
                        list.remove(ref);
                        removeKeyIfEmpty(fk, list);
                    }
                }
            } else {
                return;
            }
        }
    }
}
