package jdk.internal.misc;

import java.io.FileDescriptor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface JavaIOFileDescriptorAccess {
    int get(FileDescriptor fileDescriptor);

    long getHandle(FileDescriptor fileDescriptor);

    void set(FileDescriptor fileDescriptor, int i10);

    void setHandle(FileDescriptor fileDescriptor, long j10);
}
