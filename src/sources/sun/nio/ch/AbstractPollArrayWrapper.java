package sun.nio.ch;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractPollArrayWrapper {
    static final short EVENT_OFFSET = 4;
    static final short FD_OFFSET = 0;
    static final short REVENT_OFFSET = 6;
    static final short SIZE_POLLFD = 8;
    protected AllocatedNativeObject pollArray;
    protected long pollArrayAddress;
    protected int totalChannels = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEventOps(int i10) {
        int offset = (i10 * 8) + 4;
        return this.pollArray.getShort(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getReventOps(int i10) {
        int offset = (i10 * 8) + 6;
        return this.pollArray.getShort(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDescriptor(int i10) {
        int offset = (i10 * 8) + 0;
        return this.pollArray.getInt(offset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putEventOps(int i10, int event) {
        int offset = (i10 * 8) + 4;
        this.pollArray.putShort(offset, (short) event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putReventOps(int i10, int revent) {
        int offset = (i10 * 8) + 6;
        this.pollArray.putShort(offset, (short) revent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putDescriptor(int i10, int fd2) {
        int offset = (i10 * 8) + 0;
        this.pollArray.putInt(offset, fd2);
    }
}
