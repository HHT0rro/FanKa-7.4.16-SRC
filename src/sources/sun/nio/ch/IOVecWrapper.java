package sun.nio.ch;

import java.nio.ByteBuffer;
import sun.misc.Cleaner;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IOVecWrapper {
    private static final int BASE_OFFSET = 0;
    private static final int LEN_OFFSET;
    private static final int SIZE_IOVEC;
    static int addressSize;
    private static final ThreadLocal<IOVecWrapper> cached = new ThreadLocal<>();
    final long address;
    private final ByteBuffer[] buf;
    private final int[] position;
    private final int[] remaining;
    private final ByteBuffer[] shadow;
    private final int size;
    private final AllocatedNativeObject vecArray;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class Deallocator implements Runnable {
        private final AllocatedNativeObject obj;

        Deallocator(AllocatedNativeObject obj) {
            this.obj = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.obj.free();
        }
    }

    static {
        int addressSize2 = Util.unsafe().addressSize();
        addressSize = addressSize2;
        LEN_OFFSET = addressSize2;
        SIZE_IOVEC = (short) (addressSize2 * 2);
    }

    private IOVecWrapper(int size) {
        this.size = size;
        this.buf = new ByteBuffer[size];
        this.position = new int[size];
        this.remaining = new int[size];
        this.shadow = new ByteBuffer[size];
        AllocatedNativeObject allocatedNativeObject = new AllocatedNativeObject(SIZE_IOVEC * size, false);
        this.vecArray = allocatedNativeObject;
        this.address = allocatedNativeObject.address();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOVecWrapper get(int size) {
        ThreadLocal<IOVecWrapper> threadLocal = cached;
        IOVecWrapper wrapper = threadLocal.get();
        if (wrapper != null && wrapper.size < size) {
            wrapper.vecArray.free();
            wrapper = null;
        }
        if (wrapper == null) {
            IOVecWrapper wrapper2 = new IOVecWrapper(size);
            Cleaner.create(wrapper2, new Deallocator(wrapper2.vecArray));
            threadLocal.set(wrapper2);
            return wrapper2;
        }
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBuffer(int i10, ByteBuffer buf, int pos, int rem) {
        this.buf[i10] = buf;
        this.position[i10] = pos;
        this.remaining[i10] = rem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShadow(int i10, ByteBuffer buf) {
        this.shadow[i10] = buf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer getBuffer(int i10) {
        return this.buf[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition(int i10) {
        return this.position[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRemaining(int i10) {
        return this.remaining[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer getShadow(int i10) {
        return this.shadow[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearRefs(int i10) {
        this.buf[i10] = null;
        this.shadow[i10] = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putBase(int i10, long base) {
        int offset = (SIZE_IOVEC * i10) + 0;
        if (addressSize == 4) {
            this.vecArray.putInt(offset, (int) base);
        } else {
            this.vecArray.putLong(offset, base);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putLen(int i10, long len) {
        int offset = (SIZE_IOVEC * i10) + LEN_OFFSET;
        if (addressSize == 4) {
            this.vecArray.putInt(offset, (int) len);
        } else {
            this.vecArray.putLong(offset, len);
        }
    }
}
