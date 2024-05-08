package okio;

import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.s;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: -Base64.kt */
@d
/* renamed from: okio.-Base64 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Base64 {

    @NotNull
    private static final byte[] BASE64;

    @NotNull
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String decodeBase64ToArray) {
        int i10;
        char charAt;
        s.i(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((charAt = decodeBase64ToArray.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i11 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char charAt2 = decodeBase64ToArray.charAt(i15);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i10 = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i10 = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i10 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i10 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i10 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i13 = (i13 << 6) | i10;
            i12++;
            if (i12 % 4 == 0) {
                int i16 = i14 + 1;
                bArr[i14] = (byte) (i13 >> 16);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i13 >> 8);
                bArr[i17] = (byte) i13;
                i14 = i17 + 1;
            }
        }
        int i18 = i12 % 4;
        if (i18 == 1) {
            return null;
        }
        if (i18 == 2) {
            bArr[i14] = (byte) ((i13 << 12) >> 16);
            i14++;
        } else if (i18 == 3) {
            int i19 = i13 << 6;
            int i20 = i14 + 1;
            bArr[i14] = (byte) (i19 >> 16);
            i14 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
        }
        if (i14 == i11) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i14);
        s.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] encodeBase64, @NotNull byte[] map) {
        s.i(encodeBase64, "$this$encodeBase64");
        s.i(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b4 = encodeBase64[i10];
            int i13 = i12 + 1;
            byte b10 = encodeBase64[i12];
            int i14 = i13 + 1;
            byte b11 = encodeBase64[i13];
            int i15 = i11 + 1;
            bArr[i11] = map[(b4 & 255) >> 2];
            int i16 = i15 + 1;
            bArr[i15] = map[((b4 & 3) << 4) | ((b10 & 255) >> 4)];
            int i17 = i16 + 1;
            bArr[i16] = map[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i11 = i17 + 1;
            bArr[i17] = map[b11 & Utf8.REPLACEMENT_BYTE];
            i10 = i14;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b12 = encodeBase64[i10];
            int i18 = i11 + 1;
            bArr[i11] = map[(b12 & 255) >> 2];
            int i19 = i18 + 1;
            bArr[i18] = map[(b12 & 3) << 4];
            byte b13 = (byte) 61;
            bArr[i19] = b13;
            bArr[i19 + 1] = b13;
        } else if (length2 == 2) {
            int i20 = i10 + 1;
            byte b14 = encodeBase64[i10];
            byte b15 = encodeBase64[i20];
            int i21 = i11 + 1;
            bArr[i11] = map[(b14 & 255) >> 2];
            int i22 = i21 + 1;
            bArr[i21] = map[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr[i22] = map[(b15 & 15) << 2];
            bArr[i22 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
