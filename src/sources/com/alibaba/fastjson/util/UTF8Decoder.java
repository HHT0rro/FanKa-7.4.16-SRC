package com.alibaba.fastjson.util;

import com.android.internal.midi.MidiConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ca, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012f, code lost:
    
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r13, java.nio.CharBuffer r14) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.decodeArrayLoop(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    private static boolean isMalformed2(int i10, int i11) {
        return (i10 & 30) == 0 || (i11 & 192) != 128;
    }

    private static boolean isMalformed3(int i10, int i11, int i12) {
        return ((i10 != -32 || (i11 & 224) != 128) && (i11 & 192) == 128 && (i12 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i10, int i11, int i12) {
        return ((i10 & 192) == 128 && (i11 & 192) == 128 && (i12 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i10) {
        return (i10 & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i10) {
        for (int i11 = 1; i11 < i10; i11++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i11);
            }
        }
        return CoderResult.malformedForLength(i10);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i10, CharBuffer charBuffer, int i11, int i12) {
        byteBuffer.position(i10 - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i12);
        byteBuffer.position(i10);
        charBuffer.position(i11);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i10) {
        int i11 = 1;
        if (i10 == 1) {
            byte b4 = byteBuffer.get();
            if ((b4 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            }
            if ((b4 >> 1) == -2) {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            }
            return CoderResult.malformedForLength(1);
        }
        if (i10 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i10 == 3) {
            byte b10 = byteBuffer.get();
            byte b11 = byteBuffer.get();
            if ((b10 != -32 || (b11 & MidiConstants.STATUS_PITCH_BEND) != 128) && !isNotContinuation(b11)) {
                i11 = 2;
            }
            return CoderResult.malformedForLength(i11);
        }
        if (i10 == 4) {
            int i12 = byteBuffer.get() & 255;
            int i13 = byteBuffer.get() & 255;
            if (i12 > 244 || ((i12 == 240 && (i13 < 144 || i13 > 191)) || ((i12 == 244 && (i13 & 240) != 128) || isNotContinuation(i13)))) {
                return CoderResult.malformedForLength(1);
            }
            return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
        }
        throw new IllegalStateException();
    }

    private static CoderResult xflow(Buffer buffer, int i10, int i11, Buffer buffer2, int i12, int i13) {
        buffer.position(i10);
        buffer2.position(i12);
        return (i13 == 0 || i11 - i10 < i13) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
