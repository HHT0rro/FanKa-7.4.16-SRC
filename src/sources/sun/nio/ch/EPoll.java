package sun.nio.ch;

import java.io.IOException;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class EPoll {
    static final int EPOLLONESHOT = 1073741824;
    static final int EPOLL_CTL_ADD = 1;
    static final int EPOLL_CTL_DEL = 2;
    static final int EPOLL_CTL_MOD = 3;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final int SIZEOF_EPOLLEVENT = eventSize();
    private static final int OFFSETOF_EVENTS = eventsOffset();
    private static final int OFFSETOF_FD = dataOffset();

    private static native int dataOffset();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int epollCreate() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int epollCtl(int i10, int i11, int i12, int i13);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native int epollWait(int i10, long j10, int i11) throws IOException;

    private static native int eventSize();

    private static native int eventsOffset();

    private EPoll() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long allocatePollArray(int count) {
        return unsafe.allocateMemory(SIZEOF_EPOLLEVENT * count);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freePollArray(long address) {
        unsafe.freeMemory(address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getEvent(long address, int i10) {
        return (SIZEOF_EPOLLEVENT * i10) + address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDescriptor(long eventAddress) {
        return unsafe.getInt(OFFSETOF_FD + eventAddress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getEvents(long eventAddress) {
        return unsafe.getInt(OFFSETOF_EVENTS + eventAddress);
    }
}
