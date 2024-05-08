package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: HashingSource.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* compiled from: HashingSource.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString key) {
            s.i(source, "source");
            s.i(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString key) {
            s.i(source, "source");
            s.i(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString key) {
            s.i(source, "source");
            s.i(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @NotNull
        public final HashingSource md5(@NotNull Source source) {
            s.i(source, "source");
            return new HashingSource(source, "MD5");
        }

        @NotNull
        public final HashingSource sha1(@NotNull Source source) {
            s.i(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @NotNull
        public final HashingSource sha256(@NotNull Source source) {
            s.i(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @NotNull
        public final HashingSource sha512(@NotNull Source source) {
            s.i(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull String algorithm) {
        super(source);
        s.i(source, "source");
        s.i(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @NotNull
    public static final HashingSource md5(@NotNull Source source) {
        return Companion.md5(source);
    }

    @NotNull
    public static final HashingSource sha1(@NotNull Source source) {
        return Companion.sha1(source);
    }

    @NotNull
    public static final HashingSource sha256(@NotNull Source source) {
        return Companion.sha256(source);
    }

    @NotNull
    public static final HashingSource sha512(@NotNull Source source) {
        return Companion.sha512(source);
    }

    @NotNull
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m3746deprecated_hash() {
        return hash();
    }

    @NotNull
    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            s.f(mac);
            result = mac.doFinal();
        }
        s.h(result, "result");
        return new ByteString(result);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer sink, long j10) throws IOException {
        s.i(sink, "sink");
        long read = super.read(sink, j10);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment = sink.head;
            s.f(segment);
            while (size2 > size) {
                segment = segment.prev;
                s.f(segment);
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < sink.size()) {
                int i10 = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i10, segment.limit - i10);
                } else {
                    Mac mac = this.mac;
                    s.f(mac);
                    mac.update(segment.data, i10, segment.limit - i10);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                s.f(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull ByteString key, @NotNull String algorithm) {
        super(source);
        s.i(source, "source");
        s.i(key, "key");
        s.i(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            p pVar = p.f51048a;
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
