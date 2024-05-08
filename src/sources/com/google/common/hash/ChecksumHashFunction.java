package com.google.common.hash;

import com.google.common.base.o;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ChecksumHashFunction extends com.google.common.hash.b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final g<? extends Checksum> checksumSupplier;
    private final String toString;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class b extends com.google.common.hash.a {

        /* renamed from: b, reason: collision with root package name */
        public final Checksum f26624b;

        @Override // com.google.common.hash.f
        public HashCode hash() {
            long value = this.f26624b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        @Override // com.google.common.hash.a
        public void l(byte b4) {
            this.f26624b.update(b4);
        }

        @Override // com.google.common.hash.a
        public void o(byte[] bArr, int i10, int i11) {
            this.f26624b.update(bArr, i10, i11);
        }

        public b(Checksum checksum) {
            this.f26624b = (Checksum) o.r(checksum);
        }
    }

    public ChecksumHashFunction(g<? extends Checksum> gVar, int i10, String str) {
        this.checksumSupplier = (g) o.r(gVar);
        o.h(i10 == 32 || i10 == 64, "bits (%s) must be either 32 or 64", i10);
        this.bits = i10;
        this.toString = (String) o.r(str);
    }

    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
