package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: Hasher.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface f extends k {
    @Override // com.google.common.hash.k
    f a(int i10);

    @Override // com.google.common.hash.k
    f b(long j10);

    @Override // com.google.common.hash.k
    f c(CharSequence charSequence);

    @Override // com.google.common.hash.k
    f d(CharSequence charSequence, Charset charset);

    <T> f f(T t2, Funnel<? super T> funnel);

    f g(byte[] bArr, int i10, int i11);

    f h(ByteBuffer byteBuffer);

    HashCode hash();
}
