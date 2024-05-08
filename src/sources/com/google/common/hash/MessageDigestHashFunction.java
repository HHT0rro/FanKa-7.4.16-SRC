package com.google.common.hash;

import com.google.common.base.o;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class MessageDigestHashFunction extends com.google.common.hash.b implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        private SerializedForm(String str, int i10, String str2) {
            this.algorithmName = str;
            this.bytes = i10;
            this.toString = str2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b extends com.google.common.hash.a {

        /* renamed from: b, reason: collision with root package name */
        public final MessageDigest f26628b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26629c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f26630d;

        @Override // com.google.common.hash.f
        public HashCode hash() {
            p();
            this.f26630d = true;
            if (this.f26629c == this.f26628b.getDigestLength()) {
                return HashCode.fromBytesNoCopy(this.f26628b.digest());
            }
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f26628b.digest(), this.f26629c));
        }

        @Override // com.google.common.hash.a
        public void l(byte b4) {
            p();
            this.f26628b.update(b4);
        }

        @Override // com.google.common.hash.a
        public void m(ByteBuffer byteBuffer) {
            p();
            this.f26628b.update(byteBuffer);
        }

        @Override // com.google.common.hash.a
        public void o(byte[] bArr, int i10, int i11) {
            p();
            this.f26628b.update(bArr, i10, i11);
        }

        public final void p() {
            o.y(!this.f26630d, "Cannot re-use a Hasher after calling hash() on it");
        }

        public b(MessageDigest messageDigest, int i10) {
            this.f26628b = messageDigest;
            this.f26629c = i10;
        }
    }

    public MessageDigestHashFunction(String str, String str2) {
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        this.bytes = messageDigest.getDigestLength();
        this.toString = (String) o.r(str2);
        this.supportsClone = supportsClone(messageDigest);
    }

    private static MessageDigest getMessageDigest(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    private static boolean supportsClone(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        if (this.supportsClone) {
            try {
                return new b((MessageDigest) this.prototype.clone(), this.bytes);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new b(getMessageDigest(this.prototype.getAlgorithm()), this.bytes);
    }

    public String toString() {
        return this.toString;
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString);
    }

    public MessageDigestHashFunction(String str, int i10, String str2) {
        this.toString = (String) o.r(str2);
        MessageDigest messageDigest = getMessageDigest(str);
        this.prototype = messageDigest;
        int digestLength = messageDigest.getDigestLength();
        o.i(i10 >= 4 && i10 <= digestLength, "bytes (%s) must be >= 4 and < %s", i10, digestLength);
        this.bytes = i10;
        this.supportsClone = supportsClone(messageDigest);
    }
}
