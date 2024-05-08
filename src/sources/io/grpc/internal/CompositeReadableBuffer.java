package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CompositeReadableBuffer extends AbstractReadableBuffer {
    private boolean marked;
    private final Deque<ReadableBuffer> readableBuffers;
    private int readableBytes;
    private Deque<ReadableBuffer> rewindableBuffers;
    private static final NoThrowReadOperation<Void> UBYTE_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.1
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i10, Void r32, int i11) {
            return readableBuffer.readUnsignedByte();
        }
    };
    private static final NoThrowReadOperation<Void> SKIP_OP = new NoThrowReadOperation<Void>() { // from class: io.grpc.internal.CompositeReadableBuffer.2
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i10, Void r32, int i11) {
            readableBuffer.skipBytes(i10);
            return 0;
        }
    };
    private static final NoThrowReadOperation<byte[]> BYTE_ARRAY_OP = new NoThrowReadOperation<byte[]>() { // from class: io.grpc.internal.CompositeReadableBuffer.3
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i10, byte[] bArr, int i11) {
            readableBuffer.readBytes(bArr, i11, i10);
            return i11 + i10;
        }
    };
    private static final NoThrowReadOperation<ByteBuffer> BYTE_BUF_OP = new NoThrowReadOperation<ByteBuffer>() { // from class: io.grpc.internal.CompositeReadableBuffer.4
        @Override // io.grpc.internal.CompositeReadableBuffer.NoThrowReadOperation, io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i10, ByteBuffer byteBuffer, int i11) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            readableBuffer.readBytes(byteBuffer);
            byteBuffer.limit(limit);
            return 0;
        }
    };
    private static final ReadOperation<OutputStream> STREAM_OP = new ReadOperation<OutputStream>() { // from class: io.grpc.internal.CompositeReadableBuffer.5
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        public int read(ReadableBuffer readableBuffer, int i10, OutputStream outputStream, int i11) throws IOException {
            readableBuffer.readBytes(outputStream, i10);
            return 0;
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface NoThrowReadOperation<T> extends ReadOperation<T> {
        @Override // io.grpc.internal.CompositeReadableBuffer.ReadOperation
        int read(ReadableBuffer readableBuffer, int i10, T t2, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ReadOperation<T> {
        int read(ReadableBuffer readableBuffer, int i10, T t2, int i11) throws IOException;
    }

    public CompositeReadableBuffer(int i10) {
        this.readableBuffers = new ArrayDeque(i10);
    }

    private void advanceBuffer() {
        if (this.marked) {
            this.rewindableBuffers.add(this.readableBuffers.remove());
            ReadableBuffer peek = this.readableBuffers.peek();
            if (peek != null) {
                peek.mark();
                return;
            }
            return;
        }
        this.readableBuffers.remove().close();
    }

    private void advanceBufferIfNecessary() {
        if (this.readableBuffers.peek().readableBytes() == 0) {
            advanceBuffer();
        }
    }

    private void enqueueBuffer(ReadableBuffer readableBuffer) {
        if (!(readableBuffer instanceof CompositeReadableBuffer)) {
            this.readableBuffers.add(readableBuffer);
            this.readableBytes += readableBuffer.readableBytes();
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = (CompositeReadableBuffer) readableBuffer;
        while (!compositeReadableBuffer.readableBuffers.isEmpty()) {
            this.readableBuffers.add(compositeReadableBuffer.readableBuffers.remove());
        }
        this.readableBytes += compositeReadableBuffer.readableBytes;
        compositeReadableBuffer.readableBytes = 0;
        compositeReadableBuffer.close();
    }

    private <T> int execute(ReadOperation<T> readOperation, int i10, T t2, int i11) throws IOException {
        checkReadable(i10);
        if (!this.readableBuffers.isEmpty()) {
            advanceBufferIfNecessary();
        }
        while (i10 > 0 && !this.readableBuffers.isEmpty()) {
            ReadableBuffer peek = this.readableBuffers.peek();
            int min = Math.min(i10, peek.readableBytes());
            i11 = readOperation.read(peek, min, t2, i11);
            i10 -= min;
            this.readableBytes -= min;
            advanceBufferIfNecessary();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError((Object) "Failed executing read operation");
    }

    private <T> int executeNoThrow(NoThrowReadOperation<T> noThrowReadOperation, int i10, T t2, int i11) {
        try {
            return execute(noThrowReadOperation, i10, t2, i11);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public void addBuffer(ReadableBuffer readableBuffer) {
        boolean z10 = this.marked && this.readableBuffers.isEmpty();
        enqueueBuffer(readableBuffer);
        if (z10) {
            this.readableBuffers.peek().mark();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        Iterator<ReadableBuffer> iterator2 = this.readableBuffers.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().byteBufferSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.readableBuffers.isEmpty()) {
            this.readableBuffers.remove().close();
        }
        if (this.rewindableBuffers != null) {
            while (!this.rewindableBuffers.isEmpty()) {
                this.rewindableBuffers.remove().close();
            }
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public ByteBuffer getByteBuffer() {
        if (this.readableBuffers.isEmpty()) {
            return null;
        }
        return this.readableBuffers.peek().getByteBuffer();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void mark() {
        if (this.rewindableBuffers == null) {
            this.rewindableBuffers = new ArrayDeque(Math.min(this.readableBuffers.size(), 16));
        }
        while (!this.rewindableBuffers.isEmpty()) {
            this.rewindableBuffers.remove().close();
        }
        this.marked = true;
        ReadableBuffer peek = this.readableBuffers.peek();
        if (peek != null) {
            peek.mark();
        }
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        Iterator<ReadableBuffer> iterator2 = this.readableBuffers.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i10, int i11) {
        executeNoThrow(BYTE_ARRAY_OP, i11, bArr, i10);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return executeNoThrow(UBYTE_OP, 1, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void reset() {
        if (this.marked) {
            ReadableBuffer peek = this.readableBuffers.peek();
            if (peek != null) {
                int readableBytes = peek.readableBytes();
                peek.reset();
                this.readableBytes += peek.readableBytes() - readableBytes;
            }
            while (true) {
                ReadableBuffer pollLast = this.rewindableBuffers.pollLast();
                if (pollLast == null) {
                    return;
                }
                pollLast.reset();
                this.readableBuffers.addFirst(pollLast);
                this.readableBytes += pollLast.readableBytes();
            }
        } else {
            throw new InvalidMarkException();
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i10) {
        executeNoThrow(SKIP_OP, i10, null, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        executeNoThrow(BYTE_BUF_OP, byteBuffer.remaining(), byteBuffer, 0);
    }

    public CompositeReadableBuffer() {
        this.readableBuffers = new ArrayDeque();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i10) throws IOException {
        execute(STREAM_OP, i10, outputStream, 0);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i10) {
        ReadableBuffer poll;
        int i11;
        ReadableBuffer readableBuffer;
        if (i10 <= 0) {
            return ReadableBuffers.empty();
        }
        checkReadable(i10);
        this.readableBytes -= i10;
        ReadableBuffer readableBuffer2 = null;
        CompositeReadableBuffer compositeReadableBuffer = null;
        while (true) {
            ReadableBuffer peek = this.readableBuffers.peek();
            int readableBytes = peek.readableBytes();
            if (readableBytes > i10) {
                readableBuffer = peek.readBytes(i10);
                i11 = 0;
            } else {
                if (this.marked) {
                    poll = peek.readBytes(readableBytes);
                    advanceBuffer();
                } else {
                    poll = this.readableBuffers.poll();
                }
                ReadableBuffer readableBuffer3 = poll;
                i11 = i10 - readableBytes;
                readableBuffer = readableBuffer3;
            }
            if (readableBuffer2 == null) {
                readableBuffer2 = readableBuffer;
            } else {
                if (compositeReadableBuffer == null) {
                    compositeReadableBuffer = new CompositeReadableBuffer(i11 != 0 ? Math.min(this.readableBuffers.size() + 2, 16) : 2);
                    compositeReadableBuffer.addBuffer(readableBuffer2);
                    readableBuffer2 = compositeReadableBuffer;
                }
                compositeReadableBuffer.addBuffer(readableBuffer);
            }
            if (i11 <= 0) {
                return readableBuffer2;
            }
            i10 = i11;
        }
    }
}
