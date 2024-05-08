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

/* compiled from: HashingSink.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* compiled from: HashingSink.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
            s.i(sink, "sink");
            s.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
            s.i(sink, "sink");
            s.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
            s.i(sink, "sink");
            s.i(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @NotNull
        public final HashingSink md5(@NotNull Sink sink) {
            s.i(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @NotNull
        public final HashingSink sha1(@NotNull Sink sink) {
            s.i(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @NotNull
        public final HashingSink sha256(@NotNull Sink sink) {
            s.i(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @NotNull
        public final HashingSink sha512(@NotNull Sink sink) {
            s.i(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull String algorithm) {
        super(sink);
        s.i(sink, "sink");
        s.i(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @NotNull
    public static final HashingSink md5(@NotNull Sink sink) {
        return Companion.md5(sink);
    }

    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink) {
        return Companion.sha1(sink);
    }

    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink) {
        return Companion.sha256(sink);
    }

    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink) {
        return Companion.sha512(sink);
    }

    @NotNull
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m3745deprecated_hash() {
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long j10) throws IOException {
        s.i(source, "source");
        Util.checkOffsetAndCount(source.size(), 0L, j10);
        Segment segment = source.head;
        s.f(segment);
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.mac;
                s.f(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j11 += min;
            segment = segment.next;
            s.f(segment);
        }
        super.write(source, j10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull ByteString key, @NotNull String algorithm) {
        super(sink);
        s.i(sink, "sink");
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
