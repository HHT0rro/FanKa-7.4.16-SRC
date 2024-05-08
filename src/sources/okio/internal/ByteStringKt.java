package okio.internal;

import com.android.internal.midi.MidiConstants;
import java.util.Arrays;
import java.util.Objects;
import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ByteString.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ByteStringKt {

    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:232:0x0068, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString commonBase64) {
        s.i(commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default(commonBase64.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString commonBase64Url) {
        s.i(commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64(commonBase64Url.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString commonCompareTo, @NotNull ByteString other) {
        s.i(commonCompareTo, "$this$commonCompareTo");
        s.i(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = commonCompareTo.getByte(i10) & 255;
            int i12 = other.getByte(i10) & 255;
            if (i11 != i12) {
                return i11 < i12 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String commonDecodeBase64) {
        s.i(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(commonDecodeBase64);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String commonDecodeHex) {
        s.i(commonDecodeHex, "$this$commonDecodeHex");
        if (commonDecodeHex.length() % 2 == 0) {
            int length = commonDecodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((decodeHexDigit(commonDecodeHex.charAt(i11)) << 4) + decodeHexDigit(commonDecodeHex.charAt(i11 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String commonEncodeUtf8) {
        s.i(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull ByteString suffix) {
        s.i(commonEndsWith, "$this$commonEndsWith");
        s.i(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString commonEquals, @Nullable Object obj) {
        s.i(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData$okio().length && byteString.rangeEquals(0, commonEquals.getData$okio(), 0, commonEquals.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString commonGetByte, int i10) {
        s.i(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData$okio()[i10];
    }

    public static final int commonGetSize(@NotNull ByteString commonGetSize) {
        s.i(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString commonHashCode) {
        s.i(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(commonHashCode.getData$okio());
        commonHashCode.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString commonHex) {
        s.i(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData$okio().length * 2];
        int i10 = 0;
        for (byte b4 : commonHex.getData$okio()) {
            int i11 = i10 + 1;
            cArr[i10] = getHEX_DIGIT_CHARS()[(b4 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = getHEX_DIGIT_CHARS()[b4 & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString commonIndexOf, @NotNull byte[] other, int i10) {
        s.i(commonIndexOf, "$this$commonIndexOf");
        s.i(other, "other");
        int length = commonIndexOf.getData$okio().length - other.length;
        int max = Math.max(i10, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(commonIndexOf.getData$okio(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString commonInternalArray) {
        s.i(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull ByteString other, int i10) {
        s.i(commonLastIndexOf, "$this$commonLastIndexOf");
        s.i(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i10);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        s.i(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i10, @NotNull ByteString other, int i11, int i12) {
        s.i(commonRangeEquals, "$this$commonRangeEquals");
        s.i(other, "other");
        return other.rangeEquals(i11, commonRangeEquals.getData$okio(), i10, i12);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull ByteString prefix) {
        s.i(commonStartsWith, "$this$commonStartsWith");
        s.i(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString commonSubstring, int i10, int i11) {
        s.i(commonSubstring, "$this$commonSubstring");
        if (i10 >= 0) {
            if (i11 <= commonSubstring.getData$okio().length) {
                if (i11 - i10 >= 0) {
                    return (i10 == 0 && i11 == commonSubstring.getData$okio().length) ? commonSubstring : new ByteString(l.i(commonSubstring.getData$okio(), i10, i11));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString commonToAsciiLowercase) {
        byte b4;
        s.i(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i10 = 0; i10 < commonToAsciiLowercase.getData$okio().length; i10++) {
            byte b10 = commonToAsciiLowercase.getData$okio()[i10];
            byte b11 = (byte) 65;
            if (b10 >= b11 && b10 <= (b4 = (byte) 90)) {
                byte[] data$okio = commonToAsciiLowercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b12 = copyOf[i11];
                    if (b12 >= b11 && b12 <= b4) {
                        copyOf[i11] = (byte) (b12 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString commonToAsciiUppercase) {
        byte b4;
        s.i(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i10 = 0; i10 < commonToAsciiUppercase.getData$okio().length; i10++) {
            byte b10 = commonToAsciiUppercase.getData$okio()[i10];
            byte b11 = (byte) 97;
            if (b10 >= b11 && b10 <= (b4 = (byte) 122)) {
                byte[] data$okio = commonToAsciiUppercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b10 + MidiConstants.STATUS_PITCH_BEND);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b12 = copyOf[i11];
                    if (b12 >= b11 && b12 <= b4) {
                        copyOf[i11] = (byte) (b12 + MidiConstants.STATUS_PITCH_BEND);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString commonToByteArray) {
        s.i(commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] commonToByteString, int i10, int i11) {
        s.i(commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount(commonToByteString.length, i10, i11);
        return new ByteString(l.i(commonToByteString, i10, i11 + i10));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        ByteString commonToString = byteString;
        s.i(commonToString, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex == -1) {
            if (byteString.getData$okio().length <= 64) {
                return "[hex=" + byteString.hex() + ']';
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(byteString.getData$okio().length);
            sb2.append(" hex=");
            if (64 <= byteString.getData$okio().length) {
                if (64 != byteString.getData$okio().length) {
                    commonToString = new ByteString(l.i(byteString.getData$okio(), 0, 64));
                }
                sb2.append(commonToString.hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        String utf8 = byteString.utf8();
        Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
        String substring = utf8.substring(0, codePointIndexToCharIndex);
        s.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String A = p.A(p.A(p.A(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), StringUtils.CR, "\\r", false, 4, null);
        if (codePointIndexToCharIndex < utf8.length()) {
            return "[size=" + byteString.getData$okio().length + " text=" + A + "…]";
        }
        return "[text=" + A + ']';
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString commonUtf8) {
        s.i(commonUtf8, "$this$commonUtf8");
        String utf8$okio = commonUtf8.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(commonUtf8.internalArray$okio());
        commonUtf8.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString commonWrite, @NotNull Buffer buffer, int i10, int i11) {
        s.i(commonWrite, "$this$commonWrite");
        s.i(buffer, "buffer");
        buffer.write(commonWrite.getData$okio(), i10, i11);
    }

    public static final int decodeHexDigit(char c4) {
        if ('0' <= c4 && '9' >= c4) {
            return c4 - '0';
        }
        char c10 = 'a';
        if ('a' > c4 || 'f' < c4) {
            c10 = 'A';
            if ('A' > c4 || 'F' < c4) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c4);
            }
        }
        return (c4 - c10) + 10;
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull byte[] suffix) {
        s.i(commonEndsWith, "$this$commonEndsWith");
        s.i(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull byte[] other, int i10) {
        s.i(commonLastIndexOf, "$this$commonLastIndexOf");
        s.i(other, "other");
        for (int min = Math.min(i10, commonLastIndexOf.getData$okio().length - other.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(commonLastIndexOf.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i10, @NotNull byte[] other, int i11, int i12) {
        s.i(commonRangeEquals, "$this$commonRangeEquals");
        s.i(other, "other");
        return i10 >= 0 && i10 <= commonRangeEquals.getData$okio().length - i12 && i11 >= 0 && i11 <= other.length - i12 && Util.arrayRangeEquals(commonRangeEquals.getData$okio(), i10, other, i11, i12);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull byte[] prefix) {
        s.i(commonStartsWith, "$this$commonStartsWith");
        s.i(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }
}
