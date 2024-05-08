package com.google.common.hash;

import com.google.common.base.o;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: AbstractHashFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b implements e {
    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashInt(int i10) {
        return newHasher(4).a(i10).hash();
    }

    public HashCode hashLong(long j10) {
        return newHasher(8).b(j10).hash();
    }

    @Override // com.google.common.hash.e
    public <T> HashCode hashObject(T t2, Funnel<? super T> funnel) {
        return newHasher().f(t2, funnel).hash();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().d(charSequence, charset).hash();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).c(charSequence).hash();
    }

    public f newHasher(int i10) {
        o.h(i10 >= 0, "expectedInputSize must be >= 0 but was %s", i10);
        return newHasher();
    }

    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        o.w(i10, i10 + i11, bArr.length);
        return newHasher(i11).g(bArr, i10, i11).hash();
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).h(byteBuffer).hash();
    }
}
