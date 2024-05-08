package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class g7<E> extends h7<E> {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f24343a = new Object[4];

    /* renamed from: b, reason: collision with root package name */
    public int f24344b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f24345c;

    public g7(int i10) {
    }

    public final g7<E> a(E e2) {
        Objects.requireNonNull(e2);
        b(this.f24344b + 1);
        Object[] objArr = this.f24343a;
        int i10 = this.f24344b;
        this.f24344b = i10 + 1;
        objArr[i10] = e2;
        return this;
    }

    public final void b(int i10) {
        Object[] objArr = this.f24343a;
        int length = objArr.length;
        if (length >= i10) {
            if (this.f24345c) {
                this.f24343a = (Object[]) objArr.clone();
                this.f24345c = false;
                return;
            }
            return;
        }
        int i11 = length + (length >> 1) + 1;
        if (i11 < i10) {
            int highestOneBit = Integer.highestOneBit(i10 - 1);
            i11 = highestOneBit + highestOneBit;
        }
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        this.f24343a = Arrays.copyOf(objArr, i11);
        this.f24345c = false;
    }
}
