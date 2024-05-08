package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i10, final int i11) {
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.2
            private int position;

            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i10;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int limit() {
                return i11;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int remaining() {
                return i11 - this.position;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i12) {
                if (i12 >= 0 && i12 <= i11) {
                    this.position = i12;
                    return this;
                }
                throw new IllegalArgumentException("Invalid position: " + i12);
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i10);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0 && i10 + i11 <= bArr.length) {
            return wrapNoCheck(bArr, i10, i11);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.1
            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] array() {
                return ByteBuffer.this.array();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return ByteBuffer.this.arrayOffset();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return ByteBuffer.this.hasArray();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int limit() {
                return ByteBuffer.this.limit();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return ByteBuffer.this;
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int position() {
                return ByteBuffer.this.position();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public int remaining() {
                return ByteBuffer.this.remaining();
            }

            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i10) {
                ByteBuffer.this.position(i10);
                return this;
            }
        };
    }
}
