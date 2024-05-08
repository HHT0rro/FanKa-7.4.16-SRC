package java.util.zip;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ZStreamRef {
    private volatile long address;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZStreamRef(long address) {
        this.address = address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long address() {
        return this.address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.address = 0L;
    }
}
