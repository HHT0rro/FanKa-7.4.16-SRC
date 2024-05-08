package java.nio;

import dalvik.system.VMRuntime;
import java.io.FileDescriptor;
import java.util.Objects;
import libcore.io.Memory;
import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DirectByteBuffer extends MappedByteBuffer implements DirectBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final Cleaner cleaner;
    final MemoryRef memoryRef;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class MemoryRef {
        long allocatedAddress;
        byte[] buffer;
        boolean isAccessible;
        boolean isFreed;
        final int offset;
        final Object originalBufferObject;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MemoryRef(int capacity) {
            VMRuntime runtime = VMRuntime.getRuntime();
            byte[] bArr = (byte[]) runtime.newNonMovableArray(Byte.TYPE, capacity + 7);
            this.buffer = bArr;
            long addressOf = runtime.addressOf(bArr);
            this.allocatedAddress = addressOf;
            this.offset = (int) (((7 + addressOf) & (-8)) - addressOf);
            this.isAccessible = true;
            this.isFreed = false;
            this.originalBufferObject = null;
        }

        MemoryRef(long allocatedAddress, Object originalBufferObject) {
            this.buffer = null;
            this.allocatedAddress = allocatedAddress;
            this.offset = 0;
            this.originalBufferObject = originalBufferObject;
            this.isAccessible = true;
        }

        void free() {
            this.buffer = null;
            this.allocatedAddress = 0L;
            this.isAccessible = false;
            this.isFreed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DirectByteBuffer(int capacity, MemoryRef memoryRef) {
        super(-1, 0, capacity, capacity, memoryRef.buffer, memoryRef.offset);
        this.memoryRef = memoryRef;
        this.address = memoryRef.allocatedAddress + memoryRef.offset;
        this.cleaner = null;
        this.isReadOnly = false;
    }

    private DirectByteBuffer(long addr, int cap) {
        super(-1, 0, cap, cap);
        this.memoryRef = new MemoryRef(addr, this);
        this.address = addr;
        this.cleaner = null;
    }

    public DirectByteBuffer(int cap, long addr, FileDescriptor fd2, Runnable unmapper, boolean isReadOnly) {
        super(-1, 0, cap, cap, fd2);
        this.isReadOnly = isReadOnly;
        MemoryRef memoryRef = new MemoryRef(addr, null);
        this.memoryRef = memoryRef;
        this.address = addr;
        this.cleaner = Cleaner.create(memoryRef, unmapper);
    }

    DirectByteBuffer(MemoryRef memoryRef, int mark, int pos, int lim, int cap, int off) {
        this(memoryRef, mark, pos, lim, cap, off, false);
    }

    DirectByteBuffer(MemoryRef memoryRef, int mark, int pos, int lim, int cap, int off, boolean isReadOnly) {
        super(mark, pos, lim, cap, memoryRef.buffer, off);
        this.isReadOnly = isReadOnly;
        this.memoryRef = memoryRef;
        this.address = memoryRef.allocatedAddress + off;
        this.cleaner = null;
    }

    @Override // sun.nio.ch.DirectBuffer
    public final Object attachment() {
        return this.memoryRef;
    }

    @Override // sun.nio.ch.DirectBuffer
    public final Cleaner cleaner() {
        return this.cleaner;
    }

    @Override // java.nio.MappedByteBuffer, java.nio.ByteBuffer, java.nio.Buffer
    public final MappedByteBuffer slice() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        int off = this.offset + pos;
        return new DirectByteBuffer(this.memoryRef, -1, 0, rem, rem, off, this.isReadOnly);
    }

    @Override // java.nio.MappedByteBuffer, java.nio.ByteBuffer, java.nio.Buffer
    public final MappedByteBuffer slice(int index, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Objects.checkFromIndexSize(index, length, limit());
        return new DirectByteBuffer(this.memoryRef, -1, 0, length, length, index << 0, this.isReadOnly);
    }

    @Override // java.nio.MappedByteBuffer, java.nio.ByteBuffer, java.nio.Buffer
    public final MappedByteBuffer duplicate() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        return new DirectByteBuffer(this.memoryRef, markValue(), position(), limit(), capacity(), this.offset, this.isReadOnly);
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer asReadOnlyBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        return new DirectByteBuffer(this.memoryRef, markValue(), position(), limit(), capacity(), this.offset, true);
    }

    @Override // sun.nio.ch.DirectBuffer
    public final long address() {
        return this.address;
    }

    private long ix(int i10) {
        return this.address + i10;
    }

    private byte get(long a10) {
        return Memory.peekByte(a10);
    }

    @Override // java.nio.ByteBuffer
    public final byte get() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return get(ix(nextGetIndex()));
    }

    @Override // java.nio.ByteBuffer
    public final byte get(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return get(ix(checkIndex(i10)));
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer get(byte[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        checkBounds(dstOffset, length, dst.length);
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (length > rem) {
            throw new BufferUnderflowException();
        }
        Memory.peekByteArray(ix(pos), dst, dstOffset, length);
        this.position = pos + length;
        return this;
    }

    private ByteBuffer put(long a10, byte x10) {
        Memory.pokeByte(a10, x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(ByteBuffer src) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return super.put(src);
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer put(byte x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        put(ix(nextPutIndex()), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer put(int i10, byte x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        put(ix(checkIndex(i10)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public ByteBuffer put(byte[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        checkBounds(srcOffset, length, src.length);
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        if (length > rem) {
            throw new BufferOverflowException();
        }
        Memory.pokeByteArray(ix(pos), src, srcOffset, length);
        this.position = pos + length;
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer compact() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        int pos = position();
        int lim = limit();
        int rem = pos <= lim ? lim - pos : 0;
        System.arraycopy((Object) this.f50371hb, this.position + this.offset, (Object) this.f50371hb, this.offset, remaining());
        position(rem);
        limit(capacity());
        discardMark();
        return this;
    }

    @Override // java.nio.ByteBuffer, java.nio.Buffer
    public final boolean isDirect() {
        return true;
    }

    @Override // java.nio.Buffer
    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final byte _get(int i10) {
        return get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void _put(int i10, byte b4) {
        put(i10, b4);
    }

    @Override // java.nio.ByteBuffer
    public final char getChar() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        int newPosition = this.position + 2;
        if (newPosition > limit()) {
            throw new BufferUnderflowException();
        }
        char x10 = (char) Memory.peekShort(ix(this.position), !this.nativeByteOrder);
        this.position = newPosition;
        return x10;
    }

    @Override // java.nio.ByteBuffer
    public final char getChar(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        checkIndex(i10, 2);
        return (char) Memory.peekShort(ix(i10), !this.nativeByteOrder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public char getCharUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return (char) Memory.peekShort(ix(i10), !this.nativeByteOrder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, char[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekCharArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putChar(long a10, char x10) {
        Memory.pokeShort(a10, (short) x10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putChar(char x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putChar(ix(nextPutIndex(2)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putChar(int i10, char x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putChar(ix(checkIndex(i10, 2)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putCharUnchecked(int i10, char x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putChar(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, char[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeCharArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final CharBuffer asCharBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 1;
        return new ByteBufferAsCharBuffer(this, -1, 0, size, size, off, order());
    }

    private short getShort(long a10) {
        return Memory.peekShort(a10, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final short getShort() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getShort(ix(nextGetIndex(2)));
    }

    @Override // java.nio.ByteBuffer
    public final short getShort(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getShort(ix(checkIndex(i10, 2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public short getShortUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getShort(ix(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void getUnchecked(int pos, short[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekShortArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putShort(long a10, short x10) {
        Memory.pokeShort(a10, x10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putShort(short x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putShort(ix(nextPutIndex(2)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putShort(int i10, short x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putShort(ix(checkIndex(i10, 2)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putShortUnchecked(int i10, short x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putShort(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public void putUnchecked(int pos, short[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeShortArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final ShortBuffer asShortBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 1;
        return new ByteBufferAsShortBuffer(this, -1, 0, size, size, off, order());
    }

    private int getInt(long a10) {
        return Memory.peekInt(a10, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public int getInt() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getInt(ix(nextGetIndex(4)));
    }

    @Override // java.nio.ByteBuffer
    public int getInt(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getInt(ix(checkIndex(i10, 4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final int getIntUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getInt(ix(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void getUnchecked(int pos, int[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekIntArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putInt(long a10, int x10) {
        Memory.pokeInt(a10, x10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putInt(int x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putInt(ix(nextPutIndex(4)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putInt(int i10, int x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putInt(ix(checkIndex(i10, 4)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putIntUnchecked(int i10, int x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putInt(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putUnchecked(int pos, int[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeIntArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final IntBuffer asIntBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 2;
        return new ByteBufferAsIntBuffer(this, -1, 0, size, size, off, order());
    }

    private long getLong(long a10) {
        return Memory.peekLong(a10, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final long getLong() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getLong(ix(nextGetIndex(8)));
    }

    @Override // java.nio.ByteBuffer
    public final long getLong(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getLong(ix(checkIndex(i10, 8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final long getLongUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getLong(ix(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void getUnchecked(int pos, long[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekLongArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putLong(long a10, long x10) {
        Memory.pokeLong(a10, x10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putLong(long x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putLong(ix(nextPutIndex(8)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putLong(int i10, long x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putLong(ix(checkIndex(i10, 8)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putLongUnchecked(int i10, long x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putLong(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putUnchecked(int pos, long[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeLongArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final LongBuffer asLongBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 3;
        return new ByteBufferAsLongBuffer(this, -1, 0, size, size, off, order());
    }

    private float getFloat(long a10) {
        int x10 = Memory.peekInt(a10, !this.nativeByteOrder);
        return Float.intBitsToFloat(x10);
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getFloat(ix(nextGetIndex(4)));
    }

    @Override // java.nio.ByteBuffer
    public final float getFloat(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getFloat(ix(checkIndex(i10, 4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final float getFloatUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getFloat(ix(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void getUnchecked(int pos, float[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekFloatArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putFloat(long a10, float x10) {
        int y10 = Float.floatToRawIntBits(x10);
        Memory.pokeInt(a10, y10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putFloat(float x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putFloat(ix(nextPutIndex(4)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putFloat(int i10, float x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putFloat(ix(checkIndex(i10, 4)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putFloatUnchecked(int i10, float x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putFloat(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putUnchecked(int pos, float[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeFloatArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final FloatBuffer asFloatBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 2;
        return new ByteBufferAsFloatBuffer(this, -1, 0, size, size, off, order());
    }

    private double getDouble(long a10) {
        long x10 = Memory.peekLong(a10, !this.nativeByteOrder);
        return Double.longBitsToDouble(x10);
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble() {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getDouble(ix(nextGetIndex(8)));
    }

    @Override // java.nio.ByteBuffer
    public final double getDouble(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getDouble(ix(checkIndex(i10, 8)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final double getDoubleUnchecked(int i10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        return getDouble(ix(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void getUnchecked(int pos, double[] dst, int dstOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.peekDoubleArray(ix(pos), dst, dstOffset, length, !this.nativeByteOrder);
    }

    private ByteBuffer putDouble(long a10, double x10) {
        long y10 = Double.doubleToRawLongBits(x10);
        Memory.pokeLong(a10, y10, !this.nativeByteOrder);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putDouble(double x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putDouble(ix(nextPutIndex(8)), x10);
        return this;
    }

    @Override // java.nio.ByteBuffer
    public final ByteBuffer putDouble(int i10, double x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        if (this.isReadOnly) {
            throw new ReadOnlyBufferException();
        }
        putDouble(ix(checkIndex(i10, 8)), x10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putDoubleUnchecked(int i10, double x10) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        putDouble(ix(i10), x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.nio.ByteBuffer
    public final void putUnchecked(int pos, double[] src, int srcOffset, int length) {
        if (!this.memoryRef.isAccessible) {
            throw new IllegalStateException("buffer is inaccessible");
        }
        Memory.pokeDoubleArray(ix(pos), src, srcOffset, length, !this.nativeByteOrder);
    }

    @Override // java.nio.ByteBuffer
    public final DoubleBuffer asDoubleBuffer() {
        if (this.memoryRef.isFreed) {
            throw new IllegalStateException("buffer has been freed");
        }
        int off = position();
        int lim = limit();
        int rem = off <= lim ? lim - off : 0;
        int size = rem >> 3;
        return new ByteBufferAsDoubleBuffer(this, -1, 0, size, size, off, order());
    }

    @Override // java.nio.ByteBuffer
    public final boolean isAccessible() {
        return this.memoryRef.isAccessible;
    }

    @Override // java.nio.ByteBuffer
    public final void setAccessible(boolean value) {
        this.memoryRef.isAccessible = value;
    }
}
