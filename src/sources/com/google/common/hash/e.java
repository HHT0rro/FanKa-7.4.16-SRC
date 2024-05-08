package com.google.common.hash;

/* compiled from: HashFunction.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface e {
    <T> HashCode hashObject(T t2, Funnel<? super T> funnel);

    f newHasher();
}
