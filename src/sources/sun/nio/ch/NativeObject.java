package sun.nio.ch;

import java.nio.ByteOrder;
import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class NativeObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long address;
    protected long allocationAddress;
    protected static final Unsafe unsafe = Unsafe.getUnsafe();
    private static ByteOrder byteOrder = null;
    private static int pageSize = -1;

    NativeObject(long address) {
        this.allocationAddress = address;
        this.address = address;
    }

    NativeObject(long address, long offset) {
        this.allocationAddress = address;
        this.address = address + offset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public NativeObject(int size, boolean pageAligned) {
        if (!pageAligned) {
            long allocateMemory = unsafe.allocateMemory(size);
            this.allocationAddress = allocateMemory;
            this.address = allocateMemory;
        } else {
            int ps = pageSize();
            long a10 = unsafe.allocateMemory(size + ps);
            this.allocationAddress = a10;
            this.address = (ps + a10) - ((ps - 1) & a10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long address() {
        return this.address;
    }

    long allocationAddress() {
        return this.allocationAddress;
    }

    NativeObject subObject(int offset) {
        return new NativeObject(offset + this.address);
    }

    NativeObject getObject(int offset) {
        long newAddress;
        switch (addressSize()) {
            case 4:
                newAddress = unsafe.getInt(offset + this.address) & (-1);
                break;
            case 8:
                newAddress = unsafe.getLong(offset + this.address);
                break;
            default:
                throw new InternalError("Address size not supported");
        }
        return new NativeObject(newAddress);
    }

    void putObject(int offset, NativeObject ob2) {
        switch (addressSize()) {
            case 4:
                putInt(offset, (int) (ob2.address & (-1)));
                return;
            case 8:
                putLong(offset, ob2.address);
                return;
            default:
                throw new InternalError("Address size not supported");
        }
    }

    final byte getByte(int offset) {
        return unsafe.getByte(offset + this.address);
    }

    final void putByte(int offset, byte value) {
        unsafe.putByte(offset + this.address, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final short getShort(int offset) {
        return unsafe.getShort(offset + this.address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void putShort(int offset, short value) {
        unsafe.putShort(offset + this.address, value);
    }

    final char getChar(int offset) {
        return unsafe.getChar(offset + this.address);
    }

    final void putChar(int offset, char value) {
        unsafe.putChar(offset + this.address, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getInt(int offset) {
        return unsafe.getInt(offset + this.address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void putInt(int offset, int value) {
        unsafe.putInt(offset + this.address, value);
    }

    final long getLong(int offset) {
        return unsafe.getLong(offset + this.address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void putLong(int offset, long value) {
        unsafe.putLong(offset + this.address, value);
    }

    final float getFloat(int offset) {
        return unsafe.getFloat(offset + this.address);
    }

    final void putFloat(int offset, float value) {
        unsafe.putFloat(offset + this.address, value);
    }

    final double getDouble(int offset) {
        return unsafe.getDouble(offset + this.address);
    }

    final void putDouble(int offset, double value) {
        unsafe.putDouble(offset + this.address, value);
    }

    static int addressSize() {
        return unsafe.addressSize();
    }

    static ByteOrder byteOrder() {
        ByteOrder byteOrder2 = byteOrder;
        if (byteOrder2 != null) {
            return byteOrder2;
        }
        Unsafe unsafe2 = unsafe;
        long a10 = unsafe2.allocateMemory(8L);
        try {
            unsafe2.putLong(a10, 72623859790382856L);
            byte b4 = unsafe2.getByte(a10);
            switch (b4) {
                case 1:
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    break;
                case 8:
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                    break;
            }
            unsafe2.freeMemory(a10);
            return byteOrder;
        } catch (Throwable th) {
            unsafe.freeMemory(a10);
            throw th;
        }
    }

    static int pageSize() {
        if (pageSize == -1) {
            pageSize = unsafe.pageSize();
        }
        return pageSize;
    }
}
