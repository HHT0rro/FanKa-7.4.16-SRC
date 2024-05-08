package okio;

import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Utf8.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i10) {
        return (i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10);
    }

    public static final boolean isUtf8Continuation(byte b4) {
        return (b4 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] process2Utf8Bytes, int i10, int i11, @NotNull Function1<? super Integer, p> yield) {
        s.i(process2Utf8Bytes, "$this$process2Utf8Bytes");
        s.i(yield, "yield");
        int i12 = i10 + 1;
        if (i11 <= i12) {
            yield.invoke(65533);
            return 1;
        }
        byte b4 = process2Utf8Bytes[i10];
        byte b10 = process2Utf8Bytes[i12];
        if (!((b10 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        int i13 = (b10 ^ 3968) ^ (b4 << 6);
        if (i13 < 128) {
            yield.invoke(65533);
            return 2;
        }
        yield.invoke(Integer.valueOf(i13));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] process3Utf8Bytes, int i10, int i11, @NotNull Function1<? super Integer, p> yield) {
        s.i(process3Utf8Bytes, "$this$process3Utf8Bytes");
        s.i(yield, "yield");
        int i12 = i10 + 2;
        if (i11 <= i12) {
            yield.invoke(65533);
            int i13 = i10 + 1;
            if (i11 > i13) {
                if ((process3Utf8Bytes[i13] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b4 = process3Utf8Bytes[i10];
        byte b10 = process3Utf8Bytes[i10 + 1];
        if (!((b10 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b11 = process3Utf8Bytes[i12];
        if (!((b11 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        int i14 = ((b11 ^ (-123008)) ^ (b10 << 6)) ^ (b4 << 12);
        if (i14 < 2048) {
            yield.invoke(65533);
            return 3;
        }
        if (55296 <= i14 && 57343 >= i14) {
            yield.invoke(65533);
            return 3;
        }
        yield.invoke(Integer.valueOf(i14));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] process4Utf8Bytes, int i10, int i11, @NotNull Function1<? super Integer, p> yield) {
        s.i(process4Utf8Bytes, "$this$process4Utf8Bytes");
        s.i(yield, "yield");
        int i12 = i10 + 3;
        if (i11 <= i12) {
            yield.invoke(65533);
            int i13 = i10 + 1;
            if (i11 > i13) {
                if ((process4Utf8Bytes[i13] & 192) == 128) {
                    int i14 = i10 + 2;
                    if (i11 > i14) {
                        if ((process4Utf8Bytes[i14] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b4 = process4Utf8Bytes[i10];
        byte b10 = process4Utf8Bytes[i10 + 1];
        if (!((b10 & 192) == 128)) {
            yield.invoke(65533);
            return 1;
        }
        byte b11 = process4Utf8Bytes[i10 + 2];
        if (!((b11 & 192) == 128)) {
            yield.invoke(65533);
            return 2;
        }
        byte b12 = process4Utf8Bytes[i12];
        if (!((b12 & 192) == 128)) {
            yield.invoke(65533);
            return 3;
        }
        int i15 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b4 << 18);
        if (i15 > 1114111) {
            yield.invoke(65533);
            return 4;
        }
        if (55296 <= i15 && 57343 >= i15) {
            yield.invoke(65533);
            return 4;
        }
        if (i15 < 65536) {
            yield.invoke(65533);
            return 4;
        }
        yield.invoke(Integer.valueOf(i15));
        return 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0119, code lost:
    
        if (((r16[r4] & 192) == 128) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0098, code lost:
    
        if (((r16[r4] & 192) == 128) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf16Chars(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.p> r19) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(@NotNull String processUtf8Bytes, int i10, int i11, @NotNull Function1<? super Byte, p> yield) {
        int i12;
        char charAt;
        s.i(processUtf8Bytes, "$this$processUtf8Bytes");
        s.i(yield, "yield");
        while (i10 < i11) {
            char charAt2 = processUtf8Bytes.charAt(i10);
            if (s.k(charAt2, 128) < 0) {
                yield.invoke(Byte.valueOf((byte) charAt2));
                i10++;
                while (i10 < i11 && s.k(processUtf8Bytes.charAt(i10), 128) < 0) {
                    yield.invoke(Byte.valueOf((byte) processUtf8Bytes.charAt(i10)));
                    i10++;
                }
            } else {
                if (s.k(charAt2, 2048) < 0) {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 <= charAt2 && 57343 >= charAt2) {
                    if (s.k(charAt2, 56319) <= 0 && i11 > (i12 = i10 + 1) && 56320 <= (charAt = processUtf8Bytes.charAt(i12)) && 57343 >= charAt) {
                        int charAt3 = ((charAt2 << '\n') + processUtf8Bytes.charAt(i12)) - 56613888;
                        yield.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                        yield.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                        i10 += 2;
                    } else {
                        yield.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                } else {
                    yield.invoke(Byte.valueOf((byte) ((charAt2 >> '\f') | 224)));
                    yield.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    yield.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                }
                i10++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0117, code lost:
    
        if (((r16[r4] & 192) == 128) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0096, code lost:
    
        if (((r16[r4] & 192) == 128) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void processUtf8CodePoints(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.p> r19) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final long size(@NotNull String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(@NotNull String str, int i10) {
        return size$default(str, i10, 0, 2, null);
    }

    public static final long size(@NotNull String utf8Size, int i10, int i11) {
        int i12;
        s.i(utf8Size, "$this$utf8Size");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
        }
        if (i11 >= i10) {
            if (!(i11 <= utf8Size.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + utf8Size.length()).toString());
            }
            long j10 = 0;
            while (i10 < i11) {
                char charAt = utf8Size.charAt(i10);
                if (charAt < 128) {
                    j10++;
                } else {
                    if (charAt < 2048) {
                        i12 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i12 = 3;
                    } else {
                        int i13 = i10 + 1;
                        char charAt2 = i13 < i11 ? utf8Size.charAt(i13) : (char) 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j10++;
                            i10 = i13;
                        } else {
                            j10 += 4;
                            i10 += 2;
                        }
                    }
                    j10 += i12;
                }
                i10++;
            }
            return j10;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
    }

    public static /* synthetic */ long size$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return size(str, i10, i11);
    }
}
