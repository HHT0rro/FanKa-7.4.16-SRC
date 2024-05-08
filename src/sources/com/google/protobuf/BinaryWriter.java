package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    public final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    public int totalDoneBytes;

    /* renamed from: com.google.protobuf.BinaryWriter$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        public SafeDirectWriter(BufferAllocator bufferAllocator, int i10) {
            super(bufferAllocator, i10, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i10) {
            ByteBuffer byteBuffer = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer.put(i11, (byte) (i10 >>> 28));
            int i12 = this.pos - 4;
            this.pos = i12;
            this.buffer.putInt(i12 + 1, (i10 & 127) | 128 | ((((i10 >>> 21) & 127) | 128) << 24) | ((((i10 >>> 14) & 127) | 128) << 16) | ((((i10 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i10) {
            int i11 = this.pos - 4;
            this.pos = i11;
            this.buffer.putInt(i11 + 1, (i10 & 127) | 128 | ((266338304 & i10) << 3) | (((2080768 & i10) | 2097152) << 2) | (((i10 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i10) {
            ByteBuffer byteBuffer = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer.put(i11, (byte) i10);
        }

        private void writeVarint32ThreeBytes(int i10) {
            int i11 = this.pos - 3;
            this.pos = i11;
            this.buffer.putInt(i11, (((i10 & 127) | 128) << 8) | ((2080768 & i10) << 10) | (((i10 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i10) {
            int i11 = this.pos - 2;
            this.pos = i11;
            this.buffer.putShort(i11 + 1, (short) ((i10 & 127) | 128 | ((i10 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j10) {
            int i10 = this.pos - 8;
            this.pos = i10;
            this.buffer.putLong(i10 + 1, (j10 & 127) | 128 | ((71494644084506624L & j10) << 7) | (((558551906910208L & j10) | 562949953421312L) << 6) | (((4363686772736L & j10) | 4398046511104L) << 5) | (((34091302912L & j10) | 34359738368L) << 4) | (((266338304 & j10) | 268435456) << 3) | (((2080768 & j10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j10) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j10) {
            int i10 = this.pos - 8;
            this.pos = i10;
            this.buffer.putLong(i10 + 1, (j10 & 127) | 128 | (((71494644084506624L & j10) | 72057594037927936L) << 7) | (((558551906910208L & j10) | 562949953421312L) << 6) | (((4363686772736L & j10) | 4398046511104L) << 5) | (((34091302912L & j10) | 34359738368L) << 4) | (((266338304 & j10) | 268435456) << 3) | (((2080768 & j10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j10) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j10) {
            int i10 = this.pos - 5;
            this.pos = i10;
            this.buffer.putLong(i10 - 2, (((j10 & 127) | 128) << 24) | ((34091302912L & j10) << 28) | (((266338304 & j10) | 268435456) << 27) | (((2080768 & j10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26) | (((16256 & j10) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j10) {
            writeVarint32FourBytes((int) j10);
        }

        private void writeVarint64NineBytes(long j10) {
            ByteBuffer byteBuffer = this.buffer;
            int i10 = this.pos;
            this.pos = i10 - 1;
            byteBuffer.put(i10, (byte) (j10 >>> 56));
            writeVarint64EightBytesWithSign(j10 & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j10) {
            writeVarint32OneByte((int) j10);
        }

        private void writeVarint64SevenBytes(long j10) {
            int i10 = this.pos - 7;
            this.pos = i10;
            this.buffer.putLong(i10, (((j10 & 127) | 128) << 8) | ((558551906910208L & j10) << 14) | (((4363686772736L & j10) | 4398046511104L) << 13) | (((34091302912L & j10) | 34359738368L) << 12) | (((266338304 & j10) | 268435456) << 11) | (((2080768 & j10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10) | (((16256 & j10) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j10) {
            int i10 = this.pos - 6;
            this.pos = i10;
            this.buffer.putLong(i10 - 1, (((j10 & 127) | 128) << 16) | ((4363686772736L & j10) << 21) | (((34091302912L & j10) | 34359738368L) << 20) | (((266338304 & j10) | 268435456) << 19) | (((2080768 & j10) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18) | (((16256 & j10) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j10) {
            ByteBuffer byteBuffer = this.buffer;
            int i10 = this.pos;
            this.pos = i10 - 1;
            byteBuffer.put(i10, (byte) (j10 >>> 63));
            ByteBuffer byteBuffer2 = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            byteBuffer2.put(i11, (byte) (((j10 >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(j10 & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j10) {
            writeVarint32ThreeBytes((int) j10);
        }

        private void writeVarint64TwoBytes(long j10) {
            writeVarint32TwoBytes((int) j10);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int i10) {
            if (spaceLeft() < i10) {
                nextBuffer(i10);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            ByteBuffer byteBuffer = this.buffer;
            int i10 = this.pos;
            this.pos = i10 - 1;
            byteBuffer.put(i10, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i10, boolean z10) {
            requireSpace(6);
            write(z10 ? (byte) 1 : (byte) 0);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i10, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i10, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i10) {
            writeTag(i10, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i10, int i11) {
            requireSpace(9);
            writeFixed32(i11);
            writeTag(i10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i10, long j10) {
            requireSpace(13);
            writeFixed64(j10);
            writeTag(i10, 1);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int i10, Object obj) throws IOException {
            writeTag(i10, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i10, int i11) {
            requireSpace(15);
            writeInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                this.totalDoneBytes += i11;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i10, i11));
                nextBuffer();
            } else {
                int i12 = this.pos - i11;
                this.pos = i12;
                this.buffer.position(i12 + 1);
                this.buffer.put(bArr, i10, i11);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i10, int i11) {
            requireSpace(10);
            writeSInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i10, long j10) {
            requireSpace(15);
            writeSInt64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i10) {
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i10, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int i10, int i11) {
            writeVarint32(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i10, int i11) {
            requireSpace(10);
            writeVarint32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i10, long j10) {
            requireSpace(15);
            writeVarint64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int i10) {
            if ((i10 & (-128)) == 0) {
                writeVarint32OneByte(i10);
                return;
            }
            if ((i10 & (-16384)) == 0) {
                writeVarint32TwoBytes(i10);
                return;
            }
            if (((-2097152) & i10) == 0) {
                writeVarint32ThreeBytes(i10);
            } else if (((-268435456) & i10) == 0) {
                writeVarint32FourBytes(i10);
            } else {
                writeVarint32FiveBytes(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long j10) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j10)) {
                case 1:
                    writeVarint64OneByte(j10);
                    return;
                case 2:
                    writeVarint64TwoBytes(j10);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j10);
                    return;
                case 4:
                    writeVarint64FourBytes(j10);
                    return;
                case 5:
                    writeVarint64FiveBytes(j10);
                    return;
                case 6:
                    writeVarint64SixBytes(j10);
                    return;
                case 7:
                    writeVarint64SevenBytes(j10);
                    return;
                case 8:
                    writeVarint64EightBytes(j10);
                    return;
                case 9:
                    writeVarint64NineBytes(j10);
                    return;
                case 10:
                    writeVarint64TenBytes(j10);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i10) {
            nextBuffer(newDirectBuffer(i10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
            int i12 = this.pos - i11;
            this.pos = i12;
            this.buffer.position(i12 + 1);
            this.buffer.put(bArr, i10, i11);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.buffer.limit() - 1;
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean z10) {
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int i10) {
            int i11 = this.pos - 4;
            this.pos = i11;
            this.buffer.putInt(i11 + 1, i10);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long j10) {
            int i10 = this.pos - 8;
            this.pos = i10;
            this.buffer.putLong(i10 + 1, j10);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj, Schema schema) throws IOException {
            writeTag(i10, 4);
            schema.writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int i10) {
            if (i10 >= 0) {
                writeVarint32(i10);
            } else {
                writeVarint64(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int i10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i10));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long j10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i10 = this.pos - remaining;
            this.pos = i10;
            this.buffer.position(i10 + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String str) {
            int i10;
            int i11;
            int i12;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i12 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i12 - 1;
                    byteBuffer.put(i12, (byte) charAt2);
                } else if (charAt2 < 2048 && (i11 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i11 - 1;
                    byteBuffer2.put(i11, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i13 = this.pos;
                    this.pos = i13 - 1;
                    byteBuffer3.put(i13, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i10 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i10 - 1;
                    byteBuffer4.put(i10, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i14 = this.pos;
                    this.pos = i14 - 1;
                    byteBuffer5.put(i14, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i15 = this.pos;
                    this.pos = i15 - 1;
                    byteBuffer6.put(i15, (byte) ((charAt2 >>> '\f') | 480));
                } else {
                    if (this.pos > 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                ByteBuffer byteBuffer7 = this.buffer;
                                int i16 = this.pos;
                                this.pos = i16 - 1;
                                byteBuffer7.put(i16, (byte) ((codePoint & 63) | 128));
                                ByteBuffer byteBuffer8 = this.buffer;
                                int i17 = this.pos;
                                this.pos = i17 - 1;
                                byteBuffer8.put(i17, (byte) (((codePoint >>> 6) & 63) | 128));
                                ByteBuffer byteBuffer9 = this.buffer;
                                int i18 = this.pos;
                                this.pos = i18 - 1;
                                byteBuffer9.put(i18, (byte) (((codePoint >>> 12) & 63) | 128));
                                ByteBuffer byteBuffer10 = this.buffer;
                                int i19 = this.pos;
                                this.pos = i19 - 1;
                                byteBuffer10.put(i19, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                int i10 = this.pos - remaining;
                this.pos = i10;
                this.buffer.position(i10 + 1);
                this.buffer.put(byteBuffer);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        public SafeHeapWriter(BufferAllocator bufferAllocator, int i10) {
            super(bufferAllocator, i10, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (i10 >>> 28);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((i10 >>> 21) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((i10 >>> 14) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((i10 >>> 7) & 127) | 128);
            this.pos = i15 - 1;
            bArr[i15] = (byte) ((i10 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (i10 >>> 21);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((i10 >>> 14) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((i10 >>> 7) & 127) | 128);
            this.pos = i14 - 1;
            bArr[i14] = (byte) ((i10 & 127) | 128);
        }

        private void writeVarint32OneByte(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            this.pos = i11 - 1;
            bArr[i11] = (byte) i10;
        }

        private void writeVarint32ThreeBytes(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (i10 >>> 14);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((i10 >>> 7) & 127) | 128);
            this.pos = i13 - 1;
            bArr[i13] = (byte) ((i10 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (i10 >>> 7);
            this.pos = i12 - 1;
            bArr[i12] = (byte) ((i10 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 49);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 42) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 35) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 28) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((j10 >>> 21) & 127) | 128);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((j10 >>> 14) & 127) | 128);
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i17 - 1;
            bArr[i17] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64FiveBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 28);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 21) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 14) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i14 - 1;
            bArr[i14] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64FourBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 21);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 14) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i13 - 1;
            bArr[i13] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64NineBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 56);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 49) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 42) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 35) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((j10 >>> 28) & 127) | 128);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((j10 >>> 21) & 127) | 128);
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) (((j10 >>> 14) & 127) | 128);
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i18 - 1;
            bArr[i18] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64OneByte(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            this.pos = i10 - 1;
            bArr[i10] = (byte) j10;
        }

        private void writeVarint64SevenBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 42);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 35) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 28) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 21) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((j10 >>> 14) & 127) | 128);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i16 - 1;
            bArr[i16] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64SixBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 35);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 28) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 21) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 14) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i15 - 1;
            bArr[i15] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64TenBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 63);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 56) & 127) | 128);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((j10 >>> 49) & 127) | 128);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((j10 >>> 42) & 127) | 128);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((j10 >>> 35) & 127) | 128);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((j10 >>> 28) & 127) | 128);
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) (((j10 >>> 21) & 127) | 128);
            int i18 = i17 - 1;
            this.pos = i18;
            bArr[i17] = (byte) (((j10 >>> 14) & 127) | 128);
            int i19 = i18 - 1;
            this.pos = i19;
            bArr[i18] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i19 - 1;
            bArr[i19] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (((int) j10) >>> 14);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((j10 >>> 7) & 127) | 128);
            this.pos = i12 - 1;
            bArr[i12] = (byte) ((j10 & 127) | 128);
        }

        private void writeVarint64TwoBytes(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (j10 >>> 7);
            this.pos = i11 - 1;
            bArr[i11] = (byte) ((((int) j10) & 127) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                allocatedBuffer.position((this.pos - allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int i10) {
            if (spaceLeft() < i10) {
                nextBuffer(i10);
            }
        }

        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            this.pos = i10 - 1;
            bArr[i10] = b4;
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i10, boolean z10) throws IOException {
            requireSpace(6);
            write(z10 ? (byte) 1 : (byte) 0);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i10, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i10, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int i10) {
            writeTag(i10, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i10, int i11) throws IOException {
            requireSpace(9);
            writeFixed32(i11);
            writeTag(i10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i10, long j10) throws IOException {
            requireSpace(13);
            writeFixed64(j10);
            writeTag(i10, 1);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeGroup(int i10, Object obj) throws IOException {
            writeTag(i10, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i10, int i11) throws IOException {
            requireSpace(15);
            writeInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                this.totalDoneBytes += i11;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i10, i11));
                nextBuffer();
            } else {
                int i12 = this.pos - i11;
                this.pos = i12;
                System.arraycopy((Object) bArr, i10, (Object) this.buffer, i12 + 1, i11);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i10, int i11) throws IOException {
            requireSpace(10);
            writeSInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i10, long j10) throws IOException {
            requireSpace(15);
            writeSInt64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int i10) {
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i10, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int i10, int i11) {
            writeVarint32(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i10, int i11) throws IOException {
            requireSpace(10);
            writeVarint32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i10, long j10) throws IOException {
            requireSpace(15);
            writeVarint64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int i10) {
            if ((i10 & (-128)) == 0) {
                writeVarint32OneByte(i10);
                return;
            }
            if ((i10 & (-16384)) == 0) {
                writeVarint32TwoBytes(i10);
                return;
            }
            if (((-2097152) & i10) == 0) {
                writeVarint32ThreeBytes(i10);
            } else if (((-268435456) & i10) == 0) {
                writeVarint32FourBytes(i10);
            } else {
                writeVarint32FiveBytes(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long j10) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j10)) {
                case 1:
                    writeVarint64OneByte(j10);
                    return;
                case 2:
                    writeVarint64TwoBytes(j10);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j10);
                    return;
                case 4:
                    writeVarint64FourBytes(j10);
                    return;
                case 5:
                    writeVarint64FiveBytes(j10);
                    return;
                case 6:
                    writeVarint64SixBytes(j10);
                    return;
                case 7:
                    writeVarint64SevenBytes(j10);
                    return;
                case 8:
                    writeVarint64EightBytes(j10);
                    return;
                case 9:
                    writeVarint64NineBytes(j10);
                    return;
                case 10:
                    writeVarint64TenBytes(j10);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i10) {
            nextBuffer(newHeapBuffer(i10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
            int i12 = this.pos - i11;
            this.pos = i12;
            System.arraycopy((Object) bArr, i10, (Object) this.buffer, i12 + 1, i11);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.buffer = allocatedBuffer.array();
                int arrayOffset = allocatedBuffer.arrayOffset();
                this.limit = allocatedBuffer.limit() + arrayOffset;
                int position = arrayOffset + allocatedBuffer.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                int i10 = this.limit - 1;
                this.limitMinusOne = i10;
                this.pos = i10;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean z10) {
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int i10) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) ((i10 >> 24) & 255);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) ((i10 >> 16) & 255);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) ((i10 >> 8) & 255);
            this.pos = i14 - 1;
            bArr[i14] = (byte) (i10 & 255);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long j10) {
            byte[] bArr = this.buffer;
            int i10 = this.pos;
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) (((int) (j10 >> 56)) & 255);
            int i12 = i11 - 1;
            this.pos = i12;
            bArr[i11] = (byte) (((int) (j10 >> 48)) & 255);
            int i13 = i12 - 1;
            this.pos = i13;
            bArr[i12] = (byte) (((int) (j10 >> 40)) & 255);
            int i14 = i13 - 1;
            this.pos = i14;
            bArr[i13] = (byte) (((int) (j10 >> 32)) & 255);
            int i15 = i14 - 1;
            this.pos = i15;
            bArr[i14] = (byte) (((int) (j10 >> 24)) & 255);
            int i16 = i15 - 1;
            this.pos = i16;
            bArr[i15] = (byte) (((int) (j10 >> 16)) & 255);
            int i17 = i16 - 1;
            this.pos = i17;
            bArr[i16] = (byte) (((int) (j10 >> 8)) & 255);
            this.pos = i17 - 1;
            bArr[i17] = (byte) (((int) j10) & 255);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj, Schema schema) throws IOException {
            writeTag(i10, 4);
            schema.writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int i10) {
            if (i10 >= 0) {
                writeVarint32(i10);
            } else {
                writeVarint64(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int i10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i10));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long j10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i10 = this.pos - remaining;
            this.pos = i10;
            byteBuffer.get(this.buffer, i10 + 1, remaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i10 = this.pos - remaining;
            this.pos = i10;
            byteBuffer.get(this.buffer, i10 + 1, remaining);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String str) {
            int i10;
            int i11;
            int i12;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i12 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i12 - 1;
                    bArr[i12] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i11 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i13 = i11 - 1;
                    this.pos = i13;
                    bArr2[i11] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i13 - 1;
                    bArr2[i13] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i10 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i14 = i10 - 1;
                    this.pos = i14;
                    bArr3[i10] = (byte) ((charAt2 & '?') | 128);
                    int i15 = i14 - 1;
                    this.pos = i15;
                    bArr3[i14] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i15 - 1;
                    bArr3[i15] = (byte) ((charAt2 >>> '\f') | 480);
                } else {
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr4 = this.buffer;
                                int i16 = this.pos;
                                int i17 = i16 - 1;
                                this.pos = i17;
                                bArr4[i16] = (byte) ((codePoint & 63) | 128);
                                int i18 = i17 - 1;
                                this.pos = i18;
                                bArr4[i17] = (byte) (((codePoint >>> 6) & 63) | 128);
                                int i19 = i18 - 1;
                                this.pos = i19;
                                bArr4[i18] = (byte) (((codePoint >>> 12) & 63) | 128);
                                this.pos = i19 - 1;
                                bArr4[i19] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        public UnsafeDirectWriter(BufferAllocator bufferAllocator, int i10) {
            super(bufferAllocator, i10, null);
            nextBuffer();
        }

        public static /* synthetic */ boolean access$000() {
            return isSupported();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (i10 >>> 28));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((i10 >>> 21) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((i10 >>> 14) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((i10 >>> 7) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (i10 >>> 21));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((i10 >>> 14) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((i10 >>> 7) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32OneByte(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) i10);
        }

        private void writeVarint32ThreeBytes(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (i10 >>> 14));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((i10 >>> 7) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (i10 >>> 7));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 49));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 42) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 35) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 28) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j10 >>> 21) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((j10 >>> 14) & 127) | 128));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) (((j10 >>> 7) & 127) | 128));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 28));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 21) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 14) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 7) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 21));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 14) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 7) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 56));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 49) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 42) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 35) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j10 >>> 28) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((j10 >>> 21) & 127) | 128));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) (((j10 >>> 14) & 127) | 128));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) (((j10 >>> 7) & 127) | 128));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64OneByte(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) j10);
        }

        private void writeVarint64SevenBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 42));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 35) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 28) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 21) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j10 >>> 14) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((j10 >>> 7) & 127) | 128));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 35));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 28) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 21) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 14) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j10 >>> 7) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 63));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 56) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j10 >>> 49) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j10 >>> 42) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j10 >>> 35) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((j10 >>> 28) & 127) | 128));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) (((j10 >>> 21) & 127) | 128));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) (((j10 >>> 14) & 127) | 128));
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(j19, (byte) (((j10 >>> 7) & 127) | 128));
            long j20 = this.pos;
            this.pos = j20 - 1;
            UnsafeUtil.putByte(j20, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((int) j10) >>> 14));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j10 >>> 7) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (j10 >>> 7));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((((int) j10) & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int i10) {
            if (spaceLeft() < i10) {
                nextBuffer(i10);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i10, boolean z10) {
            requireSpace(6);
            write(z10 ? (byte) 1 : (byte) 0);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i10, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i10, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i10) {
            writeTag(i10, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i10, int i11) {
            requireSpace(9);
            writeFixed32(i11);
            writeTag(i10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i10, long j10) {
            requireSpace(13);
            writeFixed64(j10);
            writeTag(i10, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj) throws IOException {
            writeTag(i10, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i10, int i11) {
            requireSpace(15);
            writeInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                this.totalDoneBytes += i11;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i10, i11));
                nextBuffer();
            } else {
                this.pos -= i11;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(bArr, i10, i11);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i10, int i11) {
            requireSpace(10);
            writeSInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i10, long j10) {
            requireSpace(15);
            writeSInt64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i10) {
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i10, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int i10, int i11) {
            writeVarint32(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i10, int i11) {
            requireSpace(10);
            writeVarint32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i10, long j10) {
            requireSpace(15);
            writeVarint64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int i10) {
            if ((i10 & (-128)) == 0) {
                writeVarint32OneByte(i10);
                return;
            }
            if ((i10 & (-16384)) == 0) {
                writeVarint32TwoBytes(i10);
                return;
            }
            if (((-2097152) & i10) == 0) {
                writeVarint32ThreeBytes(i10);
            } else if (((-268435456) & i10) == 0) {
                writeVarint32FourBytes(i10);
            } else {
                writeVarint32FiveBytes(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long j10) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j10)) {
                case 1:
                    writeVarint64OneByte(j10);
                    return;
                case 2:
                    writeVarint64TwoBytes(j10);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j10);
                    return;
                case 4:
                    writeVarint64FourBytes(j10);
                    return;
                case 5:
                    writeVarint64FiveBytes(j10);
                    return;
                case 6:
                    writeVarint64SixBytes(j10);
                    return;
                case 7:
                    writeVarint64SevenBytes(j10);
                    return;
                case 8:
                    writeVarint64EightBytes(j10);
                    return;
                case 9:
                    writeVarint64NineBytes(j10);
                    return;
                case 10:
                    writeVarint64TenBytes(j10);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i10) {
            nextBuffer(newDirectBuffer(i10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            if (spaceLeft() < i11) {
                nextBuffer(i11);
            }
            this.pos -= i11;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i10, i11);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    long addressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = addressOffset;
                    long limit = addressOffset + (this.buffer.limit() - 1);
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean z10) {
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int i10) {
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((i10 >> 24) & 255));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((i10 >> 16) & 255));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((i10 >> 8) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (i10 & 255));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long j10) {
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((int) (j10 >> 56)) & 255));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((int) (j10 >> 48)) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((int) (j10 >> 40)) & 255));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((int) (j10 >> 32)) & 255));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((int) (j10 >> 24)) & 255));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) (((int) (j10 >> 16)) & 255));
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(j17, (byte) (((int) (j10 >> 8)) & 255));
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(j18, (byte) (((int) j10) & 255));
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj, Schema schema) throws IOException {
            writeTag(i10, 4);
            schema.writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int i10) {
            if (i10 >= 0) {
                writeVarint32(i10);
            } else {
                writeVarint64(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int i10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i10));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long j10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                long j10 = this.pos;
                this.pos = j10 - 1;
                UnsafeUtil.putByte(j10, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    long j11 = this.pos;
                    if (j11 >= this.bufferOffset) {
                        this.pos = j11 - 1;
                        UnsafeUtil.putByte(j11, (byte) charAt2);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j12 = this.pos;
                    if (j12 > this.bufferOffset) {
                        this.pos = j12 - 1;
                        UnsafeUtil.putByte(j12, (byte) ((charAt2 & '?') | 128));
                        long j13 = this.pos;
                        this.pos = j13 - 1;
                        UnsafeUtil.putByte(j13, (byte) ((charAt2 >>> 6) | 960));
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j14 = this.pos;
                    if (j14 > this.bufferOffset + 1) {
                        this.pos = j14 - 1;
                        UnsafeUtil.putByte(j14, (byte) ((charAt2 & '?') | 128));
                        long j15 = this.pos;
                        this.pos = j15 - 1;
                        UnsafeUtil.putByte(j15, (byte) (((charAt2 >>> 6) & 63) | 128));
                        long j16 = this.pos;
                        this.pos = j16 - 1;
                        UnsafeUtil.putByte(j16, (byte) ((charAt2 >>> '\f') | 480));
                        length--;
                    }
                }
                if (this.pos > this.bufferOffset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            long j17 = this.pos;
                            this.pos = j17 - 1;
                            UnsafeUtil.putByte(j17, (byte) ((codePoint & 63) | 128));
                            long j18 = this.pos;
                            this.pos = j18 - 1;
                            UnsafeUtil.putByte(j18, (byte) (((codePoint >>> 6) & 63) | 128));
                            long j19 = this.pos;
                            this.pos = j19 - 1;
                            UnsafeUtil.putByte(j19, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j20 = this.pos;
                            this.pos = j20 - 1;
                            UnsafeUtil.putByte(j20, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                requireSpace(length);
                length++;
                length--;
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                this.pos -= remaining;
                this.buffer.position(bufferPos() + 1);
                this.buffer.put(byteBuffer);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        public UnsafeHeapWriter(BufferAllocator bufferAllocator, int i10) {
            super(bufferAllocator, i10, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) (i10 >>> 28));
            byte[] bArr2 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr2, j11, (byte) (((i10 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr3, j12, (byte) (((i10 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr4, j13, (byte) (((i10 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr5, j14, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) (i10 >>> 21));
            byte[] bArr2 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr2, j11, (byte) (((i10 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr3, j12, (byte) (((i10 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr4, j13, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32OneByte(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) i10);
        }

        private void writeVarint32ThreeBytes(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) (i10 >>> 14));
            byte[] bArr2 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr2, j11, (byte) (((i10 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr3, j12, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) (i10 >>> 7));
            byte[] bArr2 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr2, j11, (byte) ((i10 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 49));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 42) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 35) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 28) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr7, j17, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr8, j18, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 28));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64FourBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 21));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64NineBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 56));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 49) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 42) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 35) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((j10 >>> 28) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr7, j17, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr8, j18, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr9, j19, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64OneByte(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) j10);
        }

        private void writeVarint64SevenBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 42));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 35) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 28) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr7, j17, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64SixBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 35));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 28) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64TenBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 63));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 56) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((j10 >>> 49) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((j10 >>> 42) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((j10 >>> 35) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) (((j10 >>> 28) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr7, j17, (byte) (((j10 >>> 21) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr8, j18, (byte) (((j10 >>> 14) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j19 = this.pos;
            this.pos = j19 - 1;
            UnsafeUtil.putByte(bArr9, j19, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr10 = this.buffer;
            long j20 = this.pos;
            this.pos = j20 - 1;
            UnsafeUtil.putByte(bArr10, j20, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (((int) j10) >>> 14));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((j10 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) ((j10 & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (j10 >>> 7));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) ((((int) j10) & 127) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.google.protobuf.BinaryWriter
        public void requireSpace(int i10) {
            if (spaceLeft() < i10) {
                nextBuffer(i10);
            }
        }

        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i10, boolean z10) {
            requireSpace(6);
            write(z10 ? (byte) 1 : (byte) 0);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i10, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i10, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int i10) {
            writeTag(i10, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i10, int i11) {
            requireSpace(9);
            writeFixed32(i11);
            writeTag(i10, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i10, long j10) {
            requireSpace(13);
            writeFixed64(j10);
            writeTag(i10, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj) throws IOException {
            writeTag(i10, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i10, int i11) {
            requireSpace(15);
            writeInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i10, int i11) {
            if (i10 >= 0 && i10 + i11 <= bArr.length) {
                if (spaceLeft() < i11) {
                    this.totalDoneBytes += i11;
                    this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i10, i11));
                    nextBuffer();
                    return;
                } else {
                    this.pos -= i11;
                    System.arraycopy((Object) bArr, i10, (Object) this.buffer, arrayPos() + 1, i11);
                    return;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i10, int i11) {
            requireSpace(10);
            writeSInt32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i10, long j10) {
            requireSpace(15);
            writeSInt64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int i10) {
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i10, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeTag(int i10, int i11) {
            writeVarint32(WireFormat.makeTag(i10, i11));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i10, int i11) {
            requireSpace(10);
            writeVarint32(i11);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i10, long j10) {
            requireSpace(15);
            writeVarint64(j10);
            writeTag(i10, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint32(int i10) {
            if ((i10 & (-128)) == 0) {
                writeVarint32OneByte(i10);
                return;
            }
            if ((i10 & (-16384)) == 0) {
                writeVarint32TwoBytes(i10);
                return;
            }
            if (((-2097152) & i10) == 0) {
                writeVarint32ThreeBytes(i10);
            } else if (((-268435456) & i10) == 0) {
                writeVarint32FourBytes(i10);
            } else {
                writeVarint32FiveBytes(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeVarint64(long j10) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j10)) {
                case 1:
                    writeVarint64OneByte(j10);
                    return;
                case 2:
                    writeVarint64TwoBytes(j10);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j10);
                    return;
                case 4:
                    writeVarint64FourBytes(j10);
                    return;
                case 5:
                    writeVarint64FiveBytes(j10);
                    return;
                case 6:
                    writeVarint64SixBytes(j10);
                    return;
                case 7:
                    writeVarint64SevenBytes(j10);
                    return;
                case 8:
                    writeVarint64EightBytes(j10);
                    return;
                case 9:
                    writeVarint64NineBytes(j10);
                    return;
                case 10:
                    writeVarint64TenBytes(j10);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i10) {
            nextBuffer(newHeapBuffer(i10));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i10, int i11) {
            if (i10 >= 0 && i10 + i11 <= bArr.length) {
                requireSpace(i11);
                this.pos -= i11;
                System.arraycopy((Object) bArr, i10, (Object) this.buffer, arrayPos() + 1, i11);
                return;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.buffer = allocatedBuffer.array();
                long arrayOffset = allocatedBuffer.arrayOffset();
                this.limit = allocatedBuffer.limit() + arrayOffset;
                long position = arrayOffset + allocatedBuffer.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                long j10 = this.limit - 1;
                this.limitMinusOne = j10;
                this.pos = j10;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeBool(boolean z10) {
            write(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed32(int i10) {
            byte[] bArr = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr, j10, (byte) ((i10 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr2, j11, (byte) ((i10 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr3, j12, (byte) ((i10 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr4, j13, (byte) (i10 & 255));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeFixed64(long j10) {
            byte[] bArr = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr, j11, (byte) (((int) (j10 >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr2, j12, (byte) (((int) (j10 >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr3, j13, (byte) (((int) (j10 >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr4, j14, (byte) (((int) (j10 >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr5, j15, (byte) (((int) (j10 >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr6, j16, (byte) (((int) (j10 >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j17 = this.pos;
            this.pos = j17 - 1;
            UnsafeUtil.putByte(bArr7, j17, (byte) (((int) (j10 >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j18 = this.pos;
            this.pos = j18 - 1;
            UnsafeUtil.putByte(bArr8, j18, (byte) (((int) j10) & 255));
        }

        @Override // com.google.protobuf.Writer
        public void writeGroup(int i10, Object obj, Schema schema) throws IOException {
            writeTag(i10, 4);
            schema.writeTo(obj, this);
            writeTag(i10, 3);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeInt32(int i10) {
            if (i10 >= 0) {
                writeVarint32(i10);
            } else {
                writeVarint64(i10);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt32(int i10) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i10));
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeSInt64(long j10) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j10));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i10, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i10, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                byte[] bArr = this.buffer;
                long j10 = this.pos;
                this.pos = j10 - 1;
                UnsafeUtil.putByte(bArr, j10, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    long j11 = this.pos;
                    if (j11 > this.offsetMinusOne) {
                        byte[] bArr2 = this.buffer;
                        this.pos = j11 - 1;
                        UnsafeUtil.putByte(bArr2, j11, (byte) charAt2);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j12 = this.pos;
                    if (j12 > this.offset) {
                        byte[] bArr3 = this.buffer;
                        this.pos = j12 - 1;
                        UnsafeUtil.putByte(bArr3, j12, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr4 = this.buffer;
                        long j13 = this.pos;
                        this.pos = j13 - 1;
                        UnsafeUtil.putByte(bArr4, j13, (byte) ((charAt2 >>> 6) | 960));
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j14 = this.pos;
                    if (j14 > this.offset + 1) {
                        byte[] bArr5 = this.buffer;
                        this.pos = j14 - 1;
                        UnsafeUtil.putByte(bArr5, j14, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr6 = this.buffer;
                        long j15 = this.pos;
                        this.pos = j15 - 1;
                        UnsafeUtil.putByte(bArr6, j15, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byte[] bArr7 = this.buffer;
                        long j16 = this.pos;
                        this.pos = j16 - 1;
                        UnsafeUtil.putByte(bArr7, j16, (byte) ((charAt2 >>> '\f') | 480));
                        length--;
                    }
                }
                if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr8 = this.buffer;
                            long j17 = this.pos;
                            this.pos = j17 - 1;
                            UnsafeUtil.putByte(bArr8, j17, (byte) ((codePoint & 63) | 128));
                            byte[] bArr9 = this.buffer;
                            long j18 = this.pos;
                            this.pos = j18 - 1;
                            UnsafeUtil.putByte(bArr9, j18, (byte) (((codePoint >>> 6) & 63) | 128));
                            byte[] bArr10 = this.buffer;
                            long j19 = this.pos;
                            this.pos = j19 - 1;
                            UnsafeUtil.putByte(bArr10, j19, (byte) (((codePoint >>> 12) & 63) | 128));
                            byte[] bArr11 = this.buffer;
                            long j20 = this.pos;
                            this.pos = j20 - 1;
                            UnsafeUtil.putByte(bArr11, j20, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                requireSpace(length);
                length++;
                length--;
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i10, AnonymousClass1 anonymousClass1) {
        this(bufferAllocator, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j10) {
        byte b4;
        if (((-128) & j10) == 0) {
            return (byte) 1;
        }
        if (j10 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j10) != 0) {
            b4 = (byte) 6;
            j10 >>>= 28;
        } else {
            b4 = 2;
        }
        if (((-2097152) & j10) != 0) {
            b4 = (byte) (b4 + 2);
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? (byte) (b4 + 1) : b4;
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i10) {
        return new SafeDirectWriter(bufferAllocator, i10);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i10) {
        return new SafeHeapWriter(bufferAllocator, i10);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i10) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i10);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i10) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i10);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void writeBoolList_Internal(int i10, List<Boolean> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i10, list.get(size2).booleanValue());
        }
    }

    private final void writeDoubleList_Internal(int i10, List<Double> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i10, list.get(size2).doubleValue());
        }
    }

    private final void writeFixed32List_Internal(int i10, List<Integer> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i10, list.get(size2).intValue());
        }
    }

    private final void writeFixed64List_Internal(int i10, List<Long> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i10, list.get(size2).longValue());
        }
    }

    private final void writeFloatList_Internal(int i10, List<Float> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i10, list.get(size2).floatValue());
        }
    }

    private final void writeInt32List_Internal(int i10, List<Integer> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i10, list.get(size2).intValue());
        }
    }

    private void writeLazyString(int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i10, (String) obj);
        } else {
            writeBytes(i10, (ByteString) obj);
        }
    }

    public static final void writeMapEntryField(Writer writer, int i10, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i10, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i10, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i10, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i10, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i10, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i10, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i10, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i10, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i10, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i10, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i10, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i10, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i10, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i10, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i10, obj);
                return;
            case 16:
                writer.writeBytes(i10, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i10, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    if (obj instanceof Integer) {
                        writer.writeEnum(i10, ((Integer) obj).intValue());
                        return;
                    }
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + ((Object) fieldType));
        }
    }

    private final void writeSInt32List_Internal(int i10, List<Integer> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i10, list.get(size2).intValue());
        }
    }

    private final void writeSInt64List_Internal(int i10, List<Long> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i10, list.get(size2).longValue());
        }
    }

    private final void writeUInt32List_Internal(int i10, List<Integer> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i10, list.get(size2).intValue());
        }
    }

    private final void writeUInt64List_Internal(int i10, List<Long> list, boolean z10) throws IOException {
        if (z10) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i10, list.get(size2).longValue());
        }
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.google.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int i10);

    public abstract void writeBool(boolean z10);

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int i10, List<Boolean> list, boolean z10) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i10, (BooleanArrayList) list, z10);
        } else {
            writeBoolList_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int i10, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i10, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int i10, double d10) throws IOException {
        writeFixed64(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int i10, List<Double> list, boolean z10) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i10, (DoubleArrayList) list, z10);
        } else {
            writeDoubleList_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int i10, int i11) throws IOException {
        writeInt32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int i10, List<Integer> list, boolean z10) throws IOException {
        writeInt32List(i10, list, z10);
    }

    public abstract void writeFixed32(int i10);

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i10, (IntArrayList) list, z10);
        } else {
            writeFixed32List_Internal(i10, list, z10);
        }
    }

    public abstract void writeFixed64(long j10);

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i10, (LongArrayList) list, z10);
        } else {
            writeFixed64List_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int i10, float f10) throws IOException {
        writeFixed32(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int i10, List<Float> list, boolean z10) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i10, (FloatArrayList) list, z10);
        } else {
            writeFloatList_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i10, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i10, list.get(size));
        }
    }

    public abstract void writeInt32(int i10);

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i10, (IntArrayList) list, z10);
        } else {
            writeInt32List_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int i10, long j10) throws IOException {
        writeUInt64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        writeUInt64List(i10, list, z10);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i10, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
            writeMapEntryField(this, 1, metadata.keyType, entry.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int i10, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i10, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i10, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i10);
        writeTag(1, 3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int i10, int i11) throws IOException {
        writeFixed32(i10, i11);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        writeFixed32List(i10, list, z10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int i10, long j10) throws IOException {
        writeFixed64(i10, j10);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        writeFixed64List(i10, list, z10);
    }

    public abstract void writeSInt32(int i10);

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i10, (IntArrayList) list, z10);
        } else {
            writeSInt32List_Internal(i10, list, z10);
        }
    }

    public abstract void writeSInt64(long j10);

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i10, (LongArrayList) list, z10);
        } else {
            writeSInt64List_Internal(i10, list, z10);
        }
    }

    public abstract void writeString(String str);

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int i10, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(i10, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i10, list.get(size2));
        }
    }

    public abstract void writeTag(int i10, int i11);

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i10, (IntArrayList) list, z10);
        } else {
            writeUInt32List_Internal(i10, list, z10);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i10, (LongArrayList) list, z10);
        } else {
            writeUInt64List_Internal(i10, list, z10);
        }
    }

    public abstract void writeVarint32(int i10);

    public abstract void writeVarint64(long j10);

    private BinaryWriter(BufferAllocator bufferAllocator, int i10) {
        this.buffers = new ArrayDeque<>(4);
        if (i10 > 0) {
            this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
            this.chunkSize = i10;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i10) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, i10);
        }
        return newSafeDirectInstance(bufferAllocator, i10);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i10) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, i10);
        }
        return newSafeHeapInstance(bufferAllocator, i10);
    }

    public final AllocatedBuffer newDirectBuffer(int i10) {
        return this.alloc.allocateDirectBuffer(Math.max(i10, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int i10) {
        return this.alloc.allocateHeapBuffer(Math.max(i10, this.chunkSize));
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i10, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i10, list.get(size), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageList(int i10, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i10, list.get(size), schema);
        }
    }

    private final void writeBoolList_Internal(int i10, BooleanArrayList booleanArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i10, booleanArrayList.getBoolean(size2));
        }
    }

    private final void writeDoubleList_Internal(int i10, DoubleArrayList doubleArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i10, doubleArrayList.getDouble(size2));
        }
    }

    private final void writeFixed32List_Internal(int i10, IntArrayList intArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i10, intArrayList.getInt(size2));
        }
    }

    private final void writeFixed64List_Internal(int i10, LongArrayList longArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i10, longArrayList.getLong(size2));
        }
    }

    private final void writeFloatList_Internal(int i10, FloatArrayList floatArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i10, floatArrayList.getFloat(size2));
        }
    }

    private final void writeInt32List_Internal(int i10, IntArrayList intArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i10, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt32List_Internal(int i10, IntArrayList intArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i10, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt64List_Internal(int i10, LongArrayList longArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i10, longArrayList.getLong(size2));
        }
    }

    private final void writeUInt32List_Internal(int i10, IntArrayList intArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i10, intArrayList.getInt(size2));
        }
    }

    private final void writeUInt64List_Internal(int i10, LongArrayList longArrayList, boolean z10) throws IOException {
        if (z10) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i10, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i10, longArrayList.getLong(size2));
        }
    }
}
