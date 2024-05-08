package okio.internal;

import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.s;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: -Utf8.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String commonAsUtf8ToByteArray) {
        int i10;
        int i11;
        char charAt;
        s.i(commonAsUtf8ToByteArray, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[commonAsUtf8ToByteArray.length() * 4];
        int length = commonAsUtf8ToByteArray.length();
        int i12 = 0;
        while (i12 < length) {
            char charAt2 = commonAsUtf8ToByteArray.charAt(i12);
            if (s.k(charAt2, 128) >= 0) {
                int length2 = commonAsUtf8ToByteArray.length();
                int i13 = i12;
                while (i12 < length2) {
                    char charAt3 = commonAsUtf8ToByteArray.charAt(i12);
                    if (s.k(charAt3, 128) < 0) {
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) charAt3;
                        i12++;
                        while (i12 < length2 && s.k(commonAsUtf8ToByteArray.charAt(i12), 128) < 0) {
                            bArr[i14] = (byte) commonAsUtf8ToByteArray.charAt(i12);
                            i12++;
                            i14++;
                        }
                        i13 = i14;
                    } else {
                        if (s.k(charAt3, 2048) < 0) {
                            int i15 = i13 + 1;
                            bArr[i13] = (byte) ((charAt3 >> 6) | 192);
                            byte b4 = (byte) ((charAt3 & '?') | 128);
                            i10 = i15 + 1;
                            bArr[i15] = b4;
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i16 = i13 + 1;
                            bArr[i13] = (byte) ((charAt3 >> '\f') | 224);
                            int i17 = i16 + 1;
                            bArr[i16] = (byte) (((charAt3 >> 6) & 63) | 128);
                            byte b10 = (byte) ((charAt3 & '?') | 128);
                            i10 = i17 + 1;
                            bArr[i17] = b10;
                        } else if (s.k(charAt3, 56319) > 0 || length2 <= (i11 = i12 + 1) || 56320 > (charAt = commonAsUtf8ToByteArray.charAt(i11)) || 57343 < charAt) {
                            i10 = i13 + 1;
                            bArr[i13] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + commonAsUtf8ToByteArray.charAt(i11)) - 56613888;
                            int i18 = i13 + 1;
                            bArr[i13] = (byte) ((charAt4 >> 18) | 240);
                            int i19 = i18 + 1;
                            bArr[i18] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i20 = i19 + 1;
                            bArr[i19] = (byte) (((charAt4 >> 6) & 63) | 128);
                            byte b11 = (byte) ((charAt4 & 63) | 128);
                            i10 = i20 + 1;
                            bArr[i20] = b11;
                            i12 += 2;
                            i13 = i10;
                        }
                        i12++;
                        i13 = i10;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i13);
                s.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i12] = (byte) charAt2;
            i12++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, commonAsUtf8ToByteArray.length());
        s.h(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011e, code lost:
    
        if (((r16[r5] & 192) == 128) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x009d, code lost:
    
        if (((r16[r5] & 192) == 128) == false) goto L23;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return commonToUtf8String(bArr, i10, i11);
    }
}
