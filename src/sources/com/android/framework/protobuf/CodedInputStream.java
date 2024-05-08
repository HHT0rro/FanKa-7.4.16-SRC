package com.android.framework.protobuf;

import com.android.framework.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    public abstract void checkLastTagWas(int i10) throws InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean z10);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i10);

    public abstract int pushLimit(int i10) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i10, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i10, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i10) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i10, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(int i10) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i10, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i10) throws IOException;

    public static CodedInputStream newInstance(InputStream input) {
        return newInstance(input, 4096);
    }

    public static CodedInputStream newInstance(InputStream input, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        }
        if (input == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        }
        return new StreamDecoder(input, bufferSize);
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> input) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(input));
        }
        return newInstance(input, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(Iterable<ByteBuffer> bufs, boolean bufferIsImmutable) {
        int flag = 0;
        int totalSize = 0;
        for (ByteBuffer buf : bufs) {
            totalSize += buf.remaining();
            if (buf.hasArray()) {
                flag |= 1;
            } else if (buf.isDirect()) {
                flag |= 2;
            } else {
                flag |= 4;
            }
        }
        if (flag == 2) {
            return new IterableDirectByteBufferDecoder(bufs, totalSize, bufferIsImmutable);
        }
        return newInstance(new IterableByteBufferInputStream(bufs));
    }

    public static CodedInputStream newInstance(byte[] buf) {
        return newInstance(buf, 0, buf.length);
    }

    public static CodedInputStream newInstance(byte[] buf, int off, int len) {
        return newInstance(buf, off, len, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(byte[] buf, int off, int len, boolean bufferIsImmutable) {
        ArrayDecoder result = new ArrayDecoder(buf, off, len, bufferIsImmutable);
        try {
            result.pushLimit(len);
            return result;
        } catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer buf) {
        return newInstance(buf, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(ByteBuffer buf, boolean bufferIsImmutable) {
        if (buf.hasArray()) {
            return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining(), bufferIsImmutable);
        }
        if (buf.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(buf, bufferIsImmutable);
        }
        byte[] buffer = new byte[buf.remaining()];
        buf.duplicate().get(buffer);
        return newInstance(buffer, 0, buffer.length, true);
    }

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
        }
        int oldLimit = this.recursionLimit;
        this.recursionLimit = limit;
        return oldLimit;
    }

    public final int setSizeLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
        }
        int oldLimit = this.sizeLimit;
        this.sizeLimit = limit;
        return oldLimit;
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int decodeZigZag32(int n10) {
        return (n10 >>> 1) ^ (-(n10 & 1));
    }

    public static long decodeZigZag64(long n10) {
        return (n10 >>> 1) ^ (-(1 & n10));
    }

    public static int readRawVarint32(int firstByte, InputStream input) throws IOException {
        if ((firstByte & 128) == 0) {
            return firstByte;
        }
        int result = firstByte & 127;
        int offset = 7;
        while (offset < 32) {
            int b4 = input.read();
            if (b4 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            result |= (b4 & 127) << offset;
            if ((b4 & 128) != 0) {
                offset += 7;
            } else {
                return result;
            }
        }
        while (offset < 64) {
            int b10 = input.read();
            if (b10 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((b10 & 128) != 0) {
                offset += 7;
            } else {
                return result;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream input) throws IOException {
        int firstByte = input.read();
        if (firstByte == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(firstByte, input);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] buffer, int offset, int len, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.limit = offset + len;
            this.pos = offset;
            this.startPos = offset;
            this.immutable = immutable;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeUInt32NoTag(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeUInt32NoTag(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeUInt32NoTag(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeUInt32NoTag(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (size <= i10 - i11) {
                    String result = new String(this.buffer, i11, size, Internal.UTF_8);
                    this.pos += size;
                    return result;
                }
            }
            if (size == 0) {
                return "";
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (size <= i10 - i11) {
                    String result = Utf8.decodeUtf8(this.buffer, i11, size);
                    this.pos += size;
                    return result;
                }
            }
            if (size == 0) {
                return "";
            }
            if (size <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            ByteString result;
            int size = readRawVarint32();
            if (size > 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (size <= i10 - i11) {
                    if (this.immutable && this.enableAliasing) {
                        result = ByteString.wrap(this.buffer, i11, size);
                    } else {
                        result = ByteString.copyFrom(this.buffer, i11, size);
                    }
                    this.pos += size;
                    return result;
                }
            }
            if (size == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytes(size));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int size = readRawVarint32();
            return readRawBytes(size);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer result;
            int size = readRawVarint32();
            if (size > 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (size <= i10 - i11) {
                    if (!this.immutable && this.enableAliasing) {
                        result = ByteBuffer.wrap(this.buffer, i11, size).slice();
                    } else {
                        result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i11, i11 + size));
                    }
                    this.pos += size;
                    return result;
                }
            }
            if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
        
            if (r2[r1] < 0) goto L33;
         */
        @Override // com.android.framework.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.pos
                int r1 = r6.limit
                if (r1 != r0) goto L8
                goto L72
            L8:
                byte[] r2 = r6.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                r4 = r0
                if (r0 < 0) goto L14
                r6.pos = r3
                return r4
            L14:
                int r1 = r1 - r3
                r0 = 9
                if (r1 >= r0) goto L1a
                goto L72
            L1a:
                int r0 = r3 + 1
                r1 = r2[r3]
                int r1 = r1 << 7
                r1 = r1 ^ r4
                r3 = r1
                if (r1 >= 0) goto L27
                r1 = r3 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L7d
            L27:
                int r1 = r0 + 1
                r0 = r2[r0]
                int r0 = r0 << 14
                r0 = r0 ^ r3
                r3 = r0
                if (r0 < 0) goto L37
                r0 = r3 ^ 16256(0x3f80, float:2.278E-41)
                r5 = r1
                r1 = r0
                r0 = r5
                goto L7d
            L37:
                int r0 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 21
                r1 = r1 ^ r3
                r3 = r1
                if (r1 >= 0) goto L46
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r1 = r1 ^ r3
                goto L7d
            L46:
                int r1 = r0 + 1
                r0 = r2[r0]
                int r4 = r0 << 28
                r3 = r3 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r3 = r3 ^ r4
                if (r0 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
                int r1 = r4 + 1
                r4 = r2[r4]
                if (r4 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
                int r1 = r4 + 1
                r4 = r2[r4]
                if (r4 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
            L72:
                long r0 = r6.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L78:
                r1 = r3
                r0 = r4
                goto L7d
            L7b:
                r0 = r1
                r1 = r3
            L7d:
                r6.pos = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.buffer;
                int i11 = this.pos;
                this.pos = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        
            if (r2[r1] < 0) goto L37;
         */
        @Override // com.android.framework.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b4 = readRawByte();
                result |= (b4 & Byte.MAX_VALUE) << shift;
                if ((b4 & 128) == 0) {
                    return result;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if (this.limit - tempPos < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if (this.limit - tempPos < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24) | ((buffer[tempPos + 4] & 255) << 32) | ((buffer[tempPos + 5] & 255) << 40) | ((buffer[tempPos + 6] & 255) << 48) | ((buffer[tempPos + 7] & 255) << 56);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            if (byteLimit2 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i10 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i10;
            int bufferEnd = i10 - this.startPos;
            int i11 = this.currentLimit;
            if (bufferEnd > i11) {
                int i12 = bufferEnd - i11;
                this.bufferSizeAfterLimit = i12;
                this.limit = i10 - i12;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i10 = this.currentLimit;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - getTotalBytesRead();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int i10 = this.pos;
            if (i10 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i10 + 1;
            return bArr[i10];
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length > 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (length <= i10 - i11) {
                    int tempPos = this.pos;
                    int i12 = i11 + length;
                    this.pos = i12;
                    return Arrays.copyOfRange(this.buffer, tempPos, i12);
                }
            }
            if (length <= 0) {
                if (length == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0) {
                int i10 = this.limit;
                int i11 = this.pos;
                if (length <= i10 - i11) {
                    this.pos = i11 + length;
                    return;
                }
            }
            if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer buffer, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            long addressOffset = UnsafeUtil.addressOffset(buffer);
            this.address = addressOffset;
            this.limit = buffer.limit() + addressOffset;
            long position = addressOffset + buffer.position();
            this.pos = position;
            this.startPos = position;
            this.immutable = immutable;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeUInt32NoTag(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeUInt32NoTag(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeUInt32NoTag(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeUInt32NoTag(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0L, size);
                String result = new String(bytes, Internal.UTF_8);
                this.pos += size;
                return result;
            }
            if (size == 0) {
                return "";
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                int bufferPos = bufferPos(this.pos);
                String result = Utf8.decodeUtf8(this.buffer, bufferPos, size);
                this.pos += size;
                return result;
            }
            if (size == 0) {
                return "";
            }
            if (size <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                if (this.immutable && this.enableAliasing) {
                    long j10 = this.pos;
                    ByteBuffer result = slice(j10, size + j10);
                    this.pos += size;
                    return ByteString.wrap(result);
                }
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0L, size);
                this.pos += size;
                return ByteString.wrap(bytes);
            }
            if (size == 0) {
                return ByteString.EMPTY;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                if (!this.immutable && this.enableAliasing) {
                    long j10 = this.pos;
                    ByteBuffer result = slice(j10, size + j10);
                    this.pos += size;
                    return result;
                }
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0L, size);
                this.pos += size;
                return ByteBuffer.wrap(bytes);
            }
            if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int y10;
            long tempPos = this.pos;
            if (this.limit != tempPos) {
                long tempPos2 = tempPos + 1;
                int x10 = UnsafeUtil.getByte(tempPos);
                if (x10 >= 0) {
                    this.pos = tempPos2;
                    return x10;
                }
                if (this.limit - tempPos2 >= 9) {
                    long tempPos3 = tempPos2 + 1;
                    int x11 = (UnsafeUtil.getByte(tempPos2) << 7) ^ x10;
                    if (x11 < 0) {
                        y10 = x11 ^ (-128);
                    } else {
                        long tempPos4 = tempPos3 + 1;
                        int x12 = (UnsafeUtil.getByte(tempPos3) << 14) ^ x11;
                        if (x12 >= 0) {
                            y10 = x12 ^ 16256;
                            tempPos3 = tempPos4;
                        } else {
                            tempPos3 = tempPos4 + 1;
                            int x13 = (UnsafeUtil.getByte(tempPos4) << 21) ^ x12;
                            if (x13 < 0) {
                                y10 = (-2080896) ^ x13;
                            } else {
                                long tempPos5 = tempPos3 + 1;
                                int y11 = UnsafeUtil.getByte(tempPos3);
                                int x14 = (x13 ^ (y11 << 28)) ^ 266354560;
                                if (y11 < 0) {
                                    tempPos3 = tempPos5 + 1;
                                    if (UnsafeUtil.getByte(tempPos5) < 0) {
                                        long tempPos6 = tempPos3 + 1;
                                        if (UnsafeUtil.getByte(tempPos3) < 0) {
                                            tempPos3 = tempPos6 + 1;
                                            if (UnsafeUtil.getByte(tempPos6) < 0) {
                                                long tempPos7 = tempPos3 + 1;
                                                if (UnsafeUtil.getByte(tempPos3) < 0) {
                                                    tempPos3 = tempPos7 + 1;
                                                    if (UnsafeUtil.getByte(tempPos7) >= 0) {
                                                        y10 = x14;
                                                    }
                                                } else {
                                                    y10 = x14;
                                                    tempPos3 = tempPos7;
                                                }
                                            } else {
                                                y10 = x14;
                                            }
                                        } else {
                                            y10 = x14;
                                            tempPos3 = tempPos6;
                                        }
                                    } else {
                                        y10 = x14;
                                    }
                                } else {
                                    y10 = x14;
                                    tempPos3 = tempPos5;
                                }
                            }
                        }
                    }
                    this.pos = tempPos3;
                    return y10;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                long j10 = this.pos;
                this.pos = 1 + j10;
                if (UnsafeUtil.getByte(j10) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long x10;
            long tempPos = this.pos;
            if (this.limit != tempPos) {
                long tempPos2 = tempPos + 1;
                int y10 = UnsafeUtil.getByte(tempPos);
                if (y10 >= 0) {
                    this.pos = tempPos2;
                    return y10;
                }
                if (this.limit - tempPos2 >= 9) {
                    long tempPos3 = tempPos2 + 1;
                    int y11 = (UnsafeUtil.getByte(tempPos2) << 7) ^ y10;
                    if (y11 < 0) {
                        x10 = y11 ^ (-128);
                    } else {
                        long tempPos4 = tempPos3 + 1;
                        int y12 = (UnsafeUtil.getByte(tempPos3) << 14) ^ y11;
                        if (y12 >= 0) {
                            x10 = y12 ^ 16256;
                            tempPos3 = tempPos4;
                        } else {
                            tempPos3 = tempPos4 + 1;
                            int y13 = (UnsafeUtil.getByte(tempPos4) << 21) ^ y12;
                            if (y13 >= 0) {
                                long tempPos5 = tempPos3 + 1;
                                long x11 = y13 ^ (UnsafeUtil.getByte(tempPos3) << 28);
                                if (x11 >= 0) {
                                    x10 = 266354560 ^ x11;
                                    tempPos3 = tempPos5;
                                } else {
                                    long tempPos6 = tempPos5 + 1;
                                    long x12 = (UnsafeUtil.getByte(tempPos5) << 35) ^ x11;
                                    if (x12 < 0) {
                                        x10 = (-34093383808L) ^ x12;
                                        tempPos3 = tempPos6;
                                    } else {
                                        long tempPos7 = tempPos6 + 1;
                                        long x13 = (UnsafeUtil.getByte(tempPos6) << 42) ^ x12;
                                        if (x13 >= 0) {
                                            x10 = 4363953127296L ^ x13;
                                            tempPos3 = tempPos7;
                                        } else {
                                            long tempPos8 = tempPos7 + 1;
                                            long x14 = (UnsafeUtil.getByte(tempPos7) << 49) ^ x13;
                                            if (x14 < 0) {
                                                x10 = (-558586000294016L) ^ x14;
                                                tempPos3 = tempPos8;
                                            } else {
                                                long tempPos9 = tempPos8 + 1;
                                                long x15 = ((UnsafeUtil.getByte(tempPos8) << 56) ^ x14) ^ 71499008037633920L;
                                                if (x15 >= 0) {
                                                    x10 = x15;
                                                    tempPos3 = tempPos9;
                                                } else {
                                                    tempPos3 = tempPos9 + 1;
                                                    if (UnsafeUtil.getByte(tempPos9) >= 0) {
                                                        x10 = x15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                x10 = (-2080896) ^ y13;
                            }
                        }
                    }
                    this.pos = tempPos3;
                    return x10;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b4 = readRawByte();
                result |= (b4 & Byte.MAX_VALUE) << shift;
                if ((b4 & 128) == 0) {
                    return result;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long tempPos = this.pos;
            if (this.limit - tempPos < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 4 + tempPos;
            return (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(1 + tempPos) & 255) << 8) | ((UnsafeUtil.getByte(2 + tempPos) & 255) << 16) | ((UnsafeUtil.getByte(3 + tempPos) & 255) << 24);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long tempPos = this.pos;
            if (this.limit - tempPos < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 8 + tempPos;
            return (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(1 + tempPos) & 255) << 8) | ((UnsafeUtil.getByte(2 + tempPos) & 255) << 16) | ((UnsafeUtil.getByte(3 + tempPos) & 255) << 24) | ((UnsafeUtil.getByte(4 + tempPos) & 255) << 32) | ((UnsafeUtil.getByte(5 + tempPos) & 255) << 40) | ((UnsafeUtil.getByte(6 + tempPos) & 255) << 48) | ((255 & UnsafeUtil.getByte(7 + tempPos)) << 56);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i10 = this.currentLimit;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - getTotalBytesRead();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long j10 = this.pos;
            if (j10 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = 1 + j10;
            return UnsafeUtil.getByte(j10);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                byte[] bytes = new byte[length];
                long j10 = this.pos;
                slice(j10, length + j10).get(bytes);
                this.pos += length;
                return bytes;
            }
            if (length <= 0) {
                if (length == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                this.pos += length;
            } else {
                if (length < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            long j10 = this.limit + this.bufferSizeAfterLimit;
            this.limit = j10;
            int bufferEnd = (int) (j10 - this.startPos);
            int i10 = this.currentLimit;
            if (bufferEnd > i10) {
                int i11 = bufferEnd - i10;
                this.bufferSizeAfterLimit = i11;
                this.limit = j10 - i11;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }

        private ByteBuffer slice(long begin, long end) throws IOException {
            int prevPos = this.buffer.position();
            int prevLimit = this.buffer.limit();
            Buffer asBuffer = this.buffer;
            try {
                try {
                    asBuffer.position(bufferPos(begin));
                    asBuffer.limit(bufferPos(end));
                    return this.buffer.slice();
                } catch (IllegalArgumentException e2) {
                    InvalidProtocolBufferException ex = InvalidProtocolBufferException.truncatedMessage();
                    ex.initCause(e2);
                    throw ex;
                }
            } finally {
                asBuffer.position(prevPos);
                asBuffer.limit(prevLimit);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public interface RefillCallback {
            void onRefill();
        }

        private StreamDecoder(InputStream input, int bufferSize) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(input, "input");
            this.input = input;
            this.buffer = new byte[bufferSize];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int read(InputStream input, byte[] data, int offset, int length) throws IOException {
            try {
                return input.read(data, offset, length);
            } catch (InvalidProtocolBufferException e2) {
                e2.setThrownFromInputStream();
                throw e2;
            }
        }

        private static long skip(InputStream input, long length) throws IOException {
            try {
                return input.skip(length);
            } catch (InvalidProtocolBufferException e2) {
                e2.setThrownFromInputStream();
                throw e2;
            }
        }

        private static int available(InputStream input) throws IOException {
            try {
                return input.available();
            } catch (InvalidProtocolBufferException e2) {
                e2.setThrownFromInputStream();
                throw e2;
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeUInt32NoTag(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeUInt32NoTag(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeUInt32NoTag(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeUInt32NoTag(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            @Override // com.android.framework.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }

            ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                int i10 = this.bufferSize;
                int i11 = this.pos;
                if (size <= i10 - i11) {
                    String result = new String(this.buffer, i11, size, Internal.UTF_8);
                    this.pos += size;
                    return result;
                }
            }
            if (size == 0) {
                return "";
            }
            if (size <= this.bufferSize) {
                refillBuffer(size);
                String result2 = new String(this.buffer, this.pos, size, Internal.UTF_8);
                this.pos += size;
                return result2;
            }
            return new String(readRawBytesSlowPath(size, false), Internal.UTF_8);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] bytes;
            int tempPos;
            int size = readRawVarint32();
            int oldPos = this.pos;
            int i10 = this.bufferSize;
            if (size <= i10 - oldPos && size > 0) {
                bytes = this.buffer;
                this.pos = oldPos + size;
                tempPos = oldPos;
            } else {
                if (size == 0) {
                    return "";
                }
                if (size <= i10) {
                    refillBuffer(size);
                    bytes = this.buffer;
                    tempPos = 0;
                    this.pos = 0 + size;
                } else {
                    bytes = readRawBytesSlowPath(size, false);
                    tempPos = 0;
                }
            }
            return Utf8.decodeUtf8(bytes, tempPos, size);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            int i10 = this.bufferSize;
            int i11 = this.pos;
            if (size <= i10 - i11 && size > 0) {
                ByteString result = ByteString.copyFrom(this.buffer, i11, size);
                this.pos += size;
                return result;
            }
            if (size == 0) {
                return ByteString.EMPTY;
            }
            return readBytesSlowPath(size);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int size = readRawVarint32();
            int i10 = this.bufferSize;
            int i11 = this.pos;
            if (size <= i10 - i11 && size > 0) {
                byte[] result = Arrays.copyOfRange(this.buffer, i11, i11 + size);
                this.pos += size;
                return result;
            }
            return readRawBytesSlowPath(size, false);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            int i10 = this.bufferSize;
            int i11 = this.pos;
            if (size <= i10 - i11 && size > 0) {
                ByteBuffer result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i11, i11 + size));
                this.pos += size;
                return result;
            }
            if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            return ByteBuffer.wrap(readRawBytesSlowPath(size, true));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
        
            if (r2[r1] < 0) goto L33;
         */
        @Override // com.android.framework.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.pos
                int r1 = r6.bufferSize
                if (r1 != r0) goto L8
                goto L72
            L8:
                byte[] r2 = r6.buffer
                int r3 = r0 + 1
                r0 = r2[r0]
                r4 = r0
                if (r0 < 0) goto L14
                r6.pos = r3
                return r4
            L14:
                int r1 = r1 - r3
                r0 = 9
                if (r1 >= r0) goto L1a
                goto L72
            L1a:
                int r0 = r3 + 1
                r1 = r2[r3]
                int r1 = r1 << 7
                r1 = r1 ^ r4
                r3 = r1
                if (r1 >= 0) goto L27
                r1 = r3 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L7d
            L27:
                int r1 = r0 + 1
                r0 = r2[r0]
                int r0 = r0 << 14
                r0 = r0 ^ r3
                r3 = r0
                if (r0 < 0) goto L37
                r0 = r3 ^ 16256(0x3f80, float:2.278E-41)
                r5 = r1
                r1 = r0
                r0 = r5
                goto L7d
            L37:
                int r0 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 21
                r1 = r1 ^ r3
                r3 = r1
                if (r1 >= 0) goto L46
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r1 = r1 ^ r3
                goto L7d
            L46:
                int r1 = r0 + 1
                r0 = r2[r0]
                int r4 = r0 << 28
                r3 = r3 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r3 = r3 ^ r4
                if (r0 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
                int r1 = r4 + 1
                r4 = r2[r4]
                if (r4 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
                int r1 = r4 + 1
                r4 = r2[r4]
                if (r4 >= 0) goto L7b
                int r4 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L78
            L72:
                long r0 = r6.readRawVarint64SlowPath()
                int r0 = (int) r0
                return r0
            L78:
                r1 = r3
                r0 = r4
                goto L7d
            L7b:
                r0 = r1
                r1 = r3
            L7d:
                r6.pos = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.buffer;
                int i11 = this.pos;
                this.pos = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        
            if (r2[r1] < 0) goto L37;
         */
        @Override // com.android.framework.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b4 = readRawByte();
                result |= (b4 & Byte.MAX_VALUE) << shift;
                if ((b4 & 128) == 0) {
                    return result;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize - tempPos < 4) {
                refillBuffer(4);
                tempPos = this.pos;
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize - tempPos < 8) {
                refillBuffer(8);
                tempPos = this.pos;
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24) | ((buffer[tempPos + 4] & 255) << 32) | ((buffer[tempPos + 5] & 255) << 40) | ((buffer[tempPos + 6] & 255) << 48) | ((buffer[tempPos + 7] & 255) << 56);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + this.totalBytesRetired + this.pos;
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i10 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i10;
            int bufferEnd = this.totalBytesRetired + i10;
            int i11 = this.currentLimit;
            if (bufferEnd > i11) {
                int i12 = bufferEnd - i11;
                this.bufferSizeAfterLimit = i12;
                this.bufferSize = i10 - i12;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i10 = this.currentLimit;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            int currentAbsolutePosition = this.totalBytesRetired + this.pos;
            return i10 - currentAbsolutePosition;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int n10) throws IOException {
            if (!tryRefillBuffer(n10)) {
                if (n10 > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private boolean tryRefillBuffer(int n10) throws IOException {
            if (this.pos + n10 <= this.bufferSize) {
                throw new IllegalStateException("refillBuffer() called when " + n10 + " bytes were already available in buffer");
            }
            int i10 = this.sizeLimit;
            int i11 = this.totalBytesRetired;
            int i12 = this.pos;
            if (n10 > (i10 - i11) - i12 || i11 + i12 + n10 > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int tempPos = this.pos;
            if (tempPos > 0) {
                int i13 = this.bufferSize;
                if (i13 > tempPos) {
                    byte[] bArr = this.buffer;
                    System.arraycopy((Object) bArr, tempPos, (Object) bArr, 0, i13 - tempPos);
                }
                this.totalBytesRetired += tempPos;
                this.bufferSize -= tempPos;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i14 = this.bufferSize;
            int bytesRead = read(inputStream, bArr2, i14, Math.min(bArr2.length - i14, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
            if (bytesRead == 0 || bytesRead < -1 || bytesRead > this.buffer.length) {
                throw new IllegalStateException(((Object) this.input.getClass()) + "#read(byte[]) returned invalid result: " + bytesRead + "\nThe InputStream implementation is buggy.");
            }
            if (bytesRead <= 0) {
                return false;
            }
            this.bufferSize += bytesRead;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= n10) {
                return true;
            }
            return tryRefillBuffer(n10);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            this.pos = i10 + 1;
            return bArr[i10];
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readRawBytes(int size) throws IOException {
            int tempPos = this.pos;
            if (size <= this.bufferSize - tempPos && size > 0) {
                this.pos = tempPos + size;
                return Arrays.copyOfRange(this.buffer, tempPos, tempPos + size);
            }
            return readRawBytesSlowPath(size, false);
        }

        private byte[] readRawBytesSlowPath(int size, boolean ensureNoLeakedReferences) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result != null) {
                return ensureNoLeakedReferences ? (byte[]) result.clone() : result;
            }
            int originalBufferPos = this.pos;
            int i10 = this.bufferSize;
            int bufferedBytes = i10 - this.pos;
            this.totalBytesRetired += i10;
            this.pos = 0;
            this.bufferSize = 0;
            int sizeLeft = size - bufferedBytes;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(sizeLeft);
            byte[] bytes = new byte[size];
            System.arraycopy((Object) this.buffer, originalBufferPos, (Object) bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            for (byte[] chunk : chunks) {
                System.arraycopy((Object) chunk, 0, (Object) bytes, tempPos, chunk.length);
                tempPos += chunk.length;
            }
            return bytes;
        }

        private byte[] readRawBytesSlowPathOneChunk(int size) throws IOException {
            if (size == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int currentMessageSize = this.totalBytesRetired + this.pos + size;
            if (currentMessageSize - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i10 = this.currentLimit;
            if (currentMessageSize > i10) {
                skipRawBytes((i10 - this.totalBytesRetired) - this.pos);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int bufferedBytes = this.bufferSize - this.pos;
            int sizeLeft = size - bufferedBytes;
            if (sizeLeft < 4096 || sizeLeft <= available(this.input)) {
                byte[] bytes = new byte[size];
                System.arraycopy((Object) this.buffer, this.pos, (Object) bytes, 0, bufferedBytes);
                this.totalBytesRetired += this.bufferSize;
                this.pos = 0;
                this.bufferSize = 0;
                int tempPos = bufferedBytes;
                while (tempPos < bytes.length) {
                    int n10 = read(this.input, bytes, tempPos, size - tempPos);
                    if (n10 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n10;
                    tempPos += n10;
                }
                return bytes;
            }
            return null;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int sizeLeft) throws IOException {
            List<byte[]> chunks = new ArrayList<>();
            while (sizeLeft > 0) {
                byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
                int tempPos = 0;
                while (tempPos < chunk.length) {
                    int n10 = this.input.read(chunk, tempPos, chunk.length - tempPos);
                    if (n10 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n10;
                    tempPos += n10;
                }
                sizeLeft -= chunk.length;
                chunks.add(chunk);
            }
            return chunks;
        }

        private ByteString readBytesSlowPath(int size) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result != null) {
                return ByteString.copyFrom(result);
            }
            int originalBufferPos = this.pos;
            int i10 = this.bufferSize;
            int bufferedBytes = i10 - this.pos;
            this.totalBytesRetired += i10;
            this.pos = 0;
            this.bufferSize = 0;
            int sizeLeft = size - bufferedBytes;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(sizeLeft);
            byte[] bytes = new byte[size];
            System.arraycopy((Object) this.buffer, originalBufferPos, (Object) bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            for (byte[] chunk : chunks) {
                System.arraycopy((Object) chunk, 0, (Object) bytes, tempPos, chunk.length);
                tempPos += chunk.length;
            }
            return ByteString.wrap(bytes);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipRawBytes(int size) throws IOException {
            int i10 = this.bufferSize;
            int i11 = this.pos;
            if (size <= i10 - i11 && size >= 0) {
                this.pos = i11 + size;
            } else {
                skipRawBytesSlowPath(size);
            }
        }

        private void skipRawBytesSlowPath(int size) throws IOException {
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i10 = this.totalBytesRetired;
            int i11 = this.pos;
            int i12 = i10 + i11 + size;
            int i13 = this.currentLimit;
            if (i12 > i13) {
                skipRawBytes((i13 - i10) - i11);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int totalSkipped = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i10 + i11;
                int totalSkipped2 = this.bufferSize - i11;
                this.bufferSize = 0;
                this.pos = 0;
                totalSkipped = totalSkipped2;
                while (totalSkipped < size) {
                    int toSkip = size - totalSkipped;
                    try {
                        long skipped = skip(this.input, toSkip);
                        if (skipped < 0 || skipped > toSkip) {
                            throw new IllegalStateException(((Object) this.input.getClass()) + "#skip returned invalid result: " + skipped + "\nThe InputStream implementation is buggy.");
                        }
                        if (skipped == 0) {
                            break;
                        } else {
                            totalSkipped += (int) skipped;
                        }
                    } finally {
                        this.totalBytesRetired += totalSkipped;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (totalSkipped < size) {
                int i14 = this.bufferSize;
                int tempPos = i14 - this.pos;
                this.pos = i14;
                refillBuffer(1);
                while (true) {
                    int i15 = size - tempPos;
                    int i16 = this.bufferSize;
                    if (i15 > i16) {
                        tempPos += i16;
                        this.pos = i16;
                        refillBuffer(1);
                    } else {
                        this.pos = size - tempPos;
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> inputBufs, int size, boolean immutableFlag) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = size;
            this.input = inputBufs;
            this.iterator = inputBufs.iterator2();
            this.immutable = immutableFlag;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (size == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0L;
                this.currentByteBufferStartPos = 0L;
                this.currentByteBufferLimit = 0L;
                this.currentAddress = 0L;
                return;
            }
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long addressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) == 0) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeUInt32NoTag(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeUInt32NoTag(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeUInt32NoTag(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeUInt32NoTag(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeUInt32NoTag(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                long j10 = size;
                long j11 = this.currentByteBufferLimit;
                long j12 = this.currentByteBufferPos;
                if (j10 <= j11 - j12) {
                    byte[] bytes = new byte[size];
                    UnsafeUtil.copyMemory(j12, bytes, 0L, size);
                    String result = new String(bytes, Internal.UTF_8);
                    this.currentByteBufferPos += size;
                    return result;
                }
            }
            if (size > 0 && size <= remaining()) {
                byte[] bytes2 = new byte[size];
                readRawBytesTo(bytes2, 0, size);
                String result2 = new String(bytes2, Internal.UTF_8);
                return result2;
            }
            if (size == 0) {
                return "";
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                long j10 = size;
                long j11 = this.currentByteBufferLimit;
                long j12 = this.currentByteBufferPos;
                if (j10 <= j11 - j12) {
                    int bufferPos = (int) (j12 - this.currentByteBufferStartPos);
                    String result = Utf8.decodeUtf8(this.currentByteBuffer, bufferPos, size);
                    this.currentByteBufferPos += size;
                    return result;
                }
            }
            if (size >= 0 && size <= remaining()) {
                byte[] bytes = new byte[size];
                readRawBytesTo(bytes, 0, size);
                return Utf8.decodeUtf8(bytes, 0, size);
            }
            if (size == 0) {
                return "";
            }
            if (size <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size > 0) {
                long j10 = size;
                long j11 = this.currentByteBufferLimit;
                long j12 = this.currentByteBufferPos;
                if (j10 <= j11 - j12) {
                    if (this.immutable && this.enableAliasing) {
                        int idx = (int) (j12 - this.currentAddress);
                        ByteString result = ByteString.wrap(slice(idx, idx + size));
                        this.currentByteBufferPos += size;
                        return result;
                    }
                    byte[] bytes = new byte[size];
                    UnsafeUtil.copyMemory(j12, bytes, 0L, size);
                    this.currentByteBufferPos += size;
                    return ByteString.wrap(bytes);
                }
            }
            if (size > 0 && size <= remaining()) {
                if (this.immutable && this.enableAliasing) {
                    ArrayList<ByteString> byteStrings = new ArrayList<>();
                    int l10 = size;
                    while (l10 > 0) {
                        if (currentRemaining() == 0) {
                            getNextByteBuffer();
                        }
                        int bytesToCopy = Math.min(l10, (int) currentRemaining());
                        int idx2 = (int) (this.currentByteBufferPos - this.currentAddress);
                        byteStrings.add(ByteString.wrap(slice(idx2, idx2 + bytesToCopy)));
                        l10 -= bytesToCopy;
                        this.currentByteBufferPos += bytesToCopy;
                    }
                    return ByteString.copyFrom(byteStrings);
                }
                byte[] temp = new byte[size];
                readRawBytesTo(temp, 0, size);
                return ByteString.wrap(temp);
            }
            if (size == 0) {
                return ByteString.EMPTY;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= currentRemaining()) {
                if (!this.immutable && this.enableAliasing) {
                    long j10 = this.currentByteBufferPos + size;
                    this.currentByteBufferPos = j10;
                    long j11 = this.currentAddress;
                    return slice((int) ((j10 - j11) - size), (int) (j10 - j11));
                }
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0L, size);
                this.currentByteBufferPos += size;
                return ByteBuffer.wrap(bytes);
            }
            if (size > 0 && size <= remaining()) {
                byte[] temp = new byte[size];
                readRawBytesTo(temp, 0, size);
                return ByteBuffer.wrap(temp);
            }
            if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int y10;
            long tempPos = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != this.currentByteBufferPos) {
                long tempPos2 = tempPos + 1;
                int x10 = UnsafeUtil.getByte(tempPos);
                if (x10 >= 0) {
                    this.currentByteBufferPos++;
                    return x10;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long tempPos3 = tempPos2 + 1;
                    int x11 = (UnsafeUtil.getByte(tempPos2) << 7) ^ x10;
                    if (x11 < 0) {
                        y10 = x11 ^ (-128);
                    } else {
                        long tempPos4 = tempPos3 + 1;
                        int x12 = (UnsafeUtil.getByte(tempPos3) << 14) ^ x11;
                        if (x12 >= 0) {
                            y10 = x12 ^ 16256;
                            tempPos3 = tempPos4;
                        } else {
                            tempPos3 = tempPos4 + 1;
                            int x13 = (UnsafeUtil.getByte(tempPos4) << 21) ^ x12;
                            if (x13 < 0) {
                                y10 = (-2080896) ^ x13;
                            } else {
                                long tempPos5 = tempPos3 + 1;
                                int y11 = UnsafeUtil.getByte(tempPos3);
                                int x14 = (x13 ^ (y11 << 28)) ^ 266354560;
                                if (y11 < 0) {
                                    tempPos3 = tempPos5 + 1;
                                    if (UnsafeUtil.getByte(tempPos5) < 0) {
                                        long tempPos6 = tempPos3 + 1;
                                        if (UnsafeUtil.getByte(tempPos3) < 0) {
                                            tempPos3 = tempPos6 + 1;
                                            if (UnsafeUtil.getByte(tempPos6) < 0) {
                                                long tempPos7 = tempPos3 + 1;
                                                if (UnsafeUtil.getByte(tempPos3) < 0) {
                                                    tempPos3 = tempPos7 + 1;
                                                    if (UnsafeUtil.getByte(tempPos7) >= 0) {
                                                        y10 = x14;
                                                    }
                                                } else {
                                                    y10 = x14;
                                                    tempPos3 = tempPos7;
                                                }
                                            } else {
                                                y10 = x14;
                                            }
                                        } else {
                                            y10 = x14;
                                            tempPos3 = tempPos6;
                                        }
                                    } else {
                                        y10 = x14;
                                    }
                                } else {
                                    y10 = x14;
                                    tempPos3 = tempPos5;
                                }
                            }
                        }
                    }
                    this.currentByteBufferPos = tempPos3;
                    return y10;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long x10;
            long tempPos = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != this.currentByteBufferPos) {
                long tempPos2 = tempPos + 1;
                int y10 = UnsafeUtil.getByte(tempPos);
                if (y10 >= 0) {
                    this.currentByteBufferPos++;
                    return y10;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long tempPos3 = tempPos2 + 1;
                    int y11 = (UnsafeUtil.getByte(tempPos2) << 7) ^ y10;
                    if (y11 < 0) {
                        x10 = y11 ^ (-128);
                    } else {
                        long tempPos4 = tempPos3 + 1;
                        int y12 = (UnsafeUtil.getByte(tempPos3) << 14) ^ y11;
                        if (y12 >= 0) {
                            x10 = y12 ^ 16256;
                            tempPos3 = tempPos4;
                        } else {
                            tempPos3 = tempPos4 + 1;
                            int y13 = (UnsafeUtil.getByte(tempPos4) << 21) ^ y12;
                            if (y13 >= 0) {
                                long tempPos5 = tempPos3 + 1;
                                long x11 = y13 ^ (UnsafeUtil.getByte(tempPos3) << 28);
                                if (x11 >= 0) {
                                    x10 = 266354560 ^ x11;
                                    tempPos3 = tempPos5;
                                } else {
                                    long tempPos6 = tempPos5 + 1;
                                    long x12 = (UnsafeUtil.getByte(tempPos5) << 35) ^ x11;
                                    if (x12 < 0) {
                                        x10 = (-34093383808L) ^ x12;
                                        tempPos3 = tempPos6;
                                    } else {
                                        long tempPos7 = tempPos6 + 1;
                                        long x13 = (UnsafeUtil.getByte(tempPos6) << 42) ^ x12;
                                        if (x13 >= 0) {
                                            x10 = 4363953127296L ^ x13;
                                            tempPos3 = tempPos7;
                                        } else {
                                            long tempPos8 = tempPos7 + 1;
                                            long x14 = (UnsafeUtil.getByte(tempPos7) << 49) ^ x13;
                                            if (x14 < 0) {
                                                x10 = (-558586000294016L) ^ x14;
                                                tempPos3 = tempPos8;
                                            } else {
                                                long tempPos9 = tempPos8 + 1;
                                                long x15 = ((UnsafeUtil.getByte(tempPos8) << 56) ^ x14) ^ 71499008037633920L;
                                                if (x15 >= 0) {
                                                    x10 = x15;
                                                    tempPos3 = tempPos9;
                                                } else {
                                                    tempPos3 = tempPos9 + 1;
                                                    if (UnsafeUtil.getByte(tempPos9) >= 0) {
                                                        x10 = x15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                x10 = (-2080896) ^ y13;
                            }
                        }
                    }
                    this.currentByteBufferPos = tempPos3;
                    return x10;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long result = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b4 = readRawByte();
                result |= (b4 & Byte.MAX_VALUE) << shift;
                if ((b4 & 128) == 0) {
                    return result;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() >= 4) {
                long tempPos = this.currentByteBufferPos;
                this.currentByteBufferPos += 4;
                return (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(1 + tempPos) & 255) << 8) | ((UnsafeUtil.getByte(2 + tempPos) & 255) << 16) | ((UnsafeUtil.getByte(3 + tempPos) & 255) << 24);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() >= 8) {
                long tempPos = this.currentByteBufferPos;
                this.currentByteBufferPos += 8;
                return ((UnsafeUtil.getByte(7 + tempPos) & 255) << 56) | (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(1 + tempPos) & 255) << 8) | ((UnsafeUtil.getByte(2 + tempPos) & 255) << 16) | ((UnsafeUtil.getByte(3 + tempPos) & 255) << 24) | ((UnsafeUtil.getByte(4 + tempPos) & 255) << 32) | ((UnsafeUtil.getByte(5 + tempPos) & 255) << 40) | ((UnsafeUtil.getByte(6 + tempPos) & 255) << 48);
            }
            return ((readRawByte() & 255) << 56) | (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i10 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i10;
            int bufferEnd = i10 - this.startOffset;
            int i11 = this.currentLimit;
            if (bufferEnd > i11) {
                int i12 = bufferEnd - i11;
                this.bufferSizeAfterCurrentLimit = i12;
                this.totalBufferSize = i10 - i12;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i10 = this.currentLimit;
            if (i10 == Integer.MAX_VALUE) {
                return -1;
            }
            return i10 - getTotalBytesRead();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j10 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j10;
            return UnsafeUtil.getByte(j10);
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0 && length <= currentRemaining()) {
                byte[] bytes = new byte[length];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0L, length);
                this.currentByteBufferPos += length;
                return bytes;
            }
            if (length >= 0 && length <= remaining()) {
                byte[] bytes2 = new byte[length];
                readRawBytesTo(bytes2, 0, length);
                return bytes2;
            }
            if (length <= 0) {
                if (length == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void readRawBytesTo(byte[] bytes, int offset, int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                int l10 = length;
                while (l10 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int bytesToCopy = Math.min(l10, (int) currentRemaining());
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, (length - l10) + offset, bytesToCopy);
                    l10 -= bytesToCopy;
                    this.currentByteBufferPos += bytesToCopy;
                }
                return;
            }
            if (length <= 0) {
                if (length == 0) {
                    return;
                } else {
                    throw InvalidProtocolBufferException.negativeSize();
                }
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.android.framework.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0 && length <= ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                int l10 = length;
                while (l10 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int rl = Math.min(l10, (int) currentRemaining());
                    l10 -= rl;
                    this.currentByteBufferPos += rl;
                }
                return;
            }
            if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void skipRawVarint() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private ByteBuffer slice(int begin, int end) throws IOException {
            int prevPos = this.currentByteBuffer.position();
            int prevLimit = this.currentByteBuffer.limit();
            Buffer asBuffer = this.currentByteBuffer;
            try {
                try {
                    asBuffer.position(begin);
                    asBuffer.limit(end);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException e2) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                asBuffer.position(prevPos);
                asBuffer.limit(prevLimit);
            }
        }
    }
}
