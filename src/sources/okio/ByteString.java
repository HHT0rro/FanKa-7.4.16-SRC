package okio;

import com.android.internal.midi.MidiConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.l;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.c;
import kotlin.text.p;
import okio.internal.ByteStringKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ByteString.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    /* compiled from: ByteString.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charset = c.f51097b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return companion.of(bArr, i10, i11);
        }

        @Nullable
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m3734deprecated_decodeBase64(@NotNull String string) {
            s.i(string, "string");
            return decodeBase64(string);
        }

        @NotNull
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m3735deprecated_decodeHex(@NotNull String string) {
            s.i(string, "string");
            return decodeHex(string);
        }

        @NotNull
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m3736deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            s.i(string, "string");
            s.i(charset, "charset");
            return encodeString(string, charset);
        }

        @NotNull
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m3737deprecated_encodeUtf8(@NotNull String string) {
            s.i(string, "string");
            return encodeUtf8(string);
        }

        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3738deprecated_of(@NotNull ByteBuffer buffer) {
            s.i(buffer, "buffer");
            return of(buffer);
        }

        @NotNull
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m3740deprecated_read(@NotNull InputStream inputstream, int i10) {
            s.i(inputstream, "inputstream");
            return read(inputstream, i10);
        }

        @Nullable
        public final ByteString decodeBase64(@NotNull String decodeBase64) {
            s.i(decodeBase64, "$this$decodeBase64");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(decodeBase64);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @NotNull
        public final ByteString decodeHex(@NotNull String decodeHex) {
            s.i(decodeHex, "$this$decodeHex");
            if (decodeHex.length() % 2 == 0) {
                int length = decodeHex.length() / 2;
                byte[] bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    bArr[i10] = (byte) ((ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i11)) << 4) + ByteStringKt.access$decodeHexDigit(decodeHex.charAt(i11 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
        }

        @NotNull
        public final ByteString encodeString(@NotNull String encode, @NotNull Charset charset) {
            s.i(encode, "$this$encode");
            s.i(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            s.h(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @NotNull
        public final ByteString encodeUtf8(@NotNull String encodeUtf8) {
            s.i(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        @NotNull
        public final ByteString of(@NotNull ByteBuffer toByteString) {
            s.i(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        @NotNull
        public final ByteString read(@NotNull InputStream readByteString, int i10) throws IOException {
            s.i(readByteString, "$this$readByteString");
            int i11 = 0;
            if (i10 >= 0) {
                byte[] bArr = new byte[i10];
                while (i11 < i10) {
                    int read = readByteString.read(bArr, i11, i10 - i11);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i11 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m3739deprecated_of(@NotNull byte[] array, int i10, int i11) {
            s.i(array, "array");
            return of(array, i10, i11);
        }

        @NotNull
        public final ByteString of(@NotNull byte... data) {
            s.i(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @NotNull
        public final ByteString of(@NotNull byte[] toByteString, int i10, int i11) {
            s.i(toByteString, "$this$toByteString");
            Util.checkOffsetAndCount(toByteString.length, i10, i11);
            return new ByteString(l.i(toByteString, i10, i11 + i10));
        }
    }

    public ByteString(@NotNull byte[] data) {
        s.i(data, "data");
        this.data = data;
    }

    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return byteString.indexOf(byteString2, i10);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return byteString.indexOf(bArr, i10);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i10);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i10);
    }

    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i10, int i11) {
        return Companion.of(bArr, i10, i11);
    }

    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i10) throws IOException {
        return Companion.read(inputStream, i10);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field field = ByteString.class.getDeclaredField("data");
        s.h(field, "field");
        field.setAccessible(true);
        field.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = byteString.size();
        }
        return byteString.substring(i10, i11);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3732deprecated_getByte(int i10) {
        return getByte(i10);
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m3733deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        s.h(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        s.i(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.data);
        s.h(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        s.i(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i10) {
        return internalGet$okio(i10);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i10 = 0;
        for (byte b4 : getData$okio()) {
            int i11 = i10 + 1;
            cArr[i10] = ByteStringKt.getHEX_DIGIT_CHARS()[(b4 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = ByteStringKt.getHEX_DIGIT_CHARS()[b4 & 15];
        }
        return new String(cArr);
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        s.i(algorithm, "algorithm");
        s.i(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            s.h(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        s.i(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(@NotNull ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(@NotNull ByteString other, int i10) {
        s.i(other, "other");
        return indexOf(other.internalArray$okio(), i10);
    }

    public final int indexOf(@NotNull byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i10) {
        return getData$okio()[i10];
    }

    public final int lastIndexOf(@NotNull ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(@NotNull ByteString other, int i10) {
        s.i(other, "other");
        return lastIndexOf(other.internalArray$okio(), i10);
    }

    public final int lastIndexOf(@NotNull byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @NotNull
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i10, @NotNull ByteString other, int i11, int i12) {
        s.i(other, "other");
        return other.rangeEquals(i11, getData$okio(), i10, i12);
    }

    public final void setHashCode$okio(int i10) {
        this.hashCode = i10;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        s.i(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        s.i(charset, "charset");
        return new String(this.data, charset);
    }

    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public final ByteString substring(int i10) {
        return substring$default(this, i10, 0, 2, null);
    }

    @NotNull
    public ByteString substring(int i10, int i11) {
        if (i10 >= 0) {
            if (i11 <= getData$okio().length) {
                if (i11 - i10 >= 0) {
                    return (i10 == 0 && i11 == getData$okio().length) ? this : new ByteString(l.i(getData$okio(), i10, i11));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b4;
        for (int i10 = 0; i10 < getData$okio().length; i10++) {
            byte b10 = getData$okio()[i10];
            byte b11 = (byte) 65;
            if (b10 >= b11 && b10 <= (b4 = (byte) 90)) {
                byte[] data$okio = getData$okio();
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
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b4;
        for (int i10 = 0; i10 < getData$okio().length; i10++) {
            byte b10 = getData$okio()[i10];
            byte b11 = (byte) 97;
            if (b10 >= b11 && b10 <= (b4 = (byte) 122)) {
                byte[] data$okio = getData$okio();
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
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        s.h(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
        if (access$codePointIndexToCharIndex == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(getData$okio().length);
            sb2.append(" hex=");
            if (64 <= getData$okio().length) {
                sb2.append((64 == getData$okio().length ? this : new ByteString(l.i(getData$okio(), 0, 64))).hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String utf8 = utf8();
        Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
        String substring = utf8.substring(0, access$codePointIndexToCharIndex);
        s.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String A = p.A(p.A(p.A(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), StringUtils.CR, "\\r", false, 4, null);
        if (access$codePointIndexToCharIndex < utf8.length()) {
            return "[size=" + getData$okio().length + " text=" + A + "…]";
        }
        return "[text=" + A + ']';
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        s.i(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int i10, int i11) {
        s.i(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@org.jetbrains.annotations.NotNull okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.s.i(r10, r0)
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        s.i(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public int indexOf(@NotNull byte[] other, int i10) {
        s.i(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i10, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(@NotNull byte[] other, int i10) {
        s.i(other, "other");
        for (int min = Math.min(i10, getData$okio().length - other.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i10, @NotNull byte[] other, int i11, int i12) {
        s.i(other, "other");
        return i10 >= 0 && i10 <= getData$okio().length - i12 && i11 >= 0 && i11 <= other.length - i12 && Util.arrayRangeEquals(getData$okio(), i10, other, i11, i12);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        s.i(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
