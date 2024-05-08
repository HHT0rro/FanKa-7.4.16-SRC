package sun.nio.fs;

import sun.misc.Cleaner;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NativeBuffer {
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private final long address;
    private final Cleaner cleaner;
    private Object owner;
    private final int size;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class Deallocator implements Runnable {
        private final long address;

        Deallocator(long address) {
            this.address = address;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeBuffer.unsafe.freeMemory(this.address);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeBuffer(int size) {
        long allocateMemory = unsafe.allocateMemory(size);
        this.address = allocateMemory;
        this.size = size;
        this.cleaner = Cleaner.create(this, new Deallocator(allocateMemory));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        NativeBuffers.releaseNativeBuffer(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long address() {
        return this.address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cleaner cleaner() {
        return this.cleaner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOwner(Object owner) {
        this.owner = owner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object owner() {
        return this.owner;
    }
}
