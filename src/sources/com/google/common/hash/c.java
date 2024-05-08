package com.google.common.hash;

import java.nio.charset.Charset;

/* compiled from: AbstractHasher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c implements f {
    @Override // com.google.common.hash.f
    public <T> f f(T t2, Funnel<? super T> funnel) {
        funnel.funnel(t2, this);
        return this;
    }

    @Override // com.google.common.hash.f
    public abstract f g(byte[] bArr, int i10, int i11);

    @Override // com.google.common.hash.k
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public f e(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public abstract f j(char c4);

    @Override // com.google.common.hash.k
    public f c(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            j(charSequence.charAt(i10));
        }
        return this;
    }

    @Override // com.google.common.hash.k
    public f d(CharSequence charSequence, Charset charset) {
        return e(charSequence.toString().getBytes(charset));
    }
}
