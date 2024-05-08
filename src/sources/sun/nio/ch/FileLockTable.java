package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class FileLockTable {
    public abstract void add(FileLock fileLock) throws OverlappingFileLockException;

    public abstract void remove(FileLock fileLock);

    public abstract List<FileLock> removeAll();

    public abstract void replace(FileLock fileLock, FileLock fileLock2);

    public static FileLockTable newSharedFileLockTable(Channel channel, FileDescriptor fd2) throws IOException {
        return new SharedFileLockTable(channel, fd2);
    }
}
