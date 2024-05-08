package sun.nio.ch;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class AllocatedNativeObject extends NativeObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AllocatedNativeObject(int size, boolean pageAligned) {
        super(size, pageAligned);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void free() {
        if (this.allocationAddress != 0) {
            unsafe.freeMemory(this.allocationAddress);
            this.allocationAddress = 0L;
        }
    }
}
