package sun.nio.ch;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PollArrayWrapper extends AbstractPollArrayWrapper {
    int interruptFD;

    private static native void interrupt(int i10);

    private native int poll0(long j10, int i10, long j11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PollArrayWrapper(int newSize) {
        this.pollArray = new AllocatedNativeObject((newSize + 1) * 8, false);
        this.pollArrayAddress = this.pollArray.address();
        this.totalChannels = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initInterrupt(int fd0, int fd1) {
        this.interruptFD = fd1;
        putDescriptor(0, fd0);
        putEventOps(0, Net.POLLIN);
        putReventOps(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void free() {
        this.pollArray.free();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEntry(SelChImpl sc2) {
        putDescriptor(this.totalChannels, IOUtil.fdVal(sc2.getFD()));
        putEventOps(this.totalChannels, 0);
        putReventOps(this.totalChannels, 0);
        this.totalChannels++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void replaceEntry(PollArrayWrapper source, int sindex, PollArrayWrapper target, int tindex) {
        target.putDescriptor(tindex, source.getDescriptor(sindex));
        target.putEventOps(tindex, source.getEventOps(sindex));
        target.putReventOps(tindex, source.getReventOps(sindex));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void grow(int newSize) {
        PollArrayWrapper temp = new PollArrayWrapper(newSize);
        for (int i10 = 0; i10 < this.totalChannels; i10++) {
            replaceEntry(this, i10, temp, i10);
        }
        this.pollArray.free();
        this.pollArray = temp.pollArray;
        this.pollArrayAddress = this.pollArray.address();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int poll(int numfds, int offset, long timeout) {
        return poll0(this.pollArrayAddress + (offset * 8), numfds, timeout);
    }

    public void interrupt() {
        interrupt(this.interruptFD);
    }
}
