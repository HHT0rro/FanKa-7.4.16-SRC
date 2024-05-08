package com.android.framework.protobuf;

import com.android.internal.os.PowerProfile;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    static {
        Processor safeProcessor;
        if (UnsafeProcessor.isAvailable() && !Android.isOnAndroidDevice()) {
            safeProcessor = new UnsafeProcessor();
        } else {
            safeProcessor = new SafeProcessor();
        }
        processor = safeProcessor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bytes) {
        return processor.isValidUtf8(bytes, 0, bytes.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(byte[] bytes, int index, int limit) {
        return processor.isValidUtf8(bytes, index, limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
        return processor.partialIsValidUtf8(state, bytes, index, limit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1) {
        if (byte1 > -12) {
            return -1;
        }
        return byte1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2) {
        if (byte1 > -12 || byte2 > -65) {
            return -1;
        }
        return (byte2 << 8) ^ byte1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int byte1, int byte2, int byte3) {
        if (byte1 > -12 || byte2 > -65 || byte3 > -65) {
            return -1;
        }
        return ((byte2 << 8) ^ byte1) ^ (byte3 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bytes, int index, int limit) {
        int byte1 = bytes[index - 1];
        switch (limit - index) {
            case 0:
                return incompleteStateFor(byte1);
            case 1:
                return incompleteStateFor(byte1, bytes[index]);
            case 2:
                return incompleteStateFor(byte1, bytes[index], bytes[index + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer buffer, int byte1, int index, int remaining) {
        switch (remaining) {
            case 0:
                return incompleteStateFor(byte1);
            case 1:
                return incompleteStateFor(byte1, buffer.get(index));
            case 2:
                return incompleteStateFor(byte1, buffer.get(index), buffer.get(index + 1));
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        /* JADX INFO: Access modifiers changed from: package-private */
        public UnpairedSurrogateException(int index, int length) {
            super("Unpaired surrogate at index " + index + " of " + length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encodedLength(CharSequence sequence) {
        int utf16Length = sequence.length();
        int utf8Length = utf16Length;
        int i10 = 0;
        while (i10 < utf16Length && sequence.charAt(i10) < 128) {
            i10++;
        }
        while (true) {
            if (i10 < utf16Length) {
                char c4 = sequence.charAt(i10);
                if (c4 < 2048) {
                    utf8Length += (127 - c4) >>> 31;
                    i10++;
                } else {
                    utf8Length += encodedLengthGeneral(sequence, i10);
                    break;
                }
            } else {
                break;
            }
        }
        if (utf8Length < utf16Length) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (utf8Length + PowerProfile.SUBSYSTEM_MODEM));
        }
        return utf8Length;
    }

    private static int encodedLengthGeneral(CharSequence sequence, int start) {
        int utf16Length = sequence.length();
        int utf8Length = 0;
        int i10 = start;
        while (i10 < utf16Length) {
            char c4 = sequence.charAt(i10);
            if (c4 < 2048) {
                utf8Length += (127 - c4) >>> 31;
            } else {
                utf8Length += 2;
                if (55296 <= c4 && c4 <= 57343) {
                    int cp = Character.codePointAt(sequence, i10);
                    if (cp < 65536) {
                        throw new UnpairedSurrogateException(i10, utf16Length);
                    }
                    i10++;
                }
            }
            i10++;
        }
        return utf8Length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int encode(CharSequence in, byte[] out, int offset, int length) {
        return processor.encodeUtf8(in, out, offset, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidUtf8(ByteBuffer buffer) {
        return processor.isValidUtf8(buffer, buffer.position(), buffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
        return processor.partialIsValidUtf8(state, buffer, index, limit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(buffer, index, size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bytes, index, size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void encodeUtf8(CharSequence in, ByteBuffer out) {
        processor.encodeUtf8(in, out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer buffer, int index, int limit) {
        int i10 = index;
        int lim = limit - 7;
        while (i10 < lim && (buffer.getLong(i10) & ASCII_MASK_LONG) == 0) {
            i10 += 8;
        }
        return i10 - index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class Processor {
        abstract String decodeUtf8(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException;

        abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i10, int i11) throws InvalidProtocolBufferException;

        abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i10, int i11);

        abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        abstract int partialIsValidUtf8(int i10, byte[] bArr, int i11, int i12);

        abstract int partialIsValidUtf8Direct(int i10, ByteBuffer byteBuffer, int i11, int i12);

        Processor() {
        }

        final boolean isValidUtf8(byte[] bytes, int index, int limit) {
            return partialIsValidUtf8(0, bytes, index, limit) == 0;
        }

        final boolean isValidUtf8(ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8(0, buffer, index, limit) == 0;
        }

        final int partialIsValidUtf8(int state, ByteBuffer buffer, int index, int limit) {
            if (buffer.hasArray()) {
                int offset = buffer.arrayOffset();
                return partialIsValidUtf8(state, buffer.array(), offset + index, offset + limit);
            }
            if (buffer.isDirect()) {
                return partialIsValidUtf8Direct(state, buffer, index, limit);
            }
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        final int partialIsValidUtf8Default(int state, ByteBuffer buffer, int index, int limit) {
            if (state != 0) {
                if (index >= limit) {
                    return state;
                }
                byte byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 >= -62) {
                        int index2 = index + 1;
                        if (buffer.get(index) <= -65) {
                            index = index2;
                        }
                    }
                    return -1;
                }
                if (byte1 < -16) {
                    byte byte2 = (byte) (~(state >> 8));
                    if (byte2 == 0) {
                        int index3 = index + 1;
                        byte2 = buffer.get(index);
                        if (index3 >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                        index = index3;
                    }
                    if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                        int index4 = index + 1;
                        if (buffer.get(index) <= -65) {
                            index = index4;
                        }
                    }
                    return -1;
                }
                byte byte22 = (byte) (~(state >> 8));
                byte byte3 = 0;
                if (byte22 == 0) {
                    int index5 = index + 1;
                    byte22 = buffer.get(index);
                    if (index5 >= limit) {
                        return Utf8.incompleteStateFor(byte1, byte22);
                    }
                    index = index5;
                } else {
                    byte3 = (byte) (state >> 16);
                }
                if (byte3 == 0) {
                    int index6 = index + 1;
                    byte3 = buffer.get(index);
                    if (index6 >= limit) {
                        return Utf8.incompleteStateFor(byte1, byte22, byte3);
                    }
                    index = index6;
                }
                if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0 && byte3 <= -65) {
                    int index7 = index + 1;
                    if (buffer.get(index) <= -65) {
                        index = index7;
                    }
                }
                return -1;
            }
            return partialIsValidUtf8(buffer, index, limit);
        }

        private static int partialIsValidUtf8(ByteBuffer buffer, int index, int limit) {
            int index2 = index + Utf8.estimateConsecutiveAscii(buffer, index, limit);
            while (index2 < limit) {
                int index3 = index2 + 1;
                int byte1 = buffer.get(index2);
                if (byte1 >= 0) {
                    index2 = index3;
                } else if (byte1 < -32) {
                    if (index3 >= limit) {
                        return byte1;
                    }
                    if (byte1 < -62 || buffer.get(index3) > -65) {
                        return -1;
                    }
                    index2 = index3 + 1;
                } else if (byte1 < -16) {
                    if (index3 >= limit - 1) {
                        return Utf8.incompleteStateFor(buffer, byte1, index3, limit - index3);
                    }
                    int index4 = index3 + 1;
                    byte byte2 = buffer.get(index3);
                    if (byte2 > -65 || ((byte1 == -32 && byte2 < -96) || ((byte1 == -19 && byte2 >= -96) || buffer.get(index4) > -65))) {
                        return -1;
                    }
                    index2 = index4 + 1;
                } else {
                    if (index3 >= limit - 2) {
                        return Utf8.incompleteStateFor(buffer, byte1, index3, limit - index3);
                    }
                    int index5 = index3 + 1;
                    int byte22 = buffer.get(index3);
                    if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0) {
                        int index6 = index5 + 1;
                        if (buffer.get(index5) <= -65) {
                            index2 = index6 + 1;
                            if (buffer.get(index6) > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }

        final String decodeUtf8(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if (buffer.hasArray()) {
                int offset = buffer.arrayOffset();
                return decodeUtf8(buffer.array(), offset + index, size);
            }
            if (buffer.isDirect()) {
                return decodeUtf8Direct(buffer, index, size);
            }
            return decodeUtf8Default(buffer, index, size);
        }

        final String decodeUtf8Default(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
            while (offset < limit) {
                byte b4 = buffer.get(offset);
                if (!DecodeUtil.isOneByte(b4)) {
                    break;
                }
                offset++;
                DecodeUtil.handleOneByte(b4, resultArr, resultPos);
                resultPos++;
            }
            int resultPos2 = resultPos;
            while (offset < limit) {
                int offset2 = offset + 1;
                byte byte1 = buffer.get(offset);
                if (DecodeUtil.isOneByte(byte1)) {
                    int resultPos3 = resultPos2 + 1;
                    DecodeUtil.handleOneByte(byte1, resultArr, resultPos2);
                    while (offset2 < limit) {
                        byte b10 = buffer.get(offset2);
                        if (!DecodeUtil.isOneByte(b10)) {
                            break;
                        }
                        offset2++;
                        DecodeUtil.handleOneByte(b10, resultArr, resultPos3);
                        resultPos3++;
                    }
                    offset = offset2;
                    resultPos2 = resultPos3;
                } else if (DecodeUtil.isTwoBytes(byte1)) {
                    if (offset2 >= limit) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleTwoBytes(byte1, buffer.get(offset2), resultArr, resultPos2);
                    offset = offset2 + 1;
                    resultPos2++;
                } else if (DecodeUtil.isThreeBytes(byte1)) {
                    if (offset2 >= limit - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset3 = offset2 + 1;
                    DecodeUtil.handleThreeBytes(byte1, buffer.get(offset2), buffer.get(offset3), resultArr, resultPos2);
                    offset = offset3 + 1;
                    resultPos2++;
                } else {
                    if (offset2 >= limit - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset4 = offset2 + 1;
                    byte b11 = buffer.get(offset2);
                    int offset5 = offset4 + 1;
                    DecodeUtil.handleFourBytes(byte1, b11, buffer.get(offset4), buffer.get(offset5), resultArr, resultPos2);
                    offset = offset5 + 1;
                    resultPos2 = resultPos2 + 1 + 1;
                }
            }
            return new String(resultArr, 0, resultPos2);
        }

        final void encodeUtf8(CharSequence in, ByteBuffer out) {
            if (out.hasArray()) {
                int offset = out.arrayOffset();
                int endIndex = Utf8.encode(in, out.array(), out.position() + offset, out.remaining());
                out.position(endIndex - offset);
            } else if (out.isDirect()) {
                encodeUtf8Direct(in, out);
            } else {
                encodeUtf8Default(in, out);
            }
        }

        final void encodeUtf8Default(CharSequence in, ByteBuffer out) {
            int inLength = in.length();
            int outIx = out.position();
            int inIx = 0;
            while (inIx < inLength) {
                try {
                    char c4 = in.charAt(inIx);
                    if (c4 >= 128) {
                        break;
                    }
                    out.put(outIx + inIx, (byte) c4);
                    inIx++;
                } catch (IndexOutOfBoundsException e2) {
                    int badWriteIndex = out.position() + Math.max(inIx, (outIx - out.position()) + 1);
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inIx) + " at index " + badWriteIndex);
                }
            }
            if (inIx == inLength) {
                out.position(outIx + inIx);
                return;
            }
            int outIx2 = outIx + inIx;
            while (inIx < inLength) {
                char c10 = in.charAt(inIx);
                if (c10 < 128) {
                    out.put(outIx2, (byte) c10);
                } else if (c10 < 2048) {
                    int outIx3 = outIx2 + 1;
                    try {
                        out.put(outIx2, (byte) ((c10 >>> 6) | 192));
                        out.put(outIx3, (byte) ((c10 & '?') | 128));
                        outIx2 = outIx3;
                    } catch (IndexOutOfBoundsException e10) {
                        outIx = outIx3;
                        int badWriteIndex2 = out.position() + Math.max(inIx, (outIx - out.position()) + 1);
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inIx) + " at index " + badWriteIndex2);
                    }
                } else if (c10 < 55296 || 57343 < c10) {
                    int outIx4 = outIx2 + 1;
                    out.put(outIx2, (byte) ((c10 >>> '\f') | 224));
                    outIx2 = outIx4 + 1;
                    out.put(outIx4, (byte) (((c10 >>> 6) & 63) | 128));
                    out.put(outIx2, (byte) ((c10 & '?') | 128));
                } else {
                    if (inIx + 1 != inLength) {
                        inIx++;
                        char low = in.charAt(inIx);
                        if (Character.isSurrogatePair(c10, low)) {
                            int codePoint = Character.toCodePoint(c10, low);
                            int outIx5 = outIx2 + 1;
                            try {
                                out.put(outIx2, (byte) ((codePoint >>> 18) | 240));
                                int outIx6 = outIx5 + 1;
                                out.put(outIx5, (byte) (((codePoint >>> 12) & 63) | 128));
                                int outIx7 = outIx6 + 1;
                                out.put(outIx6, (byte) (((codePoint >>> 6) & 63) | 128));
                                out.put(outIx7, (byte) ((codePoint & 63) | 128));
                                outIx2 = outIx7;
                            } catch (IndexOutOfBoundsException e11) {
                                outIx = outIx5;
                                int badWriteIndex22 = out.position() + Math.max(inIx, (outIx - out.position()) + 1);
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inIx) + " at index " + badWriteIndex22);
                            }
                        }
                    }
                    throw new UnpairedSurrogateException(inIx, inLength);
                }
                inIx++;
                outIx2++;
            }
            out.position(outIx2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if (state != 0) {
                if (index >= limit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 >= -62) {
                        int index2 = index + 1;
                        if (bytes[index] <= -65) {
                            index = index2;
                        }
                    }
                    return -1;
                }
                if (byte1 < -16) {
                    int byte2 = (byte) (~(state >> 8));
                    if (byte2 == 0) {
                        int index3 = index + 1;
                        byte2 = bytes[index];
                        if (index3 >= limit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                        index = index3;
                    }
                    if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                        int index4 = index + 1;
                        if (bytes[index] <= -65) {
                            index = index4;
                        }
                    }
                    return -1;
                }
                int byte22 = (byte) (~(state >> 8));
                int byte3 = 0;
                if (byte22 == 0) {
                    int index5 = index + 1;
                    byte22 = bytes[index];
                    if (index5 >= limit) {
                        return Utf8.incompleteStateFor(byte1, byte22);
                    }
                    index = index5;
                } else {
                    byte3 = (byte) (state >> 16);
                }
                if (byte3 == 0) {
                    int index6 = index + 1;
                    byte3 = bytes[index];
                    if (index6 >= limit) {
                        return Utf8.incompleteStateFor(byte1, byte22, byte3);
                    }
                    index = index6;
                }
                if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0 && byte3 <= -65) {
                    int index7 = index + 1;
                    if (bytes[index] <= -65) {
                        index = index7;
                    }
                }
                return -1;
            }
            return partialIsValidUtf8(bytes, index, limit);
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            return partialIsValidUtf8Default(state, buffer, index, limit);
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((bytes.length - index) - size)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(size)));
            }
            int offset = index;
            int limit = offset + size;
            char[] resultArr = new char[size];
            int resultPos = 0;
            while (offset < limit) {
                byte b4 = bytes[offset];
                if (!DecodeUtil.isOneByte(b4)) {
                    break;
                }
                offset++;
                DecodeUtil.handleOneByte(b4, resultArr, resultPos);
                resultPos++;
            }
            int resultPos2 = resultPos;
            while (offset < limit) {
                int offset2 = offset + 1;
                byte byte1 = bytes[offset];
                if (DecodeUtil.isOneByte(byte1)) {
                    int resultPos3 = resultPos2 + 1;
                    DecodeUtil.handleOneByte(byte1, resultArr, resultPos2);
                    while (offset2 < limit) {
                        byte b10 = bytes[offset2];
                        if (!DecodeUtil.isOneByte(b10)) {
                            break;
                        }
                        offset2++;
                        DecodeUtil.handleOneByte(b10, resultArr, resultPos3);
                        resultPos3++;
                    }
                    offset = offset2;
                    resultPos2 = resultPos3;
                } else if (DecodeUtil.isTwoBytes(byte1)) {
                    if (offset2 >= limit) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    DecodeUtil.handleTwoBytes(byte1, bytes[offset2], resultArr, resultPos2);
                    offset = offset2 + 1;
                    resultPos2++;
                } else if (DecodeUtil.isThreeBytes(byte1)) {
                    if (offset2 >= limit - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset3 = offset2 + 1;
                    DecodeUtil.handleThreeBytes(byte1, bytes[offset2], bytes[offset3], resultArr, resultPos2);
                    offset = offset3 + 1;
                    resultPos2++;
                } else {
                    if (offset2 >= limit - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int offset4 = offset2 + 1;
                    byte b11 = bytes[offset2];
                    int offset5 = offset4 + 1;
                    DecodeUtil.handleFourBytes(byte1, b11, bytes[offset4], bytes[offset5], resultArr, resultPos2);
                    offset = offset5 + 1;
                    resultPos2 = resultPos2 + 1 + 1;
                }
            }
            return new String(resultArr, 0, resultPos2);
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            return decodeUtf8Default(buffer, index, size);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            return r13 + r0;
         */
        @Override // com.android.framework.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int encodeUtf8(java.lang.CharSequence r11, byte[] r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.Utf8.SafeProcessor.encodeUtf8(java.lang.CharSequence, byte[], int, int):int");
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            encodeUtf8Default(in, out);
        }

        private static int partialIsValidUtf8(byte[] bytes, int index, int limit) {
            while (index < limit && bytes[index] >= 0) {
                index++;
            }
            if (index >= limit) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bytes, index, limit);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bytes, int index, int limit) {
            while (index < limit) {
                int index2 = index + 1;
                int byte1 = bytes[index];
                if (byte1 >= 0) {
                    index = index2;
                } else {
                    if (byte1 < -32) {
                        if (index2 >= limit) {
                            return byte1;
                        }
                        if (byte1 >= -62) {
                            index = index2 + 1;
                            if (bytes[index2] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (byte1 < -16) {
                        if (index2 >= limit - 1) {
                            return Utf8.incompleteStateFor(bytes, index2, limit);
                        }
                        int index3 = index2 + 1;
                        int byte2 = bytes[index2];
                        if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                            index = index3 + 1;
                            if (bytes[index3] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (index2 >= limit - 2) {
                        return Utf8.incompleteStateFor(bytes, index2, limit);
                    }
                    int index4 = index2 + 1;
                    int byte22 = bytes[index2];
                    if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0) {
                        int index5 = index4 + 1;
                        if (bytes[index4] <= -65) {
                            index = index5 + 1;
                            if (bytes[index5] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        int partialIsValidUtf8(int state, byte[] bytes, int index, int limit) {
            if ((index | limit | (bytes.length - limit)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bytes.length), Integer.valueOf(index), Integer.valueOf(limit)));
            }
            long offset = index;
            long offsetLimit = limit;
            if (state != 0) {
                if (offset >= offsetLimit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 >= -62) {
                        long offset2 = 1 + offset;
                        if (UnsafeUtil.getByte(bytes, offset) <= -65) {
                            offset = offset2;
                        }
                    }
                    return -1;
                }
                if (byte1 < -16) {
                    int byte2 = (byte) (~(state >> 8));
                    if (byte2 == 0) {
                        long offset3 = offset + 1;
                        byte2 = UnsafeUtil.getByte(bytes, offset);
                        if (offset3 >= offsetLimit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                        offset = offset3;
                    }
                    if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                        long offset4 = 1 + offset;
                        if (UnsafeUtil.getByte(bytes, offset) <= -65) {
                            offset = offset4;
                        }
                    }
                    return -1;
                }
                int byte22 = (byte) (~(state >> 8));
                int byte3 = 0;
                if (byte22 == 0) {
                    long offset5 = offset + 1;
                    byte22 = UnsafeUtil.getByte(bytes, offset);
                    if (offset5 >= offsetLimit) {
                        return Utf8.incompleteStateFor(byte1, byte22);
                    }
                    offset = offset5;
                } else {
                    byte3 = (byte) (state >> 16);
                }
                if (byte3 == 0) {
                    long offset6 = offset + 1;
                    byte3 = UnsafeUtil.getByte(bytes, offset);
                    if (offset6 >= offsetLimit) {
                        return Utf8.incompleteStateFor(byte1, byte22, byte3);
                    }
                    offset = offset6;
                }
                if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0 && byte3 <= -65) {
                    long offset7 = 1 + offset;
                    if (UnsafeUtil.getByte(bytes, offset) <= -65) {
                        offset = offset7;
                    }
                }
                return -1;
            }
            return partialIsValidUtf8(bytes, offset, (int) (offsetLimit - offset));
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int state, ByteBuffer buffer, int index, int limit) {
            if ((index | limit | (buffer.limit() - limit)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(limit)));
            }
            long address = UnsafeUtil.addressOffset(buffer) + index;
            long addressLimit = (limit - index) + address;
            if (state != 0) {
                if (address >= addressLimit) {
                    return state;
                }
                int byte1 = (byte) state;
                if (byte1 < -32) {
                    if (byte1 >= -62) {
                        long address2 = 1 + address;
                        if (UnsafeUtil.getByte(address) <= -65) {
                            address = address2;
                        }
                    }
                    return -1;
                }
                if (byte1 < -16) {
                    int byte2 = (byte) (~(state >> 8));
                    if (byte2 == 0) {
                        long address3 = address + 1;
                        byte2 = UnsafeUtil.getByte(address);
                        if (address3 >= addressLimit) {
                            return Utf8.incompleteStateFor(byte1, byte2);
                        }
                        address = address3;
                    }
                    if (byte2 <= -65 && ((byte1 != -32 || byte2 >= -96) && (byte1 != -19 || byte2 < -96))) {
                        long address4 = 1 + address;
                        if (UnsafeUtil.getByte(address) <= -65) {
                            address = address4;
                        }
                    }
                    return -1;
                }
                int byte22 = (byte) (~(state >> 8));
                int byte3 = 0;
                if (byte22 == 0) {
                    long address5 = address + 1;
                    byte22 = UnsafeUtil.getByte(address);
                    if (address5 >= addressLimit) {
                        return Utf8.incompleteStateFor(byte1, byte22);
                    }
                    address = address5;
                } else {
                    byte3 = (byte) (state >> 16);
                }
                if (byte3 == 0) {
                    long address6 = address + 1;
                    byte3 = UnsafeUtil.getByte(address);
                    if (address6 >= addressLimit) {
                        return Utf8.incompleteStateFor(byte1, byte22, byte3);
                    }
                    address = address6;
                }
                if (byte22 <= -65 && (((byte1 << 28) + (byte22 + 112)) >> 30) == 0 && byte3 <= -65) {
                    long address7 = 1 + address;
                    if (UnsafeUtil.getByte(address) <= -65) {
                        address = address7;
                    }
                }
                return -1;
            }
            return partialIsValidUtf8(address, (int) (addressLimit - address));
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        String decodeUtf8(byte[] bytes, int index, int size) throws InvalidProtocolBufferException {
            String s2 = new String(bytes, index, size, Internal.UTF_8);
            if (!s2.contains("�")) {
                return s2;
            }
            if (Arrays.equals(s2.getBytes(Internal.UTF_8), Arrays.copyOfRange(bytes, index, index + size))) {
                return s2;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer buffer, int index, int size) throws InvalidProtocolBufferException {
            if ((index | size | ((buffer.limit() - index) - size)) >= 0) {
                long address = UnsafeUtil.addressOffset(buffer) + index;
                long addressLimit = size + address;
                char[] resultArr = new char[size];
                int resultPos = 0;
                while (address < addressLimit) {
                    byte b4 = UnsafeUtil.getByte(address);
                    if (!DecodeUtil.isOneByte(b4)) {
                        break;
                    }
                    address++;
                    DecodeUtil.handleOneByte(b4, resultArr, resultPos);
                    resultPos++;
                }
                int resultPos2 = resultPos;
                while (address < addressLimit) {
                    long address2 = address + 1;
                    byte byte1 = UnsafeUtil.getByte(address);
                    if (DecodeUtil.isOneByte(byte1)) {
                        int resultPos3 = resultPos2 + 1;
                        DecodeUtil.handleOneByte(byte1, resultArr, resultPos2);
                        while (address2 < addressLimit) {
                            byte b10 = UnsafeUtil.getByte(address2);
                            if (!DecodeUtil.isOneByte(b10)) {
                                break;
                            }
                            address2++;
                            DecodeUtil.handleOneByte(b10, resultArr, resultPos3);
                            resultPos3++;
                        }
                        resultPos2 = resultPos3;
                        address = address2;
                    } else if (DecodeUtil.isTwoBytes(byte1)) {
                        if (address2 >= addressLimit) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        DecodeUtil.handleTwoBytes(byte1, UnsafeUtil.getByte(address2), resultArr, resultPos2);
                        resultPos2++;
                        address = address2 + 1;
                    } else if (DecodeUtil.isThreeBytes(byte1)) {
                        if (address2 >= addressLimit - 1) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        long address3 = address2 + 1;
                        DecodeUtil.handleThreeBytes(byte1, UnsafeUtil.getByte(address2), UnsafeUtil.getByte(address3), resultArr, resultPos2);
                        address = address3 + 1;
                        resultPos2++;
                    } else {
                        if (address2 >= addressLimit - 2) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        long address4 = address2 + 1;
                        long address5 = address4 + 1;
                        DecodeUtil.handleFourBytes(byte1, UnsafeUtil.getByte(address2), UnsafeUtil.getByte(address4), UnsafeUtil.getByte(address5), resultArr, resultPos2);
                        resultPos2 = resultPos2 + 1 + 1;
                        address = address5 + 1;
                    }
                }
                return new String(resultArr, 0, resultPos2);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(buffer.limit()), Integer.valueOf(index), Integer.valueOf(size)));
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        int encodeUtf8(CharSequence in, byte[] out, int offset, int length) {
            char c4;
            long j10;
            long outIx;
            char c10;
            long outIx2 = offset;
            long outLimit = length + outIx2;
            int inLimit = in.length();
            if (inLimit > length || out.length - length < offset) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inLimit - 1) + " at index " + (offset + length));
            }
            int inIx = 0;
            while (true) {
                c4 = 128;
                j10 = 1;
                if (inIx >= inLimit || (c10 = in.charAt(inIx)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(out, outIx2, (byte) c10);
                inIx++;
                outIx2++;
            }
            if (inIx == inLimit) {
                return (int) outIx2;
            }
            while (inIx < inLimit) {
                char c11 = in.charAt(inIx);
                if (c11 < c4 && outIx2 < outLimit) {
                    UnsafeUtil.putByte(out, outIx2, (byte) c11);
                    outIx2 += j10;
                    c4 = 128;
                    outIx = outLimit;
                } else if (c11 < 2048 && outIx2 <= outLimit - 2) {
                    long outIx3 = outIx2 + j10;
                    UnsafeUtil.putByte(out, outIx2, (byte) ((c11 >>> 6) | 960));
                    outIx2 = outIx3 + j10;
                    UnsafeUtil.putByte(out, outIx3, (byte) ((c11 & '?') | 128));
                    outIx = outLimit;
                    c4 = 128;
                } else {
                    if ((c11 >= 55296 && 57343 >= c11) || outIx2 > outLimit - 3) {
                        if (outIx2 > outLimit - 4) {
                            if (55296 <= c11 && c11 <= 57343 && (inIx + 1 == inLimit || !Character.isSurrogatePair(c11, in.charAt(inIx + 1)))) {
                                throw new UnpairedSurrogateException(inIx, inLimit);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + c11 + " at index " + outIx2);
                        }
                        if (inIx + 1 != inLimit) {
                            inIx++;
                            char low = in.charAt(inIx);
                            if (Character.isSurrogatePair(c11, low)) {
                                int codePoint = Character.toCodePoint(c11, low);
                                outIx = outLimit;
                                long outLimit2 = outIx2 + 1;
                                UnsafeUtil.putByte(out, outIx2, (byte) ((codePoint >>> 18) | 240));
                                long outIx4 = outLimit2 + 1;
                                c4 = 128;
                                UnsafeUtil.putByte(out, outLimit2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long outIx5 = outIx4 + 1;
                                UnsafeUtil.putByte(out, outIx4, (byte) (((codePoint >>> 6) & 63) | 128));
                                outIx2 = outIx5 + 1;
                                UnsafeUtil.putByte(out, outIx5, (byte) ((codePoint & 63) | 128));
                            }
                        }
                        throw new UnpairedSurrogateException(inIx - 1, inLimit);
                    }
                    long outIx6 = outIx2 + 1;
                    UnsafeUtil.putByte(out, outIx2, (byte) ((c11 >>> '\f') | 480));
                    long outIx7 = outIx6 + 1;
                    UnsafeUtil.putByte(out, outIx6, (byte) (((c11 >>> 6) & 63) | 128));
                    UnsafeUtil.putByte(out, outIx7, (byte) ((c11 & '?') | 128));
                    outIx = outLimit;
                    outIx2 = outIx7 + 1;
                    c4 = 128;
                }
                inIx++;
                outLimit = outIx;
                j10 = 1;
            }
            return (int) outIx2;
        }

        @Override // com.android.framework.protobuf.Utf8.Processor
        void encodeUtf8Direct(CharSequence in, ByteBuffer out) {
            char c4;
            long j10;
            long outIx;
            long j11;
            char c10;
            char c11;
            long address = UnsafeUtil.addressOffset(out);
            long outIx2 = out.position() + address;
            long outLimit = out.limit() + address;
            int inLimit = in.length();
            if (inLimit > outLimit - outIx2) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + in.charAt(inLimit - 1) + " at index " + out.limit());
            }
            int inIx = 0;
            while (true) {
                c4 = 128;
                j10 = 1;
                if (inIx >= inLimit || (c11 = in.charAt(inIx)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(outIx2, (byte) c11);
                inIx++;
                outIx2++;
            }
            if (inIx == inLimit) {
                out.position((int) (outIx2 - address));
                return;
            }
            while (inIx < inLimit) {
                char c12 = in.charAt(inIx);
                if (c12 < c4 && outIx2 < outLimit) {
                    UnsafeUtil.putByte(outIx2, (byte) c12);
                    j11 = j10;
                    outIx2 += j10;
                    outIx = address;
                    c10 = 128;
                } else if (c12 >= 2048 || outIx2 > outLimit - 2) {
                    outIx = address;
                    if ((c12 >= 55296 && 57343 >= c12) || outIx2 > outLimit - 3) {
                        if (outIx2 <= outLimit - 4) {
                            if (inIx + 1 != inLimit) {
                                inIx++;
                                char low = in.charAt(inIx);
                                if (Character.isSurrogatePair(c12, low)) {
                                    int codePoint = Character.toCodePoint(c12, low);
                                    long outIx3 = outIx2 + j10;
                                    UnsafeUtil.putByte(outIx2, (byte) ((codePoint >>> 18) | 240));
                                    long outIx4 = outIx3 + 1;
                                    UnsafeUtil.putByte(outIx3, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long outIx5 = outIx4 + 1;
                                    c10 = 128;
                                    UnsafeUtil.putByte(outIx4, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j11 = 1;
                                    outIx2 = outIx5 + 1;
                                    UnsafeUtil.putByte(outIx5, (byte) ((codePoint & 63) | 128));
                                }
                            }
                            throw new UnpairedSurrogateException(inIx - 1, inLimit);
                        }
                        if (55296 <= c12 && c12 <= 57343 && (inIx + 1 == inLimit || !Character.isSurrogatePair(c12, in.charAt(inIx + 1)))) {
                            throw new UnpairedSurrogateException(inIx, inLimit);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + c12 + " at index " + outIx2);
                    }
                    long outIx6 = outIx2 + j10;
                    UnsafeUtil.putByte(outIx2, (byte) ((c12 >>> '\f') | 480));
                    long outIx7 = outIx6 + j10;
                    UnsafeUtil.putByte(outIx6, (byte) (((c12 >>> 6) & 63) | 128));
                    UnsafeUtil.putByte(outIx7, (byte) ((c12 & '?') | 128));
                    outIx2 = outIx7 + j10;
                    j11 = j10;
                    c10 = 128;
                } else {
                    outIx = address;
                    long outIx8 = outIx2 + j10;
                    UnsafeUtil.putByte(outIx2, (byte) ((c12 >>> 6) | 960));
                    UnsafeUtil.putByte(outIx8, (byte) ((c12 & '?') | 128));
                    outIx2 = outIx8 + j10;
                    j11 = j10;
                    c10 = 128;
                }
                inIx++;
                c4 = c10;
                address = outIx;
                j10 = j11;
            }
            out.position((int) (outIx2 - address));
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bytes, long offset, int maxChars) {
            if (maxChars < 16) {
                return 0;
            }
            int unaligned = 8 - (((int) offset) & 7);
            int i10 = 0;
            while (i10 < unaligned) {
                long offset2 = 1 + offset;
                if (UnsafeUtil.getByte(bytes, offset) >= 0) {
                    i10++;
                    offset = offset2;
                } else {
                    return i10;
                }
            }
            while (i10 + 8 <= maxChars && (UnsafeUtil.getLong((Object) bytes, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + offset) & Utf8.ASCII_MASK_LONG) == 0) {
                offset += 8;
                i10 += 8;
            }
            while (i10 < maxChars) {
                long offset3 = offset + 1;
                if (UnsafeUtil.getByte(bytes, offset) >= 0) {
                    i10++;
                    offset = offset3;
                } else {
                    return i10;
                }
            }
            return maxChars;
        }

        private static int unsafeEstimateConsecutiveAscii(long address, int maxChars) {
            if (maxChars < 16) {
                return 0;
            }
            int unaligned = (int) ((-address) & 7);
            int j10 = unaligned;
            while (j10 > 0) {
                long address2 = 1 + address;
                if (UnsafeUtil.getByte(address) >= 0) {
                    j10--;
                    address = address2;
                } else {
                    return unaligned - j10;
                }
            }
            int remaining = maxChars - unaligned;
            while (remaining >= 8 && (UnsafeUtil.getLong(address) & Utf8.ASCII_MASK_LONG) == 0) {
                address += 8;
                remaining -= 8;
            }
            return maxChars - remaining;
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x003b, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(byte[] r11, long r12, int r14) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r11, r12, r14)
                int r14 = r14 - r0
                long r1 = (long) r0
                long r12 = r12 + r1
            L7:
                r1 = 0
            L8:
                r2 = 1
                if (r14 <= 0) goto L1a
                long r4 = r12 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r12)
                r1 = r12
                if (r12 < 0) goto L19
                int r14 = r14 + (-1)
                r12 = r4
                goto L8
            L19:
                r12 = r4
            L1a:
                if (r14 != 0) goto L1e
                r2 = 0
                return r2
            L1e:
                int r14 = r14 + (-1)
                r4 = -32
                r5 = -65
                r6 = -1
                if (r1 >= r4) goto L3c
                if (r14 != 0) goto L2a
                return r1
            L2a:
                int r14 = r14 + (-1)
                r4 = -62
                if (r1 < r4) goto L3b
                long r2 = r2 + r12
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r12)
                if (r12 <= r5) goto L39
                r12 = r2
                goto L3b
            L39:
                r12 = r2
                goto L99
            L3b:
                return r6
            L3c:
                r7 = -16
                if (r1 >= r7) goto L6b
                r7 = 2
                if (r14 >= r7) goto L48
                int r2 = unsafeIncompleteStateFor(r11, r1, r12, r14)
                return r2
            L48:
                int r14 = r14 + (-2)
                long r7 = r12 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r12)
                r13 = r12
                if (r12 > r5) goto L6a
                r12 = -96
                if (r1 != r4) goto L59
                if (r13 < r12) goto L6a
            L59:
                r4 = -19
                if (r1 != r4) goto L5f
                if (r13 >= r12) goto L6a
            L5f:
                long r2 = r2 + r7
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r7)
                if (r12 <= r5) goto L68
                r7 = r2
                goto L6a
            L68:
                r12 = r2
                goto L99
            L6a:
                return r6
            L6b:
                r4 = 3
                if (r14 >= r4) goto L73
                int r2 = unsafeIncompleteStateFor(r11, r1, r12, r14)
                return r2
            L73:
                int r14 = r14 + (-3)
                long r7 = r12 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r12)
                r13 = r12
                if (r12 > r5) goto L9c
                int r12 = r1 << 28
                int r4 = r13 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L9c
                long r9 = r7 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r7)
                if (r12 > r5) goto L9b
                long r7 = r9 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r11, r9)
                if (r12 <= r5) goto L98
                goto L9c
            L98:
                r12 = r7
            L99:
                goto L7
            L9b:
                r7 = r9
            L9c:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x003b, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r11, r13)
                long r1 = (long) r0
                long r11 = r11 + r1
                int r13 = r13 - r0
            L7:
                r1 = 0
            L8:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r11 = com.android.framework.protobuf.UnsafeUtil.getByte(r11)
                r1 = r11
                if (r11 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L8
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1e
                r2 = 0
                return r2
            L1e:
                int r13 = r13 + (-1)
                r4 = -32
                r5 = -65
                r6 = -1
                if (r1 >= r4) goto L3c
                if (r13 != 0) goto L2a
                return r1
            L2a:
                int r13 = r13 + (-1)
                r4 = -62
                if (r1 < r4) goto L3b
                long r2 = r2 + r11
                byte r11 = com.android.framework.protobuf.UnsafeUtil.getByte(r11)
                if (r11 <= r5) goto L39
                r11 = r2
                goto L3b
            L39:
                r11 = r2
                goto L97
            L3b:
                return r6
            L3c:
                r7 = -16
                if (r1 >= r7) goto L6a
                r7 = 2
                if (r13 >= r7) goto L48
                int r2 = unsafeIncompleteStateFor(r11, r1, r13)
                return r2
            L48:
                int r13 = r13 + (-2)
                long r7 = r11 + r2
                byte r11 = com.android.framework.protobuf.UnsafeUtil.getByte(r11)
                if (r11 > r5) goto L69
                r12 = -96
                if (r1 != r4) goto L58
                if (r11 < r12) goto L69
            L58:
                r4 = -19
                if (r1 != r4) goto L5e
                if (r11 >= r12) goto L69
            L5e:
                long r2 = r2 + r7
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r7)
                if (r12 <= r5) goto L67
                r7 = r2
                goto L69
            L67:
                r11 = r2
                goto L97
            L69:
                return r6
            L6a:
                r4 = 3
                if (r13 >= r4) goto L72
                int r2 = unsafeIncompleteStateFor(r11, r1, r13)
                return r2
            L72:
                int r13 = r13 + (-3)
                long r7 = r11 + r2
                byte r11 = com.android.framework.protobuf.UnsafeUtil.getByte(r11)
                if (r11 > r5) goto L9a
                int r12 = r1 << 28
                int r4 = r11 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L9a
                long r9 = r7 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r7)
                if (r12 > r5) goto L99
                long r7 = r9 + r2
                byte r12 = com.android.framework.protobuf.UnsafeUtil.getByte(r9)
                if (r12 <= r5) goto L96
                goto L9a
            L96:
                r11 = r7
            L97:
                goto L7
            L99:
                r7 = r9
            L9a:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.framework.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(long, int):int");
        }

        private static int unsafeIncompleteStateFor(byte[] bytes, int byte1, long offset, int remaining) {
            switch (remaining) {
                case 0:
                    return Utf8.incompleteStateFor(byte1);
                case 1:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset));
                case 2:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(bytes, offset), UnsafeUtil.getByte(bytes, 1 + offset));
                default:
                    throw new AssertionError();
            }
        }

        private static int unsafeIncompleteStateFor(long address, int byte1, int remaining) {
            switch (remaining) {
                case 0:
                    return Utf8.incompleteStateFor(byte1);
                case 1:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address));
                case 2:
                    return Utf8.incompleteStateFor(byte1, UnsafeUtil.getByte(address), UnsafeUtil.getByte(1 + address));
                default:
                    throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b4) {
            return b4 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b4) {
            return b4 < -32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b4) {
            return b4 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char) byte1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (byte1 < -62 || isNotTrailingByte(byte2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 31) << 6) | trailingByteValue(byte2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || ((byte1 == -32 && byte2 < -96) || ((byte1 == -19 && byte2 >= -96) || isNotTrailingByte(byte3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            resultArr[resultPos] = (char) (((byte1 & 15) << 12) | (trailingByteValue(byte2) << 6) | trailingByteValue(byte3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(byte2) || (((byte1 << 28) + (byte2 + 112)) >> 30) != 0 || isNotTrailingByte(byte3) || isNotTrailingByte(byte4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int codepoint = ((byte1 & 7) << 18) | (trailingByteValue(byte2) << 12) | (trailingByteValue(byte3) << 6) | trailingByteValue(byte4);
            resultArr[resultPos] = highSurrogate(codepoint);
            resultArr[resultPos + 1] = lowSurrogate(codepoint);
        }

        private static boolean isNotTrailingByte(byte b4) {
            return b4 > -65;
        }

        private static int trailingByteValue(byte b4) {
            return b4 & okio.Utf8.REPLACEMENT_BYTE;
        }

        private static char highSurrogate(int codePoint) {
            return (char) ((codePoint >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static char lowSurrogate(int codePoint) {
            return (char) ((codePoint & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }
    }

    private Utf8() {
    }
}
